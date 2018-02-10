package com.myMobApp;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class myLog {

    /** Variables **/
    private boolean folderExistResult = false;

    /** Time Stamp **/
    private String timeStamp = new SimpleDateFormat("yyyyMMdd_").format(Calendar.getInstance().getTime());
    private String logTimeStamp = new SimpleDateFormat("yyyy/MM/dd HH:MM:SS").format(Calendar.getInstance().getTime());

    /** File Pathes **/
    private String filePath = "C:\\Users\\Big-Z\\IdeaProjects\\mobAppServ\\src\\main\\resources\\Logs\\";
    private String fileName = timeStamp+"myLog.log";

    /** Check the folder is it exist or not if not it will created it. **/
    private void validateFolderExist(String infilePath){
        File theDir = new File(infilePath);

        // if the directory does not exist, create it
        if (!theDir.exists()) {
            System.out.println("Creating Directory: " + theDir.getName());

            try{
                folderExistResult = theDir.mkdir();
            }
            catch(SecurityException se){
                System.err.println("Something went very wrong...");
            }
            if(folderExistResult) {
                System.out.println("Directory created: "+infilePath);
            }
            else{
                System.out.println("Directory already exist: "+infilePath);
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

            // Here is where the message is writing to the file. //
            out.println(finalMessage);
            System.out.println(finalMessage);

        } catch (IOException e) {
            System.err.println("Something went very wrong...\n Error: "+e.getMessage());
        } catch (SecurityException e) {
            System.err.println("Something went very wrong...\n Error: "+e.getMessage());
            e.printStackTrace();
        }
    }

    /** This method get back a new instance of the logger. **/
    public static myLog getBack()
    {
        System.out.println("Return with the Logger Object..");
        return new myLog();
    }

}
