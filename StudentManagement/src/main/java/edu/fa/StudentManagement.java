package edu.fa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fa.dao.StudentJdbcDao;
import edu.fa.model.Student;

public class StudentManagement {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		StudentJdbcDao dao = context.getBean("studentJdbcDao", StudentJdbcDao.class);
		dao.insertStudent(new Student(4, "Clover 1", "Viet Nam"));
		System.out.println(dao.getAllStudents());
	}
}
