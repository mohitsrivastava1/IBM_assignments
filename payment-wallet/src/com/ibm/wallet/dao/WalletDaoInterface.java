package com.ibm.wallet.dao;

public interface WalletDaoInterface {
	public boolean walExists(int uId, String pswd);
	public double chkBal(int uId, String pswd);
	public boolean deposit(int uId, double amtdep);
	public boolean withdraw(int uId, double amtwd);
	public boolean fundTransfer(int uId, int uId1, double amtfnd);
	
	public void connectToDb();
	public boolean fetchResults(int uId,String pswd);
	public boolean validateAccountNumber(int account_no);
	public void regAndCreate(int usrid, String password, String customer_name, double balance);

}
