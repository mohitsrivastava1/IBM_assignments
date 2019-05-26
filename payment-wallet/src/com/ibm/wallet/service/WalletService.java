package com.ibm.wallet.service;

import java.util.Scanner;

import com.ibm.wallet.dao.WalletDao;
import com.ibm.wallet.dao.WalletDaoInterface;

public class WalletService implements WalletServiceInterface {

	WalletDaoInterface waldao = new WalletDao();
	//WalletServiceInterface walserv = new WalletService();
	
	Scanner scan = new Scanner(System.in);
	
	@Override
	public void usrLogin(int uId, String pswd) {
		if(waldao.walExists(uId,pswd))
		{
			System.out.println("Welcome , Press :- \n1)For checking balance,\n2)For Deposit money,\n3)Print Transaction,\n4)Withdrawal,\n5)Funds Transfer .");
			int choice = scan.nextInt();
			
			switch(choice)
			{
				case 1:double bal = waldao.chkBal(uId,pswd);
					System.out.println("Balance is :- "+ bal);
					break;
					
				case 2:System.out.println("Enter the amount to be deposited :-");
					double amtdep = scan.nextDouble();
					waldao.deposit(uId,amtdep);
					break;
					
				case 3:
				case 4:System.out.println("Enter the amount to be withdrawn :-");
					double amtwd = scan.nextDouble();
					waldao.withdraw(uId,amtwd);
					break;
				
				case 5:System.out.println("Enter the fund amount to be transferred :-");
					double amtfnd = scan.nextDouble();
					System.out.println("Enter the ID to which the fund is to be transferred :-");
					int uId1 = scan.nextInt();
					waldao.fundTransfer(uId,uId1,amtfnd);
					break;
					
				default:System.out.println("Invalid input !!!");
					
			}
		}
		else
		{
			System.out.println("Invalid userid or password !!!");
		}
		
	}

	@Override
	public void regAndCreate(String name, String mno, String pswd1) {
		
		int usrid = waldao.generateId(name,mno,pswd1);
		System.out.println("Your account created !!!");
		System.out.println("Your User ID is :- " + usrid);
		System.out.println("Please Enter some (mandatory) amount in your account :- ");
		double mandAmt = scan.nextDouble();
		waldao.deposit(usrid,mandAmt);
		this.usrLogin(usrid, pswd1);
		
	}

}
