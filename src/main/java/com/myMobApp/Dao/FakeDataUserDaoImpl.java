package com.myMobApp.Dao;

import com.myMobApp.Entity.User;
import com.myMobApp.myLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import static com.myMobApp.myLog.myLogLevel;

/**
 * This DAO call the The Persistence Layer or FAKE DATA
 **/

@Repository
@Qualifier("fakeData")
public class FakeDataUserDaoImpl implements UserDao {

    myLog logee = myLog.getBack();

    private static Map<Integer, User> users;

    static {
        users = new HashMap<Integer, User>(){
            {
                put(1, new User(1,"Blondie","Hair","Blondie","Blondie@email.com"));
                put(2, new User(2,"Walter","Melon","Walter","Walter@email.com"));
                put(3, new User(3,"Melon","Gather","Melon","Melon@email.com"));
            }
        };
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
