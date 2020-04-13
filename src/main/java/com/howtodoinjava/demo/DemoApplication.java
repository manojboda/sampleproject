package com.howtodoinjava.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Configuration;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Configuration 
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
}
