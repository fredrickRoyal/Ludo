/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hello.Factories;

import hello.ludo;
import hello.players.BluePlayer;
import hello.players.GreenPlayer;
import hello.players.Player;
import hello.players.RedPlayer;
import hello.players.YellowPlayer;

/**
 *
 * @author Royal
 */
public class PlayerFactory {

    public static Player getPlayer(String player, int button_num) {

        if (player.equalsIgnoreCase("YELLOW")) {
            return new YellowPlayer(ludo.getLudoInstance(), button_num);
        } else if (player.equalsIgnoreCase("RED")) {
            return new RedPlayer(ludo.getLudoInstance(), button_num);
        } else if (player.equalsIgnoreCase("GREEN")) {
            return new GreenPlayer(ludo.getLudoInstance(), button_num);
        } else if (player.equalsIgnoreCase("BLUE")) {
            return new BluePlayer(ludo.getLudoInstance(), button_num);
        } else {
            return null;
        }
    }
    
}
