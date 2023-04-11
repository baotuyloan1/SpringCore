package edu.fa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.fa.repository.StudentRepository;
import edu.fa.repository.StudentRepositoryImpl;
import edu.fa.service.StudentService;
import edu.fa.service.StudentServiceImpl;

@Configuration
public class ApplicationConfiguration {

	@Bean(name = "studentService")
	public StudentService zxczxcgetStudentService1() {
		
//		Cách 1 truyền vào setter
//		StudentServiceImpl studentRepository = new StudentServiceImpl();
//		studentRepository.setStudentRepository(zxczxcgetStudentRepository());
//		return studentRepository;
//		Cách 2 truyền vào constructor
//		return new StudentServiceImpl(zxczxcgetStudentRepository());
		
//		Cách 3 dùng autowired, đặt autowired trên setter của lớp đó hoặc member injection trên global variables hoặc trên constructor
//		nếu trên constructor thì return phải về constructor đó
		return new  StudentServiceImpl(zxczxcgetStudentRepository());
	}
	
	@Bean (name = "studentRepository")
	public StudentRepository zxczxcgetStudentRepository() {
		return new StudentRepositoryImpl();
	}
	
	
}
