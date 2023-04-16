package com.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean
	public EmployeePostPrecessor employeePostPrecessor() {
		return new EmployeePostPrecessor();
	}

	@Bean
	public Employee employee() {
		Employee e = new Employee();
		e.setAge(20);
		return e;
	}

}
