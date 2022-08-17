package com.example.springrest.manytomany.repository;

import com.example.springrest.manytomany.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
