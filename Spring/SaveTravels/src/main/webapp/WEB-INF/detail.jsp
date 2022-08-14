<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Expense</title>
</head>
<body>
	<h1>Expense Details</h1>
	<a href="/expenses">Go back</a>
	
	<div>Expenses Name: <c:out value="${travel.getExpense()}"/> </div>
	<div>Expenses Description: <c:out value="${travel.getDescription()}"/> </div>
	<div>Vendor: <c:out value="${travel.getVendor()}"/> </div>
	<div>Amount Spent: <c:out value="${travel.getAmount()}"/> </div>
</body>
</html>