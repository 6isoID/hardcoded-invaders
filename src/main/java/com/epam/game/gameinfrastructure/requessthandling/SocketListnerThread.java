package com.epam.game.gameinfrastructure.requessthandling;

import com.epam.game.constants.Settings;
import com.epam.game.gameinfrastructure.parser.ClientRequestParser;
import com.epam.game.gameinfrastructure.parser.SAXParserWrapper;
import com.epam.game.gamemodel.model.Model;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Listener of socket. All requests from clients (bot) are being put to Thread
 * Pool.
 * 
 * @author Andrey_Eremeev
 * 
 */

@Slf4j
public class SocketListnerThread implements Runnable {


    private ServerSocket serverSocket;

    private Model model;

    private ClientRequestParser parser;

    private final long readTimeoutMs;

    private final int webSocketPort;

    protected ExecutorService threadPool = Executors.newFixedThreadPool(10);
    
    private boolean alive = true;

    public SocketListnerThread(Model model, long readTimeoutMs, int webSocketPort) {
        this.model = model;
        this.readTimeoutMs = readTimeoutMs;
        this.webSocketPort = webSocketPort;
    }

    public void run() {
        try {
            log.info("Exposing server socket listener on port: " + webSocketPort);
            serverSocket = new ServerSocket(webSocketPort);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (alive) {
            try {
                Socket socket = serverSocket.accept();
                parser = new SAXParserWrapper();
                this.threadPool.execute(new ClientRequestHandlerThread(socket, model,
                        parser, readTimeoutMs));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public void stopAndDie() {
        try {
            serverSocket.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        alive = false;
    }
}
