package com.test;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class EmployeePostPrecessor implements BeanPostProcessor {
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		if (bean instanceof Employee) {
			Employee employee = (Employee) bean;
			int age = employee.getAge();
			if (age < 18 || age > 65) {
				throw new IllegalArgumentException("Age must be between 18 and 65.");
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}
}
