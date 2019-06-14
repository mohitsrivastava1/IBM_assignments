package com.ibm.servlet.bean;



public class Subject {

	String subjectId, subjectName, availableSeats;



	public Subject(String subjectId, String subjectName, String availableSeats) {

		this.subjectId = subjectId;

		this.subjectName = subjectName;

		this.availableSeats = availableSeats;

	}



	public String getSubjectId() {

		return subjectId;

	}



	public void setSubjectId(String subjectId) {

		this.subjectId = subjectId;

	}



	public String getSubjectName() {

		return subjectName;

	}



	public void setSubjectName(String subjectName) {

		this.subjectName = subjectName;

	}



	public String getAvailableSeats() {

		return availableSeats;

	}



	public void setAvailableSeats(String availableSeats) {

		this.availableSeats = availableSeats;

	}

	

	

}