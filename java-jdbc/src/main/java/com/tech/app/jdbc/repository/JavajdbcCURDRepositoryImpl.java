package com.tech.app.jdbc.repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.tech.app.jdbc.config.DBConfigUtil;
import com.tech.app.jdbc.dao.ActorDAO;

import lombok.extern.slf4j.Slf4j;

/**
 * Actor repository to perform DB related operation
 * 
 * @author Bhushan Bafna
 */
@Repository
@Slf4j
public class JavajdbcCURDRepositoryImpl {

	/**
	 * Method to fetch data from DB by id
	 * 
	 * @param id
	 * @return
	 * @throws SQLException
	 */
	public ActorDAO getDataByID(int id) throws SQLException {
		ActorDAO actorDao = new ActorDAO();
		String query = "SELECT * FROM ACTOR where actor_id=" + id;
		log.info(query);
		try (Connection conn = DBConfigUtil.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(query);) {
//			rs.next();
			if (rs.first()) {
				actorDao.setId(rs.getInt("actor_id"));
				actorDao.setFirstName(rs.getString("first_name"));
				actorDao.setLastName(rs.getString("last_name"));
				actorDao.setUpdateOn(rs.getString("last_update"));
				log.info("Actor - {}", actorDao.toString());
			}
		} catch (SQLException e) {
			log.error("Exception Strack Trace - {}", e);
			throw e;
		}
		return actorDao;
	}

	/**
	 * Method to fetch data from DB by first name
	 *
	 * @param firstName
	 * @return
	 * @throws SQLException
	 */
	public ActorDAO getDataByName(String firstName) throws SQLException {
		ActorDAO actorDao = new ActorDAO();
		String query = "SELECT * FROM ACTOR where first_name = '" + firstName +"'";
		log.info(query);
		try (Connection conn = DBConfigUtil.getConnection();
			 Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 ResultSet rs = stmt.executeQuery(query);) {
//			rs.next();
			if (rs.first()) {
				actorDao.setId(rs.getInt("actor_id"));
				actorDao.setFirstName(rs.getString("first_name"));
				actorDao.setLastName(rs.getString("last_name"));
				actorDao.setUpdateOn(rs.getString("last_update"));
				log.info("Data - {}", actorDao.toString());
			}
		} catch (SQLException e) {
			log.error("Exception Strack Trace - {}", e);
			throw e;
		}
		return actorDao;
	}

	public ActorDAO executeCRUDOperation(String id) throws SQLException {
		ActorDAO actorDao = new ActorDAO();
		String query = "SELECT * FROM ACTOR where ACTOR_ID=" + id;
		log.info(query);
		try (Connection conn = DBConfigUtil.getConnection();
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(query);) {
//			rs.next();
			if (rs.first()) {
				actorDao.setId(rs.getInt("actor_id"));
				log.info("Actor - {}", actorDao.toString());
			}

			// Additional operation that can be performed are as below.
			// Insert data
			String insertQuery = "insert into sakila.actor (first_name, last_name, last_update) values ('Sachin','Tendulkar',now());";
			int rowsInserted = stmt.executeUpdate(insertQuery);
			System.out.println("Rows inserted: " + rowsInserted);

			// Update data
			String updateQuery = "UPDATE actor SET first_name = 'Rohit', last_name='Sharma' WHERE actor_id = 200";
			int rowsUpdated = stmt.executeUpdate(updateQuery);
			System.out.println("Rows updated: " + rowsUpdated);

			// Delete data
			ActorDAO actorDAO = getDataByName("Sachin");
			String deleteQuery = "DELETE FROM actor WHERE actor_id = " + actorDAO.getId();
			int rowsDeleted = stmt.executeUpdate(deleteQuery);
			System.out.println("Rows deleted: " + rowsDeleted);
		} catch (SQLException e) {
			log.error("Exception Strack Trace - {}", e);
			throw e;
		}
		return actorDao;

	}

}
