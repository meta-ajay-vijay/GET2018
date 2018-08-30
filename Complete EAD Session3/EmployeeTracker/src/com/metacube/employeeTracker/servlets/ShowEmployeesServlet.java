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
			String theCommand = request.getParameter("command");
			
			if(theCommand == null) {
				theCommand = "LIST";
			}
			
			switch(theCommand) {
			case "LIST":
				listEmployees(request, response);
				break;
				
			case "LOAD":
				loadEmployee(request, response);
				break;

			case "UPDATE":
				updateEmployee(request, response);
				break;
				
			default:
				listEmployees(request, response);
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		int id = Integer.parseInt(request.getParameter("employeeId"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		
		Employee theEmployee = new Employee(id, firstName, lastName, email, age);
		
		employeeDao.updateEmployee(theEmployee);
		
		listEmployees(request, response);
	}

	private void loadEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String theEmployeeId = request.getParameter("employeeId");
		
		Employee theEmployee = employeeDao.getEmployee(theEmployeeId);
		
		request.setAttribute("THE_EMPLOYEE", theEmployee);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/updateEmployee.jsp");
		
		dispatcher.forward(request, response);
		
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
