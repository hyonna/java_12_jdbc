package com.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectTest2 {

	public static void main(String[] args) {
		
		

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Scanner sc = new Scanner(System.in);

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			String sql = "select deptno,dname,loc from dept where deptno=?";

			st = con.prepareStatement(sql);
			
			System.out.println("부서번호 입력");
			int deptNo = sc.nextInt();
			
			st.setInt(1, deptNo);
			
			rs = st.executeQuery();
			
			if(rs.next()) {
				
				System.out.println("부서번호 : " + rs.getInt("deptno"));
				System.out.println("부서명 : " + rs.getString("dname"));
				System.out.println("지역명 : " + rs.getString("loc"));
			} else {
				
				System.out.println("없는 번호입니다.");
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
