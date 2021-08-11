package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class App {

	public static void main(String[] args) {
		try {
			SpringApplication.run(App.class, args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
