package com.ibm.wallet.service;

import java.util.ArrayList;
import java.util.Scanner;

import com.ibm.wallet.bean.MyWallet;
import com.ibm.wallet.dao.WalletDao;
import com.ibm.wallet.dao.WalletDaoInterface;
import com.ibm.wallet.dao.WalletTrxnDao;

public class WalletService implements WalletServiceInterface {

	WalletDaoInterface waldao = new WalletDao();
	WalletTrxnDao waldaotrxn = new WalletTrxnDao();
	//WalletServiceInterface walserv = new WalletService();
	
	Scanner scan = new Scanner(System.in);
	
	@Override
	public boolean usrLogin(int uId, String pswd) {
		if(waldao.walExists(uId,pswd))
		{
			return true;
		}
		else 
		{
			System.out.println("Invalid userid or password !!!");
			return false;
		}
			
	}
		

	@Override
	public void regAndCreate(MyWallet mywal) {
		
		int usrid = mywal.getId();
		String password = mywal.getPaswd();
		String customer_name = mywal.getName();
		double balance = mywal.getBalance();
		waldao.regAndCreate(usrid,password,customer_name,balance);
		
	}

	@Override
	public double chkBal(int uId, String pswd) {
		
		return waldao.chkBal(uId, pswd);
	}


	@Override
	public boolean deposit(int uId, double amtdep) {

		return waldao.deposit(uId, amtdep);
	}


	@Override
	public boolean withdraw(int uId, double amtwd) {
		
		return waldao.withdraw(uId, amtwd);
	}


	@Override
	public boolean fundTransfer(int uId, int uId1, double amtfnd) {
		return waldao.fundTransfer(uId, uId1, amtfnd);
		
	}


	@Override
	public boolean validatePassword(String pswd1, String pswd2) {
		if(pswd1.equals(pswd2))
		{
			if(pswd1.length() >= 8)
				return true;
			else
			{
				System.out.println("Password length must be atleast 8");
				return false;
			}
		}
		else
			return false;
	}


	@Override
	public int generateAccountNo() {
		String num="";
		int length = 0; int store;
		while(length < 8)
		{
			store = (int)(Math.random() * 9);   //(>=0.0 to <1.0)*9 -> then casted to int -> gives int value from 0 to 8.
			num = num + store;
			length ++;
		}
		
		int account_no = Integer.parseUnsignedInt(num);  //Unsigned used here since its range is higher.
		
		if(waldao.validateAccountNumber(account_no))
			return account_no;
		else
			generateAccountNo();
		
		return 0;
	}


	@Override
	public ArrayList<String> viewTransactionDetails(int uid) {
		
		return waldaotrxn.viewMessages(uid);
		
	}

}
