/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epam.game.controller;

import com.epam.game.authorization.TokenGenerator;
import com.epam.game.constants.AttributesEnum;
import com.epam.game.constants.RequestType;
import com.epam.game.constants.ViewsEnum;
import com.epam.game.controller.forms.SignUpForm;
import com.epam.game.domain.Authority;
import com.epam.game.domain.Client;
import com.epam.game.domain.User;
import com.epam.game.gamemodel.model.GameInstance;
import com.epam.game.gamemodel.model.Model;
import com.epam.game.json.JSONConverter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Sergey_Fedorov
 */
@Controller
public class SettingsController {

    @RequestMapping(value = "/" + ViewsEnum.SETTINGS + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public void getParameter(@RequestParam( value = AttributesEnum.AJAX_REQUEST_TYPE ) String requestType, HttpServletResponse response ) {
        RequestType type = RequestType.valueOf( requestType );

        // Selection of generation type.
        JSONConverter converter = new JSONConverter();
        JSONObject object = null;
        
        switch ( type ) {
            case TURN_DURATION:
                object = converter.generateTurnDurationMessage();
                break;
            case NEXT_GAME_TIME:
                object = converter.generateNextGameTimeMessage();
                break;
        }
        // Addition of JSON object to response.
        if ( object != null ) {
            try {
                PrintWriter writer = response.getWriter();
                writer.print( object.toJSONString() );
                writer.flush();
                writer.close();
            } catch ( IOException ex ) {
                Logger.getLogger( ViewDataController.class.getName() ).log(
                        Level.SEVERE, null, ex );
            }
        }
    }


}
