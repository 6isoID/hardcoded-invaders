package com.epam.game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.game.authorization.TokenGenerator;
import com.epam.game.constants.AttributesEnum;
import com.epam.game.constants.ViewsEnum;
import com.epam.game.controller.forms.ProfileForm;
import com.epam.game.controller.validators.ProfileValidator;
import com.epam.game.domain.Client;
import com.epam.game.domain.User;
import com.epam.game.gamemodel.model.GameInstance;
import com.epam.game.gamemodel.model.Model;
import com.epam.game.model.dao.GameDAO;
import com.epam.game.model.dao.UserDAO;

/**
 * Controller for working with profile page.
 * 
 * @author Roman_Spiridonov
 * 
 */
@Controller
@SessionAttributes(value = AttributesEnum.CLIENT)
public class ProfileController {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private GameDAO gameDAO;
    @Autowired
    private ProfileValidator profileValidator;

    @RequestMapping(value = "/" + ViewsEnum.PROFILE + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String showProfileForm(@ModelAttribute Client client, ModelMap model) {
        ProfileForm profileForm = (ProfileForm)model.get(AttributesEnum.PROFILE_FORM);
        User user = userDAO.getUserWith(client.getId());
        if(profileForm == null){
            profileForm = new ProfileForm();
            profileForm.setUserName(user.getUserName());
            profileForm.setEmail(user.getEmail());
            profileForm.setPhone(user.getPhone());
        }
        model.addAttribute(AttributesEnum.PROFILE_FORM, profileForm);
        model.addAttribute(AttributesEnum.TOURNAMENTS_NUMBER, gameDAO.getNumberOfPlayedGamesFor(user).toString());
        model.addAttribute(AttributesEnum.TOURNAMENTS_WINS, gameDAO.getNumberOfWonGamesFor(user).toString());
        model.addAttribute(AttributesEnum.TOKEN, user.getToken());
        return ViewsEnum.PROFILE;
    }

    @RequestMapping(value = "/" + ViewsEnum.PROFILE + ViewsEnum.EXTENSION, method = RequestMethod.POST)
    public String saveProfileForm(@ModelAttribute Client client, ModelMap model,
            @ModelAttribute ProfileForm profileForm, BindingResult result) {
        this.profileValidator.validate(profileForm, result);
        User user = userDAO.getUserWith(client.getId());
        if(!profileForm.getNewPassword().isEmpty() || !profileForm.getOldPassword().isEmpty()){
            if(!profileForm.getOldPassword().equals(user.getPassword())){
                result.rejectValue("oldPassword", "oldPassword.incorrect.profileForm.oldPassword");
            } else {
                user.setPassword(profileForm.getNewPassword());
            }
        }
        if (result.hasErrors()) {
            return showProfileForm(client, model);
        }
        user.setUserName(profileForm.getUserName());
        user.setLogin(profileForm.getUserName());
        user.setPhone(profileForm.getPhone());
        user.setEmail(profileForm.getEmail());
        userDAO.updateUser(user);
        model.addAttribute(AttributesEnum.MESSAGE, "label.profileForm.success");
        return showProfileForm(client, model);
    }

    @RequestMapping(value = "/" + ViewsEnum.GENERATE_TOKEN
            + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String generateNewToken(@ModelAttribute Client client, ModelMap model) {
        Model gameModel = Model.getInstance();
        GameInstance game = gameModel.getByUser(client.getId());
        if (game == null) {
            User user = userDAO.getUserWith(client.getId());
            user.setToken(TokenGenerator.generate());
            userDAO.updateUser(user);
            return "redirect:" + ViewsEnum.PROFILE + ViewsEnum.EXTENSION;
        } else {
            model.addAttribute(AttributesEnum.ERROR_TOKEN,
                    "errGenerateToken.profile.token");
            return showProfileForm(client, model);
        }
    }
}