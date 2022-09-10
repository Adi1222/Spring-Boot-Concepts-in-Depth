package com.example.springrest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sport {

    @Id
    private int sportid;
    private String sname;


    /*
    *   This is for having bi-directional mapping
    *    mappedby ---> look for sport in Student Class (Entity)  mapping is done in that class
    *    Cascade = CascadeType.All   ---> which means if sport is deleted than associated student will also get deleted
    * */
    //@OneToOne(mappedBy = "sport", cascade = CascadeType.ALL)   \
    // private Student student;
}
