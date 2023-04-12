package edu.fa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
				connection = DriverManager.getConnection(jdbcUrl, "sa", "abcd1234");
				System.out.println("Kết nối thành công đến SQL Server 2019" + connection);
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
			statement.execute("insert into student values (" + student.getId() + ",'" + student.getName() + "','"
					+ student.getLocation() + "')");
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
