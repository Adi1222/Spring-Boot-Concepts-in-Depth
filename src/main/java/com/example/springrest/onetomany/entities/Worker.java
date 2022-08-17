package com.example.springrest.onetomany.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Worker {

    @Id
    @Column(name = "worker_id")
    int id;

    private String wname;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Worker worker;

}
