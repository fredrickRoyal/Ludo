package hello;

import hello.players.YellowPlayer;
import hello.players.Player;
import hello.players.RedPlayer;
import hello.players.BluePlayer;
import hello.players.GreenPlayer;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class ludo extends Canvas implements CommandListener
{
// singletone instance for ludo
    private static ludo ludo;
 //CONSTANT VALUES
 static final int initial_x = 0;
 //CLASS VARIABLES
 private static BluePlayer bluePlayer1 = null;
 private static BluePlayer bluePlayer2 = null;
 private static BluePlayer bluePlayer3 = null;
 private static BluePlayer bluePlayer4 = null;
 private static RedPlayer redPlayer1 = null;
 private static RedPlayer redPlayer2 = null;
 private static RedPlayer redPlayer3 = null;
 private static RedPlayer redPlayer4 = null;
 private static GreenPlayer greenPlayer1 = null;
 private static GreenPlayer greenPlayer2 = null;
 private static GreenPlayer greenPlayer3 = null;
 private static GreenPlayer greenPlayer4 = null;
 private static YellowPlayer yellowPlayer1 = null;
 private static YellowPlayer yellowPlayer2 = null;
 private static YellowPlayer yellowPlayer3 = null;
 private static YellowPlayer yellowPlayer4 = null;
 private static Controller game_manager = null;
 private static ArtficialIntelligence kasozi = null;
 //images
 private static Image ludo_board = null;
 //integers
 private static int initial_y = 0;
 private static int img_height = 0;
 //strings
 private static String score = null;
 //booleans
 private static boolean drawScoreAllowed = false;
 private static boolean draw_number = false;
 private static boolean drawRoadBlockedSign = false;
 private static boolean drawBluePlayerHasFinishedSign = false;
 private static boolean green_has_finished = false;
 private static boolean yellow_has_finished = false;
 private static boolean red_has_finished = false;
 private static boolean blue_has_finished = false;
 private boolean second_time = false;
 private boolean first_times = true;
 private static boolean drawRedPlayerHasFinishedSign = false;
 private static boolean drawGreenPlayerHasFinishedSign = false;
 private static boolean drawYellowPlayerHasFinishedSign = false;
 private boolean game_over = false;
 private static katuduke_ekka m;
 private Command Done = new Command("Done", Command.EXIT, 1);
 private Command Restart = new Command("REstart", Command.BACK, 2);
 private SoundEffects soundEffects = new SoundEffects();

 //constructor
 public ludo(katuduke_ekka m)
 {
  ludo.m = m;
 }

 // getting ludo instance
 public static ludo getLudoInstance()
 {
 return new ludo(m);
 }
 
 //creates background and paints it black
 public void setBackgroundColor(Graphics g)
 {
  g.setColor(0x000000);
  g.fillRect(0, 0, getWidth(), getHeight());
 }

 //initializes the game
 public void start()
 {
  try
  {
   setLudo_board(Image.createImage("/res/ludo.png"));
   setBluePlayer1(new BluePlayer(this, 1));
   setBluePlayer2(new BluePlayer(this, 2));
   setBluePlayer3(new BluePlayer(this, 3));
   setBluePlayer4(new BluePlayer(this, 4));
   setRedPlayer1(new RedPlayer(this, 1));
   setRedPlayer2(new RedPlayer(this, 2));
   setRedPlayer3(new RedPlayer(this, 3));
   setRedPlayer4(new RedPlayer(this, 4));
   setGreenPlayer1(new GreenPlayer(this, 1));
   setGreenPlayer2(new GreenPlayer(this, 2));
   setGreenPlayer3(new GreenPlayer(this, 3));
   setGreenPlayer4(new GreenPlayer(this, 4));
   setYellowPlayer1(new YellowPlayer(this, 1));
   setYellowPlayer2(new YellowPlayer(this, 2));
   setYellowPlayer3(new YellowPlayer(this, 3));
   setYellowPlayer4(new YellowPlayer(this, 4));
   setGame_manager(new Controller());
   kasozi = new ArtficialIntelligence(game_manager);
   //sound_manager=new SoundEffects();
  }
  catch (Exception e)
  {
   System.out.println(e.getMessage());
  }
  repaint();
 }

 //draws the bg image
 public void drawBgImage(Graphics g)
 {

  //resize the background image
  setLudo_board(resizeImage(getLudo_board(), getWidth(), getWidth()));
  setInitial_y(centerImage(getLudo_board(), getHeight()));
  //draw the background image
  g.drawImage(getLudo_board(), initial_x, getInitial_y(), Graphics.TOP | Graphics.LEFT);

 }

 //places background image in center of screen
 public static int centerImage(Image image, int screenHeight)
 {
  int starting_y_cordinate = 0;
  setImg_height(image.getHeight());
  int img_middle = getImg_height() / 2;
  int scrn_middle = screenHeight / 2;
  starting_y_cordinate = scrn_middle - img_middle;
  return starting_y_cordinate;

 }

 
 //resizes image given to the screen height and width
 public static Image resizeImage(Image src, int screenWidth, int screenHeight)
 {
  int srcWidth = src.getWidth();
  int srcHeight = src.getHeight();
  Image tmp = Image.createImage(screenWidth, srcHeight);
  Graphics g = tmp.getGraphics();
  int ratio = (srcWidth << 16) / screenWidth;
  int pos = ratio / 2;
  // Horizontal Resize
  for (int x = 0; x < screenWidth; x++)
  {
   g.setClip(x, 0, 1, srcHeight);
   g.drawImage(src, x - (pos >> 16), 0, Graphics.LEFT | Graphics.TOP);
   pos += ratio;
  }
  Image resizedImage = Image.createImage(screenWidth, screenHeight);
  g = resizedImage.getGraphics();
  ratio = (srcHeight << 16) / screenHeight;
  pos = ratio / 2;
  //Vertical resize
  for (int y = 0; y < screenHeight; y++)
  {
   g.setClip(0, y, screenWidth, 1);
   g.drawImage(tmp, 0, y - (pos >> 16), Graphics.LEFT | Graphics.TOP);
   pos += ratio;
  }

  return resizedImage;
 }

 //prints info out on console window
 private void printout(String string)
 {
  System.out.println(string);
 }

 //handles key pressed event
 public synchronized void keyPressed(int keyCode)
 {
  resetVariables();
  if (game_over)
  {
   game_over = false;
   m.restartGame();
  }
  switch (keyCode)
  {
   case Canvas.KEY_NUM1:
    if (Controller.getPerson_to_play() == 1)
    {
     getGame_manager().plizMovePlayerForward(getBluePlayer1());
    }
    repaint();
//    Controller.setPerson_to_play(1);
//    if(bluePlayer1.first_times)
//    {
//    game_manager.plizMovePlayerForward(bluePlayer1);
//    bluePlayer1.first_times=false;
//    }
//    else
//    {
//    bluePlayer1.movePlayerForward();
//    bluePlayer1.has_not_been_drawn=true;
//    }
//    repaint();
    break;
   case Canvas.KEY_NUM2:
    if (Controller.getPerson_to_play() == 1)
    {
     getGame_manager().plizMovePlayerForward(bluePlayer2);
    }
    repaint();
    break;
   case Canvas.KEY_NUM3:
    if (Controller.getPerson_to_play() == 1)
    {
     getGame_manager().plizMovePlayerForward(getBluePlayer3());
    }
    repaint();
    break;
   case Canvas.KEY_NUM4:
    if (Controller.getPerson_to_play() == 1)
    {
     getGame_manager().plizMovePlayerForward(getBluePlayer4());
    }
    repaint();
    break;
   case Canvas.KEY_NUM5:
    getGame_manager().plizRollDie();
    repaint();
    break;
   case -5:
    getGame_manager().plizRollDie();
    repaint();
    break;
   case Canvas.KEY_NUM6:
    Controller.changePersonToPlay();
    repaint();
    break;
  }
  if (Controller.getPerson_to_play() >= 2)
  {
   kasozi.decideNextAction();
   repaint();
  }

 }

 //draws all stuff onto screen
 protected void paint(Graphics g)
 {
  if (!game_over)
  {
   if (second_time)
   {
    check4Collisions();
    drawNumberOfPlayers(g);
   }
   printout("executing paint");
   setBackgroundColor(g);
   drawBgImage(g);
   drawPlayers(g);
   drawDieScore(g);
   drawRoadBlockedSign(g);
   drawWhoseTurnItIs(g);
   drawBlueHasFinishedSign(g);
   drawGreenHasFinishedSign(g);
   drawRedHasFinishedSign(g);
   drawYellowHasFinishedSign(g);
   drawCommands();
   if (first_times)
   {
    check4Collisions();
    drawNumberOfPlayers(g);
    first_times = false;
    second_time = true;
   }
  }
  if (Blue_has_finished())
  {
   game_over = true;
   printout("blue_has_finished=" + blue_has_finished);
   printout("blue_has_finished_first=" + blue_has_finished_first());
   DataStoreHandler mine = new DataStoreHandler();
   if (blue_has_finished_first())
   {
    printout("blue has won");
    drawBlueHasWonScreen(g);
    mine.StoreWin();
   }
   else
   {
    printout("blue has lost");
    drawGameOverScreen(g);
    mine.StoreLoss();
   }
  }
 }

 //draws all players onto screen
 private void drawPlayers(Graphics g)
 {
  drawBluePlayers(g);
  drawRedPlayers(g);
  drawGreenPlayers(g);
  drawYellowPlayers(g);
 }

 //draws blue players onto screen
 private void drawBluePlayers(Graphics g)
 {
  getBluePlayer1().drawPlayer(g);
  getBluePlayer2().drawPlayer(g);
  getBluePlayer3().drawPlayer(g);
  getBluePlayer4().drawPlayer(g);

 }

 //draws red players onto screen
 private void drawRedPlayers(Graphics g)
 {
  getRedPlayer1().drawPlayer(g);
  getRedPlayer2().drawPlayer(g);
  getRedPlayer3().drawPlayer(g);
  getRedPlayer4().drawPlayer(g);
 }

 //draws green players onto screen
 private void drawGreenPlayers(Graphics g)
 {
  getGreenPlayer1().drawPlayer(g);
  getGreenPlayer2().drawPlayer(g);
  getGreenPlayer3().drawPlayer(g);
  getGreenPlayer4().drawPlayer(g);
 }

 //draws yellow players onto screen
 private void drawYellowPlayers(Graphics g)
 {
  getYellowPlayer1().drawPlayer(g);
  getYellowPlayer2().drawPlayer(g);
  getYellowPlayer3().drawPlayer(g);
  getYellowPlayer4().drawPlayer(g);
 }

 //draws the die score onto screen
 private void drawDieScore(Graphics g)
 {
  if (isDrawScoreAllowed())
  {
   g.setColor(0, 0, 128);
   g.drawString(getScore(), (int) ((getWidth() / 2 * 1.00) - 3), (int) ((getHeight() / 2 * 1.00)), 0);
  }
 }

 //gets a player from home and places him on home pad
 public static void getPlayerFromHome(Player player)
 {
  if (player.getSteps_moved() == 0)
  {
   player.setX_cordinate((int) player.getStarting_x_cordinate());
   player.setY_cordinate((int) player.getStarting_y_cordinate());
   player.setSteps_moved(2);
  }
 }

 //checks 4 collisions btn players
 public void check4CollisionsBtnPlayers(Player player)
 {
  int collisions = getGame_manager().check4CollisionsBtnPlayers(player);
  //player.setCollisions(collisions);
  //printout("Green player1"+game_manager.check4CollisionWithGreen(greenPlayer1));

 }

 //checks for collision
 public void check4Collisions()
 {
  check4CollisionsBtnPlayers(getRedPlayer1());
  check4CollisionsBtnPlayers(getRedPlayer2());
  check4CollisionsBtnPlayers(getRedPlayer3());
  check4CollisionsBtnPlayers(getRedPlayer4());
  check4CollisionsBtnPlayers(getGreenPlayer1());
  check4CollisionsBtnPlayers(getGreenPlayer2());
  check4CollisionsBtnPlayers(getGreenPlayer3());
  check4CollisionsBtnPlayers(getGreenPlayer4());
  check4CollisionsBtnPlayers(getYellowPlayer1());
  check4CollisionsBtnPlayers(getYellowPlayer2());
  check4CollisionsBtnPlayers(getYellowPlayer3());
  check4CollisionsBtnPlayers(getYellowPlayer4());
 }

//draws the number of given players in a given position
 public void drawNumberOfPlayers(Graphics g)
 {
  printout("collisions R1=" + greenPlayer1.getCollisions());
  printout("collisions R2=" + greenPlayer2.getCollisions());
  printout("collisions R3=" + greenPlayer3.getCollisions());
  printout("collisions R4=" + greenPlayer4.getCollisions());
  drawNumberOfRedPlayers();
  drawNumberOfGreenPlayers();
  drawNumberOfYellowPlayers();
 }

 //draws whose turn it is onto screen
 public void drawWhoseTurnItIs(Graphics g)
 {
  int x_pos = ((getWidth() / 2) - 35);
  int y_pos = getHeight() - 15;
  String whose_turn = null;
  if (Controller.getPerson_to_play() == 1)
  {
   g.setColor(255, 255, 255);
   whose_turn = "YOUR TURN";
   g.drawString(whose_turn, x_pos, y_pos, 0);
  }
  else if (Controller.getPerson_to_play() == 2)
  {
   g.setColor(255, 255, 255);
   whose_turn = "R's TURN";
   g.drawString(whose_turn, x_pos, y_pos, 0);
  }
  if (Controller.getPerson_to_play() == 3)
  {
   g.setColor(255, 255, 255);
   whose_turn = "G's TURN";
   g.drawString(whose_turn, x_pos, y_pos, 0);
  }
  else if (Controller.getPerson_to_play() == 4)
  {
   g.setColor(255, 255, 255);
   whose_turn = "Y's TURN";
   g.drawString(whose_turn, x_pos, y_pos, 0);
  }
 }

 //draws the number of red players in any one position
 public static void drawNumberOfRedPlayers()
 {
  if (getRedPlayer1().getCollisions() > 1)
  {
   getRedPlayer1().setButton_numbers("" + getRedPlayer1().getCollisions() + "R");
  }
  if (getRedPlayer1().getCollisions() <= 1)
  {
   getRedPlayer1().setButton_numbers("R");
  }
  if (getRedPlayer2().getCollisions() > 1)
  {
   getRedPlayer2().setButton_numbers("" + getRedPlayer2().getCollisions() + "R");
  }
  if (getRedPlayer2().getCollisions() <= 1)
  {
   getRedPlayer2().setButton_numbers("R");
  }
  if (getRedPlayer3().getCollisions() > 1)
  {
   getRedPlayer3().setButton_numbers("" + getRedPlayer3().getCollisions() + "R");
  }
  if (getRedPlayer3().getCollisions() <= 1)
  {
   getRedPlayer3().setButton_numbers("R");
  }
  if (getRedPlayer4().getCollisions() > 1)
  {
   getRedPlayer4().setButton_numbers("" + getRedPlayer4().getCollisions() + "R");
  }
  if (getRedPlayer4().getCollisions() <= 1)
  {
   getRedPlayer4().setButton_numbers("R");
  }
 }

 //draws the number of green players in any one position
 public static void drawNumberOfGreenPlayers()
 {
  if (getGreenPlayer1().getCollisions() > 1)
  {
   getGreenPlayer1().setButton_numbers("" + getGreenPlayer1().getCollisions() + "G");
  }
  if (getGreenPlayer1().getCollisions() == 1)
  {
   getGreenPlayer1().setButton_numbers("G");
  }
  if (getGreenPlayer2().getCollisions() > 1)
  {
   getGreenPlayer2().setButton_numbers("" + getGreenPlayer2().getCollisions() + "G");
  }
  if (getGreenPlayer2().getCollisions() == 1)
  {
   getGreenPlayer2().setButton_numbers("G");
  }
  if (getGreenPlayer3().getCollisions() > 1)
  {
   getGreenPlayer3().setButton_numbers("" + getGreenPlayer3().getCollisions() + "G");
  }
  if (getGreenPlayer3().getCollisions() == 1)
  {
   getGreenPlayer3().setButton_numbers("G");
  }
  if (getGreenPlayer4().getCollisions() > 1)
  {
   getGreenPlayer4().setButton_numbers("" + getGreenPlayer4().getCollisions() + "G");
  }
  if (getGreenPlayer4().getCollisions() == 1)
  {
   getGreenPlayer4().setButton_numbers("G");
  }
 }

 //draws the number of yellow players in any one position
 public static void drawNumberOfYellowPlayers()
 {
  if (getYellowPlayer1().getCollisions() > 1)
  {
   getYellowPlayer1().setButton_numbers("" + getYellowPlayer1().getCollisions() + "Y");
  }
  if (getYellowPlayer1().getCollisions() == 1)
  {
   getYellowPlayer1().setButton_numbers("Y");
  }
  if (getYellowPlayer2().getCollisions() > 1)
  {
   getYellowPlayer2().setButton_numbers("" + getYellowPlayer2().getCollisions() + "Y");
  }
  if (getYellowPlayer2().getCollisions() == 1)
  {
   getYellowPlayer2().setButton_numbers("Y");
  }
  if (getYellowPlayer3().getCollisions() > 1)
  {
   getYellowPlayer3().setButton_numbers("" + getYellowPlayer3().getCollisions() + "Y");
  }
  if (getYellowPlayer3().getCollisions() == 1)
  {
   getYellowPlayer3().setButton_numbers("Y");
  }
  if (getYellowPlayer4().getCollisions() > 1)
  {
   getYellowPlayer4().setButton_numbers("" + getYellowPlayer4().getCollisions() + "Y");
  }
  if (getYellowPlayer4().getCollisions() == 1)
  {
   getYellowPlayer4().setButton_numbers("Y");
  }
 }

 //draws the word road blocked onto screen
 private void drawRoadBlockedSign(Graphics g)
 {
  if (isDrawRoadBlockedSign())
  {
   int x_pos = ((getWidth() / 2) - 35);
   int y_pos = 15;
   String whose_turn = null;
   if (Controller.getPerson_to_play() == 1)
   {
    g.setColor(255, 255, 255);
    whose_turn = "ROAD BLOCKED";
    g.drawString(whose_turn, x_pos, y_pos, 0);
   }
  }
 }

 //draws the word blue has finished onto screen
 public void drawBlueHasFinishedSign(Graphics g)
 {
  if (isDrawBluePlayerHasFinishedSign())
  {
   int x_pos = ((getWidth() / 2) - 45);
   int y_pos = 15;
   String whose_turn = null;
   g.setColor(255, 255, 255);
   whose_turn = "U hAVe FinIShEd";
   g.drawString(whose_turn, x_pos, y_pos, 0);

  }
 }

 //draws the word red has finished onto screen
 public void drawRedHasFinishedSign(Graphics g)
 {
  if (isDrawRedPlayerHasFinishedSign())
  {
   int x_pos = ((getWidth() / 2) - 45);
   int y_pos = 15;
   String whose_turn = null;
   g.setColor(255, 255, 255);
   whose_turn = "*ReD* hAs FinIShEd";
   g.drawString(whose_turn, x_pos, y_pos, 0);

  }
 }

 //draws the word green has finished onto screen
 public void drawGreenHasFinishedSign(Graphics g)
 {
  if (isDrawGreenPlayerHasFinishedSign())
  {
   int x_pos = ((getWidth() / 2) - 45);
   int y_pos = 15;
   String whose_turn = null;
   g.setColor(255, 255, 255);
   whose_turn = "*gREeN* HaS FinIShEd";
   g.drawString(whose_turn, x_pos, y_pos, 0);
  }
 }

 //draws the word yellow has finished onto screen
 public void drawYellowHasFinishedSign(Graphics g)
 {
  if (isDrawYellowPlayerHasFinishedSign())
  {
   int x_pos = ((getWidth() / 2) - 45);
   int y_pos = 15;
   String whose_turn = null;
   g.setColor(255, 255, 255);
   whose_turn = "*YeLLow* HaS FinIShEd";
   g.drawString(whose_turn, x_pos, y_pos, 0);

  }
 }

 //determines if blue has won the game
 private boolean blue_has_finished_first()
 {
  if (Blue_has_finished() && !Red_has_finished() && !Green_has_finished() && !Yellow_has_finished())
  {
   return true;
  }
  return false;
 }

 //draws a message to congratulate blue on winining
 private void drawBlueHasWonScreen(Graphics g)
 {
  if (game_over)
  {
   int height = (30);
   int width = getWidth();
   int x = 0;
   int y = ((getHeight() / 2) - (height / 2));
   int arc_height = 10;
   int arc_width = arc_height;
   g.setColor(255, 255, 255);
   g.drawRoundRect(x, y, width, height, arc_width, arc_height);
   g.fillRoundRect(x, y, width, height, arc_width, arc_height);
   g.setColor(0, 0, 170);
   y += 5;
   x = 30;
   g.drawString("U HAVE WON", x, y, 0);
  }
 }

 //draws message to tell blue he has lost
 private void drawGameOverScreen(Graphics g)
 {
  getSoundEffects().playGameOverSound();
  int height = (30);
  int width = getWidth();
  int x = 0;
  int y = ((getHeight() / 2) - (height / 2));
  int arc_height = 10;
  int arc_width = arc_height;
  g.setColor(255, 255, 255);
  g.drawRoundRect(x, y, width, height, arc_width, arc_height);
  g.fillRoundRect(x, y, width, height, arc_width, arc_height);
  g.setColor(0, 0, 170);
  y += 5;
  x = 30;
  g.drawString("GAME OVER:U LOSE", x, y, 0);
 }

 //creates the commands on the screen the first time the game runs
 private void drawCommands()
 {
  if (first_times)
  {
   setDone(new Command("Exit", Command.EXIT, 1));
   setRestart(new Command("Restart", Command.BACK, 2));
   this.addCommand(getDone());
   this.addCommand(getRestart());
   this.setCommandListener(this);
  }
 }

 public void commandAction(Command c, Displayable d)
 {
  if (c == getRestart())
  {
   if (game_over)
   {
   //printout("game over is true");
   resetVariables();
   game_over = false;
   m.restartGame();
   }
   else
   {
   m.restartGame();
   }
  }
  else if (c == getDone())
  {
   try
   {
    m.destroyApp(false);
    m.notifyDestroyed();
   }
   catch (Exception e)
   {
    printout(e.getMessage());

   }
  }
 }

 private void resetVariables()
 {
  if (blue_has_finished)
  {
   setBlue_has_finished(false);
   setRed_has_finished(false);
   setYellow_has_finished(false);
   setGreen_has_finished(false);
  }
  setDrawRoadBlockedSign(false);
  setDrawBluePlayerHasFinishedSign(false);
  setDrawGreenPlayerHasFinishedSign(false);
  setDrawRedPlayerHasFinishedSign(false);
  setDrawYellowPlayerHasFinishedSign(false);
 }

 //<editor-fold defaultstate="collapsed" desc="Getters&Setters">
 /**
  * @return the drawBluePlayerHasFinishedSign
  */
 public static boolean isDrawBluePlayerHasFinishedSign()
 {
  return drawBluePlayerHasFinishedSign;
 }

 /**
  * @param aDrawBluePlayerHasFinishedSign the drawBluePlayerHasFinishedSign to set
  */
 public static void setDrawBluePlayerHasFinishedSign(boolean aDrawBluePlayerHasFinishedSign)
 {
  drawBluePlayerHasFinishedSign = aDrawBluePlayerHasFinishedSign;
 }

 /**
  * @return the drawRedPlayerHasFinishedSign
  */
 public static boolean isDrawRedPlayerHasFinishedSign()
 {
  return drawRedPlayerHasFinishedSign;
 }

 /**
  * @param aDrawRedPlayerHasFinishedSign the drawRedPlayerHasFinishedSign to set
  */
 public static void setDrawRedPlayerHasFinishedSign(boolean aDrawRedPlayerHasFinishedSign)
 {
  drawRedPlayerHasFinishedSign = aDrawRedPlayerHasFinishedSign;
 }

 /**
  * @return the drawGreenPlayerHasFinishedSign
  */
 public static boolean isDrawGreenPlayerHasFinishedSign()
 {
  return drawGreenPlayerHasFinishedSign;
 }

 /**
  * @param aDrawGreenPlayerHasFinishedSign the drawGreenPlayerHasFinishedSign to set
  */
 public static void setDrawGreenPlayerHasFinishedSign(boolean aDrawGreenPlayerHasFinishedSign)
 {
  drawGreenPlayerHasFinishedSign = aDrawGreenPlayerHasFinishedSign;
 }

 /**
  * @return the drawYellowPlayerHasFinishedSign
  */
 public static boolean isDrawYellowPlayerHasFinishedSign()
 {
  return drawYellowPlayerHasFinishedSign;
 }

 /**
  * @param aDrawYellowPlayerHasFinishedSign the drawYellowPlayerHasFinishedSign to set
  */
 public static void setDrawYellowPlayerHasFinishedSign(boolean aDrawYellowPlayerHasFinishedSign)
 {
  drawYellowPlayerHasFinishedSign = aDrawYellowPlayerHasFinishedSign;
 }

 /**
  * @return the drawRoadBlockedSign
  */
 public static boolean isDrawRoadBlockedSign()
 {
  return drawRoadBlockedSign;
 }

 /**
  * @param aDrawRoadBlockedSign the drawRoadBlockedSign to set
  */
 public static void setDrawRoadBlockedSign(boolean aDrawRoadBlockedSign)
 {
  drawRoadBlockedSign = aDrawRoadBlockedSign;
 }

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
  ludo.game_manager = game_manager;
 }

 //getter:blue_player1
 public static BluePlayer getBluePlayer1()
 {
  return bluePlayer1;
 }

 //setter:blue_player1
 public static void setBluePlayer1(BluePlayer aBluePlayer1)
 {
  bluePlayer1 = aBluePlayer1;
 }

 //getter:blue_player2
 public static BluePlayer getBluePlayer2()
 {
  return bluePlayer2;
 }

 //setter:blue_player2
 public static void setBluePlayer2(BluePlayer aBluePlayer2)
 {
  bluePlayer2 = aBluePlayer2;
 }

 //getter:blue_player3
 public static BluePlayer getBluePlayer3()
 {
  return bluePlayer3;
 }

 //setter:blue_player3
 public static void setBluePlayer3(BluePlayer aBluePlayer3)
 {
  bluePlayer3 = aBluePlayer3;
 }

 //blue_player4
 public static BluePlayer getBluePlayer4()
 {
  return bluePlayer4;
 }

 //blue_player4
 public static void setBluePlayer4(BluePlayer aBluePlayer4)
 {
  bluePlayer4 = aBluePlayer4;
 }

 /**
  * @return the redPlayer1
  */
 public static RedPlayer getRedPlayer1()
 {
  return redPlayer1;
 }

 /**
  * @param aRedPlayer1 the redPlayer1 to set
  */
 public static void setRedPlayer1(RedPlayer aRedPlayer1)
 {
  redPlayer1 = aRedPlayer1;
 }

 /**
  * @return the redPlayer2
  */
 public static RedPlayer getRedPlayer2()
 {
  return redPlayer2;
 }

 /**
  * @param aRedPlayer2 the redPlayer2 to set
  */
 public static void setRedPlayer2(RedPlayer aRedPlayer2)
 {
  redPlayer2 = aRedPlayer2;
 }

 /**
  * @return the redPlayer3
  */
 public static RedPlayer getRedPlayer3()
 {
  return redPlayer3;
 }

 /**
  * @param aRedPlayer3 the redPlayer3 to set
  */
 public static void setRedPlayer3(RedPlayer aRedPlayer3)
 {
  redPlayer3 = aRedPlayer3;
 }

 /**
  * @return the redPlayer4
  */
 public static RedPlayer getRedPlayer4()
 {
  return redPlayer4;
 }

 /**
  * @param aRedPlayer4 the redPlayer4 to set
  */
 public static void setRedPlayer4(RedPlayer aRedPlayer4)
 {
  redPlayer4 = aRedPlayer4;
 }

 /**
  * @return the greenPlayer1
  */
 public static GreenPlayer getGreenPlayer1()
 {
  return greenPlayer1;
 }

 /**
  * @param aGreenPlayer1 the greenPlayer1 to set
  */
 public static void setGreenPlayer1(GreenPlayer aGreenPlayer1)
 {
  greenPlayer1 = aGreenPlayer1;
 }

 /**
  * @return the greenPlayer2
  */
 public static GreenPlayer getGreenPlayer2()
 {
  return greenPlayer2;
 }

 /**
  * @param aGreenPlayer2 the greenPlayer2 to set
  */
 public static void setGreenPlayer2(GreenPlayer aGreenPlayer2)
 {
  greenPlayer2 = aGreenPlayer2;
 }

 /**
  * @return the greenPlayer3
  */
 public static GreenPlayer getGreenPlayer3()
 {
  return greenPlayer3;
 }

 /**
  * @param aGreenPlayer3 the greenPlayer3 to set
  */
 public static void setGreenPlayer3(GreenPlayer aGreenPlayer3)
 {
  greenPlayer3 = aGreenPlayer3;
 }

 /**
  * @return the greenPlayer4
  */
 public static GreenPlayer getGreenPlayer4()
 {
  return greenPlayer4;
 }

 /**
  * @param aGreenPlayer4 the greenPlayer4 to set
  */
 public static void setGreenPlayer4(GreenPlayer aGreenPlayer4)
 {
  greenPlayer4 = aGreenPlayer4;
 }

 /**
  * @return the yellowPlayer1
  */
 public static YellowPlayer getYellowPlayer1()
 {
  return yellowPlayer1;
 }

 /**
  * @param aYellowPlayer1 the yellowPlayer1 to set
  */
 public static void setYellowPlayer1(YellowPlayer aYellowPlayer1)
 {
  yellowPlayer1 = aYellowPlayer1;
 }

 /**
  * @return the yellowPlayer2
  */
 public static YellowPlayer getYellowPlayer2()
 {
  return yellowPlayer2;
 }

 /**
  * @param aYellowPlayer2 the yellowPlayer2 to set
  */
 public static void setYellowPlayer2(YellowPlayer aYellowPlayer2)
 {
  yellowPlayer2 = aYellowPlayer2;
 }

 /**
  * @return the yellowPlayer3
  */
 public static YellowPlayer getYellowPlayer3()
 {
  return yellowPlayer3;
 }

 /**
  * @param aYellowPlayer3 the yellowPlayer3 to set
  */
 public static void setYellowPlayer3(YellowPlayer aYellowPlayer3)
 {
  yellowPlayer3 = aYellowPlayer3;
 }

 /**
  * @return the yellowPlayer4
  */
 public static YellowPlayer getYellowPlayer4()
 {
  return yellowPlayer4;
 }

 /**
  * @param aYellowPlayer4 the yellowPlayer4 to set
  */
 public static void setYellowPlayer4(YellowPlayer aYellowPlayer4)
 {
  yellowPlayer4 = aYellowPlayer4;
 }

 /**
  * @return the green_has_finished
  */
 public static boolean Green_has_finished()
 {
  return green_has_finished;
 }

 /**
  * @param aGreen_has_finished the green_has_finished to set
  */
 public static void setGreen_has_finished(boolean aGreen_has_finished)
 {
  green_has_finished = aGreen_has_finished;
 }

 /**
  * @return the yellow_has_finished
  */
 public static boolean Yellow_has_finished()
 {
  return yellow_has_finished;
 }

 /**
  * @param aYellow_has_finished the yellow_has_finished to set
  */
 public static void setYellow_has_finished(boolean aYellow_has_finished)
 {
  yellow_has_finished = aYellow_has_finished;
 }

 /**
  * @return the red_has_finished
  */
 public static boolean Red_has_finished()
 {
  return red_has_finished;
 }

 /**
  * @param aRed_has_finished the red_has_finished to set
  */
 public static void setRed_has_finished(boolean aRed_has_finished)
 {
  red_has_finished = aRed_has_finished;
 }

 /**
  * @return the blue_has_finished
  */
 public static boolean Blue_has_finished()
 {
  return blue_has_finished;
 }

 /**
  * @param aBlue_has_finished the blue_has_finished to set
  */
 public static void setBlue_has_finished(boolean aBlue_has_finished)
 {
  blue_has_finished = aBlue_has_finished;
 }

 public Command getDone()
 {
  return Done;
 }

 public void setDone(Command Done)
 {
  this.Done = Done;
 }

 public Command getRestart()
 {
  return Restart;
 }

 public void setRestart(Command Restart)
 {
  this.Restart = Restart;
 }

 //</editor-fold>
 
 //<editor-fold defaultstate="collapsed" desc="More Getters&Setters">
 //getter:ludo_board
 public Image getLudo_board()
 {
  return ludo_board;
 }

 //setter:ludo_board
 public void setLudo_board(Image ludo_board)
 {
  ludo.ludo_board = ludo_board;
 }

 public static boolean isDrawScoreAllowed()
 {
  return drawScoreAllowed;
 }

 public static void setDrawScoreAllowed(boolean aDrawScoreAllowed)
 {
  drawScoreAllowed = aDrawScoreAllowed;
 }

 public static String getScore()
 {
  return score;
 }

 public static void setScore(String aScore)
 {
  score = aScore;
 }

 public static int getInitial_y()
 {
  return initial_y;
 }

 public static void setInitial_y(int aInitial_y)
 {
  initial_y = aInitial_y;
 }

 public static int getImg_height()
 {
  return img_height;
 }

 public static void setImg_height(int aImg_height)
 {
  img_height = aImg_height;
 }

 public static boolean isDraw_number()
 {
  return draw_number;
 }

 public static void setDraw_number(boolean aDraw_number)
 {
  draw_number = aDraw_number;
 }
 //</editor-fold>

 /**
  * @return the soundEffects
  */
 public SoundEffects getSoundEffects()
 {
  return soundEffects;
 }

 /**
  * @param soundEffects the soundEffects to set
  */
 public void setSoundEffects(SoundEffects soundEffects)
 {
  this.soundEffects = soundEffects;
 }
}
