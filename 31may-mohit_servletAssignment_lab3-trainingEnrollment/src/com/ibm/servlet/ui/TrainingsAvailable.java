//This file was useful before TrainingaAvailable.jsp page was created

package com.ibm.servlet.ui;



import java.io.IOException;

import java.io.PrintWriter;



import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;



import com.ibm.servlet.service.DatabaseService;



@WebServlet("/trainings_available")

public class TrainingsAvailable extends HttpServlet {

	private DatabaseService dbService = null;

	

	public void init()	{

		System.out.println("Initializing...");

		dbService = new DatabaseService();

	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");

		PrintWriter out = response.getWriter();

		

		out.println("<html><body><table><tr><th>Training Id</th><th>Training Name</th><th>Available Seats</th></tr>");

		

		int totalRows = dbService.countRows();

		String[] rows = dbService.getRows();

		for(int i=0; i<totalRows; ++i)	{

			String id, name, seats;

			

			id = rows[i].split(" ")[0];

			name = rows[i].split(" ")[1];

			seats = rows[i].split(" ")[2];

			

			out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + seats + "</td><td>");

			

			if(seats.equals("0"))	{

				out.println("</td></tr>");

			}

			else	{

				out.println("<a href='enroll?id=" + id + "'>Enroll</a></td></tr>");

			}

		}

		

		out.println("</table></body></html>");

	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);

	}



}