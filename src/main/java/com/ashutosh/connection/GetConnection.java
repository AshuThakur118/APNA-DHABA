package com.ashutosh.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GetConnection {
	//variable of type Connection to store connection
		private static Connection connection;
		public static Connection getMysql() {
			try {
				//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//creating the connection
				connection = DriverManager.getConnection("jdbc:mysql://localhost/case_proj","root","Ashu@8848");
				return connection;
			} catch (SQLException e) {
				e.printStackTrace();
			}
			catch(ClassNotFoundException cl) {
				cl.printStackTrace();
			}
			return null;
		}
		public static void main(String[] args) {
			System.out.println(getMysql());
		}
}