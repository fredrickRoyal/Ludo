package hello;

//handles all sound effetcs in katuduke ekka

import java.io.InputStream;
import javax.microedition.media.Manager;

public class SoundEffects
{
 private static final long serialVersionUID = 1L;
 private String intro_sound="/res/No_mercy.mp3";

 public SoundEffects()
 {
 }

 public void playSoundForEatingAnotherPlayer()
 {
  try
  {
   Manager.playTone(71, 1000, 100);

  }
  catch (Exception e)
  {
   println(e.getMessage());
  }

 }

 public void playSoundForMovingPlayer()
 {
  try
  {
   Manager.playTone(69, 2000, 100);
  }
  catch (Exception e)
  {
   println(e.getMessage());
  }
 }

 public void playGameOverSound()
 {
  try
  {
   InputStream inputStream=getClass().getResourceAsStream(intro_sound);
   javax.microedition.media.Player player=Manager.createPlayer(inputStream,"audio/mpeg");
   player.start();
  }
  catch (Exception e)
  {
   println(e.getMessage());
  }
 }

 public javax.microedition.media.Player playIntroSound()
 {
  try
  {
   InputStream inputStream=getClass().getResourceAsStream(intro_sound);
   javax.microedition.media.Player player=Manager.createPlayer(inputStream,"audio/mpeg");
   player.start();
   return player;
  }
  catch (Exception e)
  {
   println(e.getMessage());
  }
  return null;
 }

 public void println(String string)
 {
  System.out.println(string);
 }

 void stopPlayingSound(javax.microedition.media.Player m)
 {
  m.deallocate();
  m.close();
 }
}
