package com.myMobApp.Dao;

import com.myMobApp.Entity.User;
import com.myMobApp.myServices.RandomString;
import com.myMobApp.myServices.myLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.*;

import static com.myMobApp.myServices.myLog.myLogLevel;

/**
 * This DAO call the The Persistence Layer or FAKE DATA
 **/

@Repository
@Qualifier("fakeData")
public class FakeDataUserDaoImpl implements UserDao {

    myLog logee = myLog.getBack();

    /** Create User Fake DATA **/
    static private Integer generatedID = (new Random()).nextInt(900000) + 100000;
    static private String generatedActivationCode =  new RandomString().getGenID();
    static private String userPassword =  new RandomString().getGenID();
    static private String userName =  new RandomString().getGenName();
    static private String userEmail =  new RandomString().getGenEmail();

    static private BufferedImage profilePic = null;
    static private boolean onlineStatus = Math.random() < 0.5;
    static private Map<Integer, String> userCity = new HashMap();
    static private Map<Integer, String> userCountry = new HashMap();

    static private SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:MM:SS");
    static private String date = sdf.format(new Date());

    /** Create User object from FAKE DATA**/
    private static Map<Integer, User> users;

    static {
        users = new HashMap<Integer, User>(){
            {
                put(1, new User(generatedID,userName,userName,userName,userEmail));
                reGenerate();
                put(2, new User(generatedID,userName,userName,userName,userEmail));
                reGenerate();
                put(3, new User(generatedID,userName,userName,userName,userEmail));
            }
        };
    }

    private static void reGenerate(){
        /** Create User Fake DATA **/
        generatedID = (new Random()).nextInt(900000) + 100000;
        generatedActivationCode =  new RandomString().getGenID();
        userPassword =  new RandomString().getGenID();
        userName =  new RandomString().getGenName();
        userEmail =  new RandomString().getGenEmail();
        onlineStatus = Math.random() < 0.5;
        sdf = new SimpleDateFormat("yyyy/MM/dd HH:MM:SS");
        date = sdf.format(new Date());
    }

    /** Here is where we can get the all User from DB **/
    @Override
    public Collection<User> getAllUser(){
        Collection<User> existingUser = users.values();
        if (existingUser.size() != 0) {
            logee.log(myLogLevel.INFO,getClass(),"Getting all User from the FAKE DATA.");
            return existingUser;
        } else {
            logee.log(myLogLevel.WARN,getClass(),"User list is empty...");
            throw new UsernameNotFoundException("User list is empty...");
        }
    }

    /** Here is where we can get a User by ID **/
    @Override
    public User getUserByID(int id){
        User existingUser = users.get(id);
        if (existingUser != null) {
            logee.log(myLogLevel.INFO,getClass(),"Getting User: "+users.get(id).getUserName().toUpperCase()+" by ID from the FAKE DATA.");
            return existingUser;
        } else {
            logee.log(myLogLevel.WARN,getClass(),"User not found...");
            throw new UsernameNotFoundException("User not found...");
        }
    }

    /** Here is where we can remove a User by ID from DB **/
    @Override
    public void deleteUserByID(int id) {
        User existingUser = users.remove(id);
        if (existingUser != null) {
            logee.log(myLogLevel.INFO,getClass(),"Delete User: "+users.get(id).getUserName().toUpperCase()+" by ID from the FAKE DATA.");
        } else {
            logee.log(myLogLevel.WARN,getClass(),"User not found to delete...");
            throw new UsernameNotFoundException("User not found to delete...");
        }
    }

    /** Here is where we can update an User in the DB **/
    @Override
    public void updateUser(User user) {
        User u = users.get(user.getId());
        if (u != null) {
            logee.log(myLogLevel.INFO,getClass(),"Delete User: "+user.getUserName().toUpperCase()+" by ID from the FAKE DATA.");
            u.setUserName(user.getUserName());
            u.setFirstName(user.getFirstName());
            u.setLastName(user.getLastName());
            u.setEmailAddress(user.getEmailAddress());
            users.put(user.getId(), user);
        } else {
            logee.log(myLogLevel.WARN,getClass(),"User not found to update...");
            throw new UsernameNotFoundException("User not found to update...");
        }
    }

    /** Here is where we can insert a User in to the DB **/
    @Override
    public void insertUser(User user) {
        User u = users.get(user.getId());
        if (u != null) {
            logee.log(myLogLevel.INFO,getClass(),"Insert User: "+user.getUserName().toUpperCase()+" into the FAKE DATA.");
            users.put(user.getId(), user);
        } else {
            logee.log(myLogLevel.WARN,getClass(),"User not found to insert User...");
            throw new UsernameNotFoundException("User not found to insert User...");
        }
    }
}
