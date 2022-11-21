package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private final String serverName = "localhost";
	private final String dbName = "shoesdb";
	private final String portNumber = "3306";
	private final String userName = "root";
	private final String password = "khanh1307";
	
	public Connection getConnection() throws Exception{
		String url = "jdbc:mysql://" + serverName + ":" + portNumber + "/" + dbName;
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(url, userName, password);
	}
	
	//Test Connection
	
//	public static void main(String[] args) {
//		try {
//			System.out.println(new DBConnect().getConnection());
//		}
//		catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
}
