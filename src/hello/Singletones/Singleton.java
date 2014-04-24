/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.Singletones;

import hello.ArtficialIntelligence;
import hello.Controller;
import hello.players.*;
import javax.microedition.lcdui.Image;

/**
 *
 * @author Royal
 */

public class Singleton {

    private static BluePlayer bluePlayer1;
    private static BluePlayer bluePlayer2;
    private static BluePlayer bluePlayer3;
    private static BluePlayer bluePlayer4;
    private static RedPlayer redPlayer1;
    private static RedPlayer redPlayer2;
    private static RedPlayer redPlayer3;
    private static RedPlayer redPlayer4;
    private static GreenPlayer greenPlayer1;
    private static GreenPlayer greenPlayer2;
    private static GreenPlayer greenPlayer3;
    private static GreenPlayer greenPlayer4;
    private static YellowPlayer yellowPlayer1;
    private static YellowPlayer yellowPlayer2;
    private static YellowPlayer yellowPlayer3;
    private static YellowPlayer yellowPlayer4;
    private static Controller game_manager;
    private static ArtficialIntelligence kasozi;
    private static Image ludo_board;
    //integers
    private static int initial_y = 0;
    private static int img_height = 0;
    //strings
    private static String score;
    //booleans
    private static boolean drawScoreAllowed = false;
    private static boolean draw_number = false;
    private static boolean drawRoadBlockedSign = false;
    private static boolean drawBluePlayerHasFinishedSign = false;
    private static boolean green_has_finished = false;
    private static boolean yellow_has_finished = false;
    private static boolean red_has_finished = false;
    private static boolean blue_has_finished = false;

    /**
     * @return the bluePlayer1
     */
    public static BluePlayer getBluePlayer1() {
        return bluePlayer1;
    }

    /**
     * @return the bluePlayer2
     */
    public static BluePlayer getBluePlayer2() {
        return bluePlayer2;
    }

    /**
     * @return the bluePlayer3
     */
    public static BluePlayer getBluePlayer3() {
        return bluePlayer3;
    }

    /**
     * @return the bluePlayer4
     */
    public static BluePlayer getBluePlayer4() {
        return bluePlayer4;
    }

    /**
     * @return the redPlayer1
     */
    public static RedPlayer getRedPlayer1() {
        return redPlayer1;
    }

    /**
     * @return the redPlayer2
     */
    public static RedPlayer getRedPlayer2() {
        return redPlayer2;
    }

    /**
     * @return the redPlayer3
     */
    public static RedPlayer getRedPlayer3() {
        return redPlayer3;
    }

    /**
     * @return the redPlayer4
     */
    public static RedPlayer getRedPlayer4() {
        return redPlayer4;
    }

    /**
     * @return the greenPlayer1
     */
    public static GreenPlayer getGreenPlayer1() {
        return greenPlayer1;
    }

    /**
     * @return the greenPlayer2
     */
    public static GreenPlayer getGreenPlayer2() {
        return greenPlayer2;
    }

    /**
     * @return the greenPlayer3
     */
    public static GreenPlayer getGreenPlayer3() {
        return greenPlayer3;
    }

    /**
     * @return the greenPlayer4
     */
    public static GreenPlayer getGreenPlayer4() {
        return greenPlayer4;
    }

    /**
     * @return the yellowPlayer1
     */
    public static YellowPlayer getYellowPlayer1() {
        return yellowPlayer1;
    }

    /**
     * @return the yellowPlayer2
     */
    public static YellowPlayer getYellowPlayer2() {
        return yellowPlayer2;
    }

    /**
     * @return the yellowPlayer3
     */
    public static YellowPlayer getYellowPlayer3() {
        return yellowPlayer3;
    }

    /**
     * @return the yellowPlayer4
     */
    public static YellowPlayer getYellowPlayer4() {
        return yellowPlayer4;
    }

    /**
     * @return the game_manager
     */
    public static Controller getGame_manager() {
        return game_manager;
    }

    /**
     * @return the kasozi
     */
    public static ArtficialIntelligence getKasozi() {
        return kasozi;
    }

    /**
     * @return the ludo_board
     */
    public static Image getLudo_board() {
        return ludo_board;
    }

    /**
     * @return the initial_y
     */
    public static int getInitial_y() {
        return initial_y;
    }

    /**
     * @return the img_height
     */
    public static int getImg_height() {
        return img_height;
    }

    /**
     * @return the score
     */
    public static String getScore() {
        return score;
    }

    /**
     * @return the drawScoreAllowed
     */
    public static boolean isDrawScoreAllowed() {
        return drawScoreAllowed;
    }

    /**
     * @return the draw_number
     */
    public static boolean isDraw_number() {
        return draw_number;
    }

    /**
     * @return the drawRoadBlockedSign
     */
    public static boolean isDrawRoadBlockedSign() {
        return drawRoadBlockedSign;
    }

    /**
     * @return the drawBluePlayerHasFinishedSign
     */
    public static boolean isDrawBluePlayerHasFinishedSign() {
        return drawBluePlayerHasFinishedSign;
    }

    /**
     * @return the green_has_finished
     */
    public static boolean isGreen_has_finished() {
        return green_has_finished;
    }

    /**
     * @return the yellow_has_finished
     */
    public static boolean isYellow_has_finished() {
        return yellow_has_finished;
    }

    /**
     * @return the red_has_finished
     */
    public static boolean isRed_has_finished() {
        return red_has_finished;
    }

    /**
     * @return the blue_has_finished
     */
    public static boolean isBlue_has_finished() {
        return blue_has_finished;
    }
}
