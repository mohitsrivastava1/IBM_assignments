package com.ibm.wallet.dao;

public interface WalletDaoInterface {
	public boolean walExists(int uId, String pswd);
	public double chkBal(int uId, String pswd);
	public void deposit(int uId, double amtdep);
	public void withdraw(int uId, double amtwd);
	public void fundTransfer(int uId, int uId1, double amtfnd);
	public int generateId(String name, String mno, String pswd1);
	public void connectToDb();
	public boolean fetchResults(int uId,String pswd);

}
