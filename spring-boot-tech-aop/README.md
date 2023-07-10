#spring-boot-tech-aop

This project is for implementing the sample for AOP (Aspect Oriented Programming)

Maven Denpendencies for AOP support and Aspect 

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

 -->> aspectjweaver -  this dependency can be omitted since it is internally included into 

Annotations to look at
@Aspect
@PointCut
@Around
@Before
@After

