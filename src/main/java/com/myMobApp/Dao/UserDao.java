package com.myMobApp.Dao;

import com.myMobApp.Entity.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    private static Map<Integer, User> users;

    static {
        users = new HashMap<Integer, User>(){
            {
                put(1, new User(1,"nick","Name","Nick","nickname@email.com"));
                put(2, new User(2,"nick2","Name2","Nick2","nickname2@email.com"));
                put(3, new User(3,"nick3","Name3","Nick3","nickname3@email.com"));
            }
        };
    }

    /** Here is where we can get the all User from DB **/
    public Collection<User> getAllUser(){
        return  users.values();
    }

    /** Here is where we can get a User by ID **/
    public User getUserByID(int id){
        return  users.get(id);
    }

    /** Here is where we can remove a User by ID from DB **/
    public void deleteUserByID(int id) {
        users.remove(id);
    }

    /** Here is where we can update an User in the DB **/
    public void updateUser(User user) {
        User u = users.get(user.getId());
        u.setUserName(user.getUserName());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmailAddress(user.getEmailAddress());
        users.put(user.getId(), user);
    }

    /** Here is where we can insert a User in to the DB **/
    public void insertUser(User user) {
        users.put(user.getId(),user);
    }
}
