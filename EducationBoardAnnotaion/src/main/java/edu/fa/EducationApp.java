package edu.fa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fa.service.StudentService;

public class EducationApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		StudentService studentService = context.getBean("studentServicez", StudentService.class);
		System.out.println(studentService.getAllStudent().size());
	}

}
