package com.example.springrest;

import com.example.springrest.controller.SportsController;
import com.example.springrest.entities.Sport;
import com.example.springrest.entities.Student;
import com.example.springrest.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.Assert;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.doReturn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@ExtendWith(MockitoExtension.class)
public class SportsControllerTests {


    //private MockMvc mockMvc;


    @Mock
    private StudentRepository studentRepository;


    //@InjectMocks
    //private SportsController sportsController;

    Sport s1 = new Sport(1, "Tennis");
    Sport s2 = new Sport(2, "Badminton");
    Sport s3 = new Sport(2, "Swimming");

    Student RECORD_1 = new Student(101, "Aditya", "Pune", "Male", 22, s1);
    Student RECORD_2 = new Student(102, "Rohan", "Pune", "Male", 22, s2);


    @BeforeEach
    void setUp()
    {
        MockitoAnnotations.initMocks(this);
        //this.mockMvc = MockMvcBuilders.standaloneSetup(SportsController.class).build();

    }

    @Test
    public void test_getStudents() throws Exception
    {
        List<Student> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));
        Mockito.when(studentRepository.findAll()).thenReturn(records);

        List<Student> output = studentRepository.findAll();

        assertEquals(records, output);

        Mockito.verify(studentRepository).findAll();

    }

    @Disabled
    @Test
    public void getAllStudents_success() throws Exception
    {
        List<Student> records = new ArrayList<>(Arrays.asList(RECORD_1, RECORD_2));

        // Mockito.mock() method allows us to create a mock object of a class or an interface
        StudentRepository localStudentRepository = Mockito.mock(StudentRepository.class);

        //Mockito.when(studentRepository.findAll()).thenReturn(records);
        //doReturn(records).when(studentRepository).findAll();

        Mockito.when(localStudentRepository.findAll()).thenReturn(records);

        List<Student> output = localStudentRepository.findAll();

        assertEquals(records, output);

        System.out.println(output);

        //Mockito.verify(localStudentRepository).findAll();

        /*mockMvc.perform(MockMvcRequestBuilders.get("/students")
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(2)));*/
    }



}
