package com.myMobApp.Controller;

import com.myMobApp.Entity.User;
import com.myMobApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Collection;

/**
 * This Controller calls the Service
 **/

@RestController
@RequestMapping("/users")
public class UserContorller {

    @Autowired
    private UserService usersrervice;

    /** Here is where we can get the all User from DB **/
    @RequestMapping(method = RequestMethod.GET)
    public Collection<User> getAllUser(){
        return usersrervice.getAllUser();
    }

    /** Here is where we can get a User by ID **/
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable("id") int id){
        return usersrervice.getUserByID(id);
    }

    /** Here is where we can remove a User by ID from DB **/
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public void removeUserById(@PathVariable("id") int id){
        usersrervice.deleteUserByID(id);
    }

    /** Here is where we can update an User in the DB **/
    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updaterUserByID(@RequestBody User user){
        usersrervice.updateUser(user);
    }

    /** Here is where we can insert a User in to the DB **/
    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void inserterUserById(@RequestBody User user){
        usersrervice.insertUser(user);
    }

}
