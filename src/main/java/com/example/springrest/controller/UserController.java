package com.example.springrest.controller;

import com.example.springrest.entities.User;
import com.example.springrest.service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAOService userDAOService;

    @PostMapping(path="/users",consumes="application/json")
    ResponseEntity<HttpStatus> addUser(@RequestBody User user)
    {
        long id = userDAOService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/user/{uid}")
    public User getUser(@PathVariable String uid)
    {
        return userDAOService.getUser(Long.parseLong(uid));
    }

    @GetMapping("/users")
    public List<User> getUsers()
    {
        return userDAOService.getUsers();
    }

}
