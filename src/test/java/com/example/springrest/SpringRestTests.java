package com.example.springrest;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SpringRestTests {

    Calculator cal = new Calculator();

    @Test
    void testMethod1()
    {
        System.out.println("I am running");

        // when
        int res = cal.add(10, 20);

        // Then
        int exp = 30;
        assertThat(res).isEqualTo(exp);


    }

    class Calculator
    {
        int add(int a, int b)
        {
            return a + b;
        }
    }

}
