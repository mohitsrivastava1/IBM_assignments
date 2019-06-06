package com.ibm.wallet.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//import com.ibm.training.MyUsingPrepSt;

public class WalletDao implements WalletDaoInterface 
{

	Connection dbCon;
	PreparedStatement theStatement;
	int idCounter;
	WalletTrxnDao waldaotrxn = new WalletTrxnDao();
	
	public boolean walExists(int uId, String pswd) {
		
		this.connectToDb();
		//new WalletDao().connectToDb();
		//check whether successful
		if(this.dbCon == null) {
			System.out.println("Some issues while connecting to database...");
			return false;
		}
		else {
			if(this.fetchResults(uId,pswd)) {
				return true;
			}
			else {
				return false;
			}
			//this.updateValues();
			//this.insertValues();
			//this.deleteValues();
		}
	}

	public boolean fetchResults(int uId,String pswd) {
		
			//Write the query to fetch results from table:userDetails
			String fetchQry = "select * from useraccounts where uid = ? and pswd = ?";
			//get the prepared statement reference
			try {
				this.theStatement = this.dbCon.prepareStatement(fetchQry);
				
				//Set the value
				this.theStatement.setInt(1,uId);
				this.theStatement.setString(2,pswd);
				
				//Execute the query
				ResultSet theResultSet = this.theStatement.executeQuery();
				
				if(theResultSet.next()) {
					System.out.println("Account exists !!!");
					return true;
					
				}
				else
				{
					System.out.println("Account doesnt exists !!!");
					return false;
				}
			
				
			} catch (SQLException e) {
				System.out.println("Some issues while fetching results : " + e);
				return false;
			}	
	}

	public void connectToDb() {
		
		try {
			//Load the Driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//Make the connection
			this.dbCon = DriverManager.getConnection("jdbc:mysql://localhost:3306/24may-paywallet", "root", "");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Some issues : " + e);
		}
		
	}

	public double chkBal(int uId, String pswd) {
		
		//Write the query to fetch results from table:userDetails
		String fetchQry = "select * from useraccounts where uid = ? and pswd = ?";
		double baln=0;
		//get the prepared statement reference
		try {
			this.theStatement = this.dbCon.prepareStatement(fetchQry);
			
			//Set the value
			this.theStatement.setInt(1,uId);
			this.theStatement.setString(2,pswd);
			
			//Execute the query
			ResultSet theResultSet = this.theStatement.executeQuery();
			
			while(theResultSet.next()) {
				
				baln = theResultSet.getDouble("bal");
				
				
			}
			
			
		} catch (SQLException e) {
			System.out.println("Some issues while fetching results : " + e);
			//return baln; //kindly check it as its not required here .
		}
		return baln;
	}

	public boolean deposit(int uId, double amtdep) {
		//Write the query to fetch results from table:userDetails
				String fetchQry = "select * from useraccounts where uid = ?";
				double baln=0;
				this.connectToDb();
				//get the prepared statement reference
				try {
					this.theStatement = this.dbCon.prepareStatement(fetchQry);
					
					//Set the value
					this.theStatement.setInt(1,uId);
					//this.theStatement.setString(2,pswd);
					
					//Execute the query
					ResultSet theResultSet = this.theStatement.executeQuery();
					
					while(theResultSet.next()) {
						
						baln = theResultSet.getDouble("bal");
						
					}
					
					baln = baln + amtdep;
					
					//Write the query to update
					String updateQry = "update useraccounts set bal = ? where uid = ?";
					
					//Get a reference to the PreparedStatement
					
						this.theStatement = this.dbCon.prepareStatement(updateQry);
						
						//Set the values for prepared statement
						this.theStatement.setDouble(1, baln);
						this.theStatement.setInt(2, uId);
						//this.theStatement.setInt(3, 6542);
						
						//execute the query
						if(this.theStatement.executeUpdate() > 0) {
							System.out.println("Amount deposited !!!");
							waldaotrxn.storeMessages(uId, "Amount of Rs "+amtdep+" deposited into account");
							return true;
						}
						
					
					
				} catch (SQLException e) {
					System.out.println("Some issues while updating : " + e);
					
				}
		return false;
	}

	public boolean withdraw(int uId, double amtwd) {
		
		this.connectToDb();
		
		String fetchQry = "select * from useraccounts where uid = ?";
		double baln=0;
		//get the prepared statement reference
		try {
			this.theStatement = this.dbCon.prepareStatement(fetchQry);
			
			//Set the value
			this.theStatement.setInt(1,uId);
			//this.theStatement.setString(2,pswd);
			
			//Execute the query
			ResultSet theResultSet = this.theStatement.executeQuery();
			
			while(theResultSet.next()) {
				
				baln = theResultSet.getDouble("bal");
				
			}
			if(amtwd < baln)
			{
			baln = baln - amtwd;
			
			//Write the query to update
			String updateQry = "update useraccounts set bal = ? where uid = ?";
			
			//Get a reference to the PreparedStatement
			
				this.theStatement = this.dbCon.prepareStatement(updateQry);
				
				//Set the values for prepared statement
				this.theStatement.setDouble(1, baln);
				this.theStatement.setInt(2, uId);
				//this.theStatement.setInt(3, 6542);
				
				//execute the query
				if(this.theStatement.executeUpdate() > 0) {
					System.out.println("Amount withdrawn !!!");
					waldaotrxn.storeMessages(uId, "Amount of Rs "+amtwd+" withdrawn from account");
					return true;
				}
			}
			else
			{
				System.out.println("Balance insufficient for withdrawal !!!");
				return false;
			}
			
			
		} catch (SQLException e) {
			System.out.println("Some issues while updating : " + e);
			
		}
		return false;
		
	}

	public boolean fundTransfer(int uId, int uId1, double amtfnd) {
		
		
		//Left as commented like this here ,so that if required in future, it may be available.
		/*
		 * String fetchQry = "select * from useraccounts where uid = ?"; double baln=0;
		 * //get the prepared statement reference try { this.theStatement =
		 * this.dbCon.prepareStatement(fetchQry);
		 * 
		 * //Set the value this.theStatement.setInt(1,uId);
		 * 
		 * 
		 * //Execute the query ResultSet theResultSet =
		 * this.theStatement.executeQuery();
		 * 
		 * while(theResultSet.next()) {
		 * 
		 * baln = theResultSet.getDouble("bal");
		 * 
		 * } if(baln > amtfnd) { baln = baln - amtfnd; String updateQry =
		 * "update useraccounts set bal = ? where uid = ?"; //Get a reference to the
		 * PreparedStatement
		 * 
		 * this.theStatement = this.dbCon.prepareStatement(updateQry);
		 * 
		 * //Set the values for prepared statement this.theStatement.setDouble(1, baln);
		 * this.theStatement.setInt(2, uId); //execute the query
		 * if(this.theStatement.executeUpdate() > 0) {
		 * 
		 * String fetchQry1 = "select * from useraccounts where uid = ?"; double
		 * baln1=0; //get the prepared statement reference
		 * 
		 * this.theStatement = this.dbCon.prepareStatement(fetchQry1);
		 * 
		 * //Set the value this.theStatement.setInt(1,uId1);
		 * 
		 * 
		 * //Execute the query ResultSet theResultSet1 =
		 * this.theStatement.executeQuery();
		 * 
		 * while(theResultSet1.next()) {
		 * 
		 * baln1 = theResultSet1.getDouble("bal");
		 * 
		 * }
		 * 
		 * baln1 = baln1 + amtfnd; String updateQry1 =
		 * "update useraccounts set bal = ? where uid = ?"; //Get a reference to the
		 * PreparedStatement
		 * 
		 * this.theStatement = this.dbCon.prepareStatement(updateQry1);
		 * 
		 * //Set the values for prepared statement this.theStatement.setDouble(1,
		 * baln1); this.theStatement.setInt(2, uId1);
		 * if(this.theStatement.executeUpdate() > 0) {
		 */
		
		if(withdraw(uId,amtfnd))
		{
			if(deposit(uId1,amtfnd))
			{
						System.out.println("Funds transfer successful !!!");
						waldaotrxn.storeMessages(uId, "Amount of Rs "+amtfnd+" transfered to account "+uId1);
						waldaotrxn.storeMessages(uId1, "Amount of Rs "+amtfnd+" received from account "+uId);
						return true;
			}
		}	
		else 
		{
				System.out.println("Insufficient balance in account, so cant transfer funds !!!");
				return false;
		}
		return false;
			
		/*
		 * } catch (SQLException e) {
		 * System.out.println("Some issues while fund transfer : " + e);
		 * 
		 * }
		 */
		
	}

	
	@Override
	public boolean validateAccountNumber(int uId) {
		try {
			this.connectToDb();
			if(this.dbCon == null) {
				System.out.println("Some issues while connecting to database...");
				return false;
			}
			theStatement = dbCon.prepareStatement("select uid from useraccounts");
			ResultSet rs = theStatement.executeQuery();
			
			while(rs.next())
			{
				if(rs.getInt("uid") == uId)
					return false;
				
			}
			
		} catch (SQLException e) {
			System.out.println("Issues while retriving account numbers "+e);
		}
		
		return true;
		
	}

	@Override
	public void regAndCreate(int usrid, String password, String customer_name, double balance) {
		try {
			theStatement = dbCon.prepareStatement("insert into useraccounts values (?,?,?,?)");
			theStatement.setInt(1, usrid);
			theStatement.setString(2, customer_name);
			theStatement.setString(3, password);
			theStatement.setDouble(4, balance);
			if(theStatement.executeUpdate() > 0)
			{
				System.out.println("Account created Successfully");
				waldaotrxn.storeMessages(usrid, "Account created Successfully");
			}
		} catch (SQLException e) 
		{
			System.out.println("Some issues while inserting data into database..... " + e);
		}
		
	}


}
