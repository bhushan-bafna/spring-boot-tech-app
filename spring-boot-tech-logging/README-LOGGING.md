Logging Configuration reference site
	- https://reflectoring.io/springboot-logging/
	- https://www.baeldung.com/spring-boot-logging
	- https://docs.spring.io/spring-boot/docs/2.1.13.RELEASE/reference/html/boot-features-logging.html

- - - -
Spring Logging Configuration
	- https://www.codejava.net/frameworks/spring-boot/spring-boot-logging-basics
	
- - - -
Spring Boot Logger Configuration
	- https://docs.spring.io/spring-boot/docs/current/reference/html/features.html#features.logging.custom-log-configuration

- - - -

To read application file from external jar (e.g.-application-logger-local.xml from spring-boot-tech-logging in spring-boot-tech-web)
Include below line in application.yml which is present in web module
	
	spring:
	  profiles:
	    include:
	    - logger-${spring.profiles.active}
	    
- - - -

