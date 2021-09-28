package com.example.demo.progmatic.backend.GetRandomMember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GetRandomApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetRandomApplication.class, args);
		System.out.println("Let's get the random members!");
	}

}
