package hello.players;

import hello.ludo;

public class GreenPlayer extends Player
{
 private int scrn_height;
 private static int number_of_buttons_allowed = 4;

 //quick constructor
 public GreenPlayer(ludo m)
 {
  super(m);
  setX_cordinate(208);//170
  setY_cordinate(159);//200
 }

 //constructor
 public GreenPlayer(ludo m, int button_num)
 {
  super(m);
  setColorToGreen();
  scrn_height = getScreen_height();
  setInit_button_number("G");
  setStarting_x_cordinate((86.66666666666667/100)*(screen_width));//128
  setStarting_y_cordinate((50.000/100)*(scrn_height)-1);//57
  //initial position of buttons
  int x_init = (int) ((71.00/ 100) * screen_width)-1;
  int y_init = (int) ((62.566/ 100) * scrn_height);

  switch (button_num)
  {
   case 1:
    setX_cordinate(x_init);
    setY_cordinate(y_init);
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    setButton_number("G");
    break;
   case 2:
    x_cordinate = x_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    y_cordinate = y_init;
    setButton_number("G");
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    break;
   case 3:
    x_cordinate = x_init;
    y_cordinate = y_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    setButton_number("G");
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    break;
   case 4:
    x_cordinate = x_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    y_cordinate = y_init + ((getWidth_of_box() * 2) - (int) ((0.9933774834437086 / 100) * scrn_height));
    setButton_number("G");
    setInitial_x(getX_cordinate());
    setInitial_y(getY_cordinate());
    break;
   default:
    //println("YOU CAN ONLY HAVE 4 BUTTONS");
  }
 }

 //sets color to red
 private void setColorToGreen()
 {
  setRed(0);
  setBlue(0);
  setGreen(20);
 }
 
 //moves red player forward 1 step
 public void movePlayerForward()
  {
    if (has_not_been_drawn)
    {
      //going thru blue
      if ((getSteps_moved()>=0)&&(getSteps_moved()<=5))
      {
        movePlayerLeftSideWays();
        incrementSteps();
      }
      //going to red
      else if (getSteps_moved()==6)
      {
        x_cordinate-=getWidth_of_box();
        y_cordinate+=getWidth_of_box();
        incrementSteps();
      }
      else if ((getSteps_moved()>=7)&&(getSteps_moved()<=11))
      {
        movePlayerDownWards();
        incrementSteps();
      }
      else if ((getSteps_moved()>11&&getSteps_moved()<14))
      {
        movePlayerLeftSideWays();
        incrementSteps();
      }
      //at red
      
      //go to green
      else if (getSteps_moved()>=14&&getSteps_moved()<=18)
      {
        movePlayerUpwards();
        incrementSteps();
      }
      else if (getSteps_moved()==19)
      {
        x_cordinate-=(getWidth_of_box());
        y_cordinate-=(getWidth_of_box());
        incrementSteps();
      }
      else if (getSteps_moved()>19&&getSteps_moved()<=24)
      {
        movePlayerLeftSideWays();
        incrementSteps();
      }
      else if (getSteps_moved()>=25&&getSteps_moved()<=26)
      {
        movePlayerUpwards();
        incrementSteps();
      }
      //move thru green
      else if (getSteps_moved()==27)
      {
        movePlayerRightSideWays();
        incrementSteps();
      }
      else if (getSteps_moved()>27&&getSteps_moved()<=31)
      {
        movePlayerRightSideWays();
        incrementSteps();
      }
      //go to yellow
      else if (getSteps_moved()==32)
      {
        x_cordinate+=(getWidth_of_box());
        y_cordinate-=(getWidth_of_box());
        incrementSteps();
      }
      else if (getSteps_moved()>32&&getSteps_moved()<=37)
      {
        movePlayerUpwards();
        incrementSteps();
      }
      else if (getSteps_moved()>=38&&getSteps_moved()<=39)
      {
        movePlayerRightSideWays();
        incrementSteps();
      }
      //move thru yellow
      else if (getSteps_moved()>=40&&getSteps_moved()<=44)
      {
        movePlayerDownWards();
        incrementSteps();
      }
      //go to blue
      else if (getSteps_moved()==45)
      {
        x_cordinate+=(getWidth_of_box());
        y_cordinate+=getWidth_of_box();
        incrementSteps();
      }
      else if (getSteps_moved()>=46&&getSteps_moved()<=50)
      {
        movePlayerRightSideWays();
        incrementSteps();
      }
      else if (getSteps_moved()>=51&&getSteps_moved()<52)
      {
        movePlayerDownWards();
        incrementSteps();
      }
      else if (getSteps_moved()>=52&&getSteps_moved()<=57)
      {
        movePlayerLeftSideWays();
        incrementSteps();
       if (getSteps_moved()==58)
       {
        decrementNumberOfAllowedPlayers();
        determineIfGreenHasFinished();
       }
      }
    }
  }

 //decreases num of allowed players by 1
 public static int decrementNumberOfAllowedPlayers()
 {
    return number_of_buttons_allowed--;
 }
 
 //increases num of allowed players
 public static int incrementNumberOfAllowedPlayers()
 {
  return number_of_buttons_allowed+=1;
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

 //determines if green has finished the game
 public static void determineIfGreenHasFinished()
 {
  if (number_of_buttons_allowed<=0)
  {
   ludo.setDrawGreenPlayerHasFinishedSign(true);
   ludo.setGreen_has_finished(true);
  }
 }
 
}
