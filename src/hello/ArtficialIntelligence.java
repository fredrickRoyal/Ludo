package hello;

//this class should control all the other 3 colors

import hello.players.YellowPlayer;
import hello.players.RedPlayer;
import hello.players.GreenPlayer;

public class ArtficialIntelligence
{

 private Controller game_manager = null;
 private RedPlayer red_player1 = ludo.getRedPlayer1();
 private RedPlayer red_player2 = ludo.getRedPlayer2();
 private RedPlayer red_player3 = ludo.getRedPlayer3();
 private RedPlayer red_player4 = ludo.getRedPlayer4();
 private GreenPlayer green_player1 = ludo.getGreenPlayer1();
 private GreenPlayer green_player2 = ludo.getGreenPlayer2();
 private GreenPlayer green_player3 = ludo.getGreenPlayer3();
 private GreenPlayer green_player4 = ludo.getGreenPlayer4();
 private YellowPlayer yellow_player1 = ludo.getYellowPlayer1();
 private YellowPlayer yellow_player2 = ludo.getYellowPlayer2();
 private YellowPlayer yellow_player3 = ludo.getYellowPlayer3();
 private YellowPlayer yellow_player4 = ludo.getYellowPlayer4();
 private boolean die_has_been_rolled = false;

 //constructor
 public ArtficialIntelligence(Controller m)
 {
  this.game_manager = m;
 }

 //decides the next action to be taken by computer
 public void decideNextAction()
 {
  rollDie();
  if (Controller.getPerson_to_play() == 2)
  {
   decideNextRedAction();
   if (Controller.getPerson_to_play() == 2)
   {
    decideNextAction();
   }
  }
  rollDie();
  if (Controller.getPerson_to_play() == 3)
  {
   decideNextGreenAction();
   if (Controller.getPerson_to_play() == 3)
   {
    decideNextAction();
   }
  }
  rollDie();
  if (Controller.getPerson_to_play() == 4)
  {
   decideNextYellowAction();
   if (Controller.getPerson_to_play() == 4)
   {
    decideNextAction();
   }
  }
  Controller.resetDieScore();
  ludo.setDrawScoreAllowed(false);
 }

 //controls all red buttons
 private void decideNextRedAction()
 {
  if (isDie_has_been_rolled())
  {
   if (getGame_manager().plizMovePlayerForward(getRed_player1()))
   {
    return;
   }
   else if (getGame_manager().plizMovePlayerForward(getRed_player2()))
   {
    return;
   }
   else if (getGame_manager().plizMovePlayerForward(getRed_player3()))
   {
    return;
   }
   else if (getGame_manager().plizMovePlayerForward(getRed_player4()))
   {
    return;
   }
   else
   {
    Controller.changePersonToPlay();
   }
  }
 }

 //rolls the die
 private void rollDie()
 {
  getGame_manager().plizRollDie();
  setDie_has_been_rolled(true);
 }

 private void println(String message)
 {
  System.out.println(message);
 }

 //controls all green buttons
 private void decideNextGreenAction()
 {
  if (isDie_has_been_rolled())
  {
   if (getGame_manager().plizMovePlayerForward(getGreen_player1()))
   {
    return;
   }
   else if (getGame_manager().plizMovePlayerForward(getGreen_player2()))
   {
    return;
   }
   else if (getGame_manager().plizMovePlayerForward(getGreen_player3()))
   {
    return;
   }
   else if (getGame_manager().plizMovePlayerForward(getGreen_player4()))
   {
    return;
   }
   else
   {
    Controller.changePersonToPlay();
   }
  }
 }

 //controls all yellow buttons
 private void decideNextYellowAction()
 {
  if (isDie_has_been_rolled())
  {
   if (getGame_manager().plizMovePlayerForward(getYellow_player1()))
   {
    return;
   }
   else if (getGame_manager().plizMovePlayerForward(getYellow_player2()))
   {
    return;
   }
   else if (getGame_manager().plizMovePlayerForward(getYellow_player3()))
   {
    return;
   }
   else if (getGame_manager().plizMovePlayerForward(getYellow_player4()))
   {
    return;
   }
   else
   {
    Controller.changePersonToPlay();
   }
  }
 }

 //<editor-fold defaultstate="collapsed" desc="Getters&Setters">
 /**
  * @return the game_manager
  */
 public Controller getGame_manager()
 {
  return game_manager;
 }

 /**
  * @param game_manager the game_manager to set
  */
 public void setGame_manager(Controller game_manager)
 {
  this.game_manager = game_manager;
 }

 /**
  * @return the red_player1
  */
 public RedPlayer getRed_player1()
 {
  return red_player1;
 }

 /**
  * @param red_player1 the red_player1 to set
  */
 public void setRed_player1(RedPlayer red_player1)
 {
  this.red_player1 = red_player1;
 }

 /**
  * @return the red_player2
  */
 public RedPlayer getRed_player2()
 {
  return red_player2;
 }

 /**
  * @param red_player2 the red_player2 to set
  */
 public void setRed_player2(RedPlayer red_player2)
 {
  this.red_player2 = red_player2;
 }

 /**
  * @return the red_player3
  */
 public RedPlayer getRed_player3()
 {
  return red_player3;
 }

 /**
  * @param red_player3 the red_player3 to set
  */
 public void setRed_player3(RedPlayer red_player3)
 {
  this.red_player3 = red_player3;
 }

 /**
  * @return the red_player4
  */
 public RedPlayer getRed_player4()
 {
  return red_player4;
 }

 /**
  * @param red_player4 the red_player4 to set
  */
 public void setRed_player4(RedPlayer red_player4)
 {
  this.red_player4 = red_player4;
 }

 /**
  * @return the green_player1
  */
 public GreenPlayer getGreen_player1()
 {
  return green_player1;
 }

 /**
  * @param green_player1 the green_player1 to set
  */
 public void setGreen_player1(GreenPlayer green_player1)
 {
  this.green_player1 = green_player1;
 }

 /**
  * @return the green_player2
  */
 public GreenPlayer getGreen_player2()
 {
  return green_player2;
 }

 /**
  * @param green_player2 the green_player2 to set
  */
 public void setGreen_player2(GreenPlayer green_player2)
 {
  this.green_player2 = green_player2;
 }

 /**
  * @return the green_player3
  */
 public GreenPlayer getGreen_player3()
 {
  return green_player3;
 }

 /**
  * @param green_player3 the green_player3 to set
  */
 public void setGreen_player3(GreenPlayer green_player3)
 {
  this.green_player3 = green_player3;
 }

 /**
  * @return the green_player4
  */
 public GreenPlayer getGreen_player4()
 {
  return green_player4;
 }

 /**
  * @param green_player4 the green_player4 to set
  */
 public void setGreen_player4(GreenPlayer green_player4)
 {
  this.green_player4 = green_player4;
 }

 /**
  * @return the yellow_player1
  */
 public YellowPlayer getYellow_player1()
 {
  return yellow_player1;
 }

 /**
  * @param yellow_player1 the yellow_player1 to set
  */
 public void setYellow_player1(YellowPlayer yellow_player1)
 {
  this.yellow_player1 = yellow_player1;
 }

 /**
  * @return the yellow_player2
  */
 public YellowPlayer getYellow_player2()
 {
  return yellow_player2;
 }

 /**
  * @param yellow_player2 the yellow_player2 to set
  */
 public void setYellow_player2(YellowPlayer yellow_player2)
 {
  this.yellow_player2 = yellow_player2;
 }

 /**
  * @return the yellow_player3
  */
 public YellowPlayer getYellow_player3()
 {
  return yellow_player3;
 }

 /**
  * @param yellow_player3 the yellow_player3 to set
  */
 public void setYellow_player3(YellowPlayer yellow_player3)
 {
  this.yellow_player3 = yellow_player3;
 }

 /**
  * @return the yellow_player4
  */
 public YellowPlayer getYellow_player4()
 {
  return yellow_player4;
 }

 /**
  * @param yellow_player4 the yellow_player4 to set
  */
 public void setYellow_player4(YellowPlayer yellow_player4)
 {
  this.yellow_player4 = yellow_player4;
 }

 /**
  * @return the die_has_been_rolled
  */
 public boolean isDie_has_been_rolled()
 {
  return die_has_been_rolled;
 }

 /**
  * @param die_has_been_rolled the die_has_been_rolled to set
  */
 public void setDie_has_been_rolled(boolean die_has_been_rolled)
 {
  this.die_has_been_rolled = die_has_been_rolled;
 }
 //</editor-fold>
}
