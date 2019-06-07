package com.ibm.mra.dao;

import java.util.Map;

import com.ibm.mra.beans.Account;

public interface AccountDao {
	
	 //Account getAccountDetails(String mobileNo); 
	 int rechargeAccount(String mobileNo, double rechargeAmount);
	 //public Map<String, Account> displayDetails();
	 public boolean mobileExists(String mobileNo);
	 public double getBalance(String mobileNo);
	 public String printName(String mobile);

}
