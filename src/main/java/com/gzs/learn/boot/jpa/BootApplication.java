package com.gzs.learn.boot.jpa;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> add jpa example
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

<<<<<<< HEAD
import com.gzs.learn.boot.jpa.repository.TestHbRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class BootApplication {
	@Autowired
	private TestHbRepository repository;

=======
@SpringBootApplication
@EnableAutoConfiguration
public class BootApplication {
>>>>>>> add jpa example
	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);

	}
}
