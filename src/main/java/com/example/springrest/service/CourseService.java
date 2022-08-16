package com.example.springrest.service;

import com.example.springrest.entities.Course;

import java.util.List;
import java.util.Map;

public interface CourseService {

    public List<Course> getCourses();

    public Course getCourse(long courseId);

    public Course addCourse(Course course);

    public Course update(Map<String, Object> updates, long id);

    public void deleteCourse(long courseId);

}
