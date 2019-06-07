package com.ibm.mra.dao;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

import com.ibm.mra.beans.Account;

public class AccountDaoImpl {
	

	Account acc = null;
	
	Map<String,Account> accountEntry;   //= new HashMap<String,Account>();
	
		//Constructor for initializing the data
		public AccountDaoImpl(){
			//System.out.println("checking constructor");
		accountEntry= new HashMap<>();
		accountEntry.put("9010210131", new Account("Prepaid", "Vaishali", 200));
		accountEntry.put("9823920123", new Account("Prepaid", "Megha", 453));
		accountEntry.put("9932012345", new Account("Prepaid", "Vikas", 631));
		accountEntry.put("9010210132", new Account("Prepaid", "Anju", 521));
		accountEntry.put("9010210133", new Account("Prepaid", "Tushar", 632));  
		}        
//	Account getAccountDetails(String mobileNo) {
//		
//		return accountEntry;
//		
//	}
	public int rechargeAccount(String mobileNo, double rechargeAmount) {
		
		acc = accountEntry.get(mobileNo);
		double bal = acc.getBalance();
		bal = bal + rechargeAmount;
		accountEntry.put(mobileNo, new Account(acc.getAccountType(), acc.getCustomerName(), bal));
		return (int)bal;
		
	}
	
	public boolean mobileExists(String mobileNo) {
		
		/*Iterator hmIterator = accountEntry.entrySet().iterator();
		while (hmIterator.hasNext()) { 
            Map.Entry mapElement = (Map.Entry)hmIterator.next(); 
            String mobile = (String) (mapElement.getKey());*/ 
		
		if (accountEntry.containsKey(mobileNo))  
        { 
			return true;
        }
		else
		{
			return false;
		}
			
	}
	
	

	public double getBalance(String mobileNo) {
		
		double bal=0.0;
		/*
		 * Iterator hmIterator = accountEntry.entrySet().iterator(); while
		 * (hmIterator.hasNext()) { Map.Entry mapElement = (Map.Entry)hmIterator.next();
		 * String mobile = (String) (mapElement.getKey());
		 * 
		 * 
		 * if(mobileNo.equals(mobile)) { bal =
		 * (double)(mapElement.getValue().hashCode()).getBalance();
		 * bal=bal.getBalance(); } } return bal;
		 */
		
		acc = accountEntry.get(mobileNo);
		bal = acc.getBalance();
		return bal;
		
		
	}

	/*
	 * public Map<String, Account> displayDetails() {
	 * 
	 * return accountEntry; }
	 */
	public String printName(String mobile) {
		acc = accountEntry.get(mobile);
		String name = acc.getCustomerName();
		return name;
	}
	}
