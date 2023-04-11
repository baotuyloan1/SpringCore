package edu.fa.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import edu.fa.model.Student;

//giống name của bean trong xml trùng với ref của lớp gọi tới 
@Repository("")
public class StudentRepositoryImpl implements StudentRepository {
	public List<Student> getAllStudent() {
		List<Student> studentList = new ArrayList<>();
		studentList.add(new Student("BaoKey", "HaNoi"));
		return studentList;
	}
}
