package com.example.javastreams;

import java.util.Arrays;
import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args)
    {
        Customer customer = new Customer(1, "alex", null, Arrays.asList("9878987654", "9898765432"));

        //  This may return null pointer exception
        //Optional<String> email1 = Optional.of(customer.getEmail());
        //System.out.println(email1);

        // if value is empty, this returns an empty object
        Optional<String> email2 = Optional.ofNullable(customer.getEmail());
        System.out.println(email2);

        if (email2.isPresent()){
            System.out.println(email2.get());
        }

        System.out.println(email2.orElse("Not present"));

        System.out.println(email2.orElseThrow(() -> new IllegalArgumentException("Email not present")));


    }
}

