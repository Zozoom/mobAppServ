package com.myMobApp.Dao;

import com.myMobApp.Entity.User;

import java.util.Collection;

/**
 * This DAO call the The Persistence Layer or DataBase
 **/

public interface UserDao {
    Collection<User> getAllUser();

    User getUserByID(int id);

    void deleteUserByID(int id);

    void updateUser(User user);

    void insertUser(User user);
}
