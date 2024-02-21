<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>BookServelt</title>
</head>
<body>
<form action="BookServlet" method="post">
BookId: <input type="number" name="bookId"><br/>
bookName: <input type="text" name="bookName"><br/>
bookPrice: <input type="text" name="bookPrice"><br/>
<input type="submit" value="submit">
</form>
</body>
</html>