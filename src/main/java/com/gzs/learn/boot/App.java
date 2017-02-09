package com.gzs.learn.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication()
@ImportResource(locations = { "/spring/spring-beans.xml" })
public class App {
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(App.class, args);
		for (String beanName : ctx.getBeanDefinitionNames()) {
			System.out.println("bean-->" + beanName);
		}
	}
}
