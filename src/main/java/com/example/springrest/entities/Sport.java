package com.example.springrest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
    *    mappedby ---> look for sport in Sport Class (Entity)  mapping is done in that class
    *    Cascade = CascadeType.All   ---> which means if sport is deleted than associated student will also get deleted
    * */
    //@OneToOne(mappedBy = "sport", cascade = CascadeType.ALL)   \
    // private Student student;
}
