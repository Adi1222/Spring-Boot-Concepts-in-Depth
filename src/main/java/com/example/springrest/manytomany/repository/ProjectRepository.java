package com.example.springrest.manytomany.repository;

import com.example.springrest.manytomany.entities.Employee;
import com.example.springrest.manytomany.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {


    @Query(value = "SELECT new com.example.springrest.manytomany.entities.Employee(e.id, e.ename) FROM Employee e join e.projects p WHERE p.pid = :pid")
    public List<Employee> findEmployeesOfproject(@Param("pid") int pid);

}
