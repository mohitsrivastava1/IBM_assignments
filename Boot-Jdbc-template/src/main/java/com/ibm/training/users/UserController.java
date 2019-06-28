package com.ibm.training.users;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController 
{
	@Autowired
	UserService service;
	
	
//	@RequestMapping("/users/{abc}")
//	String getUser(@PathVariable("abc") int id)
//	{
//		return service.getUser(id);
//	}
	
	@RequestMapping("/courses")
	List<Course> getCourses()
	{
		
		return service.getCourses();
	}
	
	@RequestMapping("/courses/{id}")
	List<Course> getUserById(@PathVariable Integer id)
	{
		
		return service.getCourseById(id);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/courses")
	void addUserId(@RequestBody Course course)
	{
		service.addCourse(course);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/courses/{id}")
	void updateUser(@RequestBody Course course, @PathVariable Integer id)
	{
		service.updateCourse(course,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value="/courses/{id}")
	void deleteUser(@PathVariable Integer id)
	{
		service.deleteCourse(id);
	}
}
