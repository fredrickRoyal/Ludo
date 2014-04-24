package hello;

import hello.players.YellowPlayer;
import hello.players.Player;
import hello.players.RedPlayer;
import hello.players.BluePlayer;
import hello.players.GreenPlayer;

public class Controller
{
 //CLASS VARIABLES

 private static int value_from_die;
 private static int person_to_play = 1;
 //booleans
 private boolean road_blocked;
 //Objects
 private Dice die = null;
 private SoundEffects sound_manager=null;
 private BluePlayer blue_player1 = ludo.getBluePlayer1();
 private BluePlayer blue_player2 = ludo.getBluePlayer2();
 private BluePlayer blue_player3 = ludo.getBluePlayer3();
 private BluePlayer blue_player4 = ludo.getBluePlayer4();
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

 //constructor
 public Controller()
 {
  die = new Dice();
  sound_manager=new SoundEffects();
 }

 //moves player forward the value on the die
 public boolean plizMovePlayerForward(Player player)
 {

  //check if die was rolled
  if (getValue_from_die() > 0)
  {
   int x_cord = player.getX_cordinate();
   int y_cord = player.getY_cordinate();
   int steps = player.getSteps_moved();

   //try to get player from color home
   if (attempt2GetPlayerFromHomeSucceds(player))
   {
    return true;
   }

   //if player has already reached home do nothing
   if (player.getSteps_moved() >= 58)
   {
    return false;
   }
   //if player is inside home stretch he has to play exact number to go home
   else if (player.getSteps_moved() >= 52)
   {
    if (59 - player.getSteps_moved() <= value_from_die)
    {
     return false;
    }
   }

   //if player isnt at home move him
   if (player.getSteps_moved() > 0)
   {
    for (int i = 1; i <= (value_from_die); i++)
    {
     player.movePlayerForward();
     if (roadBlocked(player))
     {
      road_blocked = true;
     }
     player.setHas_not_been_drawn(true);
    }

    //roll back changes
    if (road_blocked)
    {
     player.setX_cordinate(x_cord);
     player.setY_cordinate(y_cord);
     player.setSteps_moved(steps);
     ludo.setDrawRoadBlockedSign(true);
     //println("ROAD BLOCKED");
     road_blocked = false;
     return false;
    }
    playPlayerHasMovedMusic();
    //see if player eats someone
    if (getPerson_to_play() == 1)
    {
     BlueEatsPlayer(player);
    }
    else if (getPerson_to_play() == 2)
    {
     RedEatsPlayer(player);
    }
    else if (getPerson_to_play() == 3)
    {
     GreenEatsPlayer(player);
    }
    else if (getPerson_to_play() == 4)
    {
     YellowEatsPlayer(player);
    }
    if (value_from_die == 6)
    {
     resetDieScore();
     ludo.setDrawScoreAllowed(false);
     return true;
    }
    //reset variables and change person to play
    resetDieScore();
    ludo.setDrawScoreAllowed(false);
    changePersonToPlay();
    return true;
   }
   //occurs rarely at the begining of the game
   else
   {
    //println("steps less than 0");
    return false;
   }
  }
  else
  {
   //println("PLIZ ROLL DIE FIRST THEN MOVE BUTTON");
   return false;
  }
 }

 //rolls the dice
 void plizRollDie()
 {
  value_from_die = getDie().rollDice();
  ludo.setScore("" + value_from_die);
  //println("DIE SCORE=" + value_from_die);
  ludo.setDrawScoreAllowed(true);

 }

 //returns die score to 0
 public static void resetDieScore()
 {
  value_from_die = 0;
 }
 
 //checks if road is blocked
 public boolean roadBlocked(Player player)
 {
  int num = 0;
  int num2 = 0;
  int num3 = 0;
  if (person_to_play == 1)
  {
   num = check4CollisionWithRed(player);
   num2 = check4CollisionWithGreen(player);
   num3 = check4CollisionWithYellow(player);
  }
  else if (person_to_play == 2)
  {
   //println("inside road block");
   num = check4CollisionWithBlue(player);
   num2 = check4CollisionWithGreen(player);
   num3 = check4CollisionWithYellow(player);
   //println("num="+num);
  }
  else if (person_to_play == 3)
  {
   num = check4CollisionWithBlue(player);
   num2 = check4CollisionWithRed(player);
   num3 = check4CollisionWithYellow(player);
  }
  else if (person_to_play == 4)
  {
   num = check4CollisionWithBlue(player);
   num2 = check4CollisionWithRed(player);
   num3 = check4CollisionWithGreen(player);
  }
  if (num > 1 || num2 > 1 || num3 > 1)
  {
   return true;
  }
  return false;
 }

 //determines if a blue player eats any other player
 private void BlueEatsPlayer(Player player)
 {
  Player player_to_be_eaten = null;
  try
  {
   BluePlayer player_to_eat = (BluePlayer) player;
   player_to_be_eaten = checkIfEatsRedPlayer(player_to_eat);
   if (player_to_be_eaten == null)
   {
    player_to_be_eaten = checkIfEatsGreenPlayer(player_to_eat);
    if (player_to_be_eaten == null)
    {
     player_to_be_eaten = checkIfEatsYellowPlayer(player_to_eat);
    }
   }
   //player_to_be_eaten.println("blue_player_to_be_eaten" + player_to_be_eaten.toString());
   if (player_to_be_eaten != null)
   {
    playPersonEatenMusic();
    returnPlayerHome(player_to_be_eaten);
   }
  }
  catch (Exception e)
  {
   
  }
  return;
 }

 //determines if a Green player eats any other player
 private void GreenEatsPlayer(Player player)
 {
  Player player_to_be_eaten = null;
  try
  {
   Player player_to_eat = player;
   player_to_be_eaten = checkIfEatsYellowPlayer(player_to_eat);
   if (player_to_be_eaten == null)
   {
    player_to_be_eaten = checkIfEatsBluePlayer(player_to_eat);
    if (player_to_be_eaten == null)
    {
     player_to_be_eaten = checkIfEatsRedPlayer(player_to_eat);
    }
   }
   //println("green_player_to_be_eaten=" + player_to_be_eaten.toString());
   if (player_to_be_eaten != null)
   {
    playPersonEatenMusic();
    returnPlayerHome(player_to_be_eaten);
   }
  }
  catch (Exception e)
  {
   
  }
  return;
 }

 //determines if a red player eats any other player
 private void RedEatsPlayer(Player player)
 {
  Player player_to_be_eaten = null;
  try
  {
   RedPlayer player_to_eat = (RedPlayer) player;
   player_to_be_eaten = checkIfEatsBluePlayer(player_to_eat);
   if (player_to_be_eaten == null)
   {
    player_to_be_eaten = checkIfEatsGreenPlayer(player_to_eat);
    if (player_to_be_eaten == null)
    {
     player_to_be_eaten = checkIfEatsYellowPlayer(player_to_eat);
    }
   }

   //player_to_be_eaten.println("red_player_to_be_eaten" + player_to_be_eaten.toString());
   if (player_to_be_eaten != null)
   {
    playPersonEatenMusic();
    returnPlayerHome(player_to_be_eaten);
   }
  }
  catch (Exception e)
  {
   
  }
  return;
 }

 //determines if a yellow Player eats any other player
 private void YellowEatsPlayer(Player player)
 {
  Player player_to_be_eaten = null;
  try
  {
   YellowPlayer player_to_eat = (YellowPlayer) player;
   player_to_be_eaten = checkIfEatsGreenPlayer(player_to_eat);
   if (player_to_be_eaten == null)
   {
    player_to_be_eaten = checkIfEatsBluePlayer(player_to_eat);
    if (player_to_be_eaten == null)
    {
     player_to_be_eaten = checkIfEatsRedPlayer(player_to_eat);
    }
   }
   //println("yellow_player_to_be_eaten=" + player_to_be_eaten.toString());
   if (player_to_be_eaten != null)
   {
    playPersonEatenMusic();
    returnPlayerHome(player_to_be_eaten);
   }
  }
  catch (Exception e)
  {
   
  }
  return;
 }

 //gets a player from home and places him on starting pad
 private boolean attempt2GetPlayerFromHomeSucceds(Player player)
 {
  boolean blu = false;
  boolean red = false;
  boolean green = false;
  boolean yellow = false;
  if (player.getSteps_moved() == 0 && getValue_from_die() == 6)
  {
   if (getPerson_to_play() == 1)
   {
    blu = try2GetBluePlayerFromHome(player);
    if (blu)
    {
     BlueEatsPlayer(player);
    }
   }
   else if (getPerson_to_play() == 2)
   {
    red = try2GetRedPlayerFromHome(player);
    if (red)
    {
     RedEatsPlayer(player);
    }
   }
   else if (getPerson_to_play() == 3)
   {
    green = try2GetGreenPlayerFromHome(player);
    if (green)
    {
     GreenEatsPlayer(player);
    }
   }
   else if (getPerson_to_play() == 4)
   {
    yellow = try2GetYellowPlayerFromHome(player);
    if (yellow)
    {
     YellowEatsPlayer(player);
    }
   }


   if (blu || red || green || yellow)
   {
    value_from_die = 0;
    ludo.setDrawScoreAllowed(false);
    playPlayerHasMovedMusic();
    return true;
   }
  }
  return false;
 }

 //gets a blueplayer from home and places him on starting pad
 private boolean try2GetBluePlayerFromHome(Player player)
 {
  try
  {
   BluePlayer bluePlayer = (BluePlayer) player;
   if (BluePlayer.getNumber_of_buttons_allowed() > 0)
   {
    ludo.getPlayerFromHome(player);
    //BluePlayer.setNumber_of_buttons_allowed(BluePlayer.decrementNumberOfAllowedPlayers());
    return true;
   }
   return false;
  }
  catch (Exception e)
  {
   return false;
  }
 }

 //attempts to get a red player form home and places him on starting pad
 private boolean try2GetRedPlayerFromHome(Player player)
 {
  try
  {
   RedPlayer redPlayer = (RedPlayer) player;
   if (RedPlayer.getNumber_of_buttons_allowed() > 0)
   {
    ludo.getPlayerFromHome(player);
    //RedPlayer.setNumber_of_buttons_allowed(RedPlayer.decrementNumberOfAllowedPlayers());
    return true;
   }
   return false;
  }
  catch (Exception e)
  {
   return false;
  }
 }

 //attempts to get a green player form home and places him on starting pad
 private boolean try2GetGreenPlayerFromHome(Player player)
 {
  try
  {
   GreenPlayer greenPlayer = (GreenPlayer) player;
   if (GreenPlayer.getNumber_of_buttons_allowed() > 0)
   {
    ludo.getPlayerFromHome(player);
    //GreenPlayer.setNumber_of_buttons_allowed(GreenPlayer.decrementNumberOfAllowedPlayers());
    return true;
   }
   return false;
  }
  catch (Exception e)
  {
   return false;
  }
 }

 //attempts to get a yellow player form home and places him on starting pad
 private boolean try2GetYellowPlayerFromHome(Player player)
 {
  try
  {
   YellowPlayer yellowPlayer = (YellowPlayer) player;
   if (YellowPlayer.getNumber_of_buttons_allowed() > 0)
   {
    ludo.getPlayerFromHome(player);
    //YellowPlayer.setNumber_of_buttons_allowed(YellowPlayer.decrementNumberOfAllowedPlayers());
    return true;
   }
   return false;
  }
  catch (Exception e)
  {
   return false;
  }
 }

 //return the current value of the dice
 public static int getValue_from_die()
 {
  return value_from_die;
 }

//automatically changes the person to play
 public static void changePersonToPlay()
 {
  if (person_to_play == 1)
  {
   person_to_play = 2;
  }
  else if (person_to_play == 2)
  {
   person_to_play = 3;
  }
  else if (person_to_play == 3)
  {
   person_to_play = 4;
  }
  else if (person_to_play == 4)
  {
   person_to_play = 1;
  }
 }

 //collision detection method
 public int collisionDetection(int x, int y, int z, int w)
 {
  int collision = 0;
  int radius_of_player = Player.getRadius_of_player();
  if ((x + radius_of_player) >= z && (x - radius_of_player) <= z)
  {
   if ((y + radius_of_player) >= w && (y - radius_of_player) <= w)
   {
    collision = 1;
    return collision;
   }
  }
  return collision;
 }

 //checks for collision between 2 players
 public int CollisionBetween2RedPlayers(Player player)
 {
  int total_collisions = 0;
  try
  {
   RedPlayer red_player = (RedPlayer) player;
   total_collisions += check4CollisionWithRed(player);
   player.setCollisions(total_collisions);
  }
  catch (Exception e)
  {
   return -1;
  }
  return total_collisions;
 }

 //checks for a collision with blue players
 public int check4CollisionWithBlue(Player player)
 {
  int number_of_collisions = 0;
  int x_cord = getMidPoint(player.x_cordinate);
  int y_cord = getMidPoint(player.y_cordinate);
  int blux1 = getMidPoint(getBlue_player1().x_cordinate);//blue_player1.x_cordinate;
  int blux2 = getMidPoint(getBlue_player2().x_cordinate);
  int blux3 = getMidPoint(getBlue_player3().x_cordinate);//blue_player3.x_cordinate;
  int blux4 = getMidPoint(getBlue_player4().x_cordinate);//blue_player4.x_cordinate;
  int bluy1 = getMidPoint(getBlue_player1().y_cordinate);//blue_player1.y_cordinate;
  int bluy2 = getMidPoint(getBlue_player2().y_cordinate);//blue_player2.y_cordinate;
  int bluy3 = getMidPoint(getBlue_player3().y_cordinate);//blue_player3.y_cordinate;
  int bluy4 = getMidPoint(getBlue_player4().y_cordinate);//blue_player4.y_cordinate;
  number_of_collisions += collisionDetection(x_cord, y_cord, blux1, bluy1);
  number_of_collisions += collisionDetection(x_cord, y_cord, blux2, bluy2);
  number_of_collisions += collisionDetection(x_cord, y_cord, blux3, bluy3);
  number_of_collisions += collisionDetection(x_cord, y_cord, blux4, bluy4);
  return number_of_collisions;
 }

 //checks for collision with red players
 public int check4CollisionWithRed(Player player)
 {
  
  int number_of_collisions = 0;
  int x_cord = getMidPoint(player.getX_cordinate());
  int y_cord = getMidPoint(player.getY_cordinate());
  int redx1 = getMidPoint(ludo.getRedPlayer1().x_cordinate);
  int redx2 = getMidPoint(ludo.getRedPlayer2().x_cordinate);
  int redx3 = getMidPoint(ludo.getRedPlayer3().x_cordinate);
  int redx4 = getMidPoint(ludo.getRedPlayer4().x_cordinate);
  int redy1 = getMidPoint(ludo.getRedPlayer1().y_cordinate);
  int redy2 = getMidPoint(ludo.getRedPlayer2().y_cordinate);
  int redy3 = getMidPoint(ludo.getRedPlayer3().y_cordinate);
  int redy4 = getMidPoint(ludo.getRedPlayer4().y_cordinate);
  number_of_collisions += collisionDetection(x_cord, y_cord, redx1, redy1);
  number_of_collisions += collisionDetection(x_cord, y_cord, redx2, redy2);
  number_of_collisions += collisionDetection(x_cord, y_cord, redx3, redy3);
  number_of_collisions += collisionDetection(x_cord, y_cord, redx4, redy4);
  return number_of_collisions;
 }

 //checks 4 collision with red players
 public int check4CollisionWithGreen(Player player)
 {
  int number_of_collisions = 0;
  int x_cord = getMidPoint(player.getX_cordinate());
  int y_cord = getMidPoint(player.getY_cordinate());
  int greenx1 = getMidPoint(ludo.getGreenPlayer1().x_cordinate);
  int greenx2 = getMidPoint(ludo.getGreenPlayer2().x_cordinate);
  int greenx3 = getMidPoint(ludo.getGreenPlayer3().x_cordinate);
  int greenx4 = getMidPoint(ludo.getGreenPlayer4().x_cordinate);
  int greeny1 = getMidPoint(ludo.getGreenPlayer1().y_cordinate);
  int greeny2 = getMidPoint(ludo.getGreenPlayer2().y_cordinate);
  int greeny3 = getMidPoint(ludo.getGreenPlayer3().y_cordinate);
  int greeny4 = getMidPoint(ludo.getGreenPlayer4().y_cordinate);
  number_of_collisions += collisionDetection(x_cord, y_cord, greenx1, greeny1);
  number_of_collisions += collisionDetection(x_cord, y_cord, greenx2, greeny2);
  number_of_collisions += collisionDetection(x_cord, y_cord, greenx3, greeny3);
  number_of_collisions += collisionDetection(x_cord, y_cord, greenx4, greeny4);
  return number_of_collisions;
 }

 //checks 4 collision with yellow players
 public int check4CollisionWithYellow(Player player)
 {
  int number_of_collisions = 0;
  int x_cord = getMidPoint(player.getX_cordinate());
  int y_cord = getMidPoint(player.getY_cordinate());
  int yellowx1 = getMidPoint(ludo.getYellowPlayer1().x_cordinate);
  int yellowx2 = getMidPoint(ludo.getYellowPlayer2().x_cordinate);
  int yellowx3 = getMidPoint(ludo.getYellowPlayer3().x_cordinate);
  int yellowx4 = getMidPoint(ludo.getYellowPlayer4().x_cordinate);
  int yellowy1 = getMidPoint(ludo.getYellowPlayer1().y_cordinate);
  int yellowy2 = getMidPoint(ludo.getYellowPlayer2().y_cordinate);
  int yellowy3 = getMidPoint(ludo.getYellowPlayer3().y_cordinate);
  int yellowy4 = getMidPoint(ludo.getYellowPlayer4().y_cordinate);
  number_of_collisions += collisionDetection(x_cord, y_cord, yellowx1, yellowy1);
  number_of_collisions += collisionDetection(x_cord, y_cord, yellowx2, yellowy2);
  number_of_collisions += collisionDetection(x_cord, y_cord, yellowx3, yellowy3);
  number_of_collisions += collisionDetection(x_cord, y_cord, yellowx4, yellowy4);
  return number_of_collisions;

 }

 //gets the midpoint of a given x_cordinate
 private int getMidPoint(int cordinate)
 {
  int mid_point = ((cordinate + Player.getWidth_of_box()) / 2);
  return mid_point;
 }

 //checks if given player eats a red player
 private Player checkIfEatsRedPlayer(Player player)
 {
  int x_cord = getMidPoint(player.x_cordinate);//player.x_cordinate;
  int y_cord = getMidPoint(player.y_cordinate);//player.y_cordinate;
  int redx1 = getMidPoint(getRed_player1().x_cordinate);
  int redx2 = getMidPoint(getRed_player2().x_cordinate);
  int redx3 = getMidPoint(getRed_player3().x_cordinate);
  int redx4 = getMidPoint(getRed_player4().x_cordinate);
  int redy1 = getMidPoint(getRed_player1().y_cordinate);
  int redy2 = getMidPoint(getRed_player2().y_cordinate);
  int redy3 = getMidPoint(getRed_player3().y_cordinate);
  int redy4 = getMidPoint(getRed_player4().y_cordinate);
  if (collisionDetection(x_cord, y_cord, redx1, redy1) == 1)
  {
   return getRed_player1();
  }
  else if (collisionDetection(x_cord, y_cord, redx2, redy2) == 1)
  {
   return getRed_player2();
  }
  else if (collisionDetection(x_cord, y_cord, redx3, redy3) == 1)
  {
   return getRed_player3();
  }
  else if (collisionDetection(x_cord, y_cord, redx4, redy4) == 1)
  {
   return getRed_player4();
  }
  else
  {
   return null;
  }
 }

 //checks if given player eats blue player
 private Player checkIfEatsBluePlayer(Player player)
 {
  int x_cord = getMidPoint(player.x_cordinate);
  int y_cord = getMidPoint(player.y_cordinate);
  int blux1 = getMidPoint(ludo.getBluePlayer1().x_cordinate);
  int blux2 = getMidPoint(ludo.getBluePlayer2().x_cordinate);
  int blux3 = getMidPoint(ludo.getBluePlayer3().x_cordinate);
  int blux4 = getMidPoint(ludo.getBluePlayer4().x_cordinate);
  int bluy1 = getMidPoint(ludo.getBluePlayer1().y_cordinate);
  int bluy2 = getMidPoint(ludo.getBluePlayer2().y_cordinate);
  int bluy3 = getMidPoint(ludo.getBluePlayer3().y_cordinate);
  int bluy4 = getMidPoint(ludo.getBluePlayer4().y_cordinate);
  if (collisionDetection(x_cord, y_cord, blux1, bluy1) == 1)
  {
   return blue_player1;
  }
  else if (collisionDetection(x_cord, y_cord, blux2, bluy2) == 1)
  {
   return blue_player2;
  }
  else if (collisionDetection(x_cord, y_cord, blux3, bluy3) == 1)
  {
   return blue_player3;
  }
  else if (collisionDetection(x_cord, y_cord, blux4, bluy4) == 1)
  {
   return blue_player4;
  }
  else
  {
   return null;
  }
 }

 //checks if given player Eats Green player
 private Player checkIfEatsGreenPlayer(Player player)
 {
  int x_cord = getMidPoint(player.x_cordinate);
  int y_cord = getMidPoint(player.y_cordinate);
  int green_x1 = getMidPoint(ludo.getGreenPlayer1().x_cordinate);
  int green_x2 = getMidPoint(ludo.getGreenPlayer2().x_cordinate);
  int green_x3 = getMidPoint(ludo.getGreenPlayer3().x_cordinate);
  int green_x4 = getMidPoint(ludo.getGreenPlayer4().x_cordinate);
  int green_y1 = getMidPoint(ludo.getGreenPlayer1().y_cordinate);
  int green_y2 = getMidPoint(ludo.getGreenPlayer2().y_cordinate);
  int green_y3 = getMidPoint(ludo.getGreenPlayer3().y_cordinate);
  int green_y4 = getMidPoint(ludo.getGreenPlayer4().y_cordinate);
  if (collisionDetection(x_cord, y_cord, green_x1, green_y1) == 1)
  {
   return green_player1;
  }
  else if (collisionDetection(x_cord, y_cord, green_x2, green_y2) == 1)
  {
   return green_player2;
  }
  else if (collisionDetection(x_cord, y_cord, green_x3, green_y3) == 1)
  {
   return green_player3;
  }
  else if (collisionDetection(x_cord, y_cord, green_x4, green_y4) == 1)
  {
   return green_player4;
  }
  else
  {
   return null;
  }
 }

 //checks if given player eats Yellow Player
 private Player checkIfEatsYellowPlayer(Player player)
 {
  int x_cord = getMidPoint(player.x_cordinate);
  int y_cord = getMidPoint(player.y_cordinate);
  int yellow_x1 = getMidPoint(ludo.getYellowPlayer1().x_cordinate);
  int yellow_x2 = getMidPoint(ludo.getYellowPlayer2().x_cordinate);
  int yellow_x3 = getMidPoint(ludo.getYellowPlayer3().x_cordinate);
  int yellow_x4 = getMidPoint(ludo.getYellowPlayer4().x_cordinate);
  int yellow_y1 = getMidPoint(ludo.getYellowPlayer1().y_cordinate);
  int yellow_y2 = getMidPoint(ludo.getYellowPlayer2().y_cordinate);
  int yellow_y3 = getMidPoint(ludo.getYellowPlayer3().y_cordinate);
  int yellow_y4 = getMidPoint(ludo.getYellowPlayer4().y_cordinate);
  if (collisionDetection(x_cord, y_cord, yellow_x1, yellow_y1) == 1)
  {
   return yellow_player1;
  }
  else if (collisionDetection(x_cord, y_cord, yellow_x2, yellow_y2) == 1)
  {
   return yellow_player2;
  }
  else if (collisionDetection(x_cord, y_cord, yellow_x3, yellow_y3) == 1)
  {
   return yellow_player3;
  }
  else if (collisionDetection(x_cord, y_cord, yellow_x4, yellow_y4) == 1)
  {
   return yellow_player4;
  }
  else
  {
   return null;
  }
 }

 //returns an eaten player home
 private void returnPlayerHome(Player player_to_be_eaten)
 {
  player_to_be_eaten.setX_cordinate(player_to_be_eaten.getInitial_x());
  player_to_be_eaten.setY_cordinate(player_to_be_eaten.getInitial_y());
  player_to_be_eaten.setSteps_moved(0);
 }

 //checks 4 collisions btn players
 public int check4CollisionsBtnPlayers(Player player)
 {
  int collisions_red = CollisionBetween2RedPlayers(player);
  int collisions_green = CollisionBetween2GreenPlayers(player);
  int collisions_yellow = CollisionBetween2YellowPlayers(player);
  //player.setCollisions(collisions_red);
  if (collisions_red > 0)
  {
   player.setCollisions(collisions_red);
   return collisions_red;
  }
  if (collisions_green > 0)
  {
   player.setCollisions(collisions_green);
   return collisions_green;
  }
  if (collisions_yellow > 0)
  {
   player.setCollisions(collisions_yellow);
   return collisions_yellow;
  }
  return -1;
 }

 private int CollisionBetween2GreenPlayers(Player player)
 {
  int total_collisions = 0;
  try
  {
   GreenPlayer green_player = (GreenPlayer) player;
   total_collisions += check4CollisionWithGreen(player);
   player.setCollisions(total_collisions);
  }
  catch (Exception e)
  {
   return -1;
  }
  return total_collisions;
 }

 private int CollisionBetween2YellowPlayers(Player player)
 {
  int total_collisions = 0;
  try
  {
   YellowPlayer yellow_player = (YellowPlayer) player;
   total_collisions += check4CollisionWithYellow(player);
   player.setCollisions(total_collisions);
  }
  catch (Exception e)
  {
   return -1;
  }
  return total_collisions;
 }
 
 private void playPlayerHasMovedMusic()
 {
  if (getPerson_to_play()==1)
  {
   getSound_manager().playSoundForMovingPlayer();
  }
  
 }
 
  public void playPersonEatenMusic()
 {
 if(getPerson_to_play()==1)
 {
   getSound_manager().playSoundForEatingAnotherPlayer();
 }
 }

 //<editor-fold defaultstate="collapsed" desc=" Getters&Setters ">
 //returns person to play
 public static int getPerson_to_play()
 {
  return person_to_play;
 }

 //sets person to play
 public static void setPerson_to_play(int aPerson_to_play)
 {
  person_to_play = aPerson_to_play;
 }

 //gets die obj
 public Dice getDie()
 {
  return die;
 }

 //sets die obj
 public void setDie(Dice die)
 {
  this.die = die;
 }

 //return blueplayer1
 public BluePlayer getBlue_player1()
 {
  return blue_player1;
 }

 //setter:blueplayer1
 public void setBlue_player1(BluePlayer blue_player1)
 {
  this.blue_player1 = blue_player1;
 }

 //getter:blueplayer2
 public BluePlayer getBlue_player2()
 {
  return blue_player2;
 }

 //setter:blueplayer2
 public void setBlue_player2(BluePlayer blue_player2)
 {
  this.blue_player2 = blue_player2;
 }

 //getter:blueplayer3
 public BluePlayer getBlue_player3()
 {
  return blue_player3;
 }

 //setter:blueplayer3
 public void setBlue_player3(BluePlayer blue_player3)
 {
  this.blue_player3 = blue_player3;
 }

 //getter:blueplayer4
 public BluePlayer getBlue_player4()
 {
  return blue_player4;
 }

 //setter:blueplayer4
 public void setBlue_player4(BluePlayer blue_player4)
 {
  this.blue_player4 = blue_player4;
 }

 //getter:redplayer1
 public RedPlayer getRed_player1()
 {
  return red_player1;
 }

 //setter:redplayer1
 public void setRed_player1(RedPlayer red_player1)
 {
  this.red_player1 = red_player1;
 }

 //getter:redplayer2
 public RedPlayer getRed_player2()
 {
  return red_player2;
 }

 //setter:redplayer2
 public void setRed_player2(RedPlayer red_player2)
 {
  this.red_player2 = red_player2;
 }

 //getter:redplayer3
 public RedPlayer getRed_player3()
 {
  return red_player3;
 }

 //setter:redplayer3
 public void setRed_player3(RedPlayer red_player3)
 {
  this.red_player3 = red_player3;
 }

 //getter:redplayer4
 public RedPlayer getRed_player4()
 {
  return red_player4;
 }

 //setter:redplayer4
 public void setRed_player4(RedPlayer red_player4)
 {
  this.red_player4 = red_player4;
 }
 //</editor-fold>

 /**
  * @return the sound_manager
  */
 public SoundEffects getSound_manager()
 {
  return sound_manager;
 }

 /**
  * @param sound_manager the sound_manager to set
  */
 public void setSound_manager(SoundEffects sound_manager)
 {
  this.sound_manager = sound_manager;
 }

 
}
