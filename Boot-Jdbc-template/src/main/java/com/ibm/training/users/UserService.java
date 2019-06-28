package com.ibm.training.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserDao dao;
	
	public List<Course> getCourses() {
		
		return dao.getCourses();
	}

	public List<Course> getCourseById(Integer id) {
		
		return dao.getCourseById(id);
	}

	public void addCourse(Course course) {
		dao.addCourse(course);
		
	}

	public void updateCourse(Course course, Integer id) {
		dao.updateCourse(course,id);
	}

	public void deleteCourse(Integer id) {
		dao.deleteCourse(id);
		
	}
}
