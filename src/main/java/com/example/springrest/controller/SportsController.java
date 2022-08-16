package com.example.springrest.controller;

import com.example.springrest.dto.StudentPojo;
import com.example.springrest.entities.Student;
import com.example.springrest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SportsController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping(value = "/students", consumes = "application/json")
    public Student addStudent(@RequestBody StudentPojo studentPojo)
    {
        return studentRepository.save(studentPojo.getStudent());
    }

    @DeleteMapping("/students/{studid}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String studid)
    {
        studentRepository.deleteById(Integer.parseInt(studid));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }
}
