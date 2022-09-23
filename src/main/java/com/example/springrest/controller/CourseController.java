package com.example.springrest.controller;

import com.example.springrest.entities.Course;
import com.example.springrest.entities.User;
import com.example.springrest.repository.ProductRepository;
import com.example.springrest.service.CourseService;
import com.example.springrest.service.UserDAOService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private ProductRepository productRepository;



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
}
