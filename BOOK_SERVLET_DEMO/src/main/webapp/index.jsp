<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>!! INSERT BOOK INTO DATABASE !!</h3>
	<form action="BookServlet" method="post">
		BookID: 	<input type="text" name="bookId"><br/>
		BookName: 	<input type="text" name="bookName"><br/> 
		BookPrice:	<input type="text" name="bookPrice"><br/>
		 <input type="submit" value="Submit">
	</form>
</body>
</html>