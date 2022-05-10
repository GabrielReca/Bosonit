package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Db1JpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(Db1JpaApplication.class, args);
	}

}
