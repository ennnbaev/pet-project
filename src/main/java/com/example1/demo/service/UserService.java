package com.example1.demo.service;

import com.example1.demo.domain.Role;
import com.example1.demo.domain.User;
import com.example1.demo.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Service
public class UserService
{
    @Autowired UserRepository userRepository;

    @Transactional
    public User saveUser(User user){
        user.setRoles(Collections.singleton(Role.USER));
        user.setActive(true);
        return userRepository.saveUser(user);
    }

    @Transactional
    public User findUserByName(String username){
        return userRepository.findUserByName(username);
    }

    @Transactional
    public User findUserByEmail(String email){
        return userRepository.findUserByEmail(email);
    }

}
