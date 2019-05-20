
package com.ibm.eis.ui;
import java.io.IOException;
import java.util.Scanner;

import com.ibm.eis.bean.Employee;

import com.ibm.eis.service.EmployeeServiceInterface;
import com.ibm.eis.service.ServiceClass;

public class UIMain {

	
	public static void main(String[] args)throws IOException {
		Scanner scan= new Scanner(System.in);
		EmployeeServiceInterface service = new ServiceClass();
		//Employee emp = new Employee();
		int num;
		do {
		System.out.println("Press 1) To enter details , 2) To Find insurance Scheme , 3) Display the Details , 4) To exit :- ");
		
		num = scan.nextInt();
		scan.nextLine();
		
		
			switch(num)
			{
			case 1:System.out.println("Enter your name");
				String name=scan.nextLine();
				System.out.println("Enter your id");
				int id=scan.nextInt();
				System.out.println("Enter your salary");
				int salary=scan.nextInt();
				scan.nextLine();
				System.out.println("Enter your designation");
				String designation=scan.nextLine();
				
				Employee emp = new Employee(id, name, salary, designation);
				//emp.setName(name);
				//emp.setId(id);
				//emp.setSalary(salary);
				//emp.setDesignation(designation);
				emp.setInsuranceScheme(service.findScheme(salary,designation));
				service.storeIntoMap(id,emp);
				break;
			case 2:System.out.println("Enter your salary");
				int salary1=scan.nextInt();
				scan.nextLine();
				System.out.println("Enter your designation");
				String designation1=scan.nextLine();
				String scheme = service.findScheme(salary1,designation1);
				System.out.println("Your Insurance scheme is :- " + scheme);
				break;
			case 3:System.out.println("Enter your id");
				int id2=scan.nextInt();
				System.out.println(service.printEmployeeDetails(id2));
				
				break;
			case 4:System.out.println("Thankyou !!!");
				break;
			default:System.out.println("Invalid Details !!!");
			}
			
			
			
			}while(num != 4) ;
		
		

	}

}
