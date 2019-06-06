package com.ibm.wallet.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class WalletTrxnDao {
	
	static Connection dbCon;
	static PreparedStatement theStatement;
	
	public WalletTrxnDao() 
	{
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/24may-paywallet", "root", "");
		}
		catch (ClassNotFoundException | SQLException e) 
		{
			System.out.println("Issues while connecting to databse : "+e);
		}
		
	}
	
	public void storeMessages(int uId, String message)
	{
		java.util.Date date=new java.util.Date();
		
		java.sql.Date sqlDate=new java.sql.Date(date.getTime());
		java.sql.Timestamp sqlTime=new java.sql.Timestamp(date.getTime());
		
		try {
			theStatement = dbCon.prepareStatement("insert into transactions values (?,?,?,?)");
			theStatement.setInt(1, uId);
			theStatement.setDate(2, sqlDate);
			theStatement.setTimestamp(3, sqlTime);
			theStatement.setString(4, message);
			
			if(theStatement.executeUpdate() > 0)
			{
				//System.out.println("Transaction details entered Successfully");
			}
			
		} catch (SQLException e) 
		{
			System.out.println(e);
		}
	}
	
	public ArrayList<String> viewMessages(int uId)
	{
		String message = "";
		ArrayList<String> list = new ArrayList<String>();
		try 
		{
			theStatement = dbCon.prepareStatement("select * from transactions where uid = ?");
			theStatement.setInt(1, uId);
			ResultSet rs = theStatement.executeQuery();
			
			while(rs.next())
			{
				message = rs.getString("trxn_message") +" on " + rs.getDate("trxn_date") +" at "+rs.getTimestamp("trxn_time");
				list.add(message);
				message = "";
			}
		} 
		catch (SQLException e) 
		{
			System.out.println(e);
		}
		return list;
	}
}
