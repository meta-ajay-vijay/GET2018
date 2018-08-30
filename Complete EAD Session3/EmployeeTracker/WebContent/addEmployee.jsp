<!DOCTYPE html>
<html>

<head>
	<title>Add Employee</title>	
</head>

<body>
	<div id="wrapper">
		<div id="header">
			<h2>Please fill the following details</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Add Employee</h3>
		
		<form action="AddEmployeeServlet" method="GET">	
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><input type="text" name="firstName" required/></td>
					</tr>

					<tr>
						<td><label>Last name:</label></td>
						<td><input type="text" name="lastName" required/></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><input type="email" name="email" required/></td>
					</tr>
					
					<tr>
						<td><label>Age:</label></td>
						<td><input type="number" name="age" required/></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="Save" /></td>
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











