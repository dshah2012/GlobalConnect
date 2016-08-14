package com.ge.tps.util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MySql_DB_Connect {
	public static  Connection getConnection() throws ClassNotFoundException, SQLException	{
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://127.0.0.1:3306/tps_test";
		String user = "root";
		String password = "mysql";
		Connection con = DriverManager.getConnection(url, user, password);
//		System.out.println(con);
		return con;
	}
	public static void main(String [] args) throws ClassNotFoundException, SQLException
	{
		Connection con = getConnection();
		System.out.println(con);
	}
}
