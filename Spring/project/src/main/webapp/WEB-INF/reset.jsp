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
}
input{
margin-bottom:5px}


</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<h1 class="title">RESET YOUR PASSWORD</h1>
	
	<div class="container">
	
		
<div class="register">
	<h1>Reset Password</h1>
	<form class="form-control row" action="/reset/post" method="post">
		<label name="password">Password:</label>
		<input name="password"/>
		
		<label name="confirmpw">Confirm Password:</label>
		<input name="confirmpw"/>
		
		
		<button type="submit" class="btn btn-dark">Reset Password</button>
		</form>
		</div>
</body>
</html>
