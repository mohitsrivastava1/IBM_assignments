package com.ibm.training.users;

public class Course 
{
	Integer courseId, courseSeats;
	String courseName;
	public Integer getCourseId() {
		return courseId;
	}
	public Course()
	{
		
	}
	public Course(Integer courseId, Integer courseSeats, String courseName) {
		super();
		this.courseId = courseId;
		this.courseSeats = courseSeats;
		this.courseName = courseName;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getCourseSeats() {
		return courseSeats;
	}
	public void setCourseSeats(Integer courseSeats) {
		this.courseSeats = courseSeats;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
