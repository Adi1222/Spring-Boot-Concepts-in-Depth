package com.example.springrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class SpringrestApplication {

	@RequestMapping("/")
	String Home()
	{
		return "Home";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringrestApplication.class, args);

	}

}
