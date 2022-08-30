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
<title>Read Share</title>
</head>
<body>
	<h1>${book.title}</h1>
	<a href="/books">back to the shelves</a>
	<h3><span style="color:red">${book.posted}</span> read <span style="color:purple">${book.title}</span> by <span style="color:green">${book.author}.</span></h3>
	<p>Here are ${book.posted}'s thoughts: </p>
	<hr>
	<p>${book.thought}</p>
	<hr>
	<c:set var = "userId" value = "${user.name}"/>
	<c:set var = "post" value = "${book.posted}"/>
	<c:if test = "${userId.equals(post)}">
	<a href="/books/${book.id}/edit">edit</a>
	</c:if>
	<c:if test = "${!userId.equals(post)}">
	<a href="/edit" style="pointer-events: none">edit</a>
	</c:if>
</body>
</html>