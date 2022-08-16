package com.example.springrest.service;

import com.example.springrest.entities.User;
import com.example.springrest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserDAOService {

    @Autowired
    UserRepository userRepository;

    public long addUser(User user){
        //entityManager.persist(user);
        return userRepository.insertUser(user);
    }

    public User getUser(long uid)
    {
        return userRepository.getUser(uid);
    }

    public List<User> getUsers()
    {
        return userRepository.getUsers();
    }
}
