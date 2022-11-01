package com.tech.app;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * My Web Application Main class to initialize the application 
 * 
 * @author p249387
 *
 */
@SpringBootApplication
public class MyWebApplication {
	
	static Logger logger = LoggerFactory.getLogger(MyWebApplication.class);

    /**
     * This method is main method to Bootstrap Spring Application
     * 
     * @param args
     */
    public static void main(String[] args) {
    	logger.info("init MyWebApplication");
        SpringApplication.run(MyWebApplication.class, args);

    }

    /**
     * This method is to inspect the beans provided by Spring Boot application
     * on initialization
     * 
     * @param ctx
     *            ApplicationContext object
     * @return
     */
    @SuppressWarnings("unused")
	@Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
        return args -> {
            logger.info("Let's inspect the beans provided by Spring Boot :");
            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames) {
                logger.debug(beanName);
            }

        };
    }

}
