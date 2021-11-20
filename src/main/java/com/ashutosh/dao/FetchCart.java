package com.ashutosh.dao;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ashutosh.bean.Menu;
import com.ashutosh.connection.GetConnection;

public class FetchCart {
	public List<Menu> ReadData() throws IOException{
		List<Menu> list=new ArrayList<Menu>();
		String sql = "select cartId,itemName,itemPrice from menu";
		try {
			ResultSet rset = null;
			PreparedStatement prepareStatement = GetConnection.getMysql().prepareStatement(sql);
			rset = prepareStatement.executeQuery();

			while(rset.next()) {
				System.out.println(rset.getString(2)+" - ₹"+rset.getDouble(3));
				list.add(new Menu(rset.getString(2),rset.getDouble(3)));
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}