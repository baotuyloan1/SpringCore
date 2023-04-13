package edu.fa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import edu.fa.dao.StudentHibernateDao;
import edu.fa.dao.StudentJdbcDao;
import edu.fa.dao.StudentJdbcDaoSupport;
import edu.fa.dao.StudentJdbcTemplateDao;
import edu.fa.model.Student;
import edu.fa.service.StudentService;

public class StudentManagement {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
//		StudentHibernateDao dao = context.getBean("studentHibernateDao", StudentHibernateDao.class);
//		dao.deleteStudent();
//		dao.insertStudent(new Student(1, "Clover", "Viet Nam"));
//		dao.insertStudent(new Student(2, "Clover 2", "Viet Nam 2"));
//		System.out.println(dao.getAllStudents());
//		System.out.println(dao.countStudents());
////		System.out.println(dao.nameStudents());
//		System.out.println(dao.getStudentById(1));

//		dao.save(new Student("BaoKey 3","Da Nang"));
		StudentService service = context.getBean("studentService", StudentService.class);
		service.save(new Student("Bao Nguyen 3", "Viet Nam"));
		service.saveUsingRepository(new Student(1, "Bao Nguyen 2", "Viet Nam 2"));
		service.test();
	}
}
