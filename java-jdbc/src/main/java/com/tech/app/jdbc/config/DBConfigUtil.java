package com.tech.app.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

/**
 * This is the onfig class to get DB connection
 * 
 * @author Bhushan
 */
@Slf4j
public class DBConfigUtil {
	
	final static String DB_URL = "jdbc:oracle:thin:@{IP-ADDRESS}:1521:{SID}";
	final static String USER = "username";
	final static String PASS = "passwrod";
	
	public static Connection getConnection() throws SQLException {
		try {
			return DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (SQLException e) {
			log.info("Error Creating Connection :: {}", e.getMessage());
			throw e;
		}
	}

}
