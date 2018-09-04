<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<form action="register" id="registrationForm" method = 'post'>
		<table>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="first_name" id="first_name" required></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="last_name" id="last_name" required></td>
			</tr>
			<tr>
				<td>Age</td>
				<td><input type="text" name="age" id="age" required></td>
			</tr>
			<tr>
				<td>Date Of Birth</td>
				<td><input type="date" name="dob" id="dob" required></td>
			</tr>
			<tr>
				<td>Mobile</td>
				<td><input type="text" name="contact" id="contact" required></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" id="email" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="password"
					required></td>
			</tr>
			<tr>
				<td>Confirm Password</td>
				<td><input type="password" name="confirm_password"
					id="confirm_password" required></td>
			</tr>
			<tr>
				<td>Organization</td>
				<td><select name="organization">
						<option value="select">Select</option>
						<option value="Metacube">Metacube</option>
						<option value="Google">Google</option>
						<option value="Amazon">Amazon</option>
						<option value="Facebook">Facebook</option>
						<option value="Apple">Apple</option>
				</select></td> 
			</tr>
		</table>
		<input type="submit" value="Create Account">
	</form>
<% 
String message = (String)request.getAttribute("message");
try{
if(message.length()>1){
	out.println("<script> alert(\"" + message + "\""+")</script>" );
}
}catch(Exception e){}
%>


</body>
</html>