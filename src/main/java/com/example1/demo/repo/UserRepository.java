package com.example1.demo.repo;

import com.example1.demo.dao.UserDao;
import com.example1.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository
{
    @Autowired UserDao userDao;

    public User saveUser(User user){
        return userDao.saveUser(user);
    }
    public User findUserByName(String username){
        return userDao.findByName(username);
    }
    public User findUserByEmail(String findUserByEmail){
        return userDao.findByEmail(findUserByEmail);
    }
}
