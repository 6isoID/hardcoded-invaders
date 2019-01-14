package com.epam.game.utils;

import com.epam.game.constants.AttributesEnum;
import com.epam.game.domain.Client;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
    
    public static Client getClient(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Client client = (Client) session.getAttribute(AttributesEnum.CLIENT);
        return client;
    }
}
