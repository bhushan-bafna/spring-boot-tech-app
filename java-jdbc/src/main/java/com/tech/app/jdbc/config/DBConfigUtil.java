package com.tech.app.jdbc.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.extern.slf4j.Slf4j;

/**
 * This is the configuration class to get DB connection
 * 
 * @author Bhushan
 */
@Slf4j
public class DBConfigUtil {

	/*
	For Oracle:
		DB_URL = "jdbc:oracle:thin:@localhost:1521:XE";
		USER = "C##springtechappdb";
		PASS = "C##springtechappdb";
	For MySQL:
		DB_URL = "jdbc:mysql://localhost:3306/sakila";
	 */
	final static String DB_URL = "jdbc:mysql://localhost:3306/sakila";
	final static String USER = "root";
	final static String PASS = "root";
	
	public static Connection getConnection() throws SQLException {
		
		try {
			Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
			return connection;
		} catch (SQLException e) {
			log.error("Exception Strack Trace - {}", e.getMessage());
			throw e;
		}
	}

}
