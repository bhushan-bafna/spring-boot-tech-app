package com.tech.app.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

@Component
public class JavajdbcDaoImpl {
	
	final String DB_URL = "jdbc:oracle:thin:@sd1600021.gch.generali.ch:1521:GCHB2BD";
	final String USER = "XBPSEL1";
	final String PASS = "XBPSEL1";
	final String QUERY = "SELECT * FROM nutzer where NUTZ_NUTZER_ID='pt249387'";

	public void getData() {
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stmt = conn.createStatement();
		         ResultSet rs = stmt.executeQuery(QUERY);
		      ) {		      
		         while(rs.next()){
		            //Display values
		            System.out.print("NUTZ_INSTANZ: " + rs.getLong("NUTZ_INSTANZ"));
		            System.out.print(", NUTZ_NAME: " + rs.getString("NUTZ_NAME"));
		            System.out.print(", NUTZ_VORNAME: " + rs.getString("NUTZ_VORNAME"));
		            System.out.println(", NUTZ_NUTZER_ID: " + rs.getString("NUTZ_NUTZER_ID"));
		         }
		      } catch (SQLException e) {
		         e.printStackTrace();
		      } 

	}

}
