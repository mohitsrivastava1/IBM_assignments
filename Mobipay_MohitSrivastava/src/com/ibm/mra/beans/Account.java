package com.ibm.mra.beans;

public class Account {
	
	private String accountType;
	private String customerName;
	private double accountBalance; 
	// getter, setter & constructor 

	
	public Account(String accountType, String customerName, double accountBalance)
	{
		this.accountType = accountType;
		this.customerName = customerName;
		this.accountBalance = accountBalance;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getBalance() {
		return accountBalance;
	}

	public void setBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	/*
	 * @Override public String toString() { return "Hello " + customerName +
	 * "  ,Available Balance is " + accountBalance; }
	 */

	
	
}
