package com.ibm.wallet.ui;

import java.util.Scanner;

import com.ibm.wallet.service.WalletService;
import com.ibm.wallet.service.WalletServiceInterface;

//import com.ibm.eis.bean.Employee;
//import com.ibm.eis.service.EmployeeServiceInterface;
//import com.ibm.eis.service.ServiceClass;

public class MyMain {

	public static void main(String[] args) {
		Scanner scan= new Scanner(System.in);
		WalletServiceInterface walser = new WalletService();
		
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
				walser.usrLogin(uId,pswd);
				
				break;
				
			case 2:System.out.println("Enter your name");
				String name = scan.nextLine();
				System.out.println("Enter your mobile no. in 10 digits");
				String mno = scan.nextLine();
				/*
				 * System.out.println("Enter your user id (in 5 digits and completely numeric)"
				 * ); String uId1 = scan.nextLine();
				 */
				System.out.println("Enter your password");
				String pswd1 = scan.nextLine();
				walser.regAndCreate(name,mno,pswd1);
				
				break;
				
			case 3:System.out.println("Thankyou");
					
				break;
			
			default:System.out.println("Invalid Details, Kindly Re-enter correct choice !!!");
			}
			
			}while(num != 3) ;
	}

}
