package edu.fa.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import edu.fa.model.Student;

@Component("studentJdbcDaoSupportClass1")
public class StudentJdbcDaoSupport extends JdbcDaoSupport {

	public void insertStudent(Student student) {
		String query = "insert into student values (" + student.getId() + ",'" + student.getName() + "','"
				+ student.getLocation() + "')";
		this.getJdbcTemplate().execute(query);
	}

	public void deleteStudent() {
		String query = "delete from student";
		this.getJdbcTemplate().execute(query);

	}

	public int countStudents() {
		String query = "select count(*) from student";
		return this.getJdbcTemplate().queryForObject(query, Integer.class);

	}

	public String nameStudents() {
		String query = "select name from student";
		return this.getJdbcTemplate().queryForObject(query, String.class);

	}

	public Student getStudentById(int id) {
		String query = "Select * from student where id = ?";
		return this.getJdbcTemplate().queryForObject(query, new Object[] { id }, new StudentMapper());
	}

	public List<Student> getAllStudents() {
		String query = "select * from student";
		return this.getJdbcTemplate().query(query, new StudentMapper());
	}

	private static final class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("location"));
		}

	}
}
