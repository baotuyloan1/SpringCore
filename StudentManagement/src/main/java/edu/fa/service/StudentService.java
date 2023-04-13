package edu.fa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fa.dao.StudentHibernateDao;
import edu.fa.model.Student;
import edu.fa.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentHibernateDao studentHibernateDao;

	@Autowired
	private StudentRepository studentRepository;

	public void save(Student student) {
		studentHibernateDao.save(student);
	}

	public void saveUsingRepository(Student student) {
		studentRepository.save(student);
	}

	public void test() {
		System.out.println(studentRepository.count());
		System.out.println(studentRepository.findAll());
		System.out.println(studentRepository.findByNameAndLocation("Bao Nguyen 2", "Viet Nam 2"));
		System.out.println(studentRepository.findByNameOrLocation("Bao Nguyen", "Viet Nam 2"));
		System.out.println(studentRepository.findFirstByOrderByNameDesc());
		System.out.println(studentRepository.getAllByName("Bao Nguyen"));
	}

}
