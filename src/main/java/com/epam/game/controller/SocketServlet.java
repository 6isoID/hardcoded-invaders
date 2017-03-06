package com.epam.game.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epam.game.gameinfrastructure.requessthandling.SocketListnerThread;

/**
 * Servlet implementation class SocketServlet
 */
public class SocketServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private SocketListnerThread listenerThread;
    
    @Override
    public void init() throws ServletException {
        super.init();
        listenerThread = new SocketListnerThread();
        new Thread(listenerThread).start();
    }

    @Override
    public void destroy() {
        listenerThread.stopAndDie();
        super.destroy();
    }
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SocketServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     * response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }
}
