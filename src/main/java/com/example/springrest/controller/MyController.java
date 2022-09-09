package com.example.springrest.controller;

import com.example.springrest.entities.Course;
import com.example.springrest.entities.User;
import com.example.springrest.service.CourseService;
import com.example.springrest.service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MyController {


    @Autowired
    private UserDAOService userDAOService;

    @GetMapping("/home")
    public String Home()
    {
        return "Home";
    }


    @GetMapping("/hello")
    ResponseEntity<String> hello()
    {
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    // Request Param Example
    @GetMapping("api/foos")
    public String getFoos(@RequestParam String id)
    {
        return "Id: " + id;
    }

    @GetMapping("api/requestparam")
    @ResponseBody
    public String getParamid(@RequestParam(name="id") String paramid, @RequestParam(required = false) String name)
    {
        return "Id: " +  paramid + "Name: " + name;
    }

    @GetMapping("api/maprequestparam")
    @ResponseBody
    public String getParams(@RequestParam Map<String, String> allParams)
    {
        return "Paramaters are :" + allParams.entrySet();
    }

    @GetMapping("/age")
    ResponseEntity<String> getAge(@RequestParam(name="yearOfBirth") int yr)
    {
        if (yr != 2000){
            return new ResponseEntity<>("Not fit for the role", HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>("Your age is 22", HttpStatus.OK);
    }

    @PostMapping(path="/users",consumes="application/json")
    ResponseEntity<HttpStatus> addUser(@RequestBody User user)
    {
        long id = userDAOService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/users/{uid}")
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
