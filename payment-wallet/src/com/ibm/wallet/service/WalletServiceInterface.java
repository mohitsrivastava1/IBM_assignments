package com.ibm.wallet.service;

public interface WalletServiceInterface {

	void usrLogin(int uId, String pswd);

	void regAndCreate(String name, String mno, String pswd1);
	

}
