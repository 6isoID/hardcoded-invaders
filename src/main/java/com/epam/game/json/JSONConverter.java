package com.epam.game.json;

import com.epam.game.constants.Settings;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.epam.game.domain.User;
import com.epam.game.gamemodel.model.GameInstance;
import com.epam.game.gamemodel.model.UserScore;
import com.epam.game.gamemodel.model.Vertex;

/**
 * {@code JSONConverter} implements some methods to create JSON representations
 * of model objects.
 * 
 * @author Evgeny_Tetuhin
 * 
 */
public class JSONConverter {

    /**
     * Creates a JSONObject representing the game field.
     * 
     * @param vertices
     *            - collection of {@link Vertex}
     * @return JSONObject
     */
    @SuppressWarnings("unchecked")
    public JSONObject generateGameMapMessage(GameInstance game) {
        JSONObject result = new JSONObject();
        JSONArray planetMap = new JSONArray();
        JSONObject aPlanet;
        JSONArray neighbours;
        for (Vertex v : game.getVertices()) {
            aPlanet = new JSONObject();
            aPlanet.put("id", v.getId());
            aPlanet.put("name", v.getName());
            aPlanet.put("owner", (v.getOwner() != null) ? v.getOwner().getUserName() : "neutral");
            aPlanet.put("xCoord", v.getPoint().getX());
            aPlanet.put("yCoord", v.getPoint().getY());
            aPlanet.put("regenRate", v.getType().getRegenerationRate());
            aPlanet.put("unitsCount", v.getUnitsCount());
            aPlanet.put("type", v.getType().name());
            neighbours = new JSONArray();
            for (Vertex n : v.getNeighbours()) {
                neighbours.add(n.getId());
            }
            aPlanet.put("neighbors", neighbours);
            planetMap.add(aPlanet);
        }
        result.put("planetMap", planetMap);
        JSONArray players = new JSONArray();
        for (User u : game.getPlayers()) {
            JSONObject player = new JSONObject();
            player.put("name", u.getUserName());
            players.add(player);
        }
        result.put("players", players);
        String status = (game.isStarted()) ? (game.isFinished() ? "finished" : "started") : "not started";
        result.put("gameState", status);
        
        if(game.isStarted() && game.isFinished()){
            JSONArray scores = new JSONArray();
            for(UserScore us : game.getStatistics()){
                JSONObject score = new JSONObject();
                score.put("player", us.getUser().getUserName());
                score.put("lastTurn", us.getTurnsSurvived());
                score.put("place", us.getPlace());
                score.put("unitsCount", us.getUnitsCount());
                scores.add(score);
            }
            result.put("scores", scores);
        }
        
        return result;
    }

    /**
     * Creates a JSONObject representing all changes made during the last turn.
     * 
     * @param vertices
     *            - collection of {@link Vertex}
     * @return JSONObject
     */
    @SuppressWarnings("unchecked")
    public JSONObject generatePlayersActionsMessage(GameInstance game) {
        List<Vertex> vertices = game.getVertices();
        List<GameInstance.Change> changes = game.getChanges();
        Long turnNumber = game.getTurnsNumber();

        JSONObject result = new JSONObject();
        JSONObject playersActions = new JSONObject();
        JSONArray planetsOwners = new JSONArray();
        JSONArray actions = new JSONArray();
        JSONObject change;
        JSONObject owner;
        for (Vertex v : vertices) {
            owner = new JSONObject();
            owner.put("id", v.getId());
            owner.put("owner", (v.getOwner() != null) ? v.getOwner().getUserName() : "neutral");
            owner.put("unitsCount", v.getUnitsCount());
            planetsOwners.add(owner);
        }
        playersActions.put("planetOwners", planetsOwners);
        for (GameInstance.Change ch : changes) {
            change = new JSONObject();

            change.put("from", ch.from);
            change.put("to", ch.to);
            change.put("unitCount", ch.count);
            actions.add(change);
        }

        playersActions.put("actions", actions);
        result.put("playersActions", playersActions);
        String status = (game.isStarted()) ? (game.isFinished() ? "finished" : "started") : "not started";
        result.put("gameState", status);
        result.put("turnNumber", turnNumber);
        
        if(game.isStarted() && game.isFinished()){
            JSONArray scores = new JSONArray();
            for(UserScore us : game.getStatistics()){
                JSONObject score = new JSONObject();
                score.put("player", us.getUser().getUserName());
                score.put("lastTurn", us.getTurnsSurvived());
                score.put("place", us.getPlace());
                score.put("unitsCount", us.getUnitsCount());
                scores.add(score);
            }
            result.put("scores", scores);
        }

        return result;
    }



    public JSONObject generateTurnDurationMessage() {
        JSONObject result = new JSONObject();
        result.put("TurnDelay",Settings.GAME_TURN_DELAY);
        return result;

    }



    public JSONObject generateNextGameTimeMessage() {
        JSONObject result = new JSONObject();
        result.put("NextGameTime",Settings.NEXT_GAME_TIME);
        return result;
    }
}
