package com.ibm.servlet.dao;



import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;

//import java.util.TimeZone;



import com.ibm.servlet.bean.Subject;



public class DatabaseDAO implements DatabaseDAOInterface {

	

	private static Connection dbConnection = null;

	private static PreparedStatement stmt = null;

	

	public void createConnection(String dbName, String userName, String password)	{

		

		try	{

			//String timeZoneCorrection = "?serverTimezone=" + TimeZone.getDefault().getID();

			

			Class.forName("com.mysql.jdbc.Driver");

			

			DatabaseDAO.dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName/* + timeZoneCorrection */, userName, password);

			

		}

		catch(ClassNotFoundException | SQLException e)	{

			System.out.println("[createConnection]\n" + e.getMessage());

		}

		

	}



	@Override

	public boolean setAvailableSeats(String id, String quantity) {

		String query = "update training set available_seats=? where training_id=?";

		

		try	{

			DatabaseDAO.stmt = DatabaseDAO.dbConnection.prepareStatement(query);

			DatabaseDAO.stmt.setString(1, quantity);

			DatabaseDAO.stmt.setString(2, id);

			

			if(DatabaseDAO.stmt.executeUpdate() != 0)	{

//				System.out.println("seats: " + quantity + " on id: " + id);

				return true;

			}

			else	{

				return false;

			}

		}

		catch(SQLException e) {

			System.out.println("[setAvailableSeats]\n" + e);

			return false;

		}

	}



	@Override

	public String getTrainingName(String id) {

		String query = "select training_name from training where training_id=?";

		

		try	{

			DatabaseDAO.stmt = DatabaseDAO.dbConnection.prepareStatement(query);

			DatabaseDAO.stmt.setString(1, id);

			

			ResultSet rs = DatabaseDAO.stmt.executeQuery();

			String trainingName = null;

			while(rs.next())	{

				trainingName = rs.getString(1);

			}

			return trainingName;

		}

		catch(SQLException e)	{

			System.out.println("[getTrainingName]\n" + e);

			return "[id not found]";

		}

	}



	@Override

	public String getAvailableSeats(String id) {

		String query = "select available_seats from training where training_id=?";

		

		try	{

			DatabaseDAO.stmt = DatabaseDAO.dbConnection.prepareStatement(query);

			DatabaseDAO.stmt.setString(1, id);

			

			ResultSet rs = DatabaseDAO.stmt.executeQuery();

			String availableSeats = null;

			while(rs.next())	{

				availableSeats = rs.getString(1);

			}

			return availableSeats;

		}

		catch(SQLException e) {

			System.out.println("[getAvailableSeats]\n" + e);

			return "[id not found]";

		}

	}



	@Override

	public boolean setSubject(Subject subject) {

		String query = "insert into training values(?, ?, ?)";

		

		try	{

			DatabaseDAO.stmt = DatabaseDAO.dbConnection.prepareStatement(query);

			DatabaseDAO.stmt.setString(1, subject.getSubjectId());

			DatabaseDAO.stmt.setString(2, subject.getSubjectName());

			DatabaseDAO.stmt.setString(3, subject.getAvailableSeats());

			

			if(DatabaseDAO.stmt.executeUpdate() != 0)	{

//				System.out.println("id:" + subject.getSubjectId() + " name: " + subject.getSubjectName() + " seats: " + subject.getAvailableSeats() + " added!");

				return true;

			}

			else	{

				return false;

			}

		}

		catch(SQLException e)	{

			System.out.println("[setSubject]\n" + e);

			return false;

		}

	}

	

	@Override

	public boolean removeSubject(String id)	{

		String query = "delete from training where training_id=? limit 1";

		

		try	{

			DatabaseDAO.stmt = DatabaseDAO.dbConnection.prepareStatement(query);

			DatabaseDAO.stmt.setString(1, id);

			

			if(DatabaseDAO.stmt.executeUpdate() != 0)	{

				System.out.println("id: " + id + " removed");

				return true;

			}

			else	{

				return false;

			}

		}

		catch(SQLException e)	{

			System.out.println("[removeSubject]\n" + e);

			return false;

		}

	}

	

	public int countRows()	{

		String query = "select count(training_id) from training";

		

		try	{

			DatabaseDAO.stmt = DatabaseDAO.dbConnection.prepareStatement(query);

			ResultSet rs = DatabaseDAO.stmt.executeQuery();

			

			int returnIt = 0;

			while(rs.next())	returnIt = rs.getInt(1);

			

			return returnIt;

		}

		catch(SQLException e)	{

			System.out.println("[countRows]\n" + e);

			return 0;

		}

	}

	

	public String[] getRows()	{

		String query = "select training_id,training_name,available_seats from training";

		

		try	{

			DatabaseDAO.stmt = DatabaseDAO.dbConnection.prepareStatement(query);

			ResultSet rs = DatabaseDAO.stmt.executeQuery();

			

			String[] rows = new String[this.countRows()];

			int counter = 0;

			while(rs.next())	{

				rows[counter++] = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3);

			}

			return rows;

		}

		catch(SQLException e)	{

			System.out.println("[getRows]\n" + e);

			return null;

		}

	}

}