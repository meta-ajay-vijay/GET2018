package com.metacube.employeeTracker.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metacube.employeeTracker.dao.EmployeeDao;
import com.metacube.employeeTracker.model.Employee;

/**
 * Servlet implementation class SearchEmployeeServlet
 */
@WebServlet("/SearchEmployeeServlet")
public class SearchEmployeeServlet extends HttpServlet {
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
		try {
			searchEmployees(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void searchEmployees(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		// read student info from search field
		String nameToSearch = request.getParameter("name");
		
		String[] names = nameToSearch.split("\\s+");
		
		PrintWriter out = response.getWriter();
		
		if(names.length > 2){
			out.println("<h2> Please enter either first or both first and last names </h2>");
		} else {
			// get employees from dao
			List<Employee> listOfEmployees = employeeDao.getEmployees(names);
			// add employees to the request
			request.setAttribute("SEARCH_RESULT", listOfEmployees);

			// send to the jsp page
			RequestDispatcher dispatcher = request.getRequestDispatcher("/searchedEmployees.jsp");
			dispatcher.forward(request, response);
		}
		
		
		
		
	}

}
