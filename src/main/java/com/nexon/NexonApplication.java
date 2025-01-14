package com.nexon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NexonApplication {

	public static void main(String[] args) {
        int x=10;
		int y=20;
		SpringApplication.run(NexonApplication.class, args);
		System.out.println("Project is running ........");
	}

}
