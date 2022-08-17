package com.example.springrest.onetomany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Employee {

    @Id
    @Column(name = "emp_id")
    int id;

    private String ename;

    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee emp;

}
