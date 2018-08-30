package com.metacube.employeeTracker.servlets;

import java.io.IOException;
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
 * Servlet implementation class ShowEmployeesServlet
 */
@WebServlet("/ShowEmployeesServlet")
public class ShowEmployeesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmployeeDao employeeDao;
	
	/*@Resource(name="jdbc/employee_connection_pool")
	private DataSource dataSource;*/
	
	
	/* (non-Javadoc)
	 * @see javax.servlet.GenericServlet#init()
	 */
	@Override
	public void init() throws ServletException {
		super.init();
		
		try{
			/*employeeDao = new EmployeeDao(dataSource);*/
			employeeDao = new EmployeeDao();
		}
		catch(Exception e){
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			listEmployees(request, response);
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void listEmployees(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//get employees from dao
		List<Employee> listOfEmployees = employeeDao.showEmployees();
		
		//add employees to the request
		request.setAttribute("EMPLOYEE_LIST", listOfEmployees);
		
		//send to the jsp page
		RequestDispatcher dispatcher = request.getRequestDispatcher("/listEmployees.jsp");
		dispatcher.forward(request, response);
		
	}

}
