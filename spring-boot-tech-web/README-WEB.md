# My Spring Web Application

This Application is created using the spring-boot-starter-web as an dependency instead of using the spring-boot-starter

#Automatic Property Expansion Using Maven

You can automatically expand properties from the Maven project by using resource filtering. If you use the spring-boot-starter-parent, you can then refer to your Maven 'project properties' with @..@ placeholders, as shown in the following example:

YAML

	app:
	  encoding: "@project.build.sourceEncoding@"
	  java:
	    version: "@java.version@"

Only production configuration is filtered that way (in other words, no filtering is applied on src/test/resources).
If you enable the addResources flag, the spring-boot:run goal can add src/main/resources directly to the classpath (for hot reloading purposes). Doing so circumvents the resource filtering and this feature. Instead, you can use the exec:java goal or customize the plugin's configuration. See the plugin usage page for more details.
If you do not use the starter parent, you need to include the following element inside the <build/> element of your pom.xml:

	<resources>
	    <resource>
	        <directory>src/main/resources</directory>
	        <filtering>true</filtering>
	    </resource>
	</resources>

You also need to include the following element inside <plugins/>:

	<plugin>
	    <groupId>org.apache.maven.plugins</groupId>
	    <artifactId>maven-resources-plugin</artifactId>
	    <version>2.7</version>
	    <configuration>
	        <delimiters>
	            <delimiter>@</delimiter>
	        </delimiters>
	        <useDefaultDelimiters>false</useDefaultDelimiters>
	    </configuration>
	</plugin>

The useDefaultDelimiters property is important if you use standard Spring placeholders (such as ${placeholder}) in your configuration. If that property is not set to false, these may be expanded by the build.

- - - -
Read application file from external jar (e.g.-application-logger-local.xml from spring-boot-tech-logging)
Include below line in application.yml which i present in web module
	
	spring:
	  profiles:
	    include:
	    - logger-${spring.profiles.active}

This will load the application-logger-local.yml in application.yml, where, VM argument to provide active profile:

	-Dspring.profiles.active=local

- - - -
Default error mapping handling:
Change the default error mapping path from /error to /app/error in application.yml
  
	error:
    	path: /app/error

Created AppErrorController which implements ErrorController to handle error response

- - - -
