package com.example.springrest.manytomany.controller;

import com.example.springrest.manytomany.entities.Employee;
import com.example.springrest.manytomany.entities.Project;
import com.example.springrest.manytomany.repository.EmployeeRepository;
import com.example.springrest.manytomany.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ProjectRepository projectRepository;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    @PostMapping(path = "/employee", consumes = "application/json")
    public Employee addEmployee(@RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    @PostMapping(path = "/project", consumes = "application/json")
    public Project addProject(@RequestBody Project project)
    {
        return projectRepository.save(project);
    }


    @GetMapping("/projects")
    public List<Project> getAllProjects()
    {
        return projectRepository.findAll();
    }

    @GetMapping("/project/{pid}")
    public List<Employee> getEmployeesOfProject(@PathVariable("pid") String pid)
    {
        //return new ArrayList<>();
        return projectRepository.findEmployeesOfproject(Integer.parseInt(pid));
    }


}
