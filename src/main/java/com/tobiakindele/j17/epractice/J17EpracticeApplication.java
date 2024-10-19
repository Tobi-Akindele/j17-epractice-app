package com.tobiakindele.j17.epractice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class J17EpracticeApplication {

	public static void main(String[] args) {
		SpringApplication.run(J17EpracticeApplication.class, args);
	}
}
