package com.callor.todolist.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OracleConnection {

	private static Connection dbConn;
	
	static {
		
		String jdbcDriver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String username = "tbuser"; 
		String password = "tbuser"; 
		
		try {
			Class.forName(jdbcDriver);
			if(dbConn == null) {
				
				dbConn = DriverManager.getConnection(url,username,password);
				
			}
			
			System.out.println("Oracle 접속 완료");
		} catch (ClassNotFoundException e) {
			System.out.println(" 접속 오류");
			System.out.println("jdbc Driver를 찾지 못함");
			
			
		} catch (SQLException e) {
			System.out.println("URL : " + url);
			System.out.println("username : " + username);
			System.out.println("password : " + password);
			
		}
		
		
	} // static end
	
	public static Connection getConnection() {
		
		return dbConn;
		
	}
	
}