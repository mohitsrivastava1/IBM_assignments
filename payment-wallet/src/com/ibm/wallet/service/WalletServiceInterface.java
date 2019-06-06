package com.ibm.wallet.service;

import java.util.ArrayList;

import com.ibm.wallet.bean.MyWallet;

public interface WalletServiceInterface {

	boolean usrLogin(int uId, String pswd);

	double chkBal(int uId, String pswd);

	boolean deposit(int uId, double amtdep);

	boolean withdraw(int uId, double amtwd);

	boolean fundTransfer(int uId, int uId1, double amtfnd);

	boolean validatePassword(String pswd1, String pswd2);

	int generateAccountNo();

	void regAndCreate(MyWallet mywal);

	ArrayList<String> viewTransactionDetails(int uid);
	

}
