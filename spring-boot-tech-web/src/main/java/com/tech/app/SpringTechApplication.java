package com.tech.app;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import lombok.extern.slf4j.Slf4j;

/**
 * My Web Application Main class to initialize the application
 * 
 * @author Bhushan Bafna
 *
 */
@SpringBootApplication
@Slf4j
public class SpringTechApplication {
	
	/**
	 * This method is main method to Bootstrap Spring Application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("init MyWebApplication");
		SpringApplication.run(SpringTechApplication.class, args);
		
	}
	
	/**
	 * This method is to inspect the beans provided by Spring Boot application on
	 * initialization
	 * 
	 * @param ctx ApplicationContext object
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			
			String[] beanNames = ctx.getBeanDefinitionNames();
			log.info("Let's inspect the beans provided by Spring Boot, total beans found : {}", beanNames.length);
			Arrays.sort(beanNames);
			for (String beanName : beanNames) {
				log.debug(beanName);
			}
			
		};
	}
	
}
