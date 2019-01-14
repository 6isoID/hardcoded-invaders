package com.epam.game.controller;

import com.epam.game.constants.AttributesEnum;
import com.epam.game.constants.ViewsEnum;
import com.epam.game.controller.forms.LoginForm;
import com.epam.game.controller.validators.LoginValidator;
import com.epam.game.dao.UserDAO;
import com.epam.game.domain.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Controller for working with login page.
 *
 * @author Roman_Spiridonov
 *
 */
@Controller
@SessionAttributes(value = AttributesEnum.CLIENT )
public class LoginController {

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private LoginValidator loginValidator;



    @RequestMapping( value = "/" + ViewsEnum.LOGIN + ViewsEnum.EXTENSION, method = RequestMethod.GET )
    public String showLoginForm( ModelMap model ) {
        LoginForm loginForm = new LoginForm();
        Client client = (Client) model.get( AttributesEnum.CLIENT );
        if ( client == null ) {
            client = new Client();
        }
        model.addAttribute( AttributesEnum.LOGIN_FORM, loginForm );
        model.addAttribute( AttributesEnum.CLIENT, client );
        return ViewsEnum.LOGIN;
    }



    @RequestMapping( value = "/" + ViewsEnum.LOGIN + ViewsEnum.EXTENSION, method = RequestMethod.POST )
    public String onSubmit(@ModelAttribute Client client,
                           @ModelAttribute LoginForm loginForm, BindingResult result ) {
//        this.loginValidator.validate( loginForm, result );
//        if ( result.hasErrors() ) {
//            return ViewsEnum.LOGIN;
//        }
//        User user = this.userDAO.getUserWith( loginForm.getUserName(),
//                                              loginForm.getPassword() );
//        client.setLogin( user.getLogin() );
//        client.setId( user.getId() );
//        client.setUserName( user.getUserName() );
//        client.setAuthorities( user.getAuthorities() );
//        return "redirect:" + ViewsEnum.DOCUMENTATION + ViewsEnum.EXTENSION;
        return null;
    }



    @RequestMapping( value = "/" + ViewsEnum.LOGOUT + ViewsEnum.EXTENSION, method = RequestMethod.GET )
    public String logout(HttpSession session, HttpServletResponse response, HttpServletRequest request, ModelMap model ) {
       
        session.setAttribute( AttributesEnum.CLIENT, null );
        model.remove( AttributesEnum.CLIENT);
        session.removeAttribute( AttributesEnum.CLIENT );
         session.invalidate();
        return "redirect:" + ViewsEnum.LOGIN + ViewsEnum.EXTENSION;
    }


}
