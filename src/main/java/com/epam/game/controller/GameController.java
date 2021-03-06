package com.epam.game.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

import com.epam.game.controller.dtos.GameInfo;
import com.epam.game.domain.Authority;
import com.epam.game.gameinfrastructure.requessthandling.SocketResponseSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.game.constants.AttributesEnum;

import com.epam.game.constants.GameState;
import com.epam.game.constants.GameType;
import com.epam.game.constants.LevelGenerators;
import com.epam.game.constants.Settings;
import com.epam.game.constants.ViewsEnum;
import com.epam.game.controller.forms.CreateGameForm;
import com.epam.game.controller.forms.CreateTrainingLevelForm;
import com.epam.game.controller.forms.MultipleLoginForm;
import com.epam.game.controller.validators.CreateGameValidator;
import com.epam.game.controller.validators.TrainingLevelFormValidator;
import com.epam.game.domain.Client;
import com.epam.game.domain.Game;
import com.epam.game.domain.User;
import com.epam.game.gamemodel.gamehandler.GameThread;
import com.epam.game.gamemodel.mapgenerator.MapGenerator;
import com.epam.game.gamemodel.mapgenerator.impl.TriangleMapGenerator;
import com.epam.game.gamemodel.model.GameInstance;
import com.epam.game.gamemodel.model.Model;
import com.epam.game.gamemodel.naming.impl.FileRandomNamingHandler;
import com.epam.game.model.dao.GameDAO;
import com.epam.game.model.dao.UserDAO;

import javax.servlet.http.HttpServletResponse;

/**
 * Controller for working with actions on game and model.
 *
 * @author Roman_Spiridonov
 */
@Controller
@SessionAttributes(value = AttributesEnum.CLIENT)
public class GameController {

    @Autowired
    private GameDAO gameDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private CreateGameValidator createGameValidator;

    @Autowired
    private TrainingLevelFormValidator trainingLevelFormValidator;

    @RequestMapping(value = "/" + ViewsEnum.OPEN_GAMES + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String showGames(ModelMap model) {
        Model gameModel = Model.getInstance();
        if (!model.containsAttribute(AttributesEnum.TRAINING_LEVEL_FORM)) {
            model.addAttribute(AttributesEnum.TRAINING_LEVEL_FORM, new CreateTrainingLevelForm());
        }
        model.addAttribute(AttributesEnum.GAMES, gameModel.getNotStartedTournaments());
        return ViewsEnum.OPEN_GAMES;
    }


    @RequestMapping(value = "/" + ViewsEnum.BATTLE + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String showBattle(@ModelAttribute Client client, ModelMap model) {

        if (client.hasAnyRole("ROLE_ADMIN")) {
            if (!model.containsAttribute(AttributesEnum.CREATE_GAME_FORM)) {
                CreateGameForm createGameForm = new CreateGameForm();
                model.addAttribute(AttributesEnum.CREATE_GAME_FORM, createGameForm);
            }
            model.addAttribute(AttributesEnum.LEVEL_TYPES_MAP, LevelGenerators.getAvailableGenerators());
        }

        Model gameModel = Model.getInstance();
        GameInstance userGame = gameModel.getByUser(client.getId());
        if (userGame != null) {
            model.addAttribute(AttributesEnum.GAME, userGame);
            Game gameStats = gameDAO.getById(userGame.getId());
            GameInfo info = new GameInfo();
            info.setGameStatistics(gameStats);
            info.setGameObject(userGame);
            info.setCreator(userDAO.getUserWith(gameStats.getCreatorId()));
            model.addAttribute(AttributesEnum.GAME_INFO, info);
        }
        Map<Long, GameInstance> games;
        if (client.hasAnyRole("ROLE_ADMIN")) {
            games = gameModel.getAllTournaments();
            if (!model.containsAttribute(AttributesEnum.CREATE_GAME_FORM)) {
                CreateGameForm createGameForm = new CreateGameForm();
                model.addAttribute(AttributesEnum.CREATE_GAME_FORM, createGameForm);
            }
            model.addAttribute(AttributesEnum.LEVEL_TYPES_MAP, LevelGenerators.getAvailableGenerators());
        } else {
            games = gameModel.getNotStartedTournaments();
        }
        Map<Long, GameInfo> gamesToShow = new HashMap<Long, GameInfo>(games.size());
        for(Long gameId : games.keySet()) {
            GameInfo gameInfo = new GameInfo();
            gameInfo.setGameObject(games.get(gameId));
            gameInfo.setGameStatistics(gameDAO.getById(gameId));
            gameInfo.setCreator(userDAO.getUserWith(gameInfo.getGameStatistics().getCreatorId()));
            gamesToShow.put(gameId, gameInfo);
        }
        if (gamesToShow.size() > 0) {
            model.addAttribute(AttributesEnum.GAMES, gamesToShow);
            model.addAttribute(AttributesEnum.GAMES_FROM_MODEL, games);
            return ViewsEnum.BATTLE;
        }
        return ViewsEnum.BATTLE;
    }

    @RequestMapping(value = "/" + ViewsEnum.CREATE_NEW_GAME + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String showCreateGamePage(@ModelAttribute Client client, ModelMap model){
        if (!model.containsAttribute(AttributesEnum.CREATE_GAME_FORM)) {
            CreateGameForm createGameForm = new CreateGameForm();
            model.addAttribute(AttributesEnum.CREATE_GAME_FORM, createGameForm);
        }
        model.addAttribute(AttributesEnum.LEVEL_TYPES_MAP, LevelGenerators.getAvailableGenerators());
        return ViewsEnum.CREATE_NEW_GAME;
    }

    @RequestMapping(value = "/" + ViewsEnum.CREATE_NEW_GAME + ViewsEnum.EXTENSION, method = RequestMethod.POST)
    public String onSubmitNewBattle(@ModelAttribute Client client, @ModelAttribute CreateGameForm createGameForm, BindingResult result, ModelMap model) {
        User user = userDAO.getUserWith(client.getId());
        this.createGameValidator.validate(createGameForm, result);
        if (result.hasErrors()) {
            model.addAttribute(AttributesEnum.LEVEL_TYPES_MAP, LevelGenerators.getAvailableGenerators());
            return showCreateGamePage(client, model);
        }
        Model gameModel = Model.getInstance();
        Long id = generateId();
        Game game = new Game();
        game.setGameId(id);
        game.setTitle(createGameForm.getTitle());
        game.setDescription(createGameForm.getDescription());
        boolean admin = client.hasAnyRole(Authority.ROLE_ADMIN.getAuthority());
        game.setType(admin ? GameType.ADMIN_TOURNAMENT : GameType.PLAYER_TOURNAMENT);
        game.setState(GameState.NOT_STARTED);
        game.setCreatorId(user.getId());
	    game.setTimeCreated(new Timestamp(System.currentTimeMillis()));
        gameDAO.addGame(game);
        MapGenerator generator = LevelGenerators.getGenerator(createGameForm.getType());
        generator.setNamingHandler(new FileRandomNamingHandler());
        GameInstance newGame = gameModel.createNewGame(generator, id, game.getType(), createGameForm.getTitle(), user);
        if (!admin) {
            // The should be no chance for a user to create a game while playing another game
            GameInstance existingGame = gameModel.getByUser(user.getId());
            if (existingGame != null) {
                existingGame.deleteUser(user.getId());
            }
            newGame.addPlayer(user);
        }
        return "redirect:" + ViewsEnum.BATTLE + ViewsEnum.EXTENSION;
    }


    @RequestMapping(value = "/" + ViewsEnum.JOIN_TO_GAME + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String joinToGame(@RequestParam(value = AttributesEnum.GAME_ID, required = true) Long id, @ModelAttribute Client client, ModelMap model) {
        Model gameModel = Model.getInstance();
        GameInstance gameToJoin = gameModel.getByUser(client.getId());
        if (gameToJoin != null && gameToJoin.isFinished()) {
            gameToJoin.deleteUser(client.getId());
            gameToJoin = null;
        }
        if (gameToJoin != null) {
            return "return:" + ViewsEnum.BATTLE + ViewsEnum.EXTENSION;
        }
        GameInstance game = gameModel.getGameById(id);
        try {
            game.addPlayer(userDAO.getUserWith(client.getId()));
            gameDAO.addPlayer(client.getId(), game.getId());
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return "redirect:" + ViewsEnum.BATTLE + ViewsEnum.EXTENSION;
    }

    @RequestMapping(value = "/" + ViewsEnum.DELETE_FROM_GAME + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String deleteFromGame(@ModelAttribute Client client, @RequestParam(value = AttributesEnum.GAME_ID, required = true) Long gameId, @RequestParam(value = AttributesEnum.PLAYER_ID, required = true) Long playerId, ModelMap model, HttpServletResponse response) {
        Model gameModel = Model.getInstance();
        boolean isAdmin = client.hasAnyRole(Authority.ROLE_ADMIN.getAuthority());
        GameInstance gameToJoin = gameModel.getByUser(playerId);
        if (gameToJoin != null && gameToJoin.getId() == gameId) {
            Game stats = gameDAO.getById(gameId);
            if (!client.canControlGame(stats)) {
                try {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            gameToJoin.deleteUser(playerId, isAdmin);   // admin can do a game without players
            gameDAO.deletePlayer(playerId, gameId);
        }
        if (isAdmin) {
            return "redirect:" + ViewsEnum.GAME_CONTROL + ViewsEnum.EXTENSION + "?gameId=" + gameId;
        } else {
            return "redirect:" + ViewsEnum.BATTLE + ViewsEnum.EXTENSION;
        }
    }

    // * begin NOT TO BE SUPPORTED * //
    @RequestMapping(value = "/" + ViewsEnum.GOD_MODE + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String showGodPage(@RequestParam(value = AttributesEnum.GAME_ID, required = false) Long id, @ModelAttribute Client client, ModelMap model) {
        MultipleLoginForm form =
                model.containsAttribute("multipleLoginForm") ?
                        (MultipleLoginForm) model.get("multipleLoginForm") : new MultipleLoginForm();
        if (id != null) {
            form.setIdGame(id);
        }
        model.addAttribute("multipleLoginForm", form);
        return ViewsEnum.GOD_MODE;
    }

    @RequestMapping(value = "/" + ViewsEnum.GOD_MODE + ViewsEnum.EXTENSION, method = RequestMethod.POST)
    public String joinToGame(@ModelAttribute Client client, @ModelAttribute MultipleLoginForm multipleLoginForm, ModelMap model) {
        String msg = "";
        Model gameModel = Model.getInstance();
        GameInstance game = gameModel.getGameById(multipleLoginForm.getIdGame());
        String[] logins = multipleLoginForm.getLogins().replaceAll("\\s", "").split(",");
        for (String login : logins) {
            User u = userDAO.getUserWith(login);
            if (u != null) {
                try {
                    game.addPlayer(u);
                    gameDAO.addPlayer(u.getId(), game.getId());
                    msg += login + " logged in; ";
                } catch (Exception e) {
                    msg += login + " failed with " + e.getMessage() + "; ";
                }
            } else {
                msg += login + " not found in db; ";
            }
        }
        model.addAttribute(AttributesEnum.MESSAGE, msg);
        return showGodPage(null, client, model);
    }
    // * end of NOT TO BE SUPPORTED * //

    @RequestMapping(value = "/" + ViewsEnum.GAME_CONTROL + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String showGameControl(@RequestParam(value = AttributesEnum.GAME_ID, required = true) Long id, ModelMap model, @ModelAttribute Client client) {
        GameInstance gameInstance = Model.getInstance().getGameById(id);
        model.addAttribute(AttributesEnum.GAME, gameInstance);
        return ViewsEnum.GAME_CONTROL;
    }

    @RequestMapping(value = "/" + ViewsEnum.DELETE_GAME + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String deleteGame(@RequestParam(value = AttributesEnum.GAME_ID, required = true) Long id, @ModelAttribute Client client, ModelMap model, HttpServletResponse response) {
        Model gameModel = Model.getInstance();
        if (gameModel.getGameById(id) != null) {
            Game stats = gameDAO.getById(id);
            if (!client.canControlGame(stats)) {
                try {
                    response.sendError(HttpServletResponse.SC_FORBIDDEN);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            gameModel.deleteGameById(id);
            //gameDAO.deleteById(id);
        }
        return "redirect:" + ViewsEnum.BATTLE + ViewsEnum.EXTENSION;
    }


    @RequestMapping(value = "/" + ViewsEnum.START_GAME + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String startGame(@RequestParam(value = AttributesEnum.GAME_ID, required = true) Long id, @ModelAttribute Client client, ModelMap model) {
        Model gameModel = Model.getInstance();
        GameInstance game = gameModel.getGameById(id);
        if (game == null) {
            return "redirect:" + ViewsEnum.BATTLE + ViewsEnum.EXTENSION;
        }
        if (game.getNumberOfPlayers() < Settings.MINIMAL_PLAYERS_NUMBER) {
            model.addAttribute(AttributesEnum.ERROR_SHOW_GAMES, "notEnoughPlayers.game.errorNumber");
            return "redirect:" + ViewsEnum.BATTLE + ViewsEnum.EXTENSION;
        }
        GameThread gameThread = new GameThread(game);
        new Thread(gameThread).start();
        if(client.hasAnyRole(Authority.ROLE_ADMIN.getAuthority())) {
            return showGameControl(id, model, client);
        } else {
            return "redirect:" + ViewsEnum.BATTLE + ViewsEnum.EXTENSION;
        }
    }


    @RequestMapping(value = "/" + ViewsEnum.CURRENT_GAME + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String showCurrentGame(@ModelAttribute Client client, ModelMap model) {
        Model gameModel = Model.getInstance();
        GameInstance game = gameModel.getByUser(client.getId());
        model.addAttribute(AttributesEnum.GAME, game);
        return ViewsEnum.CURRENT_GAME;
    }


    @RequestMapping(value = "/" + ViewsEnum.LEAVE_GAME + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String leaveGame(@RequestParam(value = AttributesEnum.GAME_ID, required = true) Long id, @ModelAttribute Client client, ModelMap model) {
        Model gameModel = Model.getInstance();
        GameInstance game = gameModel.getGameById(id);
        if (game != null) {
            Game gameStat = gameDAO.getById(game.getId());
            game.deleteUser(client.getId());
            if(client.canControlGame(gameStat)){
                gameModel.deleteGameById(game.getId());
            }
        }
        return "redirect:" + ViewsEnum.BATTLE + ViewsEnum.EXTENSION;
    }

    @RequestMapping(value = "/" + ViewsEnum.TRAINING_LEVEL + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String showTrainingLevel(@ModelAttribute Client client, ModelMap model) {
        Model gameModel = Model.getInstance();
        User user = userDAO.getUserWith(client.getId());
        GameInstance gameToStart = gameModel.getByUser(client.getId());
        if (gameToStart != null && gameToStart.isFinished()) {
            gameToStart.deleteUser(client.getId());
            gameToStart = null;
        }
        if (gameToStart == null) {
            if (!model.containsAttribute(AttributesEnum.TRAINING_LEVEL_FORM)) {
                model.addAttribute(AttributesEnum.TRAINING_LEVEL_FORM, new CreateTrainingLevelForm());
            }
            model.addAttribute(AttributesEnum.MAX_TRAINING_BOTS, Settings.MAXIMAL_PLAYERS_NUMBER - 1);
            model.addAttribute(AttributesEnum.TOKEN, user.getToken());
            model.addAttribute(AttributesEnum.LEVEL_TYPES_MAP, LevelGenerators.getAvailableGenerators());
        }
        model.addAttribute(AttributesEnum.GAME, gameToStart);
        return ViewsEnum.TRAINING_LEVEL;
    }

    @RequestMapping(value = "/" + ViewsEnum.TRAINING_LEVEL + ViewsEnum.EXTENSION, method = RequestMethod.POST)
    public String startTrainingLevel(@ModelAttribute CreateTrainingLevelForm createTrainingLevelForm, BindingResult result, @ModelAttribute Client client, ModelMap model) {
        trainingLevelFormValidator.validate(createTrainingLevelForm, result);
        if (result.hasErrors()) {
            return showTrainingLevel(client, model);
        }
        User user = userDAO.getUserWith(client.getId());
        Long id = generateId();
        Game game = new Game();
        game.setGameId(id);
        game.setTitle(ViewsEnum.TRAINING_LEVEL);
        game.setType(GameType.TRAINING_LEVEL);
        game.setState(GameState.NOT_STARTED);
        game.setCreatorId(user.getId());
	    game.setTimeCreated(new Timestamp(System.currentTimeMillis()));
        gameDAO.addGame(game);
        MapGenerator generator = new TriangleMapGenerator();
        generator.setNamingHandler(new FileRandomNamingHandler());
        GameInstance gameToStart = Model.getInstance().createNewGame(id, GameType.TRAINING_LEVEL, ViewsEnum.TRAINING_LEVEL, user);
        gameToStart.addPlayer(user);
        if (!GameType.TRAINING_LEVEL.equals(game.getType())) {
            return ViewsEnum.TRAINING_LEVEL;
        }
        gameToStart.setMapGenerator(LevelGenerators.getGenerator(createTrainingLevelForm.getType()));
        int i = 0;
        int trueI = 0;
        while (trueI < Settings.TRAINIG_BOT_LOGINS.length && i < createTrainingLevelForm.getBotsCount()) {
            User bot = userDAO.getUserWith(Settings.TRAINIG_BOT_LOGINS[i]);
            if (bot != null) {
                gameToStart.addPlayer(bot);
                gameToStart.addBot(bot);
                i++;
            }
            trueI++;
        }
        if (gameToStart.getNumberOfPlayers() < Settings.MINIMAL_PLAYERS_NUMBER) {
            return ViewsEnum.TRAINING_LEVEL;
        }
        GameThread gameThread = new GameThread(gameToStart);
        new Thread(gameThread).start();
        return "redirect:" + ViewsEnum.TRAINING_LEVEL + ViewsEnum.EXTENSION;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/" + ViewsEnum.SHOW_GAME_TABLE + ViewsEnum.EXTENSION)
    public String getStatisticsTable(@RequestParam(required = true, value = "gameId") Long gameId, Client client, ModelMap model) {
        Model gameModel = Model.getInstance();
        GameInstance gameInstance = gameModel.getGameById(gameId);
        Game gameStat = gameDAO.getById(gameId);
        GameInfo gameInfo = new GameInfo();
        gameInfo.setGameStatistics(gameStat);
        gameInfo.setGameObject(gameInstance);
        // gameInfo.setCreator();   // an overkill
        model.addAttribute("gameInfo", gameInfo);
        model.addAttribute("requestHandler", SocketResponseSender.getInstance());
        return ViewsEnum.SHOW_GAME_TABLE;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/" + ViewsEnum.BROADCAST + ViewsEnum.EXTENSION)
    public String showGameForBroadcasting(@RequestParam(required = true, value = "gameId") Long gameId, Client client, ModelMap model) {
        Model gameModel = Model.getInstance();
        GameInstance gameInstance = gameModel.getGameById(gameId);
        if (gameInstance != null) {
            Game gameStats = gameDAO.getById(gameId);
            GameInfo gi = new GameInfo();
            gi.setGameObject(gameInstance);
            gi.setGameStatistics(gameStats);
            model.addAttribute(AttributesEnum.GAME, gameInstance);
            model.addAttribute(AttributesEnum.GAME_INFO, gi);
        }
        return ViewsEnum.BROADCAST;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/" + ViewsEnum.GAME_LIST_AJAX + ViewsEnum.EXTENSION)
    public String getGamesList(Client client, ModelMap model) {
        Model gameModel = Model.getInstance();
        GameInstance userGame = gameModel.getByUser(client.getId());
        if (userGame != null) {
            model.addAttribute(AttributesEnum.GAME, userGame);
            Game gameStats = gameDAO.getById(userGame.getId());
            GameInfo info = new GameInfo();
            info.setGameStatistics(gameStats);
            info.setGameObject(userGame);
            info.setCreator(userDAO.getUserWith(gameStats.getCreatorId()));
            model.addAttribute(AttributesEnum.GAME_INFO, info);
        }
        Map<Long, GameInstance> games = gameModel.getNotStartedTournaments();
        Map<Long, GameInfo> gamesToShow = new HashMap<Long, GameInfo>(games.size());
        for(Long gameId : games.keySet()) {
            GameInfo gameInfo = new GameInfo();
            gameInfo.setGameObject(games.get(gameId));
            gameInfo.setGameStatistics(gameDAO.getById(gameId));
            gameInfo.setCreator(userDAO.getUserWith(gameInfo.getGameStatistics().getCreatorId()));
            gamesToShow.put(gameId, gameInfo);
        }
        if (gamesToShow.size() > 0) {
            model.addAttribute(AttributesEnum.GAMES, gamesToShow);
            model.addAttribute(AttributesEnum.GAMES_FROM_MODEL, games);
            return ViewsEnum.GAME_LIST_AJAX ;
        }
        return ViewsEnum.GAME_LIST_AJAX;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/" + ViewsEnum.CHECK_GAME_AJAX + ViewsEnum.EXTENSION)
    public String checkGameInfo(@RequestParam(required = true, value = "gameId") Long gameId, Client client, ModelMap model) {
        Model gameModel = Model.getInstance();
        GameInstance gameObject = gameModel.getGameById(gameId);
        GameInfo gameInfo = new GameInfo();
        if(gameObject != null) {
            gameInfo.setGameObject(gameObject);
            gameInfo.setGameStatistics(gameDAO.getById(gameId));
            model.addAttribute("userInTheGame", gameObject.hasPlayerWithId(client.getId()));
        }
        model.addAttribute(AttributesEnum.GAME_INFO, gameInfo);
        return ViewsEnum.CHECK_GAME_AJAX;
    }

    private Long generateId() {
        return (new Date()).getTime();
    }

}