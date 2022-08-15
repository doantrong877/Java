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
    <title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body style="padding: 15% 0;display:flex; align-items:center; justify-content:center;">
	<div>
	<ul>
		<li><a href="/dojos/new">Create New Dojo</a></li>
		<li><a href="/ninjas/new">Create New Ninja</a></li>
	</ul>
	</div>
	<form:form action="/dojos/post" method="post" modelAttribute="dojo1"> 
	<form:select path="id">
		<c:forEach var="dojo" items="${dojos}">
			<form:option value="${dojo.getId()}" path="id">
				<c:out value="${dojo.getName()}"/>
			</form:option>
		</c:forEach>
		
	</form:select>
	<button type="submit">Find Dojo</button> 
	</form:form>
</body>
</html>