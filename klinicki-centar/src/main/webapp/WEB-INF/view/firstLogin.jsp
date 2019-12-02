<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
		<title>Prvi put ulogovan administrator</title>
		<link rel="stylesheet" href="/bootstrap-3.3.7/css/bootstrap.min.css"/>
	</head>
	<body>
		
		<div th:if = "${info}" class="alert alert-danger" th:text = "${info}"></div>
		
		<h1 th:text = "'Hello: ' + ${admin.name}"></h1>
		<h1 th:text = "'Ovo je Vasa stara lozinka:' + ${admin.password}"></h1>
		<h1>Molimo Vas izmenite Vasu lozinku!</h1>
		<form th:action="@{'/fanzone/profile/' + ${admin.id} + '/editpassword'}" th:object="${admin}" th:method="PUT">
			<table>
				
				<tr>
					<td><strong>Password: </strong></td>
					<td><input type="text" th:field="*{password}" required/></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type = "submit" value="Izmeni">
						<input type = "hidden" th:field="*{id}">
					</td>
				</tr>
			</table>
		</form>
		<script src="/scripts/jquery-3.2.1.min.js"></script>
		<script src="/bootstrap-3.3.7/bootstrap.min.js"></script>
	</body>