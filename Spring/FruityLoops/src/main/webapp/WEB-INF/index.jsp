<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Fruit Store</h1>
	<table class="table">
	<tr>
	<th>Name</th>
	<th>Price</th>
	</tr>
	<c:forEach var="fruit" items="${fruits}">
		<tr>
		<td><c:out value="${fruit.getName()}"></c:out></td>
		<td><c:out value="${fruit.getPrice()}"></c:out></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>