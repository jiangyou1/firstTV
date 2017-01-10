package gam.org.com.firstgame;

import gam.org.com.firstgame.model.Game;

/**
 * Created by wujamie on 17/1/8.
 */

public class GameManager {

    private static Game sGame;

    public static Game getInstance() {
        if (sGame == null) sGame = new Game();
        return sGame;
    }

    public static void setGame(Game game) {
        sGame = game;
    }

    public static void reset() {
        sGame = new Game();
    }
}
