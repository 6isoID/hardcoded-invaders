package com.epam.game.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.epam.game.constants.AttributesEnum;
import com.epam.game.constants.ViewsEnum;

/**
 * Controller for working with information page.
 * 
 * @author Roman_Spiridonov
 * 
 */
@Controller
@SessionAttributes(value = AttributesEnum.CLIENT)
public class InformationController {

    @RequestMapping(value = "/" + ViewsEnum.INFO_PAGE + ViewsEnum.EXTENSION, method = RequestMethod.GET)
    public String showInformation() {
        return ViewsEnum.INFO_PAGE;
    }
}
