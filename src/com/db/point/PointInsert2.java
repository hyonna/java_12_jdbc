package com.db.point;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.db.util.DbConnector;

public class PointInsert2 {

	public static void main(String[] args) {

		try {

			Connection c = DbConnector.getConnect();

		} catch (Exception e) {

			e.printStackTrace();

		}

		String sql = "";

	}

}
