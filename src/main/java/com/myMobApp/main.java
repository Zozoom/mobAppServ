package com.myMobApp;

import com.myMobApp.myLog.myLogLevel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class main {

    public static void main(String[] args) {

        myLog logee = myLog.getBack();
        logee.log(myLogLevel.STATUS, main.class,"Start Applciation");

        SpringApplication.run(main.class,args);
    }
}
