package com.epam.game.controller;

import com.epam.game.constants.AttributesEnum;
import com.epam.game.constants.ViewsEnum;
import com.epam.game.controller.forms.SignUpForm;
import com.epam.game.controller.validators.SignUpValidator;
import com.epam.game.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 * Controller for working with Sign Up page
 * 
 * @author Roman_Spiridonov
 * 
 */
@Controller
@SessionAttributes(value = AttributesEnum.CLIENT)
public class SignUpController {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private SignUpValidator signUpValidator;

    @RequestMapping(value = "/" + ViewsEnum.SIGN_UP + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String showSignUpForm(ModelMap model) {
        SignUpForm signUpForm = new SignUpForm();
        model.addAttribute(AttributesEnum.SIGN_UP_FORM, signUpForm);
        return ViewsEnum.SIGN_UP;
    }

    @RequestMapping(value = "/" + ViewsEnum.SIGN_UP + ViewsEnum.EXTENSION, method = RequestMethod.POST)
    public String onSubmit(@ModelAttribute SignUpForm signUpForm,
                           BindingResult result, ModelMap model) {
//        if (!Settings.REGISTRATION_IS_OPEN) {
//            return ViewsEnum.SIGN_UP;
//        }
//        this.signUpValidator.validate(signUpForm, result);
//        if (result.hasErrors()) {
//            return ViewsEnum.SIGN_UP;
//        }
//        List<Authority> authorities = new ArrayList<Authority>();
//        authorities.add(Authority.ROLE_USER);
//        User userToDB = new User();
//        userToDB.setAuthorities(authorities);
//        userToDB.setLogin(signUpForm.getName());
//        userToDB.setPassword(signUpForm.getPassword());
//        userToDB.setToken(TokenGenerator.generate());
//        userToDB.setUserName(signUpForm.getName());
//        userToDB.setEmail(signUpForm.getEmail());
//        userToDB.setPhone(signUpForm.getPhone());
//        userDAO.addUser(userToDB);
//        User user = userDAO.getUserWith(signUpForm.getName(),
//                signUpForm.getPassword());
//        Client client = new Client();
//        client.setId(user.getId());
//        client.setLogin(user.getLogin());
//        client.setUserName(user.getUserName());
//        client.setAuthorities(user.getAuthorities());
//        model.addAttribute(AttributesEnum.CLIENT, client);
        return "redirect:" + ViewsEnum.DOCUMENTATION + ViewsEnum.EXTENSION;
    }
}
