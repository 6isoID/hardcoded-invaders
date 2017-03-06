package com.epam.game.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.epam.game.constants.AttributesEnum;
import com.epam.game.domain.Client;

public class SessionUtils {
    
    public static Client getClient(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute(AttributesEnum.CLIENT);
        return client;
    }
}
