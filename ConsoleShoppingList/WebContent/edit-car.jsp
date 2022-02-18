<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Car</title>
</head>
<body>
<form action="editCarServlet" method="post">

Model:<input type="text" name="model" value="${itemToEdit.model}">
Color: <input type="text" name="color" value="${itemToEdit.color}">
Amount:<input type="text" name="amount" value="${itemToEdit.amount }">
<input type = "hidden" name="id" value="${itemToEdit.id }">
<input type="submit" value="Save Edited Item">

</form>




</body>
</html>