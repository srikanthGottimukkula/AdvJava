<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UserDetailServlet</title>
</head>
<body>
	<%
	String msg = (String) request.getAttribute("msg");
	if (msg != null) {
		out.print(msg);
	}
	%>
	<form action="users" method="POST">
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<td>UserEmail:</td>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td>UserPhno:</td>
				<td><input type="number" name="phno"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form>
	<a href="users">view Users</a>
</body>
</html>