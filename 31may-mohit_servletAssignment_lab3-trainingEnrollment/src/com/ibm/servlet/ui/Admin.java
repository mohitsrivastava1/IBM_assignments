package com.ibm.servlet.ui;



import java.io.IOException;

import java.io.PrintWriter;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



@WebServlet("/admin")

public class Admin extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");

		

		out.println("<h1>Admin Page!</h1><br>");

		

//		Add Training Form

		out.println("Add Training<br>");

		out.println("<form action='admin_action_add' method='post'>");

		out.println("Course Id: <input type='text' name='courseid'><br>");

		out.println("Course Name: <input type='text' name='coursename'><br>");

		out.println("Course Seats: <input type='text' name='courseseats'><br>");

		out.println("<input type='submit' value='Add Training'>");

		out.println("</form><br>");

		

//		Add Update Seats Form

		out.println("Update Seats<br>");

		out.println("<form action='admin_action_update' method='post'>");

		out.println("Course Id: <input type='text' name='courseid'><br>");

		out.println("Course Seats: <input type='text' name='courseseats'><br>");

		out.println("<input type='submit' value='Update Seats'><br>");

		out.println("</form><br>");

		

//		Delete Training Form

		out.println("Delete Training<br>");

		out.println("<form action='admin_action_remove' method='post'>");

		out.println("Course Id: <input type='text' name='courseid'><br>");

		out.println("<input type='submit' value='Delete Training'>");

		out.println("</form><br>");

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}

}