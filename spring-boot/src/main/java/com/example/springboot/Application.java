package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@RestController
public class Application {

	@RequestMapping("/")
	public String home() throws UnknownHostException {
					return "Spring Boot Docker: " + InetAddress.getLocalHost().getHostAddress();
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
