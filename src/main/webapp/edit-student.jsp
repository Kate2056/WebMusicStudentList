<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Student</title>
</head>
<body>
<form action ="editStudentServlet" method="post">
Store: <input type ="text" name ="name" value="${studentToEdit.name}">
Item: <input type ="text" name ="instrument" value="${studentToEdit.instrument}">
<input type ="hidden" name ="id" value="${studentToEdit.id}">
<input type ="submit" value="Save Edited Student">
</form>
</body>
</html>