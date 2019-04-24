package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest2 {

	public static void main(String[] args) {

		// 부서번호, 부서명, 지역명을 입력 받아서
		// dept 테이블에 insert

		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE"; // SID
		String driver = "oracle.jdbc.driver.OracleDriver";
		Scanner sc = new Scanner(System.in);

		Connection con = null;
		Statement st = null;
		int result = 0;

		try {

			Class.forName(driver);
			System.out.println("드라이버 로딩 성공");

			con = DriverManager.getConnection(url, user, password);
			System.out.println("연결 성공");

			System.out.println("부서번호 입력");
			String deptno = sc.next();

			System.out.println("부서명 입력");
			String dName = sc.next();

			System.out.println("지역명 입력");
			String local = sc.next();

			String sql = "insert into dept values(" + deptno + ",'" + dName + "','" + local + "')";

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
