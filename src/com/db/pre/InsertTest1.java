package com.db.pre;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest1 {

	public static void main(String[] args) {
		
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;
		
		int deptno = 13;
		String dname = "HR";
		String loc = "Paris";
		
		//1. 로그인정보 4가지
		
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:XE";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		
		//2. 드라이버를 메모리에 로딩
		
		try {
			
			Class.forName(driver);
			
			//3. 로그인 후 Connection 객체 받아오기
			
			con = DriverManager.getConnection(url, user, password);
			
			//4. SQL문 작성
			
			String sql = "insert into dept values(?, ?, ?)";
			
			//5. 미리 전송
			
			st = con.prepareStatement(sql);
			
			//6. ? 값을 세팅
			
			//st.setXXX(?의 인덱스 번호, 해당하는 값);   // XXX -> 데이터 타입
			st.setInt(1, deptno);
			st.setString(2, dname);
			st.setString(3, loc);
			
			//7. 최종 전송 후 결과 처리
			
			result = st.executeUpdate();
			
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
