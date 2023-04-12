package edu.fa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fa.dao.StudentJdbcDao;
import edu.fa.dao.StudentJdbcTemplateDao;
import edu.fa.model.Student;

public class StudentManagement {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		StudentJdbcTemplateDao dao = context.getBean("studentJdbcTemplateDao", StudentJdbcTemplateDao.class);
		dao.deleteStudent();
		dao.insertStudent(new Student(1, "Clover", "Viet Nam"));
		System.out.println(dao.getAllStudents());
		System.out.println(dao.countStudents());
		System.out.println(dao.nameStudents());
		System.out.println(dao.getStudentById(1));
	}
}
