package edu.fa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.fa.model.Student;

@Component("studentJdbcDao")
public class StudentJdbcDao {
	private String jdbcUrl = "jdbc:sqlserver://DESKTOP-HKVP723\\BAO:1433;databaseName=education;trustServerCertificate=true;";

//	jdbc Connection
	private Connection connection = null;
	private Statement statement = null;

	public void createConnection() {
		if (connection == null) {
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(jdbcUrl, "sa", "abcd1234");
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
