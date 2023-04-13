package edu.fa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.fa.model.Student;

// vì sử dụng <jpa:repositories nên khoogn cần sử dụng annotation
public interface StudentRepository extends JpaRepository<Student, Integer> {

	
}
