package com.example.demoST;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.example.demoST")
@SpringBootApplication
public class AssessmentApplication {
	public static void main(String[] args) {

		SpringApplication.run(AssessmentApplication.class, args);
	}

}
