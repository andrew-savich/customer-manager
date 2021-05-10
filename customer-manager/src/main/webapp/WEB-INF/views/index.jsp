<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Manager</title>
</head>
<body>
	<div align="center">
		<h2>Customer Manager</h2>

		<form method="get" action="search">
			<input type="text" name="keyword" /> <input type="submit"
				value="Search" />
		</form>

		<h3>
			<a href="new">New customer</a>
		</h3>
		<table border="1">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>E-mail</th>
				<th>Address</th>
				<th>Actions</th>
			</tr>
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.name}</td>
					<td>${customer.email}</td>
					<td>${customer.address}</td>
					<td>
						<a href="edit?id=${customer.id}">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>