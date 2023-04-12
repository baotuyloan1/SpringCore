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
import org.springframework.stereotype.Component;

import edu.fa.model.Student;

@Component
public class StudentJdbcTemplateDao {

	private Connection connection = null;
	private Statement statement = null;

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

	public void createConnection() {
		if (connection == null) {
			try {
//				connection = DriverManager.getConnection(jdbcUrl, "sa", "abcd1234");
				connection = dataSource.getConnection();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	public void shutdown() {
		try {
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			// TODO: handle exception
		}
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

	public List<Student> getAllStudents() {
		createConnection();
		List<Student> students = new ArrayList<>();

		try {
			statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select * from student");
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String location = rs.getString(3);
				students.add(new Student(id, name, location));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return students;
	}
}
