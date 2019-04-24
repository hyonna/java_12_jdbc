package com.db.test;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.Test;

import com.db.util.DbConnector;

public class DBConnectorTest {

	//Annotation : 설명 + 실행 기능.
	@Test
	public void test() throws Exception {

		Connection con = DbConnector.getConnect();
		assertNotNull(con); //null 이 아니면 테스트 성공,
		
		//assertEquals(1, 리턴받은거);
		
	}

}
