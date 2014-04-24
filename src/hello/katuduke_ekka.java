package hello;

import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.Choice;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.Item;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.StringItem;
import javax.microedition.midlet.MIDlet;
import org.netbeans.microedition.lcdui.SplashScreen;

public class katuduke_ekka extends MIDlet implements CommandListener
{

 private boolean midletPaused = false;
 private ludo ludo_game = null;
  
 //<editor-fold defaultstate="collapsed" desc=" Generated Fields ">//GEN-BEGIN:|fields|0|
 private Command exitCommand;
 private Command backCommand;
 private Command exitCommand1;
 private Command itemCommand;
 private Command itemCommand1;
 private Command backCommand1;
 private Command cancelCommand;
 private Command exitCommand2;
 private Command backCommand2;
 private Command exitCommand3;
 private Command backCommand3;
 private Command backCommand4;
 private Form form;
 private StringItem stringItem;
 private StringItem stringItem2;
 private StringItem stringItem1;
 private StringItem stringItem5;
 private StringItem stringItem4;
 private StringItem stringItem3;
 private StringItem stringItem8;
 private StringItem stringItem7;
 private StringItem stringItem6;
 private List list;
 private Form form1;
 private StringItem stringItem10;
 private StringItem stringItem9;
 private StringItem stringItem11;
 private SplashScreen splashScreen;
 private SplashScreen splashScreen1;
 private Font font;
 private Image image;
 private Image image1;
 //</editor-fold>//GEN-END:|fields|0|

 //constructor
 public katuduke_ekka()
 {
  ludo_game = new ludo(this);
 }

 //<editor-fold defaultstate="collapsed" desc=" Generated Methods ">//GEN-BEGIN:|methods|0|
 //</editor-fold>//GEN-END:|methods|0|

 //<editor-fold defaultstate="collapsed" desc=" Generated Method: initialize ">//GEN-BEGIN:|0-initialize|0|0-preInitialize
 /**
  * Initializes the application.
  * It is called only once when the MIDlet is started. The method is called before the <code>startMIDlet</code> method.
  */
 private void initialize()
 {//GEN-END:|0-initialize|0|0-preInitialize
     // write pre-initialize user code here
//GEN-LINE:|0-initialize|1|0-postInitialize
     // write post-initialize user code here
 }//GEN-BEGIN:|0-initialize|2|
 //</editor-fold>//GEN-END:|0-initialize|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Method: startMIDlet ">//GEN-BEGIN:|3-startMIDlet|0|3-preAction
 /**
  * Performs an action assigned to the Mobile Device - MIDlet Started point.
  */
 public void startMIDlet()
 {//GEN-END:|3-startMIDlet|0|3-preAction
     // write pre-action user code here
  switchDisplayable(null, getSplashScreen());//GEN-LINE:|3-startMIDlet|1|3-postAction
     // write post-action user code here
 }//GEN-BEGIN:|3-startMIDlet|2|
 //</editor-fold>//GEN-END:|3-startMIDlet|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Method: resumeMIDlet ">//GEN-BEGIN:|4-resumeMIDlet|0|4-preAction
 /**
  * Performs an action assigned to the Mobile Device - MIDlet Resumed point.
  */
 public void resumeMIDlet()
 {//GEN-END:|4-resumeMIDlet|0|4-preAction
     // write pre-action user code here
//GEN-LINE:|4-resumeMIDlet|1|4-postAction
     // write post-action user code here
 }//GEN-BEGIN:|4-resumeMIDlet|2|
 //</editor-fold>//GEN-END:|4-resumeMIDlet|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Method: switchDisplayable ">//GEN-BEGIN:|5-switchDisplayable|0|5-preSwitch
 /**
  * Switches a current displayable in a display. The <code>display</code> instance is taken from <code>getDisplay</code> method. This method is used by all actions in the design for switching displayable.
  * @param alert the Alert which is temporarily set to the display; if <code>null</code>, then <code>nextDisplayable</code> is set immediately
  * @param nextDisplayable the Displayable to be set
  */
 public void switchDisplayable(Alert alert, Displayable nextDisplayable)
 {//GEN-END:|5-switchDisplayable|0|5-preSwitch
     // write pre-switch user code here
  Display display = getDisplay();//GEN-BEGIN:|5-switchDisplayable|1|5-postSwitch
  if (alert == null)
  {
   display.setCurrent(nextDisplayable);
  }
  else
  {
   display.setCurrent(alert, nextDisplayable);
  }//GEN-END:|5-switchDisplayable|1|5-postSwitch
     // write post-switch user code here
 }//GEN-BEGIN:|5-switchDisplayable|2|
 //</editor-fold>//GEN-END:|5-switchDisplayable|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Method: commandAction for Displayables ">//GEN-BEGIN:|7-commandAction|0|7-preCommandAction
 /**
  * Called by a system to indicated that a command has been invoked on a particular displayable.
  * @param command the Command that was invoked
  * @param displayable the Displayable where the command was invoked
  */
 public void commandAction(Command command, Displayable displayable)
 {//GEN-END:|7-commandAction|0|7-preCommandAction
     // write pre-action user code here
  if (displayable == form)//GEN-BEGIN:|7-commandAction|1|65-preAction
  {
   if (command == backCommand3)
   {//GEN-END:|7-commandAction|1|65-preAction
    // write pre-action user code here
    switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|2|65-postAction
    // write post-action user code here
   }//GEN-BEGIN:|7-commandAction|3|19-preAction
   else if (command == exitCommand)
   {//GEN-END:|7-commandAction|3|19-preAction
             // write pre-action user code here
    exitMIDlet();//GEN-LINE:|7-commandAction|4|19-postAction
             // write post-action user code here
   }//GEN-BEGIN:|7-commandAction|5|73-preAction
  }
  else if (displayable == form1)
  {
   if (command == backCommand4)
   {//GEN-END:|7-commandAction|5|73-preAction
    // write pre-action user code here
    switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|6|73-postAction
    // write post-action user code here
   }//GEN-BEGIN:|7-commandAction|7|70-preAction
   else if (command == exitCommand3)
   {//GEN-END:|7-commandAction|7|70-preAction
    // write pre-action user code here
    exitMIDlet();//GEN-LINE:|7-commandAction|8|70-postAction
    // write post-action user code here
   }//GEN-BEGIN:|7-commandAction|9|42-preAction
  }
  else if (displayable == list)
  {
   if (command == List.SELECT_COMMAND)
   {//GEN-END:|7-commandAction|9|42-preAction
    // write pre-action user code here
    listAction();//GEN-LINE:|7-commandAction|10|42-postAction
    // write post-action user code here
   }//GEN-BEGIN:|7-commandAction|11|49-preAction
   else if (command == backCommand2)
   {//GEN-END:|7-commandAction|11|49-preAction
    // write pre-action user code here
    exitMIDlet();//GEN-LINE:|7-commandAction|12|49-postAction
    // write post-action user code here
   }//GEN-BEGIN:|7-commandAction|13|51-preAction
   else if (command == exitCommand2)
   {//GEN-END:|7-commandAction|13|51-preAction
    // write pre-action user code here
//GEN-LINE:|7-commandAction|14|51-postAction
    // write post-action user code here
   }//GEN-BEGIN:|7-commandAction|15|77-preAction
  }
  else if (displayable == splashScreen)
  {
   if (command == SplashScreen.DISMISS_COMMAND)
   {//GEN-END:|7-commandAction|15|77-preAction
    // write pre-action user code here
    switchDisplayable(null, getSplashScreen1());//GEN-LINE:|7-commandAction|16|77-postAction
    // write post-action user code here
   }//GEN-BEGIN:|7-commandAction|17|81-preAction
  }
  else if (displayable == splashScreen1)
  {
   if (command == SplashScreen.DISMISS_COMMAND)
   {//GEN-END:|7-commandAction|17|81-preAction
    // write pre-action user code here
    switchDisplayable(null, getList());//GEN-LINE:|7-commandAction|18|81-postAction
    // write post-action user code here
   }//GEN-BEGIN:|7-commandAction|19|7-postCommandAction
  }//GEN-END:|7-commandAction|19|7-postCommandAction
     // write post-action user code here
 }//GEN-BEGIN:|7-commandAction|20|
 //</editor-fold>//GEN-END:|7-commandAction|20|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand ">//GEN-BEGIN:|18-getter|0|18-preInit
 /**
  * Returns an initiliazed instance of exitCommand component.
  * @return the initialized component instance
  */
 public Command getExitCommand()
 {
  if (exitCommand == null)
  {//GEN-END:|18-getter|0|18-preInit
         // write pre-init user code here
   exitCommand = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|18-getter|1|18-postInit
         // write post-init user code here
  }//GEN-BEGIN:|18-getter|2|
  return exitCommand;
 }
 //</editor-fold>//GEN-END:|18-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form ">//GEN-BEGIN:|14-getter|0|14-preInit
 /**
  * Returns an initiliazed instance of form component.
  * @return the initialized component instance
  */
 public Form getForm()
 {
  if (form == null)
  {//GEN-END:|14-getter|0|14-preInit
         // write pre-init user code here
   form = new Form("KATUDUKE EKKA", new Item[] { getStringItem(), getStringItem1(), getStringItem2(), getStringItem3(), getStringItem4(), getStringItem5(), getStringItem6(), getStringItem7(), getStringItem8() });//GEN-BEGIN:|14-getter|1|14-postInit
   form.addCommand(getExitCommand());
   form.addCommand(getBackCommand3());
   form.setCommandListener(this);//GEN-END:|14-getter|1|14-postInit
         // write post-init user code here
  }//GEN-BEGIN:|14-getter|2|
  return form;
 }
 //</editor-fold>//GEN-END:|14-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem ">//GEN-BEGIN:|16-getter|0|16-preInit
 /**
  * Returns an initiliazed instance of stringItem component.
  * @return the initialized component instance
  */
 public StringItem getStringItem()
 {
  if (stringItem == null)
  {//GEN-END:|16-getter|0|16-preInit
         // write pre-init user code here
   stringItem = new StringItem("Hello", "");//GEN-LINE:|16-getter|1|16-postInit
         // write post-init user code here
  }//GEN-BEGIN:|16-getter|2|
  return stringItem;
 }
 //</editor-fold>//GEN-END:|16-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand ">//GEN-BEGIN:|23-getter|0|23-preInit
 /**
  * Returns an initiliazed instance of backCommand component.
  * @return the initialized component instance
  */
 public Command getBackCommand()
 {
  if (backCommand == null)
  {//GEN-END:|23-getter|0|23-preInit
      // write pre-init user code here
   backCommand = new Command("Back", Command.BACK, 0);//GEN-LINE:|23-getter|1|23-postInit
      // write post-init user code here
  }//GEN-BEGIN:|23-getter|2|
  return backCommand;
 }
 //</editor-fold>//GEN-END:|23-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand1 ">//GEN-BEGIN:|25-getter|0|25-preInit
 /**
  * Returns an initiliazed instance of exitCommand1 component.
  * @return the initialized component instance
  */
 public Command getExitCommand1()
 {
  if (exitCommand1 == null)
  {//GEN-END:|25-getter|0|25-preInit
      // write pre-init user code here
   exitCommand1 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|25-getter|1|25-postInit
      // write post-init user code here
  }//GEN-BEGIN:|25-getter|2|
  return exitCommand1;
 }
 //</editor-fold>//GEN-END:|25-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand ">//GEN-BEGIN:|27-getter|0|27-preInit
 /**
  * Returns an initiliazed instance of itemCommand component.
  * @return the initialized component instance
  */
 public Command getItemCommand()
 {
  if (itemCommand == null)
  {//GEN-END:|27-getter|0|27-preInit
      // write pre-init user code here
   itemCommand = new Command("start game", "start game", Command.ITEM, 0);//GEN-LINE:|27-getter|1|27-postInit
      // write post-init user code here
  }//GEN-BEGIN:|27-getter|2|
  return itemCommand;
 }
 //</editor-fold>//GEN-END:|27-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: itemCommand1 ">//GEN-BEGIN:|29-getter|0|29-preInit
 /**
  * Returns an initiliazed instance of itemCommand1 component.
  * @return the initialized component instance
  */
 public Command getItemCommand1()
 {
  if (itemCommand1 == null)
  {//GEN-END:|29-getter|0|29-preInit
      // write pre-init user code here
   itemCommand1 = new Command("Statistics", "Statistics", Command.ITEM, 0);//GEN-LINE:|29-getter|1|29-postInit
      // write post-init user code here
  }//GEN-BEGIN:|29-getter|2|
  return itemCommand1;
 }
 //</editor-fold>//GEN-END:|29-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand1 ">//GEN-BEGIN:|35-getter|0|35-preInit
 /**
  * Returns an initiliazed instance of backCommand1 component.
  * @return the initialized component instance
  */
 public Command getBackCommand1()
 {
  if (backCommand1 == null)
  {//GEN-END:|35-getter|0|35-preInit
      // write pre-init user code here
   backCommand1 = new Command("Back", Command.BACK, 0);//GEN-LINE:|35-getter|1|35-postInit
      // write post-init user code here
  }//GEN-BEGIN:|35-getter|2|
  return backCommand1;
 }
 //</editor-fold>//GEN-END:|35-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: cancelCommand ">//GEN-BEGIN:|37-getter|0|37-preInit
 /**
  * Returns an initiliazed instance of cancelCommand component.
  * @return the initialized component instance
  */
 public Command getCancelCommand()
 {
  if (cancelCommand == null)
  {//GEN-END:|37-getter|0|37-preInit
      // write pre-init user code here
   cancelCommand = new Command("Cancel", Command.CANCEL, 0);//GEN-LINE:|37-getter|1|37-postInit
      // write post-init user code here
  }//GEN-BEGIN:|37-getter|2|
  return cancelCommand;
 }
 //</editor-fold>//GEN-END:|37-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand2 ">//GEN-BEGIN:|48-getter|0|48-preInit
 /**
  * Returns an initiliazed instance of backCommand2 component.
  * @return the initialized component instance
  */
 public Command getBackCommand2()
 {
  if (backCommand2 == null)
  {//GEN-END:|48-getter|0|48-preInit
   // write pre-init user code here
   backCommand2 = new Command("Back", Command.BACK, 0);//GEN-LINE:|48-getter|1|48-postInit
   // write post-init user code here
  }//GEN-BEGIN:|48-getter|2|
  return backCommand2;
 }
 //</editor-fold>//GEN-END:|48-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand2 ">//GEN-BEGIN:|50-getter|0|50-preInit
 /**
  * Returns an initiliazed instance of exitCommand2 component.
  * @return the initialized component instance
  */
 public Command getExitCommand2()
 {
  if (exitCommand2 == null)
  {//GEN-END:|50-getter|0|50-preInit
   // write pre-init user code here
   exitCommand2 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|50-getter|1|50-postInit
   // write post-init user code here
  }//GEN-BEGIN:|50-getter|2|
  return exitCommand2;
 }
 //</editor-fold>//GEN-END:|50-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: list ">//GEN-BEGIN:|40-getter|0|40-preInit
 /**
  * Returns an initiliazed instance of list component.
  * @return the initialized component instance
  */
 public List getList()
 {
  if (list == null)
  {//GEN-END:|40-getter|0|40-preInit
   // write pre-init user code here
   list = new List("menu", Choice.IMPLICIT);//GEN-BEGIN:|40-getter|1|40-postInit
   list.append("NEW_GAME", null);
   list.append("STATISTICS", null);
   list.append("RULES", null);
   list.addCommand(getBackCommand2());
   list.addCommand(getExitCommand2());
   list.setCommandListener(this);
   list.setSelectedFlags(new boolean[] { true, false, false });//GEN-END:|40-getter|1|40-postInit
   ludo_game=new ludo(this);
  }//GEN-BEGIN:|40-getter|2|
  return list;
 }
 //</editor-fold>//GEN-END:|40-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Method: listAction ">//GEN-BEGIN:|40-action|0|40-preAction
 /**
  * Performs an action assigned to the selected list element in the list component.
  */
 public void listAction()
 {//GEN-END:|40-action|0|40-preAction
  // enter pre-action user code here
  switch (getList().getSelectedIndex())//GEN-BEGIN:|40-action|1|45-preAction
  {
   case 0://GEN-END:|40-action|1|45-preAction
    ludo_game.start();
    switchDisplayable(null, ludo_game) ;
//GEN-LINE:|40-action|2|45-postAction
    // write post-action user code here
    break;//GEN-BEGIN:|40-action|3|46-preAction
   case 1://GEN-END:|40-action|3|46-preAction
    // write pre-action user code here
    switchDisplayable(null, getForm1());//GEN-LINE:|40-action|4|46-postAction
    // write post-action user code here
    break;//GEN-BEGIN:|40-action|5|56-preAction
   case 2://GEN-END:|40-action|5|56-preAction
    // write pre-action user code here
    switchDisplayable(null, getForm());//GEN-LINE:|40-action|6|56-postAction
    // write post-action user code here
    break;//GEN-BEGIN:|40-action|7|40-postAction
  }//GEN-END:|40-action|7|40-postAction
  // enter post-action user code here
 }//GEN-BEGIN:|40-action|8|
 //</editor-fold>//GEN-END:|40-action|8|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem1 ">//GEN-BEGIN:|52-getter|0|52-preInit
 /**
  * Returns an initiliazed instance of stringItem1 component.
  * @return the initialized component instance
  */
 public StringItem getStringItem1()
 {
  if (stringItem1 == null)
  {//GEN-END:|52-getter|0|52-preInit
   // write pre-init user code here
   stringItem1 = new StringItem("1", "THESE ARE THE GAME RULES");//GEN-LINE:|52-getter|1|52-postInit
   // write post-init user code here
  }//GEN-BEGIN:|52-getter|2|
  return stringItem1;
 }
 //</editor-fold>//GEN-END:|52-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem2 ">//GEN-BEGIN:|53-getter|0|53-preInit
 /**
  * Returns an initiliazed instance of stringItem2 component.
  * @return the initialized component instance
  */
 public StringItem getStringItem2()
 {
  if (stringItem2 == null)
  {//GEN-END:|53-getter|0|53-preInit
   // write pre-init user code here
   stringItem2 = new StringItem("2", "you need to roll a 6 inorder to start moving button");//GEN-LINE:|53-getter|1|53-postInit
   // write post-init user code here
  }//GEN-BEGIN:|53-getter|2|
  return stringItem2;
 }
 //</editor-fold>//GEN-END:|53-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem3 ">//GEN-BEGIN:|57-getter|0|57-preInit
 /**
  * Returns an initiliazed instance of stringItem3 component.
  * @return the initialized component instance
  */
 public StringItem getStringItem3()
 {
  if (stringItem3 == null)
  {//GEN-END:|57-getter|0|57-preInit
   // write pre-init user code here
   stringItem3 = new StringItem("3", "a subsequent 6 can be used to get another button from home if any still exist");//GEN-LINE:|57-getter|1|57-postInit
   // write post-init user code here
  }//GEN-BEGIN:|57-getter|2|
  return stringItem3;
 }
 //</editor-fold>//GEN-END:|57-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem4 ">//GEN-BEGIN:|58-getter|0|58-preInit
 /**
  * Returns an initiliazed instance of stringItem4 component.
  * @return the initialized component instance
  */
 public StringItem getStringItem4()
 {
  if (stringItem4 == null)
  {//GEN-END:|58-getter|0|58-preInit
   // write pre-init user code here
   stringItem4 = new StringItem("4", "a button if out and onto board only moves forward the distance indicated on the die");//GEN-LINE:|58-getter|1|58-postInit
   // write post-init user code here
  }//GEN-BEGIN:|58-getter|2|
  return stringItem4;
 }
 //</editor-fold>//GEN-END:|58-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem5 ">//GEN-BEGIN:|59-getter|0|59-preInit
 /**
  * Returns an initiliazed instance of stringItem5 component.
  * @return the initialized component instance
  */
 public StringItem getStringItem5()
 {
  if (stringItem5 == null)
  {//GEN-END:|59-getter|0|59-preInit
   // write pre-init user code here
   stringItem5 = new StringItem("5", "a player who rolls a 6 is given one more chance to roll the die immediately");//GEN-LINE:|59-getter|1|59-postInit
   // write post-init user code here
  }//GEN-BEGIN:|59-getter|2|
  return stringItem5;
 }
 //</editor-fold>//GEN-END:|59-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem6 ">//GEN-BEGIN:|60-getter|0|60-preInit
 /**
  * Returns an initiliazed instance of stringItem6 component.
  * @return the initialized component instance
  */
 public StringItem getStringItem6()
 {
  if (stringItem6 == null)
  {//GEN-END:|60-getter|0|60-preInit
   // write pre-init user code here
   stringItem6 = new StringItem("6", "a player button automatically eats an enemy button if it finds itself in the same spot after a dice roll ");//GEN-LINE:|60-getter|1|60-postInit
   // write post-init user code here
  }//GEN-BEGIN:|60-getter|2|
  return stringItem6;
 }
 //</editor-fold>//GEN-END:|60-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem7 ">//GEN-BEGIN:|61-getter|0|61-preInit
 /**
  * Returns an initiliazed instance of stringItem7 component.
  * @return the initialized component instance
  */
 public StringItem getStringItem7()
 {
  if (stringItem7 == null)
  {//GEN-END:|61-getter|0|61-preInit
   // write pre-init user code here
   stringItem7 = new StringItem("7", "however any 2 buttons of the same color in the same spot automaticallly block the road and any opposing buttons cannot subsequently pass the barrier and have to wait for player to unblock");//GEN-LINE:|61-getter|1|61-postInit
   // write post-init user code here
  }//GEN-BEGIN:|61-getter|2|
  return stringItem7;
 }
 //</editor-fold>//GEN-END:|61-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem8 ">//GEN-BEGIN:|62-getter|0|62-preInit
 /**
  * Returns an initiliazed instance of stringItem8 component.
  * @return the initialized component instance
  */
 public StringItem getStringItem8()
 {
  if (stringItem8 == null)
  {//GEN-END:|62-getter|0|62-preInit
   // write pre-init user code here
   stringItem8 = new StringItem("8", "once a player is in the home stretch of his color he has play the a number equal to or less than the exact number of steps needed to reach home on the die");//GEN-LINE:|62-getter|1|62-postInit
   // write post-init user code here
  }//GEN-BEGIN:|62-getter|2|
  return stringItem8;
 }
 //</editor-fold>//GEN-END:|62-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand3 ">//GEN-BEGIN:|64-getter|0|64-preInit
 /**
  * Returns an initiliazed instance of backCommand3 component.
  * @return the initialized component instance
  */
 public Command getBackCommand3()
 {
  if (backCommand3 == null)
  {//GEN-END:|64-getter|0|64-preInit
   // write pre-init user code here
   backCommand3 = new Command("Back", Command.BACK, 0);//GEN-LINE:|64-getter|1|64-postInit
   // write post-init user code here
  }//GEN-BEGIN:|64-getter|2|
  return backCommand3;
 }
 //</editor-fold>//GEN-END:|64-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: exitCommand3 ">//GEN-BEGIN:|69-getter|0|69-preInit
 /**
  * Returns an initiliazed instance of exitCommand3 component.
  * @return the initialized component instance
  */
 public Command getExitCommand3()
 {
  if (exitCommand3 == null)
  {//GEN-END:|69-getter|0|69-preInit
   // write pre-init user code here
   exitCommand3 = new Command("Exit", Command.EXIT, 0);//GEN-LINE:|69-getter|1|69-postInit
   // write post-init user code here
  }//GEN-BEGIN:|69-getter|2|
  return exitCommand3;
 }
 //</editor-fold>//GEN-END:|69-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: backCommand4 ">//GEN-BEGIN:|72-getter|0|72-preInit
 /**
  * Returns an initiliazed instance of backCommand4 component.
  * @return the initialized component instance
  */
 public Command getBackCommand4()
 {
  if (backCommand4 == null)
  {//GEN-END:|72-getter|0|72-preInit
   // write pre-init user code here
   backCommand4 = new Command("Back", Command.BACK, 0);//GEN-LINE:|72-getter|1|72-postInit
   // write post-init user code here
  }//GEN-BEGIN:|72-getter|2|
  return backCommand4;
 }
 //</editor-fold>//GEN-END:|72-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: form1 ">//GEN-BEGIN:|67-getter|0|67-preInit
 /**
  * Returns an initiliazed instance of form1 component.
  * @return the initialized component instance
  */
 public Form getForm1()
 {
  if (form1 == null)
  {//GEN-END:|67-getter|0|67-preInit
   // write pre-init user code here
   form1 = new Form("form1", new Item[] { getStringItem9(), getStringItem10(), getStringItem11() });//GEN-BEGIN:|67-getter|1|67-postInit
   form1.addCommand(getExitCommand3());
   form1.addCommand(getBackCommand4());
   form1.setCommandListener(this);//GEN-END:|67-getter|1|67-postInit
   // write post-init user code here
  }//GEN-BEGIN:|67-getter|2|
  return form1;
 }
 //</editor-fold>//GEN-END:|67-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen ">//GEN-BEGIN:|75-getter|0|75-preInit
 /**
  * Returns an initiliazed instance of splashScreen component.
  * @return the initialized component instance
  */
 public SplashScreen getSplashScreen()
 {
  if (splashScreen == null)
  {//GEN-END:|75-getter|0|75-preInit
   SoundEffects m=new SoundEffects();
   m.playIntroSound();
   splashScreen = new SplashScreen(getDisplay());//GEN-BEGIN:|75-getter|1|75-postInit
   splashScreen.setTitle("splashScreen");
   splashScreen.setCommandListener(this);
   splashScreen.setFullScreenMode(true);
   splashScreen.setImage(getImage());
   splashScreen.setText(" !! IMPOSSIBLE is NOTHING !!");
   splashScreen.setTextFont(getFont());//GEN-END:|75-getter|1|75-postInit

  }//GEN-BEGIN:|75-getter|2|
  return splashScreen;
 }
 //</editor-fold>//GEN-END:|75-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: font ">//GEN-BEGIN:|78-getter|0|78-preInit
 /**
  * Returns an initiliazed instance of font component.
  * @return the initialized component instance
  */
 public Font getFont()
 {
  if (font == null)
  {//GEN-END:|78-getter|0|78-preInit
   // write pre-init user code here
   font = Font.getDefaultFont();//GEN-LINE:|78-getter|1|78-postInit
   // write post-init user code here
  }//GEN-BEGIN:|78-getter|2|
  return font;
 }
 //</editor-fold>//GEN-END:|78-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: splashScreen1 ">//GEN-BEGIN:|80-getter|0|80-preInit
 /**
  * Returns an initiliazed instance of splashScreen1 component.
  * @return the initialized component instance
  */
 public SplashScreen getSplashScreen1()
 {
  if (splashScreen1 == null)
  {//GEN-END:|80-getter|0|80-preInit
   // write pre-init user code here
   splashScreen1 = new SplashScreen(getDisplay());//GEN-BEGIN:|80-getter|1|80-postInit
   splashScreen1.setTitle("splashScreen1");
   splashScreen1.setCommandListener(this);
   splashScreen1.setImage(getImage1());//GEN-END:|80-getter|1|80-postInit
   // write post-init user code here
  }//GEN-BEGIN:|80-getter|2|
  return splashScreen1;
 }
 //</editor-fold>//GEN-END:|80-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image ">//GEN-BEGIN:|86-getter|0|86-preInit
 /**
  * Returns an initiliazed instance of image component.
  * @return the initialized component instance
  */
 public Image getImage()
 {
  if (image == null)
  {//GEN-END:|86-getter|0|86-preInit
   // write pre-init user code here
   try//GEN-BEGIN:|86-getter|1|86-@java.io.IOException
   {
    image = Image.createImage("/res/intro.png");
   }
   catch (java.io.IOException e)
   {//GEN-END:|86-getter|1|86-@java.io.IOException
    destroyApp(false);
   }//GEN-LINE:|86-getter|2|86-postInit
   // write post-init user code here
  }//GEN-BEGIN:|86-getter|3|
  return image;
 }
 //</editor-fold>//GEN-END:|86-getter|3|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: image1 ">//GEN-BEGIN:|91-getter|0|91-preInit
 /**
  * Returns an initiliazed instance of image1 component.
  * @return the initialized component instance
  */
 public Image getImage1()
 {
  if (image1 == null)
  {//GEN-END:|91-getter|0|91-preInit
   // write pre-init user code here
   try//GEN-BEGIN:|91-getter|1|91-@java.io.IOException
   {
    image1 = Image.createImage("/res/Katuduke_ekka.png");
   }
   catch (java.io.IOException e)
   {//GEN-END:|91-getter|1|91-@java.io.IOException
    destroyApp(false);
   }//GEN-LINE:|91-getter|2|91-postInit
   // write post-init user code here
  }//GEN-BEGIN:|91-getter|3|
  return image1;
 }
 //</editor-fold>//GEN-END:|91-getter|3|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem9 ">//GEN-BEGIN:|92-getter|0|92-preInit
 /**
  * Returns an initiliazed instance of stringItem9 component.
  * @return the initialized component instance
  */
 public StringItem getStringItem9()
 {
  if (stringItem9 == null)
  {//GEN-END:|92-getter|0|92-preInit
   // write pre-init user code here
   stringItem9 = new StringItem("", "Wins=");//GEN-LINE:|92-getter|1|92-postInit
   DataStoreHandler m=new DataStoreHandler();
   println("Wins="+m.GetNumberOfWins());
   stringItem9=new StringItem("Wins=",""+m.GetNumberOfWins());
  }//GEN-BEGIN:|92-getter|2|
  return stringItem9;
 }
 //</editor-fold>//GEN-END:|92-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem10 ">//GEN-BEGIN:|93-getter|0|93-preInit
 /**
  * Returns an initiliazed instance of stringItem10 component.
  * @return the initialized component instance
  */
 public StringItem getStringItem10()
 {
  if (stringItem10 == null)
  {//GEN-END:|93-getter|0|93-preInit
   // write pre-init user code here
   stringItem10 = new StringItem("", "Losses=");//GEN-LINE:|93-getter|1|93-postInit
   DataStoreHandler m=new DataStoreHandler();
   println("Losses="+m.GetNumberOfLosses());
   stringItem10=new StringItem("Losses=",""+m.GetNumberOfLosses());
  }//GEN-BEGIN:|93-getter|2|
  return stringItem10;
 }
 //</editor-fold>//GEN-END:|93-getter|2|

 //<editor-fold defaultstate="collapsed" desc=" Generated Getter: stringItem11 ">//GEN-BEGIN:|94-getter|0|94-preInit
 /**
  * Returns an initiliazed instance of stringItem11 component.
  * @return the initialized component instance
  */
 public StringItem getStringItem11()
 {
  if (stringItem11 == null)
  {//GEN-END:|94-getter|0|94-preInit
   // write pre-init user code here
   stringItem11 = new StringItem("", "Games Played=");//GEN-LINE:|94-getter|1|94-postInit
   DataStoreHandler m=new DataStoreHandler();
   println("Games Played="+(m.GetNumberOfLosses()+m.GetNumberOfWins()));
   stringItem11=new StringItem("Games Played=",""+(m.GetNumberOfWins()+m.GetNumberOfLosses()));
  }//GEN-BEGIN:|94-getter|2|
  return stringItem11;
 }
 //</editor-fold>//GEN-END:|94-getter|2|
   
 //returns display
 public Display getDisplay()
 {
  return Display.getDisplay(this);
 }

 //ends midlet
 public void exitMIDlet()
 {
  switchDisplayable(null, null);
  destroyApp(true);
  notifyDestroyed();
 }

//starts our game
 public void startApp()
 {
  if (midletPaused)
  {
   resumeMIDlet();
  }
  else
  {
   initialize();
   startMIDlet();
  }
  
  midletPaused = false;
 }

 //called if game paused
 public void pauseApp()
 {
  midletPaused = true;
  notifyDestroyed();
 }

 //terminates midlet
 public void destroyApp(boolean unconditional)
 {
 }
 
 //getter:ludo_game
 public ludo getLudo_game()
 {
  return ludo_game;
 }

 //setter:ludo_game
 public void setLudo_game(ludo ludo_game)
 {
  this.ludo_game = ludo_game;
 }

 void restartGame()
 {
  ludo_game=new ludo(this);
  switchDisplayable(null, getList());
 }

 private void println(String string)
 {
  System.out.println(string);
 }
 
}
