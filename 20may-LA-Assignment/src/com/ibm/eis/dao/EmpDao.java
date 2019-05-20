package com.ibm.eis.dao;

import java.util.HashMap;
import java.util.Map;
import com .ibm.eis.bean.Employee;


public class EmpDao implements EmpDaoInterface {
	private Map<Integer,Employee> employees=new HashMap<Integer,Employee>();
	
	@Override
	public void storeIntoMap(int id, Employee emp) {

		employees.put(id, emp);

		System.out.println("User Added!");

	}
	
	@Override
	public Employee getUserDetail(int id) {

		return employees.get(id);

	}
	
	/*
	 * @Override public Map<Integer,Employee>displayEmployee(){ return employees; }
	 */
	
}