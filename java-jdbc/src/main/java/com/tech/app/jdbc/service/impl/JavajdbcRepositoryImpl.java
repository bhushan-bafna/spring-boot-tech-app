package com.tech.app.jdbc.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.tech.app.jdbc.dao.PersonDAO;

import lombok.extern.slf4j.Slf4j;

/**
 * Person repository to perform DB related operation
 * 
 * @author Bhushan Bafna
 */
@Component
@Slf4j
public class JavajdbcRepositoryImpl {
	
	final String DB_URL = "jdbc:oracle:thin:@{IP-ADDRESS}:1521:{SID}";
	final String USER = "username";
	final String PASS = "passwrod";
	
	/**
	 * Method to fetch person data from DB by id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException 
	 */
	public PersonDAO getData(String id) throws SQLException {
		PersonDAO personDao = new PersonDAO();
		String query = "SELECT * FROM PERSON where PERSON_ID='" + id + "'";
		log.info(query);
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(query);) {
//			rs.next();
			if (rs.first()) {
				personDao.setInstanz(rs.getLong("INSTANCE"));
				personDao.setFirstName(rs.getString("FIRST_NAME"));
				personDao.setLastName(rs.getString("LAST_NAME"));
				personDao.setId(rs.getString("PERSON_ID"));
				log.info("Person - {}", personDao.toString());
			}
			
			//Additional operation that can be performed are as below.
			// Insert data
            String insertQuery = "INSERT INTO PERSON (name, age) VALUES ('John Doe', 30)";
            int rowsInserted = stmt.executeUpdate(insertQuery);
            System.out.println("Rows inserted: " + rowsInserted);

            // Update data
            String updateQuery = "UPDATE PERSON SET age = 31 WHERE id = 1";
            int rowsUpdated = stmt.executeUpdate(updateQuery);
            System.out.println("Rows updated: " + rowsUpdated);

            // Delete data
            String deleteQuery = "DELETE FROM PERSON WHERE id = 2";
            int rowsDeleted = stmt.executeUpdate(deleteQuery);
            System.out.println("Rows deleted: " + rowsDeleted);
		} catch (SQLException e) {
			log.error("Exception Strack Trace ", e);
			throw e;
		}
		return personDao;
	}
	
}
