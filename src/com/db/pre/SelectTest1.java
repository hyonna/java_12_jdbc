package com.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectTest1 {

	public static void main(String[] args) {
		
		//조회할 부서 번호를 입력 받기

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			String sql = "select * from dept";

			st = con.prepareStatement(sql);
			
			rs = st.executeQuery();
			
			while(rs.next()) {
				
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서명 : " + rs.getString("dname"));
				System.out.println("지역명 : " + rs.getString("loc"));
				
			}

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {

				rs.close();
				st.close();
				con.close();

			} catch (SQLException e) {

				e.printStackTrace();

			}

		}

//		if (result > 0) {
//
//			System.out.println("성공");
//
//		} else {
//
//			System.out.println("실패");
//		}

	}

}
