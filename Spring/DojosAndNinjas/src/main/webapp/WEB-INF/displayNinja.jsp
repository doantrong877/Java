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
<title>Dojo page</title>
</head>
<body>
<h1> <c:out value="${dojo.getName()}"/> Location Ninjas</h1>
	<table class="table">
	<tr>
	<th>First Name</th>
	<th>Last Name</th>
	<th>Age</th>
	</tr>
	<c:forEach var="ninja" items="${ninjas}">
		<tr>
		<td><c:out value="${ninja.getFirstName()}"></c:out></td>
		<td><c:out value="${ninja.getLastName()}"></c:out></td>
		<td><c:out value="${ninja.getAge()}"></c:out></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>