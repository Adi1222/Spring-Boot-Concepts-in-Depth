package com.example.springrest.dto;

import com.example.springrest.entities.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentPojo {

    private Student student;

}
