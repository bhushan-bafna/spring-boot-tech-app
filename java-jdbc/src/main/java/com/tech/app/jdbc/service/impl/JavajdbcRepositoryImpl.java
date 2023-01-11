package com.tech.app.jdbc.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import com.tech.app.jdbc.dao.PersonDAO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JavajdbcRepositoryImpl {
	
	final String DB_URL = "jdbc:oracle:thin:@{IP-ADDRESS}:1521:{SID}";
	final String USER = "username";
	final String PASS = "passwrod";
	
	public PersonDAO getData(String id) {
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
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return personDao;
	}
	
}
