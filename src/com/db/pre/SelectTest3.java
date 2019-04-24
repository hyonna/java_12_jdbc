package com.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectTest3 {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		// DEPT 에서 부서의 갯수는 총 몇개?
		// 부서번호가 제일 큰것과 제일 작은 것

		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			String sql = "select count(deptno), max(deptno), min(deptno) from dept";

			st = con.prepareStatement(sql);

			rs = st.executeQuery();

			rs.next();

			System.out.println("부서의 갯수 : " + rs.getInt(1)); //인덱스번호로 입력해도 됨
			System.out.println("가장 큰 부서번호 : " + rs.getInt(2));
			System.out.println("가장 작은 부서번호 : " + rs.getInt(3));

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

	}

}
