<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import ="java.util.*,com.metacube.userLogin.view.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src ='./script/profile.js' ></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 

ProfileView profileView = (ProfileView)request.getAttribute("profile_data");
String visibility = (String)request.getAttribute("visibility");

%>


<h1 align = 'center'>Profile Page</h1>

<img src = <%out.println("'"+profileView.getImageUrl()+"'"); %> alt = '' width = '200px' align = 'right' style = 'margin-right:300px;'>

<div style = "display:<%out.print(visibility);%>">
<form action = "image" enctype="multipart/form-data" method = "post">
<input type = 'file' name = 'image' id = 'image' accept="image/png,image/jpeg">
<input type= 'submit' value = 'submit'>
</form>
</div>

<div id = 'user_profile_container' style = "display:block;">
	<form id="form_login" name="loginform" action='editProfileInfo' method= 'post'>
		<table align="center" cellpadding="10" cellspacing="20">
			<tr>
				<th>Name</th>
				<td><%out.print(profileView.getName());%></td>
			</tr>
			<tr>
				<th>Age</th>
				<td><% out.print(profileView.getAge());%></td>
			</tr>
			<tr>
				<th>Contact</th>
				<td><% out.print(profileView.getContact());%></td>
			</tr>
			<tr>
				<th>Organization</th>
				<td><%=profileView.getOrgnization()%></td>
			</tr>
			<tr>
				<td colspan='2'><a href = 'editProfileInfo'><input type='button' value='Edit Info'
					id='edit_info' name='edit' onclick = 'toggleProfileDetailUpdateDIV()' style = "display:<% out.print(visibility); %>" /></a></td>
			</tr>
			
			<tr>
				<td colspan='2'><a href = 'logout'><input type='button' value='Log Out'
					id='log_out' name='log_out'   style = "display:<% out.print(visibility); %>"/></a></td>
			</tr>
			
			<tr>
				<td colspan='2'>
				<a href = 'friends'><input type='button' value='Friends'
					id='friends' name='friends'  style = "display:<% out.print(visibility); %>"/></a></td>
			</tr>
			
			
		</table>
	</form>
</div>


<div id = 'user_profile_edit_container' style = "display:none;">
	<form id="form_login" name="loginform" action='updateInfo'>
		<table align="center" cellpadding="10" cellspacing="20">
			<tr>
				<th>Name</th>
				<td><input type = 'text' id = 'update_name' name = 'update_name' value = '<%out.print(profileView.getName());%>'></td>
			</tr>
			<tr>
				<th>Age</th>
				<td><input type = 'text' id = 'update_age' name = 'update_age' value = '<% out.print(profileView.getAge());%>'></td>
			</tr>
			<tr>
				<th>Contact</th>
				<td><input type = 'text' id = 'update_contact' name = 'update_contact' value = '<% out.print(profileView.getContact());%>'></td>
			</tr>
			<tr>
				<th>Organization</th>
				<td><input type = 'text' id = 'update_org' name='update_org' value = '<% out.print(profileView.getOrgnization()); %>'></td>
			</tr>
			
			<tr>
				<td colspan='2'>
				<input type= 'button' value='cancel' id='cancel' name='cancel' onclick = 'toggleProfileDetailUpdateDIV()' ></td>
			</tr>
			
			<tr>
				<td colspan='2'><input type='submit' value='update'
					id='update' name='update' /></td>
			</tr>
			
			
			
		</table>
	</form>
</div>

<%
String message = (String)request.getAttribute("update_message");
try{
if(message.length()>1){
%>	
<script> alert("<%out.print(message);%>")</script>
<%}
}catch(Exception e){}
%>

<%
String message2 = (String)request.getAttribute("image_message");
try{
if(message2.length()>1){
%>	
<script> alert("<%out.print(message2);%>")</script>
<%}
}catch(Exception e){}
%>


</body>
</html>