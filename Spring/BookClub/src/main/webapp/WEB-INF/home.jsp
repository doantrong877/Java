<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="/css/style.css">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
	<h1>Welcome, <c:out value="${user.name}"></c:out>!</h1>
	<p>Books from everyone's shelves:</p>
	
	<a href="/logout">logout</a>
	<a href="/books/new">+ Add a book to my shelf!</a>
	
	<table class="table">
	<tr>
	<th>ID</th>
	<th>Title</th>
	<th>Author Name</th>
	<th>Posted By</th>
	</tr>
	<c:forEach var="book" items="${books}">
		<tr>
		<td> <c:out value="${book.id}"></c:out></td>
		<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
		<td><c:out value="${book.author}"></c:out></td>
		<td><c:out value="${book.posted}"></c:out></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>