package com.ibm.servlet.ui;



import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import com.ibm.servlet.bean.Subject;

import com.ibm.servlet.service.DatabaseService;



@WebServlet(urlPatterns= {"/admin_action", "/admin_action_add", "/admin_action_update", "/admin_action_remove"})

public class AdminAction extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		String courseId = request.getParameter("courseid");

		String courseName = request.getParameter("coursename");

		String courseSeats = request.getParameter("courseseats");

		

		System.out.println("courseId: " + courseId + " courseName: " + courseName + " courseSeats: " + courseSeats);

		

		if(courseId==null && courseName==null && courseSeats==null)	{

			response.sendRedirect("admin");

		}

		else	{

			//Removal of course

			if((!courseId.equals("")) && (courseName == null) && (courseSeats == null))	{

				new DatabaseService().removeSubject(courseId);

				response.getWriter().println("Course Removed!");

				request.getRequestDispatcher("admin").include(request, response);

			}

			//Updation of available seats

			else if((!courseId.equals("")) && (courseName == null) && (!courseSeats.equals("")))	{

				new DatabaseService().setAvailableSeats(courseId, courseSeats);

				response.getWriter().println("Course Seats Added!");

				request.getRequestDispatcher("admin").include(request, response);

			}

			//Addition of new course

			else if((!courseId.equals("")) && (!courseName.equals("")) && (!courseSeats.equals("")))	{

				new DatabaseService().setSubject(new Subject(courseId, courseName, courseSeats));

				response.getWriter().println("New Course Added!");

				request.getRequestDispatcher("admin").include(request, response);

			}

			else	{

				response.getWriter().println("Correct option is not selected!");

				request.getRequestDispatcher("admin").include(request, response);

			}

		}

		

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}



}