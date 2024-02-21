<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

 <%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="index.jsp">Add New Record</a>
	<table border="1">
		<thead>
			<tr>
				<td>S.No</td>
				<td>UserName</td>
				<td>UserEmails</td>
				<td>UserPhno</td>
				<td>Action</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" varStatus="index">
				<tr>
					<td>${index.count}</td>
					<td>${user.userName}</td>
					<td>${user.userEmail}</td>
					<td>${user.userPhno}</td>
<%-- 					 <a href="/edit?id=<c:out value='${book.id}' />">Edit</a> --%>
					<td><a href="#?id=<c:out value='${index.count}' />">Edit</a></td> &nbsp;
					<td><a href="#">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>