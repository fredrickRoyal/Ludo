package hello.players;

import hello.ludo;
import javax.microedition.lcdui.Graphics;

public class Player implements PlayerInterface
{
 //CONSTANT VALUES
 public  final int screen_width;
 private final int screen_height ;
 
 //public integers
 public int x_cordinate = 5;
 public int y_cordinate = 128;
 
//doubles
 private double starting_x_cordinate = 0;
 private double starting_y_cordinate = 0;
 
 //static integerss
 private static int width_of_box = 15;
 private static int radius_of_player = getWidth_of_box() / 2;
 
 //integers
 private int ref_pos = 128;
 private int ref_x = 5;
 private int steps_moved = 0;
 private int red = 0;
 private int green = 0;
 private int blue = 0;
 private int collisions = 0;
 private int initial_x = 0;
 private int initial_y = 0 ;
 
 //variable boolean values
 private boolean first_time = true;
 public boolean has_not_been_drawn = true;
 
 //variable strings
 private String button_number = "1";
 private String init_button_number = null;
 private boolean first_times=true;

 //constructor
 public Player(ludo m)
 {
  //set variables using screen height
  screen_height = m.getHeight();
  screen_width=m.getWidth();
  width_of_box = (screen_width/15);
  //radius_of_player=(int)((4.304635761589404/100)*(screen_height));
  y_cordinate = (int) ((39.73509933774834 / 100) * (screen_height));
  x_cordinate = (int) ((1.655629139072848 / 100) * (screen_height));
  ref_pos = y_cordinate;
  ref_x = x_cordinate;

 }

 //moves player one step forward
 public void movePlayerForward()
 {
  
 }

 //increments steps moved by 1
 public void incrementSteps()
 {
  setHas_not_been_drawn(false);
  setSteps_moved(getSteps_moved() + 1);
  //println("steps_moved="+steps_moved);
 }

 //moves player sideways right one step
 public void movePlayerRightSideWays()
 {
  setX_cordinate(getX_cordinate() + getWidth_of_box());
 }

 //moves player left sideways one step
 public void movePlayerLeftSideWays()
 {
  setX_cordinate(getX_cordinate() - getWidth_of_box());
 }

 //moves player down one step
 public void movePlayerDownWards()
 {
  setY_cordinate(getY_cordinate() + getWidth_of_box());
 }

 //moves player up one step
 public void movePlayerUpwards()
 {
  setY_cordinate(getY_cordinate() - getWidth_of_box());
 }

 //draws player onto screen
 public void drawPlayer(Graphics g)
 {
//  println("drawing player");
//  println("x=" + getX_cordinate());
//  println("y=" + getY_cordinate());
//  println("width=" + getWidth_of_box());
//  println("steps_moved=" + getSteps_moved());
//  println("person_to_play=" + Controller.getPerson_to_play());
//  println("value_of_die=" + Controller.getValue_from_die());
//  println("screen width="+screen_width);
  g.setColor(getRed(), getGreen(), getBlue());
  //setX_cordinate(20);
  //setY_cordinate(128);
  g.fillRoundRect(getX_cordinate(), getY_cordinate(), getWidth_of_box() - 1, getWidth_of_box() - 1, 5, 5);
  g.drawRoundRect(getX_cordinate(), getY_cordinate(), getWidth_of_box(), getWidth_of_box(), 5, 5);
  g.setColor(255, 255, 255);
  g.drawString(getButton_number(), getX_cordinate() + 2, getY_cordinate(), 0);
 }

 public void drawNumber(Graphics g)
 {
  if (collisions > 1)
  {
   int x_pos = this.x_cordinate;
   int y_pos = this.y_cordinate;
   g.setColor(255, 255, 255);
   g.drawString(collisions + "R", x_pos, y_pos, 0);
  }

 }

 //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">
 public String getInit_button_number()
 {
  return init_button_number;
 }

 public void setInit_button_number(String init_button_number)
 {
  this.init_button_number = init_button_number;
 }

 
 public boolean isFirst_times()
 {
  return first_times;
 }


 public void setFirst_times(boolean first_times)
 {
  this.first_times = first_times;
 }
 
 //setter 4 x_cordinate
 public void setX_cordinate(int m)
 {
  this.x_cordinate = m;
 }

 //setter 4 y_cordinate
 public void setY_cordinate(int m)
 {
  this.y_cordinate = m;
 }

 //getter 4 steps_moved
 public int getSteps_moved()
 {
  return steps_moved;
 }

 void setButton_numbers(String string)
 {
  if (this.getCollisions() > 0)
  {
   if (this.getCollisions() == 1)
   {
    this.button_number = getInit_button_number();
    return;
   }
   this.button_number = string;
  }
 }

 //setter 4 steps moved
 public void setSteps_moved(int steps_moved)
 {
  this.steps_moved = steps_moved;
 }

 //prints info out on command line
// public void println(String string)
// {
//  System.out.println(string);
// }

 /**
  * @return the red
  */
 public int getRed()
 {
  return red;
 }

 /**
  * @param red the red to set
  */
 public void setRed(int red)
 {
  this.red = red;
 }

 /**
  * @return the green
  */
 public int getGreen()
 {
  return green;
 }

 /**
  * @param green the green to set
  */
 public void setGreen(int green)
 {
  this.green = green;
 }

 /**
  * @return the blue
  */
 public int getBlue()
 {
  return blue;
 }

 /**
  * @param blue the blue to set
  */
 public void setBlue(int blue)
 {
  this.blue = blue;
 }

 /**
  * @return the x_cordinate
  */
 public int getX_cordinate()
 {
  return x_cordinate;
 }

 /**
  * @return the y_cordinate
  */
 public int getY_cordinate()
 {
  return y_cordinate;
 }

 /**
  * @return the first_time
  */
 public boolean isFirst_time()
 {
  return first_time;
 }

 /**
  * @param first_time the first_time to set
  */
 public void setFirst_time(boolean first_time)
 {
  this.first_time = first_time;
 }

 /**
  * @return the has_not_been_drawn
  */
 public boolean isHas_not_been_drawn()
 {
  return has_not_been_drawn;
 }

 /**
  * @param has_not_been_drawn the has_not_been_drawn to set
  */
 public void setHas_not_been_drawn(boolean has_not_been_drawn)
 {
  this.has_not_been_drawn = has_not_been_drawn;
 }

 /**
  * @return the button_number
  */
 public String getButton_number()
 {
  return button_number;
 }

 /**
  * @param button_number the button_number to set
  */
 public void setButton_number(String button_number)
 {
  this.button_number = button_number;
 }

 public static int getRadius_of_player()
 {
  return radius_of_player;
 }

 public static void setRadius_of_player(int radius_of_player)
 {
  Player.radius_of_player = radius_of_player;
 }

 /**
  * @return the width_of_box
  */
 public static int getWidth_of_box()
 {
  return width_of_box;
 }

 /**
  * @param width_of_box the width_of_box to set
  */
 public static void setWidth_of_box(int width_of_box)
 {
  Player.width_of_box = width_of_box;
 }

 /**
  * @return the ref_pos
  */
 public int getRef_pos()
 {
  return ref_pos;
 }

 /**
  * @param ref_pos the ref_pos to set
  */
 public void setRef_pos(int ref_pos)
 {
  this.ref_pos = ref_pos;
 }

 /**
  * @return the ref_x
  */
 public int getRef_x()
 {
  return ref_x;
 }

 /**
  * @param ref_x the ref_x to set
  */
 public void setRef_x(int ref_x)
 {
  this.ref_x = ref_x;
 }

 /**
  * @return the initial_x
  */
 public int getInitial_x()
 {
  return initial_x;
 }

 /**
  * @param initial_x the initial_x to set
  */
 public void setInitial_x(int initial_x)
 {
  this.initial_x = initial_x;
 }

 /**
  * @return the initial_y
  */
 public int getInitial_y()
 {
  return initial_y;
 }

 /**
  * @param initial_y the initial_y to set
  */
 public void setInitial_y(int initial_y)
 {
  this.initial_y = initial_y;
 }

 /**
  * @return the collisions
  */
 public int getCollisions()
 {
  return collisions;
 }

 /**
  * @param collisions the collisions to set
  */
 public void setCollisions(int collisions)
 {
  this.collisions = collisions;
 }

 /**
  * @return the screen_height
  */
 public int getScreen_height()
 {
  return screen_height;
 }

 /**
  * @return the starting_x_cordinate
  */
 public double getStarting_x_cordinate()
 {
  return starting_x_cordinate;
 }

 /**
  * @param starting_x_cordinate the starting_x_cordinate to set
  */
 public void setStarting_x_cordinate(double starting_x_cordinate)
 {
  this.starting_x_cordinate = starting_x_cordinate;
 }

 /**
  * @return the starting_y_cordinate
  */
 public double getStarting_y_cordinate()
 {
  return starting_y_cordinate;
 }

 /**
  * @param starting_y_cordinate the starting_y_cordinate to set
  */
 public void setStarting_y_cordinate(double starting_y_cordinate)
 {
  this.starting_y_cordinate = starting_y_cordinate;
 }
 //</editor-fold>

 
 
}
