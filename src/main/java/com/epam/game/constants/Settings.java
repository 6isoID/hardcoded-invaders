package com.epam.game.constants;

import java.util.GregorianCalendar;

public class Settings {

    /**
     * Time in milliseconds between turns.
     */
    public static final long GAME_TURN_DELAY = 2000;

    /**
     * Enumeration of bot logins. Used to show bot selectors in views and to add bots to game.
     */
    public static final String[] TRAINIG_BOT_LOGINS = {"bot", "bot2", "bot3", "bot4", "bot5", "bot6", "bot7", "bot8", "bot9", "bot10"};

    /**
     * A port to listen for players requests.
     */
    public static final int PORT = 10040;

    /**
     * Time in milliseconds when the great tournament will be started.
     */
    public static final Long NEXT_GAME_TIME =  new GregorianCalendar( 2014, 7, 19, 18, 0 ).getTimeInMillis();
    
    /**
     * Maximal time for reading client's messages.
     */
    public static final long READING_TIMEOUT = 10000;

    /**
     * Delay before error response sending. Used to reduce server loading.
     */
    public static final long ERROR_RESPONSE_DELAY = 500;

    /**
     * After that number of turns game stops and player with maximal number of units became the game winner.
     */
    public static final long GAME_TURNS_LIMIT = 200;

    public static final int MINIMAL_PLAYERS_NUMBER = 2;

    public static final int MAXIMAL_TITLE_LENGTH = 200;
    public static final int MAXIMAL_PLAYERS_NUMBER = 8;

	public static final int DAYS_TO_SHOW = 1;

	public static final int STAT_ROWS_TO_SHOW = 30;
    public static final boolean REGISTRATION_IS_OPEN = false;
}
