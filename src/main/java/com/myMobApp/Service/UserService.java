package com.myMobApp.Service;

import com.myMobApp.Dao.UserDao;
import com.myMobApp.Entity.User;
import com.myMobApp.myLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    //@Qualifier("mongoDb")
    @Qualifier("fakeData")
    private UserDao userdao;

    /** Here is where we can get the all User from DB **/
    public Collection<User> getAllUser(){
        return userdao.getAllUser();
    }

    /** Here is where we can get a User by ID **/
    public User getUserByID(int id){
        return  userdao.getUserByID(id);
    }

    /** Here is where we can remove a User by ID from DB **/
    public void deleteUserByID(int id) {
        userdao.deleteUserByID(id);
    }

    /** Here is where we can update an User in the DB **/
    public void updateUser(User user) {
        userdao.updateUser(user);
    }

    /** Here is where we can insert a User in to the DB **/
    public void insertUser(User user) {
        userdao.insertUser(user);
    }
}