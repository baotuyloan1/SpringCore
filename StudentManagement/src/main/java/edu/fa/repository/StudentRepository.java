package edu.fa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.fa.model.Student;

// vì sử dụng <jpa:repositories nên khoogn cần sử dụng annotation
public interface StudentRepository extends JpaRepository<Student, Integer> {
	Student findByNameAndLocation(String name, String location);

	List<Student> findByNameOrLocation(String name, String location);

	Student findFirstByOrderByNameDesc();

	List<Student> getAllByName(String name);
	
	@Query("select s from Student s where s.name = ?1")
	List<Student> getAllByNameUsingQuery(String name);
}
