package com.db.point;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.db.util.DbConnector;

public class PointDAO {
	
	
//	public int delete() throws Exception {
//		
//		
//		
//		return result;
//		
//	}
//	
	

	public int insert(PointDTO pointDTO) throws Exception {

		Connection con = DbConnector.getConnect();

		int result = 0;

		Scanner sc = new Scanner(System.in);

		String sql = "insert into point values(?, ?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);


		st.setInt(1, pointDTO.getNum());
		st.setString(2, pointDTO.getSid());
		st.setInt(3, pointDTO.getKor());
		st.setInt(4, pointDTO.getEng());
		st.setInt(5, pointDTO.getMath());
		st.setInt(6, pointDTO.getTotal());
		st.setDouble(7, pointDTO.getAvg());
		st.setInt(8, pointDTO.getBnum());

		result = st.executeUpdate();
		DbConnector.disconnect(st, con);

		return result;

	}

}
