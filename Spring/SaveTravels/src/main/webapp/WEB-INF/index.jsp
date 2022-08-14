<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Read Share</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
	<h1>Read Share</h1>
	<table class="table">
	<tr>
	<th>Expense</th>
	<th>Vendor</th>
	<th>Amount</th>
	<th>Action</th>
	</tr>
	
	<c:forEach var="travel" items="${travels}">
		<tr> 
			<td><a href="/expenses/${travel.getId()}">${travel.getExpense()}</a></td>
			<td>${travel.getVendor()}</td>
			<td>$<span>${travel.getAmount()}</span></td>
			<td><a href="/expenses/edit/${travel.getId()}">edit</a> <a href="/delete/${travel.getId()}">delete</a></td>
		</tr>
	</c:forEach>
	</table>
	
	<div class="form-div">
	<h2>Add an expense:</h2>
		
		<form:form action="/create" method="post" modelAttribute="form">
			<div class="box">
			<form:label path="expense">Expense Name: </form:label>
			<form:input path="expense"/>
			<form:errors path="expense"/>
			</div>
			<div class="box">
			<form:label path="vendor">Vendor: </form:label>
			<form:input path="vendor"/>
			<form:errors path="vendor"/>
			</div>
			<div class="box">
			<form:label path="amount">Amount: </form:label>
			<form:input path="amount"/>
			<form:errors path="amount"/>
			</div>
			<div class="box">
			<form:label path="description">Description: </form:label>
			<form:textarea path="description"></form:textarea>
			<form:errors path="description"/>
			</div>
			<button type="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>