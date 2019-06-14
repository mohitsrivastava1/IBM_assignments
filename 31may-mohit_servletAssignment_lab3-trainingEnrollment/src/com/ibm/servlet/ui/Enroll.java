package com.ibm.servlet.ui;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import com.ibm.servlet.service.DatabaseService;





@WebServlet("/enroll")

public class Enroll extends HttpServlet {



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		DatabaseService dbService = new DatabaseService();

		String id = request.getParameter("id");

		

		dbService.reduceSeatByOne(id);

		//commented out by me
		//response.getWriter().println("Hi! you are successfully enrolled for the "+ new DatabaseService().getTrainingName(id) +" training");

		//response.getWriter().print(new DatabaseService().getAvailableSeats(id));

		PrintWriter out=response.getWriter();
		out.print(new DatabaseService().getAvailableSeats(id));
//		response.sendRedirect("trainings_available");

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}



}