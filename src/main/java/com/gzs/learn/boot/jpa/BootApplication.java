package com.gzs.learn.boot.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gzs.learn.boot.jpa.repository.TestHbRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class BootApplication {
	@Autowired
	private TestHbRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);

	}
}
