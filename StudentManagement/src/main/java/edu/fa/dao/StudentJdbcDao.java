package edu.fa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component()
public class StudentJdbcDao {
	private String jdbcUrl = "jdbc:sqlserver://DESKTOP-HKVP723\\BAO:1433;databaseName=education;trustServerCertificate=true;";

//	jdbc Connection
	private Connection connection = null;
	private Statement statement = null;

	public void createConnection() {
		if (connection == null) {
			try {
				Connection connection = DriverManager.getConnection(jdbcUrl, "sa", "abcd1234");
				System.out.println("Kết nối thành công đến SQL Server 2019");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	private void shutdown() {
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
}
