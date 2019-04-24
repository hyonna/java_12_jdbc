package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsetTest1 {

	public static void main(String[] args) {

		// 1. DB연결 정보 준비

		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE"; // SID
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection con = null;
		Statement st = null;
		int result = 0;

		// 2. driver를 메모리에 로딩
		try {

			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");

			// 3. DB서비스에 접속해서 로그인해서 Connection 받기

			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결성공");

			// 4. Query(SQL)문 생성 , ; 생략

			String sql = "insert into dept values(11, 'OFFICE', 'BUSAN')";

			// 5. 전송

			st = con.createStatement();
			result = st.executeUpdate(sql);

		} catch (Exception e) {

			e.printStackTrace();

		} finally {
			
			try {
				
				st.close();
				con.close();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}

		if (result > 0) {

			System.out.println("성공");

		} else {

			System.out.println("실패");
		}

	}

}
