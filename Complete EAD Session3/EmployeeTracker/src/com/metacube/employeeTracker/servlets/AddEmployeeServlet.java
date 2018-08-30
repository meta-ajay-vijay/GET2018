package com.metacube.employeeTracker.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.employeeTracker.Response.BooleanAndString;
import com.metacube.employeeTracker.dao.EmployeeDao;
import com.metacube.employeeTracker.model.Employee;

/**
 * Servlet implementation class AddEmployeeServlet
 */
@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDao employeeDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();

		try {
			/* employeeDao = new EmployeeDao(dataSource); */
			employeeDao = new EmployeeDao();
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		addEmployee(request, response);
	}

	private void addEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// read student info from form data
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));

		// create a new student object
		Employee employee = new Employee(firstName, lastName, email, age);

		// add the student to the database
		BooleanAndString responseOfAddOp = employeeDao.addEmployee(employee);
		if(responseOfAddOp.getFlag()){
			// send back to main page (the student list)
			RequestDispatcher dispatcher =
				       getServletContext().getRequestDispatcher("/ShowEmployeesServlet");
			dispatcher.include(request, response);

		} else {
			PrintWriter out = response.getWriter();
			out.println("<h1>" + responseOfAddOp.getMessage() + "</h1>");
			out.println("<p><a href='ShowEmployeesServlet'>Back to List</a></p>");
			out.println("<p><a href='addEmployee.jsp'>Back to Add Employee page</a></p>");
		}

		
	}

}
