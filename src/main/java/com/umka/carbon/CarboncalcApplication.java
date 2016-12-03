package com.umka.carbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScan("com.umka.carbon")
@Configuration
@PropertySource(value = { "classpath:application.properties"})
public class CarboncalcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarboncalcApplication.class, args);
	}
}
