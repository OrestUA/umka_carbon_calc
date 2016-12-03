package com.umka.carbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan("com.umka.carbon")
@Configuration
public class CarboncalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarboncalcApplication.class, args);
	}
}
