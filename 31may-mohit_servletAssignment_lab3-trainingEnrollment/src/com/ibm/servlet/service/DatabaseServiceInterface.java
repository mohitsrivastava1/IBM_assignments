package com.ibm.servlet.service;



import com.ibm.servlet.bean.Subject;



public interface DatabaseServiceInterface {

//	For users perspective	

	public String getTrainingName(String id);

	public String getAvailableSeats(String id);

	

//	For admin perspective

	public boolean setSubject(Subject subject);

	public boolean removeSubject(String id);

	public boolean setAvailableSeats(String id, String quantity);

}