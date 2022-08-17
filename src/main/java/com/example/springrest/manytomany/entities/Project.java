package com.example.springrest.manytomany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Project {

    @Id
    private int pid;

    @Column(name = "proj_name")
    private String pname;

    @ManyToMany(mappedBy = "projects") // You (This class) do not create another table (Project_employee) This is taken care by Employee class (more specifically search projects attribute in Employee class)
    private List<Employee> employees;

}
