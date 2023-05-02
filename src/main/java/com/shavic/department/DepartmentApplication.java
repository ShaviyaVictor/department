package com.shavic.department;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//	@SpringBootApplication --> is then main annotation in a SpringBoot application
//		- the annotation contains the below bundled up annotations:
//			@SpringBootConfiguration --> which tells the application that this is the main SpringBoot application
//			@EnableAutoConfiguration --> which adds all the auto configurations of the applications but gives an allowance to exclude classes and annotations that you don't want to include automatically
//			@ComponentScan --> which scans all the components in our application and adds the scanned components to the created SpringBoot container when the app runs

@SpringBootApplication
public class DepartmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepartmentApplication.class, args);
	}

}
