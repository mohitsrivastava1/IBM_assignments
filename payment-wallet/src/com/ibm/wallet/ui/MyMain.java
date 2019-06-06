package com.ibm.wallet.ui;

import java.util.ArrayList;
import java.util.Scanner;

import com.ibm.wallet.bean.MyWallet;
import com.ibm.wallet.service.WalletService;
import com.ibm.wallet.service.WalletServiceInterface;

//import com.ibm.eis.bean.Employee;
//import com.ibm.eis.service.EmployeeServiceInterface;
//import com.ibm.eis.service.ServiceClass;

public class MyMain {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		WalletServiceInterface walser = new WalletService();
		MyWallet mywal = null;
		
		//EmployeeServiceInterface service = new ServiceClass();
		//Employee emp = new Employee();
		
		int num;
		do {
		System.out.println("Press \n1) To Login , \n2) To Register and Create Account , \n3) To Exit :- ");
		
		num = scan.nextInt();
		scan.nextLine();
		
		
			switch(num)
			{
			case 1:System.out.println("Enter your UserId");
				int uId = scan.nextInt();
				scan.nextLine();
				System.out.println("Enter your Password");
				String pswd = scan.nextLine();
				if(walser.usrLogin(uId,pswd))
				{
				System.out.println("Welcome , Press :- \n1)For checking balance,\n2)For Deposit money,\n3)Print Transaction,\n4)Withdrawal,\n5)Funds Transfer .");
				int choice = scan.nextInt();
				
				switch(choice)
				{
					case 1:double bal = walser.chkBal(uId,pswd);
						System.out.println("Balance is :- "+ bal);
						break;
						
					case 2:System.out.println("Enter the amount to be deposited :-");
						double amtdep = scan.nextDouble();
						if(walser.deposit(uId,amtdep))
						{
							System.out.println("Amount deposited successfully!!!");
						}
						else
						{
							System.out.println("Some issues while depositing!!!");
						}
						break;
						
					case 3:
							ArrayList<String> list = walser.viewTransactionDetails(uId);
							System.out.println("Your transaction history :");
							for(String s: list)
							{
								System.out.println(s);
							}
							break;
						
					
					
					case 4:System.out.println("Enter the amount to be withdrawn :-");
						double amtwd = scan.nextDouble();
						if(walser.withdraw(uId,amtwd))
						{
							System.out.println("Amount withdrawn successfully !!!");
						}
						else
						{
							System.out.println("Some issues while withdrawal !!!");
						}
						break;
					
					case 5:System.out.println("Enter the fund amount to be transferred :-");
						double amtfnd = scan.nextDouble();
						System.out.println("Enter the ID to which the fund is to be transferred :-");
						int uId1 = scan.nextInt();
						if(walser.fundTransfer(uId,uId1,amtfnd))
						{
							System.out.println("Fund transfer successful !!!");
						}
						else
						{
							System.out.println("fund transfer unsuccessful !!!");
						}
						break;
						
					default:System.out.println("Invalid input !!!");
						
				}
				}
				else
				{
					System.out.println("Kindly re-enter the details ...");
				}
			
				
				break;
				
			case 2:System.out.println("Enter your name");
				String name = scan.nextLine();
				int uId1 = walser.generateAccountNo();
				/*
				 * System.out.println("Enter your mobile no. in 10 digits"); String mno =
				 * scan.nextLine();
				 */
				/*
				 * System.out.println("Enter your user id (in 5 digits and completely numeric)"
				 * ); String uId1 = scan.nextLine();
				 */
				
				EnterPasswordAgain: while(true)
				{					
				System.out.println("Enter your password");
				String pswd1 = scan.nextLine();
				System.out.println("Re-Enter your password");
				String pswd2 = scan.nextLine();
				if(walser.validatePassword(pswd1,pswd2)){
					mywal = new MyWallet(name,1000,uId1,pswd1);
					walser.regAndCreate(mywal);
					System.out.println("User Id created for you is: "+uId1);
					break;
					
				}
				else
				{
					continue EnterPasswordAgain;
				}
				}
				
				break;
				
			case 3:System.out.println("Thankyou");
					
				break;
			
			default:System.out.println("Invalid Details, Kindly Re-enter correct choice !!!");
			}
			
			}while(num != 3) ;
	}

}
