package com.ibm.mra.service;

import com.ibm.mra.beans.Account;
import com.ibm.mra.dao.AccountDaoImpl;
import java.util.HashMap;
import java.util.Map;

public class AccountServiceImpl implements AccountService { 
	
	Account account = null;
	AccountDaoImpl dao = new AccountDaoImpl();
	
//	public Account getAccountDetails(String mobileno){
//		
//		return account.getAccountType();
//	}
//	
	
	public int rechargeAccount(String mobileNo, double rechargeAmount){
		return dao.rechargeAccount(mobileNo , rechargeAmount);
		
	}

	public double getBalance(String mobileNo) {

		return dao.getBalance(mobileNo);
	}


	public boolean mobileExists(String mobileNo) {
		
		return dao.mobileExists(mobileNo);
	}

	public boolean validateMobile(String mobileNo) {
		if(mobileNo.length() == 10)
		{
			return true;
		}
		else
		{
			return false;
		} 
	}

	/*
	 * public Map<String , Account> displayDetails() {
	 * 
	 * return dao.displayDetails(); }
	 */

	public String printName(String mobile) {
		
		return dao.printName(mobile);
	}
}
