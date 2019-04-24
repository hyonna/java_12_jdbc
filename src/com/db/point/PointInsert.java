package com.db.point;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PointInsert {

	public static void main(String[] args) {

		PointController pc = new PointController();
		try {
			
			pc.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}

	}

}
