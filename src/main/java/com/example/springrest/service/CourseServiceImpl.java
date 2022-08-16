package com.example.springrest.service;

import com.example.springrest.entities.Course;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CourseServiceImpl implements CourseService{

    List<Course> list;


    public CourseServiceImpl()
    {
        this.list = new ArrayList<>();

        list.add(new Course(1, "Java", "Learn Java"));
        list.add(new Course(2, "Spring Boot", "Learn Spring Boot"));
    }

    @Override
    public List<Course> getCourses() {

        return list;
    }
    
    @Override
    public Course getCourse(long cId)
    {
        Course course = null;

        for(Course  c : list)
        {
            if (c.getId() == cId){
                course = c;
                break;
            }
        }
        
        return course;
    }


    @Override
    public Course addCourse(Course course)
    {
        this.list.add(course);
        return course;
    }


    @Override
    public Course update(Map<String, Object> updates, long id)
    {
        Course course = null;

        for(Course  c : list)
        {
            if (c.getId() == id){
                course = c;
                break;
            }
        }

        Course finalCourse = course;
        updates.forEach((key, value) -> {

            if (key.equals("name")) {
                finalCourse.setName((String) value);
            }
        });

        return finalCourse;
    }

    @Override
    public void deleteCourse(long courseId)
    {
        return;
    }

}
