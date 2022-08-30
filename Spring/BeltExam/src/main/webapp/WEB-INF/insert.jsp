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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<style>
body{
padding: 2% 10%}

.bot-but{
margin-top: 20px;
display:flex;
justify-content: flex-end;
}

a{
margin-right: 20px}

</style>
<title>Create a course</title>
</head>
<body>
<h1>Create a Course</h1>

	<form:form class="form-control row" action="/postcourse" method="post" modelAttribute="course">
		<form:label path="name">Name: </form:label>
		<form:input path="name"/>
		<form:errors path="name"/>
		
		<form:label path="dayOfWeek">Day of Week: </form:label>
		<form:select path="dayOfWeek">
			<form:option value="Mon" path="dayOfWeek">
				<c:out value="Monday"/>
			</form:option>
			<form:option value="Tues" path="dayOfWeek">
				<c:out value="Tuesday"/>
			</form:option>
			<form:option value="Wed" path="dayOfWeek">
				<c:out value="Wednesday"/>
			</form:option>
			<form:option value="Thu" path="dayOfWeek">
				<c:out value="Thursday"/>
			</form:option>
			<form:option value="Fri" path="dayOfWeek">
				<c:out value="Friday"/>
			</form:option>
			<form:option value="Sat" path="dayOfWeek">
				<c:out value="Saturday"/>
			</form:option>
			<form:option value="Sun" path="dayOfWeek">
				<c:out value="Sunday"/>
			</form:option>
	</form:select>
		
		<form:label path="price">Drop-in Price </form:label>
		<form:input  path="price"/>
		<form:errors path="price"/>
		
		
		<form:label path="description">Description: </form:label>
		<form:input path="description"/>
		<form:errors path="description"/>
		
		
		<form:input  type="hidden" path="instructor" value="${user.name}"/>
		<div class="bot-but"><a href="/classes" class="btn btn-dark">Cancel</a>
		<button type="submit" class="btn btn-dark">Submit</button></div>
		
		</form:form>
		
</body>
</html>