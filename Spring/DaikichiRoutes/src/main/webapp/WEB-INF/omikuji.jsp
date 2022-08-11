<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikuji</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<h1>Send a Omikuji!</h1>
	<form  action="/read" method="post">
	<div class="inp" class="mb-3">
	<label class="form-label">Pick any number from 5 to 25</label>
	<input class="form-control" type="number" name="number">
	</div>
	<div class="inp" class="mb-3">
	<label class="form-label">Enter the name of any city</label>
	<input class="form-control" type="text" name="city">
	</div>
	<div class="inp" class="mb-3">
	<label class="form-label">Enter the name of any real person</label>
	<input class="form-control" type="text" name="name">
	</div>
	<div class="inp" class="mb-3">
	<label class="form-label">Enter professional endeavor or hobby</label>
	<input class="form-control" type="text" name="hobby">
	</div>
	<div class="inp" class="mb-3">
	<label class="form-label">Enter any type of living thing</label>
	<input class="form-control" type="text" name="thing">
	</div>
	<div class="inp" class="mb-3">
	<label class="form-label">Say something nice to someone</label>
	<textarea class="form-control" cols="20" rows="10" name="message"></textarea>
	</div>
	<p>Send and show a friend</p>
	<button type="submit">Send</button>
	</form>
</body>
</html>