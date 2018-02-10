package com.myMobApp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class myLog {

    /** Variables **/
    boolean folderExistResult = false;

    /** Time Stamp **/
    String timeStamp = new SimpleDateFormat("yyyyMMdd_").format(Calendar.getInstance().getTime());
    String logTimeStamp = new SimpleDateFormat("yyyy/MM/dd HH:MM:SS").format(Calendar.getInstance().getTime());

    /** File Pathes **/
    String filePath = "C:\\Users\\Big-Z\\IdeaProjects\\mobAppServ\\src\\main\\resources\\Logs\\";
    String fileName = timeStamp+"myLog.log";

    /** Check the folder is it exist or not if not it will created it. **/
    private void validateFolderExist(String infilePath){
        File theDir = new File(infilePath);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("Creating Directory: " + theDir.getName());

            try{
                theDir.mkdir();
                folderExistResult = theDir.exists();
            }
            catch(SecurityException se){
                System.out.println("Something went very wrong...");
            }
            if(folderExistResult) {
                System.out.println("Directory created: "+infilePath);
            }
        }
    }

    /** This method is the log itself. **/
    public void log(String logLevel,String message){

        String finalMessage = logTimeStamp+" "+"["+logLevel+"] - ["+getClass().getCanonicalName()+"] Msg: "+message;

        if(!folderExistResult)
            validateFolderExist(filePath);

        try(FileWriter fw = new FileWriter(filePath+fileName, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw)){

            /** Here is where the message is writing to the file. **/
            out.println(finalMessage);
            System.out.println(finalMessage);

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        } catch (SecurityException e) {
            e.printStackTrace();
        }
    }

    public static myLog getBack()
    {
        System.out.println("Return with the Logger Object..");
        return new myLog();
    }

}
