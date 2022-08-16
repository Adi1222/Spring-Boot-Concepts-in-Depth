package com.example.springrest.dao;

import com.example.springrest.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

public interface CourseDao extends JpaRepository<Course, Long> {


}
