package com.epam.game.controller;

import com.epam.game.conf.WebSocketProperties;
import com.epam.game.dao.GameDAO;
import com.epam.game.gameinfrastructure.requessthandling.SocketListnerThread;
import com.epam.game.gamemodel.model.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * Servlet implementation class SocketServlet
 */
@Configuration
@DependsOn("liquibase")
@RequiredArgsConstructor
public class SocketServlet {

    private SocketListnerThread listenerThread;

    private final GameDAO gameDAO;
    private final Model model;
    private final WebSocketProperties webSocketProperties;

    @PostConstruct
    public void init()  {
        long clientTimeout = gameDAO.getSettings().getClientTimeoutMs();
        listenerThread = new SocketListnerThread(model,clientTimeout, webSocketProperties.getPort());
        new Thread(listenerThread).start();
    }

    @PreDestroy
    public void destroy() {
        listenerThread.stopAndDie();
    }
}
