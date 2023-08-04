#spring-boot-tech-aop#

This project is for implementing the sample for AOP (Aspect Oriented Programming)

* Maven Denpendencies for AOP support and Aspect 

			<dependency>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-starter-aop</artifactId>
				<version>${spring-boot.version}</version>
			</dependency>

			<dependency>
				<groupId>org.aspectj</groupId>
				<artifactId>aspectjweaver</artifactId>
				<version>${aspectj.version}</version>
				<scope>runtime</scope>
			</dependency>

**Note:** aspectjweaver -  this dependency can be omitted since it is internally included into 

1. **Aspect** - An aspect is a modular unit that encapsulates a cross-cutting concern. A cross-cutting concern is a behavior or functionality that affects multiple parts of an application and cannot be easily decomposed into separate, independent modules using traditional object-oriented programming techniques. <code>@Aspect</code> - is used to declare that class is Aspect.
2. **JoinPoint** - A join point is a well-defined point in the execution flow of the program where the aspect can intercept and execute its cross-cutting behavior.
3. **PointCut** - A pointcut is an expression that defines the specific join points in the program's execution <code>@PointCut</code> is used to declare the expression for join point..
4. **Advice** - The advice represents the actual code that is executed when the aspect is applied at a specific join point. There are different types of advice as mentioned below:
	1. <code>@Around</code>	 - It allows the aspect to execute custom code before and after the method execution and even decide whether to proceed with the original method invocation or skip it entirely.
    2. <code>@Before</code>	 - It is a type of advice that can be used to intercept a method execution before the actual method invocation takes place. It allows an aspect to execute custom code or behavior just before the target method is called or executed.
    3. <code>@After</code>	- is a type of advice that can be used to intercept a method execution after the actual method invocation has completed. It allows an aspect to execute custom code or behavior just after the target method finishes its execution.
    4. <code>@AfterReturning</code> - is a type of advice that can be used to intercept a method execution after the actual method invocation has successfully completed and returned a result. It allows an aspect to execute custom code or behavior just after the target method has finished its execution and returned a value.
    5. <code>@AfterThrowing</code> - is a type of advice that can be used to intercept a method execution after the method has thrown an exception. It allows an aspect to execute custom code or behavior just after the target method finishes its execution due to an exception being thrown.
	 


