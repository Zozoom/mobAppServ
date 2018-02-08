package com.myMobApp.Service;

import com.myMobApp.Dao.UserDao;
import com.myMobApp.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserService {

    @Autowired
    private UserDao userdao;

    public Collection<User> getAllUser(){
        return userdao.getAllUser();
    }

    public User getUserByID(int id){
        return  userdao.getUserByID(id);
    }
}
