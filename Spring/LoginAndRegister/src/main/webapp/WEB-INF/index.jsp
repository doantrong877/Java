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
<style>
form{
display: flex;
flex-direction:column;
}
.container{
display: flex;
justify-content: space-evenly;
}
</style>
</head>
<body>
	<h1>Welcome!</h1>
	<p>Join our growing community</p>
	
	<div class="container">
	<div class="register">
	<h1>Register</h1>
	<form:form action="/register" method="post" modelAttribute="newUser">
		<form:label path="userName">User Name: </form:label>
		<form:input path="userName"/>
		<form:errors path="userName"/>
		
		<form:label path="email">Email: </form:label>
		<form:input path="email"/>
		<form:errors path="email"/>
		
		
		<form:label path="password">Password: </form:label>
		<form:input path="password"/>
		<form:errors path="password"/>
		
		<form:label path="confirm">Confirm PW: </form:label>
		<form:input path="confirm"/>
		<form:errors path="confirm"/>
		
		<button type="submit">Submit</button>
		</form:form>
		</div>
		
		<div class="login">
	<h1>Login</h1>
	<form:form action="/login" method="post" modelAttribute="newLogin">
		
		<form:label path="email">Email: </form:label>
		<form:input path="email"/>
		<form:errors path="email"/>
		
		
		<form:label path="password">Password: </form:label>
		<form:input path="password"/>
		<form:errors path="password"/>
		

		<button type="submit">Submit</button>
		</form:form>
		</div>
	</div>
</body>
</html>