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

    public Collection<User> getAllUser(){
        return  users.values();
    }

    public User getUserByID(int id){
        return  users.get(id);
    }
}
