<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit My Task</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>
	<div class="form-div">
	<h2>Edit Expense</h2>
	<a href="/">Go back</a>
		
		<form:form action="/expenses/update" method="post" modelAttribute="form">
			<div class="box">
			<form:label path="expense">Expense Name: </form:label>
			<form:input path="expense" value="${travel.getExpense()}"/>
			<form:errors path="expense"/>
			</div>
			<div class="box">
			<form:label path="vendor">Vendor: </form:label>
			<form:input path="vendor" value="${travel.getVendor()}"/>
			<form:errors path="vendor"/>
			</div>
			<div class="box">
			<form:label path="amount">Amount: </form:label>
			<form:input path="amount" value="${travel.getAmount()}"/>
			<form:errors path="amount"/>
			</div>
			<div class="box">
			<form:label path="description">Description: </form:label>
			<textarea id="myTextArea" onchange="here();"> ${travel.getDescription()} </textarea>
			<form:input name="description" type="hidden" id="content" path="description" value="${travel.getDescription()}"/>
			<form:input name="id" type="hidden" id="id" path="id" value="${travel.getId()}"/>
			<form:errors path="description"/>
			</div>
			<button type="submit">Submit</button>
		</form:form>
	</div>
	<script>
  var text1 = document.getElementById('myTextArea').value;
  function here() {
     text1 = document.getElementById('myTextArea').value;
     document.getElementById("content").value = text1;
  }
</script>
</body>
</html>