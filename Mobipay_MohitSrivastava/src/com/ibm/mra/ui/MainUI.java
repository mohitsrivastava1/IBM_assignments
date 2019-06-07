package com.ibm.mra.ui;

import java.util.Scanner;

import com.ibm.mra.beans.Account;
import com.ibm.mra.dao.AccountDaoImpl;
import com.ibm.mra.service.AccountServiceImpl;

public class MainUI {

	public static void main(String[] args) {
		// to display the menu and accept the details from user 
		// create object for service class and execute the respective methods 
		
		int exit = 0; 
		int choice;
		Account account = null;
		Scanner sc = new Scanner(System.in);
		AccountServiceImpl service = new AccountServiceImpl();
		//AccountDaoImpl dao = new AccountDaoImpl();
		
		
		try
		{
		while(exit == 0)
		{
			System.out.println("Enter choice of operation you want to perform...");
			System.out.println("1. Account Balance Enquiry \n"
							 + "2. Recharge Account \n"
							 + "3. Exit");
			
				choice = sc.nextInt();
				sc.nextLine();
				switch(choice)
				{
				case 1:
					System.out.println("Welcome!");
					System.out.println("Enter Mobile No. : ");
					String mobileNo = sc.nextLine();
					if(service.validateMobile(mobileNo))
					{
					if(service.mobileExists(mobileNo))
					{
					double balance = service.getBalance(mobileNo);
					System.out.println("Your current balance is Rs. : "+ balance);
					}
					else
					{
						System.out.println("ERROR:  Given  Account Id Does Not Exits !!!");
					}
					}
					else
					{
						System.out.println("Invalid mobile no.");
					}
					break;
					
				case 2:System.out.println("Enter Mobile No. : ");
					String mobile = sc.nextLine();
					System.out.println("Enter Recharge Amount : ");
					double amt = sc.nextDouble();
					
					if(service.validateMobile(mobile))
					{
					if(service.mobileExists(mobile))
					{
						int final_amt= service.rechargeAccount(mobile, amt);
						System.out.println("Your Account Recharged Successfully ");
						//System.out.println(service.displayDetails());// use override toString() from Account.
						System.out.println("Hello "+service.printName(mobile) +" ,Available balance is "+ final_amt);
					}
					else
					{
						System.out.println("ERROR:  Cannot Recharge Account as Given Mobile No  Does Not Exits ");
					}
					}
					else
					{
						System.out.println("Invalid mobile no.");
					}
					break;	
					
				
				case 3:System.out.println("Thankyou !!!");
					exit = 1;
					break;
				
				default:
					System.out.println("Enter appropriate choice");
				}
			}
		}
			catch(Exception e)
			{
				System.out.println("Please enter input in appropriate format "+e);
			}
			
		

	}
		
		
	}


