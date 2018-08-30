<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.*, com.metacube.employeeTracker.servlets.*, com.metacube.employeeTracker.model.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees list</title>
</head>

<%
	// get the students from the request object (sent by servlet)
	List<Employee> listOfEmployees = 
					(List<Employee>) request.getAttribute("EMPLOYEE_LIST");
%>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>List of Employees</h2>
		</div>
	</div>

	<div id="container">

		<div id="content">

			<input type="button" value="Home"
				onclick="window.location.href='index.jsp'"> 
			<input type="button" value="Add Employee"
				onclick="window.location.href='addEmployee.jsp'"> 
			<input type="button" value="Search Employee"
				onclick="window.location.href='searchEmployee.jsp'">
			<table>

				<tr>
					<th>Id</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Age</th>
				</tr>

				<% for (Employee temporaryEmployee : listOfEmployees) { %>

				<tr>
					<td><%= temporaryEmployee.getId() %></td>
					<td><%= temporaryEmployee.getFirstName() %></td>
					<td><%= temporaryEmployee.getLastName() %></td>
					<td><%= temporaryEmployee.getEmailId() %></td>
					<td><%= temporaryEmployee.getAge() %></td>
				</tr>

				<% } %>

			</table>
		</div>

	</div>

</body>
</html>