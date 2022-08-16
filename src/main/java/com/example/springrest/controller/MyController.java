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
    private CourseService courseService;

    @Autowired
    private UserDAOService userDAOService;

    @GetMapping("/home")
    public String Home()
    {
        return "Home";
    }

    @GetMapping("/courses")
    public List<Course> getCourses()
    {
        return this.courseService.getCourses();
    }

    //@GetMapping("/courses/{courseId}")
    @RequestMapping(path = "/courses/{courses}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable String courseId)
    {
        return this.courseService.getCourse(Long.parseLong(courseId));
    }

    @PostMapping(path="/courses", consumes="application/json")
    public Course addCourse(@RequestBody Course course)
    {
        return this.courseService.addCourse(course);
    }

    // Partial Update
    @PatchMapping(path = "/courses/{id}", consumes = "application/json")
    public Course partialUpdate(@RequestBody Map<String, Object> updates , @PathVariable String id)
    {
        System.out.println(updates);
        return this.courseService.update(updates, Long.parseLong(id));
    }

    @DeleteMapping("/courses/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable String courseId)
    {
        try
        {
            this.courseService.deleteCourse(Long.parseLong(courseId));
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<>(e.toString(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
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
