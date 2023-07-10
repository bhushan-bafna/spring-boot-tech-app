package com.tech.app.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Component;

import com.tech.app.jdbc.config.DBConfigUtil;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JDBCTransactionExample {
	public String showTxExample() throws SQLException {
		Connection connection = null;
		try {
			connection = DBConfigUtil.getConnection();
			connection.setAutoCommit(false); // Disable auto-commit

			// Perform multiple database operations within a transaction
			insertEmployee(connection, "John Doe", 30);
			updateEmployeeAge(connection, "John Doe", 31);

			// Commit the transaction if all operations succeed
			connection.commit();
			log.info("Transaction committed successfully!");
			return "Transaction committed successfully!";
		} catch (SQLException e) {
			e.printStackTrace();
			rollbackTransaction(connection);
			return "Exception Occured!";
		} finally {
			closeConnection(connection);
		}
	}

	private static void insertEmployee(Connection connection, String name, int age) throws SQLException {
		String insertQuery = "INSERT INTO PERSON (name, age) VALUES (?, ?)";
		try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setString(1, name);
			statement.setInt(2, age);
			statement.executeUpdate();
			log.info("Employee inserted successfully!");
		}
	}

	private static void updateEmployeeAge(Connection connection, String name, int newAge) throws SQLException {
		String updateQuery = "UPDATE employees SET age = ? WHERE name = ?";
		try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
			statement.setInt(1, newAge);
			statement.setString(2, name);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				log.info("Employee age updated successfully!");
			} else {
				throw new SQLException("Employee not found!");
			}
		}
	}

	private static void rollbackTransaction(Connection connection) {
		if (connection != null) {
			try {
				connection.rollback();
				log.info("Transaction rolled back!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private static void closeConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
				log.info("Connection Closed!");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
