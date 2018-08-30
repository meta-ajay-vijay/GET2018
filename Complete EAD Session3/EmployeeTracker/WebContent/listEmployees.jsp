<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees list</title>
</head>
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
					<th>Action</th>
				</tr>

				<c:forEach var="temporaryEmployee" items="${EMPLOYEE_LIST}">

				<c:url var="temporaryLink" value="ShowEmployeesServlet">
					<c:param name="command" value="LOAD" />
					<c:param name="employeeId" value="${temporaryEmployee.id}" />
				</c:url>

				<tr>
					<td>  ${temporaryEmployee.id } </td>
					<td> ${temporaryEmployee.firstName }</td>
					<td> ${temporaryEmployee.lastName }</td>
					<td> ${temporaryEmployee.emailId }</td>
					<td> ${temporaryEmployee.age }</td>
					<td> <a href="${temporaryLink}">Update</a> </td>
				</tr>

				</c:forEach>
			</table>
		</div>

	</div>

</body>
</html>