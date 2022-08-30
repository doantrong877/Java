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

	<h1><c:out value="${course.name}"></c:out> with <c:out value="${course.instructor}"></c:out></h1>
		<p>Day: <c:out value="${course.dayOfWeek}"></c:out></p>
		<p>Cost: $<c:out value="${course.price}"></c:out></p>
		<p><c:out value="${course.description}"></c:out></p>
</body>
</html>