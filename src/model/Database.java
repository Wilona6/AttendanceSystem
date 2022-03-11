package model;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;
public class Database {
	
	public static Connection getConnection() {
		 String driverName="com.mysql.jdbc.Driver" ;
		 String Name="root";
		 String Pwd="000610";
		 String url="jdbc:mysql://localhost:3306/kaoqin?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&characterEncoding=UTF-8";
		try {
		Class.forName(driverName);
	}
	catch(Exception e) {
		e.printStackTrace();
	}
		try {
			Connection conn=DriverManager.getConnection(url,Name,Pwd);
			conn.setAutoCommit(false);
			return conn;
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
	return null;
	}
	
}
