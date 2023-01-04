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
public class JavajdbcDaoImpl {

	final String DB_URL = "jdbc:oracle:thin:@sd1600021.gch.generali.ch:1521:GCHB2BD";
	final String USER = "XBPSEL1";
	final String PASS = "XBPSEL1";
	String query = "SELECT * FROM nutzer where NUTZ_NUTZER_ID='pt249387' or NUTZ_NUTZER_ID='id'";

	public PersonDAO getData(String id) {
		StringBuilder sb = new StringBuilder();
		PersonDAO person = new PersonDAO();
		String query = "SELECT * FROM nutzer where NUTZ_NUTZER_ID='pt249387' or NUTZ_NUTZER_ID='"+id+"'";
		log.info(query);
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(query);) {
//			rs.next();
			if (rs.first()) {
				person.setInstanz(rs.getLong("NUTZ_INSTANZ"));
				person.setFirstName(rs.getString("NUTZ_VORNAME"));
				person.setLastName(rs.getString("NUTZ_NAME"));
				person.setId(rs.getString("NUTZ_NUTZER_ID"));
				log.info("Person - {}", person.toString());
			}
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return person;
	}

}
