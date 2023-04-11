package edu.fa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fa.dao.StudentJdbcDao;

public class StudentManagement {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		StudentJdbcDao dao = context.getBean("studentJdbcDao", StudentJdbcDao.class);
		System.out.println("Hello");
	}
}
