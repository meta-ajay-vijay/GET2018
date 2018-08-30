/**
 * 
 */
package com.metacube.employeeTracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.metacube.employeeTracker.Response.BooleanAndString;
import com.metacube.employeeTracker.dao.daoInterface.EmployeeDaoInterface;
import com.metacube.employeeTracker.model.Employee;


/**
 * @author User1
 *
 */
public class EmployeeDao implements EmployeeDaoInterface {

	public EmployeeDao() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.employeeTracker.dao.daoInterface.EmployeeDaoInterface#
	 * addEmployee(com.metacube.employeeTracker.model.Employee)
	 */
	@Override
	public BooleanAndString addEmployee(Employee employee){
		Connection myConnection = null;
		PreparedStatement myStatement = null;
		BooleanAndString responseObject = new BooleanAndString();
		responseObject.setFlag(true);
		try {
			// get db connection
			myConnection = Connect.getConnection();
			
			// create sql for insert
			String sql = "insert into employee "
					   + "(first_name, last_name, email_id, age) "
					   + "values (?, ?, ?, ?)";
			
			myStatement = myConnection.prepareStatement(sql);
			
			// set the param values for the student
			myStatement.setString(1, employee.getFirstName());
			myStatement.setString(2, employee.getLastName());
			myStatement.setString(3, employee.getEmailId());
			myStatement.setInt(4, employee.getAge());
			
			// execute sql insert
			myStatement.execute();
			
		} catch (SQLException e) {
			responseObject.setFlag(false);
			responseObject.setMessage("Email id is already registered");
		}
		finally {
			// clean up JDBC objects
			close(myConnection, myStatement, null);
		}
		return responseObject;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.employeeTracker.dao.daoInterface.EmployeeDaoInterface#
	 * showEmployees()
	 */
	@Override
	public List<Employee> showEmployees() throws Exception {
		List<Employee> listOfEmployees = new ArrayList<>();

		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myResultSet = null;

		try {
			// get a connection
			myConnection = Connect.getConnection();

			// create sql statement
			String sql = "select * from employee";

			myStatement = myConnection.createStatement();

			// execute query
			myResultSet = myStatement.executeQuery(sql);

			// process result set
			while (myResultSet.next()) {

				// retrieve data from result set row
				int id = myResultSet.getInt("employee_id");
				String firstName = myResultSet.getString("first_name");
				String lastName = myResultSet.getString("last_name");
				String email = myResultSet.getString("email_id");
				int age = myResultSet.getInt("age");

				// create new student object
				Employee temporaryEmployee = new Employee(id, firstName, lastName, email, age);

				// add it to the list of students
				listOfEmployees.add(temporaryEmployee);
			}

			return listOfEmployees;
		} finally {
			// close JDBC objects
			close(myConnection, myStatement, myResultSet);
		}
	}

	private void close(Connection myConnection, Statement myStatement, ResultSet myResultSet) {

		try {
			if (myResultSet != null) {
				myResultSet.close();
			}
			
			if (myStatement != null) {
				myStatement.close();
			}
			
			if (myConnection != null) {
				myConnection.close();
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.employeeTracker.dao.daoInterface.EmployeeDaoInterface#
	 * updateEmployee(com.metacube.employeeTracker.model.Employee)
	 */
	@Override
	public boolean updateEmployee(Employee employee) {
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.metacube.employeeTracker.dao.daoInterface.EmployeeDaoInterface#
	 * getEmployee(java.lang.String[])
	 */
	@Override
	public List<Employee> getEmployees(String[] name) throws SQLException {
		List<Employee> listOfEmployees = new ArrayList<>();

		Connection myConnection = null;
		Statement myStatement = null;
		ResultSet myResultSet = null;
		String firstName = null;
		String lastName = null;
		String sql;
		try {
			// get a connection
			myConnection = Connect.getConnection();
			if(name.length == 1) {
				firstName = name[0];
				sql = "SELECT * from employee WHERE first_name LIKE '"+ firstName + "%'";
			} else {
				firstName = name[0];
				lastName = name[1];
				sql = "SELECT * from employee WHERE first_name = '"+ firstName + "' AND last_name LIKE '"+ lastName + "%'"
						+ "OR first_name LIKE '" + firstName + " " + lastName + "%' ";
			}
			
			// create sql statement
			myStatement = myConnection.createStatement();

			// execute query
			myResultSet = myStatement.executeQuery(sql);

			// process result set
			while (myResultSet.next()) {

				// retrieve data from result set row
				int id = myResultSet.getInt("employee_id");
				firstName = myResultSet.getString("first_name");
				lastName = myResultSet.getString("last_name");
				String email = myResultSet.getString("email_id");
				int age = myResultSet.getInt("age");

				// create new student object
				Employee temporaryEmployee = new Employee(id, firstName, lastName, email, age);

				// add it to the list of students
				listOfEmployees.add(temporaryEmployee);
			}

			return listOfEmployees;
		} finally {
			// close JDBC objects
			close(myConnection, myStatement, myResultSet);
		}

	}

}
