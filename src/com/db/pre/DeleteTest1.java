package com.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteTest1 {

	public static void main(String[] args) {

		// 부서번호를 입력 받아서
		// dept 테이블에서 삭제

		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		Scanner sc = new Scanner(System.in);

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			String sql = "delete emp where deptno=?";

			st = con.prepareStatement(sql);

			System.out.println("부서번호 입력");
			int deptNo = sc.nextInt();

			st.setInt(1, deptNo);

			result = st.executeUpdate();
			
//			if(result != 0) {
//				
//				con.commit();
//				
//			} else {
//				
//				con.rollback();
//			}

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
