package edu.fa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.fa.model.Student;
import edu.fa.repository.StudentRepository;
import edu.fa.repository.StudentRepositoryImpl;

public class StudentServiceImpl implements StudentService {

	private StudentRepository studentRepository;
	private Student student;

	public StudentServiceImpl() {
		System.out.println("Constructor default injection");
	}

	public Student getStudent() {
		return student;
	}

	public void setStudentzxczxc(Student student) {
		this.student = student;
		System.out.println("Student Setter Injection");
	}

	public void setStudentRepository(StudentRepository studentRepository) {
		System.out.println("Setter Injection Java Base");
		this.studentRepository = studentRepository;
	}

	@Autowired
	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		System.out.println("Constructor injection");
		this.studentRepository = studentRepository;
	}

	public StudentServiceImpl(StudentRepository studentRepositoryParameter, Student student) {
		super();
		System.out.println("Constructor Injection");
		System.out.println(student);
		this.studentRepository = studentRepositoryParameter;
	}

	public StudentRepository getStudentRepository() {
		return studentRepository;
	}

	public void setStudentRepositorys(StudentRepository studentRepository) {
		System.out.println("Setter Injection");
		this.studentRepository = studentRepository;
	}

	@Override
	public List<Student> getALlStudent() {
		return studentRepository.getAllStudent();
	}
}
