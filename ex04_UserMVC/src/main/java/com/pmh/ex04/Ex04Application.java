package com.pmh.ex04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Ex04Application {

	public static void main(String[] args) {

		ApplicationContext applicationContext = SpringApplication.run(Ex04Application.class, args);

//		Arrays.stream(applicationContext.getBeanDefinitionNames()).toList().forEach(System.out::println);

	}

}
