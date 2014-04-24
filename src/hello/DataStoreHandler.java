package hello;

import javax.microedition.rms.*;

public class DataStoreHandler
{
 private RecordStore rs;
 private String dataStore_for_losses="KATUDUKE_EKKA_LOSSES";
 private String dataStore_for_wins="KATUDUKE_EKKA_WINS";
 
 public DataStoreHandler()
 {
 
 }
 
 public void StoreWin()
 {
  try
  {
   
   String num="";
   byte[] data=num.getBytes();
   rs=RecordStore.openRecordStore(dataStore_for_wins, true);
   rs.addRecord(data, 0,data.length );
  }
  catch (RecordStoreException ex)
  {
   
  }
 }
 
 public void StoreLoss()
 {
  try
  {
   
   String num="";
   byte[] data=num.getBytes();
   rs=RecordStore.openRecordStore(dataStore_for_losses, true);
   rs.addRecord(data, 0,data.length );
  }
  catch (RecordStoreException ex)
  {
   
  }
 }
 
 public void IncrementNumberOfGamesPlayed()
 {
 
 }
 
 public int GetNumberOfWins()
 {
  int wins=0;
  try
  {
   rs=RecordStore.openRecordStore(dataStore_for_wins, true);
   wins=rs.getNumRecords();
   return wins;
  }
  catch (Exception e)
  {
  
  }
  return wins;
 }
 
 public int GetNumberOfLosses()
 {
  int losses=0;
  try
  {
   rs=RecordStore.openRecordStore(dataStore_for_losses, true);
   losses=rs.getNumRecords();
   return losses;
  }
  catch (Exception e)
  {
  
  }
  return losses;
 }
 
 public int GetNumberOfGamesPlayed()
 {
 return 0;
 }
}
