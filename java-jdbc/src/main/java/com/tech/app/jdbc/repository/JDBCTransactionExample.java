package com.tech.app.jdbc.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import com.tech.app.jdbc.config.DBConfigUtil;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class JDBCTransactionExample {
	public String executeTxExample() throws SQLException {
		Connection connection = null;
		try {
			connection = DBConfigUtil.getConnection();
			connection.setAutoCommit(false); // Disable auto-commit

			// Perform multiple database operations within a transaction
			insertEmployee(connection);
			updateEmployeeAge(connection);

			// Commit the transaction if all operations succeed
			connection.commit();
			log.info("Transaction committed successfully!");
			return "Transaction committed successfully!";
		} catch (SQLException e) {
			log.error("Exception Strack Trace - {}", e.getMessage());
			rollbackTransaction(connection);
			throw e;
		} finally {
			closeConnection(connection);
		}
	}

	private static void insertEmployee(Connection connection) throws SQLException {
		String insertQuery = "INSERT INTO PERSON_EVENT (PER_INSTANZ, PER_INSTANZIERUNG, PER_APPLICATION, PER_NPERSON_ID, PER_EVENT_NAME, PER_STARTED, PER_FINISHED, PER_STATE)"
				+ "values (?, sysdate, 'NSI', 'p100001', 'NSI', sysdate, sysdate, 0)";
		try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
			statement.setInt(1, 2);
			statement.executeUpdate();
			log.info("Employee inserted successfully!");
		}
//		log.info("Explicit Exception Thrown!");
//		throw new SQLException("Explicit Exception Thrown!");
	}

	private static void updateEmployeeAge(Connection connection) throws SQLException {
		String updateQuery = "UPDATE PERSON_EVENT SET PER_NPERSON_ID = ? WHERE PER_INSTANZ = ?";
		try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
			statement.setString(1, "p110011");
			statement.setInt(2, 2);
			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				log.info("Employee id updated successfully!");
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

	private static void closeConnection(Connection connection) throws SQLException {
		if (connection != null) {
			try {
				connection.close();
				log.info("Connection Closed!");
			} catch (SQLException e) {
				log.error("Exception Strack Trace - {}", e.getMessage());
				throw e;
			}
		}
	}
}
