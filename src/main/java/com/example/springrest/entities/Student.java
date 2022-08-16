package com.example.springrest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {

    @Id
    @Column(name="stud_id")
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private String gender;
    private int age;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sport_played")
    private Sport sport;

}
