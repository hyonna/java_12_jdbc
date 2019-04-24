package com.db.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbConnector {

	// Connection

	public static Connection getConnect() throws Exception {

		

		String user = "user01";
		String password = "user01";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Class.forName(driver);

		Connection con = DriverManager.getConnection(url, user, password);

		return con;

	}

	public static void disconnect(PreparedStatement st, Connection con) throws Exception {

		st.close();
		con.close();

	}
	
	
	public static void disconnect(ResultSet rs, PreparedStatement st, Connection con) throws Exception {
		
		
		rs.close();
		
		
		DbConnector.disconnect(st, con);
		
		
	}

}
