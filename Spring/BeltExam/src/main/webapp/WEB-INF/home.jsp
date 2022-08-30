<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Project Manager Dashboard</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<style>
body{
padding: 2% 10%}

.top{
display:flex;
justify-content: space-between}
</style>
</head>
<body>
	<div class="top" >
	<div><h1>Welcome, <c:out value="${user.name}"></c:out>.</h1>
	<p>Course Schedule:</p></div>
	<a href="/logout">logout</a>
	</div>
	
	
	
	
	
	<table class="table table-hover">
	<tr class="table-active">
	<th>Class Name</th>
	<th>Instructor</th>
	<th>Weekday</th>
	<th>Price</th>
	
	</tr>
	<c:forEach var="course" items="${courses}">
		<c:set var="userName" value="${user.name}" ></c:set>
		<c:set var="instructor" value="${course.instructor}" ></c:set>
		<c:if test="${!userName.equals(instructor)}">
		<tr>
		<td> <a href="/classes/${course.id}"> <c:out value="${course.name}"></c:out></a></td>
		<td><c:out value="${course.instructor}"></c:out></td>
		<td><c:out value="${course.dayOfWeek}"></c:out></td>
		<td>$<c:out value="${course.price}"></c:out></td>
		</tr>
		</c:if>
		
		<c:if test="${userName.equals(instructor)}">
		<tr>
		<td> <a href="/classes/${course.id}"> <c:out value="${course.name}"></c:out></a> <a href="classes/${course.id}/edit">Edit</a></td>
		<td><c:out value="${course.instructor}"></c:out></td>
		<td><c:out value="${course.dayOfWeek}"></c:out></td>
		<td>$<c:out value="${course.price}"></c:out></td>
		</tr>
		</c:if>
		
	</c:forEach>
	</table>
	<a href="/classes/new" class="btn btn-dark">+ new course</a>
</body>
</html>