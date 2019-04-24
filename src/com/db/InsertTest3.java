package com.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertTest3 {

	public static void main(String[] args) {

		// EMP 테이블에 insert
		// dept30
		// comm , 0
		// sal 1000
		// hire-date 오늘날짜
		// manager 번호는 있는번호

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

			System.out.println("사원번호 입력");
			String empNo = sc.next();

			System.out.println("사원명 입력");
			String eName = sc.next();
			
			System.out.println("직종명 입력");
			String job = sc.next();
			
			System.out.println("매니저번호 입력");
			String mgr = sc.next();

		

			String sql = "insert into emp values(" + empNo + ", '" + eName + "', '"	+ job + "', " + mgr + ", sysdate, 1000, 0, 30)";

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
