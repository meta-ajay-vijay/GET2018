<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Employee</title>
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>Please fill the following details</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Search Employee</h3>
		
		<form action="SearchEmployeeServlet" method="GET">	
			<table>
				<tbody>
					<tr>
						<td><label>Search by name:</label></td>
						<td><input type="text" name="name" required/></td>
					</tr>
										
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Search" /></td>
					</tr>
				</tbody>
			</table>
			
			<input type="button" value="Show Employees"
				onclick="window.location.href='ShowEmployeesServlet'">
			<input type="button" value="Home"
				onclick="window.location.href='index.jsp'">
		</form>
		
	</div>

</body>
</html>