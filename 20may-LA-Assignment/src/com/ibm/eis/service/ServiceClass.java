package com.ibm.eis.service;
import java.util.Map;
import com.ibm.eis.dao.EmpDao;
import com .ibm.eis.bean.Employee;

public class ServiceClass implements EmployeeServiceInterface {
	
EmpDao edao = new EmpDao();
//ServiceClass sc = new ServiceClass();
	
@Override
public void storeIntoMap(int id , Employee employee){
		edao.storeIntoMap(id , employee);
		
	}


public String printEmployeeDetails(int id)	{

	Employee emp = edao.getUserDetail(id);

	String empDetails;

	

	empDetails = "Name: " + emp.getName() + "\n";

	empDetails += "Id: " + emp.getId() + "\n";

	empDetails += "Salary: " + emp.getSalary() + "\n";

	empDetails += "Designation: " + emp.getDesignation() + "\n";

		empDetails += "Insurance Scheme: " +  emp.getInsuranceScheme() + "\n";

	

	return empDetails;

}

@Override
public String findScheme(int salary, String designation) {
	if(salary < 5000 && designation.equalsIgnoreCase("Clerk"))
	{
		return "No Scheme";
	}
	else if(salary >= 5000 && salary < 20000 && designation.equalsIgnoreCase("System Associate"))
	{
		return "Scheme C";
	}
	else if(salary >= 20000 && salary < 40000 && designation.equalsIgnoreCase("Programmer"))
	{
		return "Scheme B";
	}
	else if(salary >= 40000 && designation.equalsIgnoreCase("Manager")) 
	{
		return "Scheme A";
	}
	else return "Invalid Input";
}


	/*
	 * @Override public Map<Integer, Employee> displayEmployees() {
	 * 
	 * return edao.displayEmployee(); }
	 */
	

}
