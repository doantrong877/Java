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
<title>Insert title here</title>
</head>
<body>
<h1>New Ninja</h1>
	<form:form action="/postninja" method="post" modelAttribute="ninja"> 
	
	<form:label path="dojo">Dojo</form:label>
	<form:select path="dojo">
		<c:forEach var="dojo" items="${dojos}">
			<form:option value="${dojo.getId()}" path="dojo">
				<c:out value="${dojo.getName()}"/>
			</form:option>
		</c:forEach>
	</form:select>
	
	<form:label path="firstName">First Name</form:label>
	<form:input path="firstName"/>
	
	<form:label path="lastName">Last Name</form:label>
	<form:input path="lastName"/>
	
	<form:label path="age">Age</form:label>
	<form:input path="age"/>
	<button type="submit">create</button>
	</form:form>
</body>
</html>