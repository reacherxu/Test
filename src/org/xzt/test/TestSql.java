package org.xzt.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestSql {
	// Declare the JDBC objects.    
	private Connection conn = null;    
	private Statement stmt = null;    
	private ResultSet rs = null;  

	//sa身份连接    
	String url = "jdbc:sqlserver://localhost:1433;databaseName=STOMS;user=sa;password=reacher";

	//    String url2 = "jdbc:sqlserver://127.0.0.1:1368;databaseName=mydb;integratedSecurity=true;";//windows集成模式连接 
	public void connect() {
		try {
			System.out.println("begin."); 
			// 加载sql驱动
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection(url);
			System.out.println("end.");    

			// Create and execute an SQL statement that returns some data.    
			String SQL = "SELECT TOP 1000 [id],[department] FROM [STOMS].[dbo].[DD]";    
			stmt = conn.createStatement();    
			rs = stmt.executeQuery(SQL);    

			// Iterate through the data in the result set and display it.    
			while (rs.next()) {    
				System.out.println(rs.getString(1) + " " + rs.getString(2));    
			}    
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new TestSql().connect();
	}
	
}
