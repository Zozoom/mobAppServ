package com.myMobApp.Dao;

import com.myMobApp.Entity.User;
import com.myMobApp.myLog;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Collection;

/**
 * This DAO call the The Persistence Layer or DataBase
 **/

@Repository
@Qualifier("mongoDb")
public class MongoUserDao implements UserDao{

    @Override
    public Collection<User> getAllUser() {
        return new ArrayList<User>(){
            {
                add(new User(1,"Mario","Mario","Prince","mario@mario.com"));
            }
        };
    }

    @Override
    public User getUserByID(int id) {
        return null;
    }

    @Override
    public void deleteUserByID(int id) {

    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void insertUser(User user) {

    }
}
