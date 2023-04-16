package com.test;

import org.springframework.stereotype.Component;

@Component
public class EmployeeService {
	private  Employee employee;

	public EmployeeService(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return employee.getName() + " -" + employee.getAddress();
	}
}
