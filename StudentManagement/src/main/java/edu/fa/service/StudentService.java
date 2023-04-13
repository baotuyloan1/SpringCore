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
}
