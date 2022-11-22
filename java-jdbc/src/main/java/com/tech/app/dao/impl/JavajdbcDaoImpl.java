package com.tech.app.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JavajdbcDaoImpl {

	final String DB_URL = "jdbc:oracle:thin:@sd1600021.gch.generali.ch:1521:GCHB2BD";
	final String USER = "XBPSEL1";
	final String PASS = "XBPSEL1";
	final String QUERY = "SELECT * FROM nutzer where NUTZ_NUTZER_ID='pt249387' or NUTZ_NUTZER_ID='pt249380'";

	public String getData() {
		StringBuilder sb = new StringBuilder();

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				ResultSet rs = stmt.executeQuery(QUERY);) {
//			rs.next();
			if (rs.first()) {
				sb.append("{ NUTZ_INSTANZ: " + rs.getLong("NUTZ_INSTANZ"));
				sb.append(", NUTZ_NAME: " + rs.getString("NUTZ_NAME"));
				sb.append(", NUTZ_VORNAME: " + rs.getString("NUTZ_VORNAME"));
				sb.append(", NUTZ_NUTZER_ID: " + rs.getString("NUTZ_NUTZER_ID") + " }");

				log.info(sb.toString());

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

}
