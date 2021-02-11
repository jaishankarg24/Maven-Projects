package com.abc.controller;

import java.io.IOException;



import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.abc.dto.Student;
import com.abc.factory.StudentServiceFactory;
import com.abc.service.StudentService;

/**
 * SERVLET implementation class StudentController
 */
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String action = request.getParameter("action");

		// Module for Adding a Record
		if (action.equalsIgnoreCase("ADD")) {

			// Took the data from the client
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddress");

			// Create a student object use DTO pattern to transfer the data
			Student student = new Student();
			student.setSid(sid);
			student.setSage(sage);
			student.setSname(sname);
			student.setSaddress(saddress);

			// Use Factory Design pattern to the StudentService object
			StudentService studentService = StudentServiceFactory.getStudentService();
			String status = studentService.save(student);
			RequestDispatcher requestDispatcher = null;
			if (status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
			}
			if (status.equals("failure")) {
				requestDispatcher = request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}
			if (status.equals("alreadyExisted")) {
				requestDispatcher = request.getRequestDispatcher("existed.html");
				requestDispatcher.forward(request, response);
			}
		} // End of ADD Module

		// Module for Reading a Record
		if (action.equalsIgnoreCase("READ")) {

			// Collect student id(sid) from the client
			String sid = request.getParameter("sid");

			// Use Factory Design pattern to the StudentService object
			StudentService studentService = StudentServiceFactory.getStudentService();
			Student student = studentService.findById(sid);

			// Based on the student object send the response to the client
			RequestDispatcher requestDispatcher = null;
			if (student == null) {
				requestDispatcher = request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);

			} else {

				// Keep the data in request object and redirect it to JSP page
				request.setAttribute("student", student);
				requestDispatcher = request.getRequestDispatcher("displayRecord.jsp");
				requestDispatcher.forward(request, response);

			}

		} // End of READ Module

		// Module for Deleting a student Record
		if (action.equalsIgnoreCase("delete")) {

			// Collect the data from the client
			String sid = request.getParameter("sid");

			// Use Factory Design pattern to the StudentService object
			StudentService studentService = StudentServiceFactory.getStudentService();
			String status = studentService.deleteById(sid);

			// Based on status process the information to the client
			RequestDispatcher requestDispatcher = null;
			if (status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);

			}
			if (status.equals("notexisted")) {
				requestDispatcher = request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);

			}
			if (status.equals("failure")) {

				requestDispatcher = request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}

		} // End of Delete Module

		// Module for updating a Record
		if (action.equalsIgnoreCase("update")) {

			// Get the data(SID) from the client
			String sid = request.getParameter("sid");

			// Use Factory Design pattern to the StudentService object
			StudentService studentService = StudentServiceFactory.getStudentService();
			Student student = studentService.findById(sid);

			// Based on the student object send the response to the client
			RequestDispatcher requestDispatcher = null;
			if (student == null) {
				requestDispatcher = request.getRequestDispatcher("notexisted.html");
				requestDispatcher.forward(request, response);

			} else {

				// Keep the data in request object and redirect it to JSP page
				request.setAttribute("student", student);
				requestDispatcher = request.getRequestDispatcher("editRecord.jsp");
				requestDispatcher.forward(request, response);

			}

		}

		if (action.equals("edit")) {
			// Took the data from the client
			String sid = request.getParameter("sid");
			String sname = request.getParameter("sname");
			String sage = request.getParameter("sage");
			String saddress = request.getParameter("saddress");

			// Create a student object use DTO pattern to transfer the data
			Student student = new Student();
			student.setSid(sid);
			student.setSage(sage);
			student.setSname(sname);
			student.setSaddress(saddress);

			// Use Factory Design pattern to the StudentService object
			StudentService studentService = StudentServiceFactory.getStudentService();
			String status = studentService.update(student);

			// Based on status process the information to the client
			RequestDispatcher requestDispatcher = null;
			if (status.equals("success")) {
				requestDispatcher = request.getRequestDispatcher("success.html");
				requestDispatcher.forward(request, response);
			}
			if (status.equals("failure")) {
				requestDispatcher = request.getRequestDispatcher("failure.html");
				requestDispatcher.forward(request, response);
			}

		}//End of Update Module

	}
}

