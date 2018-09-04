<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import = "java.util.*,com.metacube.userLogin.view.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src ='./script/profile.js' ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1 align = 'center'>Friend List</h1>

<% 
List<UserFriendView> listOfFriends = (List)request.getAttribute("friend_list");
%>

<%for(UserFriendView userFriendView:listOfFriends){ %>

<div>
	<form id="form_login" name="loginform" action='login' method = 'post' >
		<table align="center" cellpadding="10" cellspacing="20">
			<tr>
				<th>Name</th>
				<td><% out.print(userFriendView.getName()); %></td>
			</tr>
			<tr>
				<th>Age</th>
				<td><% out.print(userFriendView.getAge()); %></td>
			</tr>
			
			<tr>
				<th></th>
				
				<td><input type = 'hidden' value = '<%out.print(userFriendView.getEmail());%>' name = 'friend_email'/></td>
			</tr>

				<tr>
					<th>showInfo</th>

					<td><input type='submit' value='show profile'></td>
				</tr>


			</table>

	</form>
</div>
<%} %>

</body>
</html>