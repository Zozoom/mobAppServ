package com.myMobApp.myServices;

import java.util.Random;

public class RandomString {

    private String SALTCHARS_WithNumber = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890";
    private String SALTCHARS_WithoutNumber = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static String genNameForEmail;

    private String getSaltString(int CharLen, String SALTCHARS) {
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();

        while (salt.length() < CharLen) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }

    public String getGenName(){
        return genNameForEmail = getSaltString(8,SALTCHARS_WithoutNumber);
    }

    public String getGenID(){
        return getSaltString(15,SALTCHARS_WithNumber);
    }

    public String getGenEmail(){
        return genNameForEmail + "@email.com";
    }
}