package com.ibm.servlet.service;



import com.ibm.servlet.bean.Subject;

import com.ibm.servlet.dao.DatabaseDAO;



public class DatabaseService implements DatabaseServiceInterface	{

	private static DatabaseDAO db = null;

	

	public DatabaseService()	{

		try	{

			DatabaseService.db = new DatabaseDAO();

			DatabaseService.db.createConnection("31may-trainingenrollment", "root", "");

		}

		catch(NullPointerException npe)	{

			System.out.println("database is not connected!");

		}

	}



	@Override

	public String getTrainingName(String id) {

		return DatabaseService.db.getTrainingName(id);

	}



	@Override

	public String getAvailableSeats(String id) {

		return DatabaseService.db.getAvailableSeats(id);

	}



	@Override

	public boolean setSubject(Subject subject) {

		return DatabaseService.db.setSubject(subject);

	}



	@Override

	public boolean removeSubject(String id) {

		return DatabaseService.db.removeSubject(id);

	}



	@Override

	public boolean setAvailableSeats(String id, String quantity) {

		return DatabaseService.db.setAvailableSeats(id, quantity);

	}

	

	public boolean reduceSeatByOne(String id)	{

		String currentSeats = this.getAvailableSeats(id);

		if(currentSeats.equals("0"))	{

			return false;

		}

		else	{

			this.setAvailableSeats(id, new Integer((Integer.parseInt(currentSeats)-1)).toString());

			return true;

		}

	}

	

	public int countRows()	{

		return DatabaseService.db.countRows();

	}

	

	public String[] getRows()	{

		return DatabaseService.db.getRows();

	}

}