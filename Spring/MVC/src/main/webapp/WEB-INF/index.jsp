<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<h1>All Books</h1>
	<table class="table">
	<tr>
	<th>ID</th>
	<th>Title</th>
	<th>Language</th>
	<th># Pages</th>
	</tr>
	
	<c:forEach var="book" items="${books}">
	<tr>
	<td><c:out value="${book.getId()}"/></td>
	<td><a href="/books/${book.getId()}"><c:out value="${book.getTitle()}"/></a></td>
	<td><c:out value="${book.getLanguage()}"/></td>
	<td><c:out value="${book.getNumberOfPages()}"/></td>
		</tr>
	</c:forEach>


	</table>
	
	
</body>
</body>
</html>