package com.pmh.ex07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Ex07Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(Ex07Application.class, args);

//		Arrays.stream(applicationContext.getBeanDefinitionNames()).toList().forEach(System.out::println);

	}

}
