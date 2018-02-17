package com.myMobApp;

import com.myMobApp.myServices.myLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootWebApplication {

    public static void main(String[] args) {

        myLog logee = myLog.getBack();
        logee.log(myLog.myLogLevel.STATUS, SpringBootWebApplication.class,"Start Applciation");
        SpringApplication.run(SpringBootWebApplication.class,args);
    }
}
