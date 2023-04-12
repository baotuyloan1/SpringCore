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
import org.springframework.stereotype.Component;

import edu.fa.model.Student;

@Component()
public class StudentJdbcTemplateDao {

	private Connection connection = null;
	private Statement statement = null;

	@Autowired
	private DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void createConnection() {
		if (connection == null) {
			try {
//				connection = DriverManager.getConnection(jdbcUrl, "sa", "abcd1234");
				connection = dataSource.getConnection();
				System.out.println("AAA");
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
		createConnection();
		try {
			statement = connection.createStatement();
			if (statement != null) {
				statement.execute("insert into student values (" + student.getId() + ",'" + student.getName() + "','"
						+ student.getLocation() + "')");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
