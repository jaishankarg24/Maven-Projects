package com.abc.controller;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.factory.StudentServiceFactory;
import com.abc.service.StudentService;

public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Get the id and name from the HTML page through request object

		int sid = Integer.parseInt(request.getParameter("sid"));
		String sname = request.getParameter("sname");

		// call service layer services and get the status
		StudentService studentService = StudentServiceFactory.getStudentService();
		String status = studentService.validateUser(sid, sname);

		RequestDispatcher requestDispatcher = null;

		// Depending on the status forward to the respective page
		if (status.equals("success")) {
			requestDispatcher = request.getRequestDispatcher("./success.html");
			requestDispatcher.forward(request, response);
		}
		if (status.equals("failure")) {
			requestDispatcher = request.getRequestDispatcher("./failure.html");
			requestDispatcher.forward(request, response);
		}

	}

}