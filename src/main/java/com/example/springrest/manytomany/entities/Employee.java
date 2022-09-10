package com.example.springrest.manytomany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @GeneratedValue
    @Column(name = "eid")
    int id;

    private String ename;

    public Employee(int id, String ename) {
        this.id = id;
        this.ename = ename;
    }
    /*
     *   here, if I do not write @JoinColumn, Employee will create another table employee_project (and that is something we want)
     *   Also, we explicetly want that table's name as "empl_proj" , so @JoinTable(name = "empl_proj") will do the work
     */

    @ManyToMany
    @JoinTable(
            name = "empl_proj",
            joinColumns = {@JoinColumn(name = "emp_id")},  // name for the first column in the new table
            inverseJoinColumns = {@JoinColumn(name = "proj_id")} // name for the second column in the new table
    )
    private List<Project> projects;

}






