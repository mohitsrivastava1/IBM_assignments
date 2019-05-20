package com.ibm.eis.dao;
import java.util.HashMap;
import java.util.Map;
import com.ibm.eis.bean.Employee;



public interface EmpDaoInterface {
	void storeIntoMap(int id, Employee employee);
	public abstract Employee getUserDetail(int id);
	//Map<Integer,Employee> displayEmployee();

}
