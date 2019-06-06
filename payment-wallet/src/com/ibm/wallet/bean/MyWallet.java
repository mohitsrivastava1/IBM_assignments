package com.ibm.wallet.bean;

public class MyWallet {

	
	//private String mobileNumber;
	private String name;
	//private String transaction;
	private double balance;
	private int userid;
	private String password;
	
	
	public MyWallet(String name, double balance, int userid, String password) {
		
		//this.mobileNumber = mobileNumber;
		this.name = name;
		//this.transaction = transaction;
		this.balance = balance;
		this.userid = userid;
		this.password = password;
		
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	/*
	 * public String getTransaction() { return transaction; }
	 * 
	 * public void setTransaction(String string) { this.transaction = string; }
	 */

	/*
	 * public String getMobileNumber() { return mobileNumber; }
	 * 
	 * public void setMobileNumber(String mobileNumber) { this.mobileNumber =
	 * mobileNumber; }
	 */
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setId(int userid) {
		this.userid = userid;
	}
	
	public int getId() {
		return userid;
	}
	
	public void setPaswd(String password) {
		this.password = password;
	}
	
	public String getPaswd() {
		return password;
	}

}
