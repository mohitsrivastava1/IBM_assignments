package com.ibm.eis.service;
import java.util.Map;
import com.ibm.eis.bean.Employee;


public interface EmployeeServiceInterface {


		void storeIntoMap(int id, Employee employee);
		String findScheme(int salary,String designation);
		String printEmployeeDetails(int id);
		//Map<Integer,Employee> displayEmployees();
		
	
}
