package hello.players;

import hello.ludo;

public class RedPlayer extends Player
{

 private int scrn_height;
 private static int number_of_buttons_allowed = 4;

 //quick constructor
 public RedPlayer(ludo m)
 {
  super(m);
 }

 //constructor
 public RedPlayer(ludo m, int button_num)
 {
  super(m);
  setColorToRed();
  scrn_height = getScreen_height();
  setInit_button_number("R");
  setStarting_x_cordinate((53.33333333333333/100)*(screen_width));//128
  setStarting_y_cordinate((15.000/100)*(scrn_height)-1);//57
  //initial position of buttons
  int x_init = (int) ((53.00 / 100) * scrn_height);
  int y_init = (int) ((17.99 / 100) * scrn_height);

  switch (button_num)
  {
   case 1:
    setX_cordinate(x_init);
    setY_cordinate(y_init);
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    setButton_number("R");
    break;
   case 2:
    x_cordinate = x_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    y_cordinate = y_init;
    setButton_number("R");
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    break;
   case 3:
    x_cordinate = x_init;
    y_cordinate = y_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    setButton_number("R");
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    break;
   case 4:
    x_cordinate = x_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    y_cordinate = y_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    setButton_number("R");
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    break;
   default:
    //println("YOU CAN ONLY HAVE 4 BUTTONS");
  }
 }

 //sets color to red
 private void setColorToRed()
 {
  setRed(60);
  setBlue(0);
  setGreen(0);
 }
 
 //moves red player forward 1 step
 public void movePlayerForward()
  {
    if (has_not_been_drawn)
    {
      //going thru blue
      if ((getSteps_moved()>=0)&&(getSteps_moved()<=5))
      {
        movePlayerDownWards();
        incrementSteps();
      }
      //going to red
      else if (getSteps_moved()==6)
      {
        x_cordinate+=getWidth_of_box();
        y_cordinate+=getWidth_of_box();
        incrementSteps();
      }
      else if ((getSteps_moved()>=7)&&(getSteps_moved()<=11))
      {
        movePlayerRightSideWays();
        incrementSteps();
      }
      else if ((getSteps_moved()>11&&getSteps_moved()<14))
      {
        movePlayerDownWards();
        incrementSteps();
      }
      //at red
      
      //go to green
      else if (getSteps_moved()>=14&&getSteps_moved()<=18)
      {
        movePlayerLeftSideWays();
        incrementSteps();
      }
      else if (getSteps_moved()==19)
      {
        x_cordinate-=(getWidth_of_box());
        y_cordinate+=(getWidth_of_box());
        incrementSteps();
      }
      else if (getSteps_moved()>19&&getSteps_moved()<=24)
      {
        movePlayerDownWards();
        incrementSteps();
      }
      else if (getSteps_moved()>=25&&getSteps_moved()<=26)
      {
        movePlayerLeftSideWays();
        incrementSteps();
      }
      //move thru green
      else if (getSteps_moved()==27)
      {
        movePlayerUpwards();
        incrementSteps();
      }
      else if (getSteps_moved()>27&&getSteps_moved()<=31)
      {
        movePlayerUpwards();
        incrementSteps();
      }
      //go to yellow
      else if (getSteps_moved()==32)
      {
        x_cordinate-=(getWidth_of_box());
        y_cordinate-=(getWidth_of_box());
        incrementSteps();
      }
      else if (getSteps_moved()>32&&getSteps_moved()<=37)
      {
        movePlayerLeftSideWays();
        incrementSteps();
      }
      else if (getSteps_moved()>=38&&getSteps_moved()<=39)
      {
        movePlayerUpwards();
        incrementSteps();
      }
      //move thru yellow
      else if (getSteps_moved()>=40&&getSteps_moved()<=44)
      {
        movePlayerRightSideWays();
        incrementSteps();
      }
      //go to blue
      else if (getSteps_moved()==45)
      {
        x_cordinate+=(getWidth_of_box());
        y_cordinate-=getWidth_of_box();
        incrementSteps();
      }
      else if (getSteps_moved()>=46&&getSteps_moved()<=50)
      {
        movePlayerUpwards();
        incrementSteps();
      }
      else if (getSteps_moved()>=51&&getSteps_moved()<52)
      {
        movePlayerRightSideWays();
        incrementSteps();
      }
      else if (getSteps_moved()>=52&&getSteps_moved()<=57)
      {
        movePlayerDownWards();
        incrementSteps();
        if (getSteps_moved()==58)
       {
        decrementNumberOfAllowedPlayers();
        determineIfRedHasFinished();
       }
        
      }
    }
  }

 //decreases num of allowed players by 1
 public static int decrementNumberOfAllowedPlayers()
 {
    return number_of_buttons_allowed-=1;
 }
 
 //increases num of allowed players
 public static int incrementNumberOfAllowedPlayers()
 {
  return number_of_buttons_allowed+=1;
 }
 
 public static int getNumber_of_buttons_allowed()
 {
  return number_of_buttons_allowed;
 }

 public static void setNumber_of_buttons_allowed(int aNumber_of_buttons_allowed)
 {
  number_of_buttons_allowed = aNumber_of_buttons_allowed;
 }

 //determines if Red has finished the game
 public static void determineIfRedHasFinished()
 {
  if (number_of_buttons_allowed<=0)
  {
   ludo.setDrawRedPlayerHasFinishedSign(true);
   ludo.setRed_has_finished(true);
  }
 }
}
