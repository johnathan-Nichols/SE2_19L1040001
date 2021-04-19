package connect;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static String DB_URL = "jdbc:mysql://localhost:3306/se201_project?useSSL=false";
    private static String USER_NAME = "root";
    private static String PASSWORD = "root";
	
	public static Connection getConnection()  {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
		} catch (Exception e) {
			System.out.println("Connection to DB failed!");
			e.printStackTrace();
		} 
		return conn;
	}
}
