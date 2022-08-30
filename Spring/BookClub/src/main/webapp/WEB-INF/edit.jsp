<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Share</title>
</head>
<body>
<h1>Add a Book to Your Shelf!!</h1>
<a href="/books">back to the shelves</a>
	<form:form action="/postedit/" method="post" modelAttribute="book">
		<form:label path="title">Title: </form:label>
		<form:input path="title" value="${book.title}"/>
		<form:errors path="title"/>
		
		<form:label path="author">Author: </form:label>
		<form:input  path="author" value="${book.author}"/>
		<form:errors path="author"/>
		
		
		<form:label path="thought">My thought: </form:label>
		<form:input path="thought" value="${book.thought}"/>
		<form:errors path="thought"/>
		
		<form:input  type="hidden" path="id" value="${book.id}"/>
		<form:input  type="hidden" path="posted" value="${user.name}"/>
		<form:errors path="posted"/>
		
		<button type="submit">Submit</button>
		</form:form>
		
</body>
</html>