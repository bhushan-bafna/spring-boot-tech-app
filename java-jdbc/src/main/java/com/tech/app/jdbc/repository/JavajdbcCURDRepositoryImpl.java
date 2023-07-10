package com.tech.app.jdbc.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.tech.app.jdbc.config.DBConfigUtil;
import com.tech.app.jdbc.dao.PersonDAO;

import lombok.extern.slf4j.Slf4j;

/**
 * Person repository to perform DB related operation
 * 
 * @author Bhushan Bafna
 */
@Repository
@Slf4j
public class JavajdbcCURDRepositoryImpl {

	/**
	 * Method to fetch person data from DB by id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public PersonDAO getData(String id) throws SQLException {
		PersonDAO personDao = new PersonDAO();
		String query = "SELECT * FROM PERSON where person_PERSON_id='" + id + "'";
		log.info(query);
		try (Connection conn = DBConfigUtil.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(query);) {
//			rs.next();
			if (rs.first()) {
				personDao.setInstanz(rs.getLong("person_instanz"));
//				personDao.setFirstName(rs.getString("FIRST_NAME"));
//				personDao.setLastName(rs.getString("LAST_NAME"));
//				personDao.setId(rs.getString("PERSON_ID"));
				log.info("Person - {}", personDao.toString());
			}
		} catch (SQLException e) {
			log.error("Exception Strack Trace - {}", e);
			throw e;
		}
		return personDao;
	}

	public PersonDAO executeCRUDOperation(String id) throws SQLException {
		PersonDAO personDao = new PersonDAO();
		String query = "SELECT * FROM PERSON where person_PERSON_id='" + id + "'";
		log.info(query);
		try (Connection conn = DBConfigUtil.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(query);) {
//			rs.next();
			if (rs.first()) {
				personDao.setInstanz(rs.getLong("person_instanz"));
				log.info("Person - {}", personDao.toString());
			}

			// Additional operation that can be performed are as below.
			// Insert data
			String insertQuery = "INSERT INTO PERSON_EVENT (INSTANZ, INSTANZ_DATE, APPLICATION, PERSON_ID, EVENT_NAME, STARTED, FINISHED, STATE) \r\n"
					+ "values (1, sysdate, 'NSI', 'p100001', 'NSI', sysdate, sysdate, 0)";
			int rowsInserted = stmt.executeUpdate(insertQuery);
			System.out.println("Rows inserted: " + rowsInserted);

			// Update data
			String updateQuery = "UPDATE PERSON_EVENT SET PERSON_ID = 'p110011' WHERE INSTANZ = 1";
			int rowsUpdated = stmt.executeUpdate(updateQuery);
			System.out.println("Rows updated: " + rowsUpdated);

			// Delete data
			String deleteQuery = "DELETE FROM PERSON_EVENT WHERE INSTANZ = 2";
			int rowsDeleted = stmt.executeUpdate(deleteQuery);
			System.out.println("Rows deleted: " + rowsDeleted);
		} catch (SQLException e) {
			log.error("Exception Strack Trace - {}", e);
			throw e;
		}
		return personDao;

	}

}
