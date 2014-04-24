package hello.players;

import hello.ludo;

public class BluePlayer extends Player
{
 //private BluePlayer player1,player2,player3,player4;
 private int scrn_height;
 private static int number_of_buttons_allowed = 4;
 
 //quick constructor
 public BluePlayer(ludo m)
 {
  super(m);
  //initializeObjects(m);
  //x_cordinate=10;
  //y_cordinate=10;
 }

 //real constructor
 public BluePlayer(ludo m, int button_num)
 {
  super(m);
  scrn_height = getScreen_height();
  setInit_button_number("B");
  setStarting_x_cordinate(((7.0 / 100) * screen_width));//20
  setStarting_y_cordinate(((39.5 / 100) * scrn_height));//128

  //initial position of buttons
  int x_init = (int) ((8.000 / 100) * scrn_height);
  int y_init = (int) ((18.000 / 100) * scrn_height);

  switch (button_num)
  {
   case 1:
    setX_cordinate(x_init);
    setY_cordinate(y_init);
    setButton_number("1");
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    break;
   case 2:
    x_cordinate = x_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    y_cordinate = y_init;
    setButton_number("2");
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    break;
   case 3:
    x_cordinate = x_init;
    y_cordinate = y_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    setButton_number("3");
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    break;
   case 4:
    x_cordinate = x_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    y_cordinate = y_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    setButton_number("4");
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    break;
   default:
    //println("YOU CAN ONLY HAVE 4 BUTTONS");
  }
 }

 //decrements the number of allowed players
 public static int decrementNumberOfAllowedPlayers()
 {
    return number_of_buttons_allowed--;
 }
 
 //increments number of allowed players
 public static int incrementNumberOfAllowedPlayers()
 {
  return number_of_buttons_allowed++;
 }
 
 //getter
 public static int getNumber_of_buttons_allowed()
 {
  return number_of_buttons_allowed;
 }
 
 //setter
 public static void setNumber_of_buttons_allowed(int aNumber_of_buttons_allowed)
 {
  number_of_buttons_allowed = aNumber_of_buttons_allowed;
 }

 //determines if Blue has finished the game
 public static void determineIfBlueHasFinished()
 {
  if (number_of_buttons_allowed<=0)
  {
   ludo.setDrawBluePlayerHasFinishedSign(true);
   ludo.setBlue_has_finished(true);
  }
 }
 
 //moves player one step forward
 public void movePlayerForward()
 {
  //setHas_not_been_drawn(true);
  if (isHas_not_been_drawn())
  {
   //going thru blue
   if ((getSteps_moved() >= 0) && (getSteps_moved() <= 5))
   {
    movePlayerRightSideWays();
    incrementSteps();
   }
   //going to red
   else if (getSteps_moved() == 6)
   {
    setX_cordinate(getX_cordinate() + getWidth_of_box());
    setY_cordinate(getRef_pos() - getWidth_of_box() );
    incrementSteps();
   }
   else if ((getSteps_moved() >= 7) && (getSteps_moved() <= 11))
   {
    movePlayerUpwards();
    incrementSteps();
   }
   else if ((getSteps_moved() > 11 && getSteps_moved() < 13))
   {
    movePlayerRightSideWays();
    incrementSteps();
   }
   //at red
   else if (getSteps_moved() == 13)
   {
    setX_cordinate(getX_cordinate() + (getWidth_of_box()));
    incrementSteps();
   }
   //go to green
   else if (getSteps_moved() > 13 && getSteps_moved() <= 18)
   {
    movePlayerDownWards();
    incrementSteps();
   }
   //correct box position
   else if (getSteps_moved() == 19)
   {
    setX_cordinate(getX_cordinate() + (getWidth_of_box()));
    setY_cordinate(getRef_pos());
    incrementSteps();
   }
   else if (getSteps_moved() > 19 && getSteps_moved() <= 24)
   {
    movePlayerRightSideWays();
    incrementSteps();
   }
   else if (getSteps_moved() >= 25 && getSteps_moved() <= 26)
   {
    movePlayerDownWards();
    incrementSteps();
   }
   //move thru green
   else if (getSteps_moved() == 27)
   {
    setY_cordinate(getRef_pos() + (getWidth_of_box() * 2));
    movePlayerLeftSideWays();
    incrementSteps();
   }
   else if (getSteps_moved() > 27 && getSteps_moved() <= 31)
   {
    movePlayerLeftSideWays();
    incrementSteps();
   }
   //go to yellow
   //correct box position
   else if (getSteps_moved() == 32)
   {
    setX_cordinate(getX_cordinate() - (getWidth_of_box()));
    setY_cordinate(getRef_pos() + (getWidth_of_box() * 3));
    incrementSteps();
   }
   else if (getSteps_moved() > 32 && getSteps_moved() <= 37)
   {
    movePlayerDownWards();
    incrementSteps();
   }
   else if (getSteps_moved() >= 38 && getSteps_moved() <= 39)
   {
    setY_cordinate(getY_cordinate());
    movePlayerLeftSideWays();
    incrementSteps();
   }
   //move thru yellow
   else if (getSteps_moved() >= 40 && getSteps_moved() <= 44)
   {
    movePlayerUpwards();
    incrementSteps();
   }
   //go to blue
   else if (getSteps_moved() == 45)
   {
    setX_cordinate(getX_cordinate() - (getWidth_of_box()));
    setY_cordinate(getRef_pos() + (getWidth_of_box() * 2));
    incrementSteps();
   }
   else if (getSteps_moved() >= 46 && getSteps_moved() <= 50)
   {
    movePlayerLeftSideWays();
    incrementSteps();
   }
   else if (getSteps_moved() >= 51 && getSteps_moved() < 52)
   {
    movePlayerUpwards();
    incrementSteps();
   }
   else if (getSteps_moved() >= 52 && getSteps_moved() <= 57)
   {
    movePlayerRightSideWays();
    incrementSteps();
    if (getSteps_moved()>=58)
    {
     decrementNumberOfAllowedPlayers();
     determineIfBlueHasFinished();
    }
   }
  }
 }
 
}
