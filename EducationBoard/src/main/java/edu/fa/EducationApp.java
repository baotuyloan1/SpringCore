package edu.fa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import edu.fa.config.ApplicationConfiguration;
import edu.fa.service.StudentService;

public class EducationApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
		StudentService studentService =  context.getBean("studentService", StudentService.class);
		System.out.println(studentService.getALlStudent().size());
	}

}
