<!DOCTYPE html>
<html>

<head>
	<title>Update Employee</title>	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Company</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Update Employee</h3>
		
		<form action="ShowEmployeeServlet" method="GET">	
		
			<input type="hidden" name="command" value="UPDATE" />
			<input type="hidden" name="employeeId" value="${THE_EMPLOYEE.id}" />
			
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" 
						value="${THE_EMPLOYEE.firstName}" required/></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" 
						value="${THE_EMPLOYEE.lastName}" required/></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="email" name="email" 
						value="${THE_EMPLOYEE.emailId}" required/></td>
					</tr>
					
					<tr>
						<td><label>Age:</label></td>
						<td><input type="number" name="age"
						value="${THE_EMPLOYEE.age}" required/></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="Update" /></td>
						<td><input type="button" value="Cancel" onclick="window.location.href='index.jsp'"/></td>
					</tr>
					
				</tbody>
			</table>
			
			<input type="button" value="Show Employees"
				onclick="window.location.href='ShowEmployeesServlet'">
		</form>
		
	</div>
</body>

</html>











