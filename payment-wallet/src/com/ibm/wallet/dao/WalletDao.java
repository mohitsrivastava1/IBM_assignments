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
			/*
			 * while(theResultSet.next()) { System.out.println("ID : " +
			 * theResultSet.getInt("userId")); }
			 */
				
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
			return baln;
			/*
			 * else { System.out.println("Account doesnt exists !!!"); return false; }
			 */
		/*
		 * while(theResultSet.next()) { System.out.println("ID : " +
		 * theResultSet.getInt("userId")); }
		 */
			
		} catch (SQLException e) {
			System.out.println("Some issues while fetching results : " + e);
			return baln; //kindly check it as its not required here .
		}
	}

	public void deposit(int uId, double amtdep) {
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
						}
						
					
					
				} catch (SQLException e) {
					System.out.println("Some issues while updating : " + e);
					
				}
		
	}

	public void withdraw(int uId, double amtwd) {
		
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
				}
				
			//return baln;
			/*
			 * else { System.out.println("Account doesnt exists !!!"); return false; }
			 */
		/*
		 * while(theResultSet.next()) { System.out.println("ID : " +
		 * theResultSet.getInt("userId")); }
		 */
			
		} catch (SQLException e) {
			System.out.println("Some issues while updating : " + e);
			
		}
		
	}

	public void fundTransfer(int uId, int uId1, double amtfnd) {
		
		String fetchQry = "select * from useraccounts where uid = ?";
		double baln=0;
		//get the prepared statement reference
		try {
			this.theStatement = this.dbCon.prepareStatement(fetchQry);
			
			//Set the value
			this.theStatement.setInt(1,uId);
			
			
			//Execute the query
			ResultSet theResultSet = this.theStatement.executeQuery();
			
			while(theResultSet.next()) {
				
				baln = theResultSet.getDouble("bal");
				
			}
			if(baln > amtfnd) {
			baln = baln - amtfnd;
			String updateQry = "update useraccounts set bal = ? where uid = ?";
			//Get a reference to the PreparedStatement
			
			this.theStatement = this.dbCon.prepareStatement(updateQry);
			
			//Set the values for prepared statement
			this.theStatement.setDouble(1, baln);
			this.theStatement.setInt(2, uId);
			//execute the query
			if(this.theStatement.executeUpdate() > 0) {
			
				String fetchQry1 = "select * from useraccounts where uid = ?";
				double baln1=0;
				//get the prepared statement reference
				
					this.theStatement = this.dbCon.prepareStatement(fetchQry1);
					
					//Set the value
					this.theStatement.setInt(1,uId1);
					
					
					//Execute the query
					ResultSet theResultSet1 = this.theStatement.executeQuery();
					
					while(theResultSet1.next()) {
						
						baln1 = theResultSet1.getDouble("bal");
						
					}
					
					baln1 = baln1 + amtfnd;
					String updateQry1 = "update useraccounts set bal = ? where uid = ?";
					//Get a reference to the PreparedStatement
					
					this.theStatement = this.dbCon.prepareStatement(updateQry1);
					
					//Set the values for prepared statement
					this.theStatement.setDouble(1, baln1);
					this.theStatement.setInt(2, uId1);
					if(this.theStatement.executeUpdate() > 0) {
						System.out.println("Funds transfer successful !!!");
					}
				}	
			
			}
			else {
				System.out.println("Insufficient balance in account, so cant transfer funds !!!");
			}
			
		} catch (SQLException e) {
			System.out.println("Some issues while fund transfer : " + e);
			
		}
		
	}

	public int generateId(String name, String mno, String pswd1) {
		
		this.connectToDb();
		int id=0;
		//check whether successful
		if(this.dbCon == null) {
			System.out.println("Some issues while connecting to database 111...");
			
		}
		else {
			String insertQry = "INSERT INTO `useraccounts`(`uname`, `mobile`, `pswd`, `bal`) VALUES (?,?,?,?)";
			//Set the value
			try {
				this.theStatement = this.dbCon.prepareStatement(insertQry);

				this.theStatement.setString(1, name);
				this.theStatement.setString(2, mno);
				this.theStatement.setString(3, pswd1);
				this.theStatement.setInt(4, 0);
				
			//Execute the query
				if(theStatement.executeUpdate() > 0) {
					String fetchQry = "select * from useraccounts where mobile = ? and pswd = ?";
					//get the prepared statement reference
					
						this.theStatement = this.dbCon.prepareStatement(fetchQry);
						
						//Set the value
						this.theStatement.setString(1,mno);
						this.theStatement.setString(2,pswd1);
						
						//Execute the query
						ResultSet theResultSet = this.theStatement.executeQuery();
						
						if(theResultSet.next()) {
							id = theResultSet.getInt("uid");
							
							
						}
				}
			}
				 catch (SQLException e) {
				System.out.println("Some issues 222 : " + e);
				e.printStackTrace();
			}
		}
		return id;
		
	}

}
