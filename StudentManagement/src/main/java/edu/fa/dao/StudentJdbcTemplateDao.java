package edu.fa.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import edu.fa.model.Student;

@Component
public class StudentJdbcTemplateDao {


	private DataSource dataSource;

	private JdbcTemplate jdbcTemplate;

	public DataSource getDataSource() {
		return dataSource;
	}

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}


	public void insertStudent(Student student) {
		String query = "insert into student values (" + student.getId() + ",'" + student.getName() + "','"
				+ student.getLocation() + "')";
		jdbcTemplate.execute(query);
	}

	public void deleteStudent() {
		String query = "delete from student";
		jdbcTemplate.execute(query);

	}

	public int countStudents() {
		String query = "select count(*) from student";
		return jdbcTemplate.queryForObject(query, Integer.class);

	}

	public String nameStudents() {
		String query = "select name from student";
		return jdbcTemplate.queryForObject(query, String.class);

	}

	public Student getStudentById(int id) {
		String query = "Select * from student where id = ?";
		return jdbcTemplate.queryForObject(query, new Object[] { id }, new StudentMapper());
	}

	public List<Student> getAllStudents() {
		String query = "select * from student";
		return jdbcTemplate.query(query, new StudentMapper());
	}

	private static final class StudentMapper implements RowMapper<Student> {

		@Override
		public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new Student(rs.getInt("id"), rs.getString("name"), rs.getString("location"));
		}

	}
}
