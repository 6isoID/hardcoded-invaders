package com.epam.game.gamemodel.gamehandler;

import com.epam.game.constants.Settings;
import com.epam.game.gamemodel.model.GameInstance;

public class GameThread implements Runnable {

    private final long TIMEOUT = Settings.GAME_TURN_DELAY;

    private GameInstance game;

    public GameThread(GameInstance game) {
        this.game = game;
    }

    public GameInstance getGame() {
        return game;
    }

    public void run() {
        try {
            game.start();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (game.isStarted() && !game.isFinished()) {            
            try {
                Thread.sleep(TIMEOUT);
                game.nextTurn();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
