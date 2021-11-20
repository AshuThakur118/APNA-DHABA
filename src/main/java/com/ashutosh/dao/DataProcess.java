package com.ashutosh.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Priority;

import com.ashutosh.bean.Login;
import com.ashutosh.bean.Registration;
import com.ashutosh.connection.GetConnection;

public class DataProcess {
	public static boolean Store(Registration reg) throws SQLException {
		//query to store data in database
		String sql = "insert into client values(?,?,?,?)";
		try (PreparedStatement prepareStatement = GetConnection.getMysql().prepareStatement(sql);) {
			prepareStatement.setString(1, reg.getUserName());
			prepareStatement.setString(2, reg.getEmail());
			prepareStatement.setString(3, reg.getPassWord());
			prepareStatement.setString(4, reg.getGender());
			return prepareStatement.executeUpdate() > 0;
		}

	}

	public static boolean Fetch(Login login) {
		String sql = "select username,password from client where username = ? and password = ?";
		

		try {
			ResultSet restset = null;
			PreparedStatement prepareStatement = GetConnection.getMysql().prepareStatement(sql);
			prepareStatement.setString(1, login.getUserName());
			prepareStatement.setString(2, login.getPassWord());
			restset = prepareStatement.executeQuery();

			if (restset.next()) {
				Login log = new Login();
				log.setUserName(restset.getString(1));
				log.setPassWord(restset.getString(2));
				
				return log.getUserName().equals(login.getUserName()) && log.getPassWord().equals(login.getPassWord());
			}
			
		} 
		catch (SQLException e) {
			//e.printStackTrace();
			org.apache.log4j.Logger.getLogger(DataProcess.class).log(Priority.ERROR,"");
		}
		return false;
	}
}