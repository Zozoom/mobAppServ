package com.myMobApp.Dao;

import com.myMobApp.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeDataUserDaoImpl implements UserDao {

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
    @Override
    public Collection<User> getAllUser(){
        return  users.values();
    }

    /** Here is where we can get a User by ID **/
    @Override
    public User getUserByID(int id){
        return  users.get(id);
    }

    /** Here is where we can remove a User by ID from DB **/
    @Override
    public void deleteUserByID(int id) {
        users.remove(id);
    }

    /** Here is where we can update an User in the DB **/
    @Override
    public void updateUser(User user) {
        User u = users.get(user.getId());
        u.setUserName(user.getUserName());
        u.setFirstName(user.getFirstName());
        u.setLastName(user.getLastName());
        u.setEmailAddress(user.getEmailAddress());
        users.put(user.getId(), user);
    }

    /** Here is where we can insert a User in to the DB **/
    @Override
    public void insertUser(User user) {
        users.put(user.getId(),user);
    }
}
