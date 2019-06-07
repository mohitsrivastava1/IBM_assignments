package com.ibm.mra.service;

import java.util.HashMap;
import java.util.Map;

import com.ibm.mra.beans.Account;

public interface AccountService {

	 //Account getAccountDetails(String mobileNo);
	 int rechargeAccount(String mobileno, double rechargeAmount);
	 public boolean validateMobile(String mobileNo);
	 //public Map<String , Account> displayDetails();
	 public double getBalance(String mobileNo);
	 public boolean mobileExists(String mobileNo);
	 public String printName(String mobile);
	 
	
}
