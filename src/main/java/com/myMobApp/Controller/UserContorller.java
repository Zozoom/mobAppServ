package com.myMobApp.Controller;

import com.myMobApp.Entity.User;
import com.myMobApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserContorller {

    @Autowired
    private UserService usersrervice;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUser(){
        return usersrervice.getAllUser();
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id){
        return usersrervice.getUserByID(id);
    }
}
