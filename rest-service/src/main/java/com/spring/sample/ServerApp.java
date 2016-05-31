package com.spring.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication
public class ServerApp{
	public static void main(String[] args) {
		SpringApplication.run(ServerApp.class, args);
	}

	
}
