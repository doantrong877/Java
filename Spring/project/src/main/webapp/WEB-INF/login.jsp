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
<title>Login</title>
<style>
.title{
text-align:center;
margin-bottom:5%;}
.container{
display: flex;
justify-content: center;
}
.login{
margin-left:5%}

.link{
display:flex;
justify-content: space-between;
margin-bottom: 5px;
}
input{
margin-bottom:5px}

.but{
margin-top: 10px;}

</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<h1 class="title">Login Page</h1>
	
	<div class="container">
	
		
		<div class="login">
	<h1>Login</h1>
	<form:form class="form-control row"  action="/login" method="post" modelAttribute="login">
		
		<form:label path="email">Email: </form:label>
		<form:input path="email"/>
		<form:errors path="email"/>
		
		
		<form:label path="password">Password: </form:label>
		<form:input type="password" path="password"/>
		<form:errors path="password"/>
		
		<div class="link">
		<a href="/register">Register</a>
		<a href="/resetpw">Reset Password</a>
		</div>
		
		<div class="but"><button type="submit" class="btn btn-dark">Login</button></div>
		
		</form:form>
		</div>
	</div>
</body>
</html>