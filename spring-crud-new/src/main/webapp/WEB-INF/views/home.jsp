<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<%@ page isELIgnored="false" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<div >
		<h1>List</h1>
		<table border="1">
			<tr>
				<th>Name</th>
				<th>Phone</th>
				<th>Action</th>
			</tr>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>${user.get('name')}</td>
					<td>${user.get('phone')}</td>
					<td><a href="get?phone=${user.get('phone')}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?phone=${user.get('phone')}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>
		<h1>Add Users</h1>
		<form action="add" method="post">
		<table>
			<tr>
				<td>Name:</td>
				<td><input type="text" name="name" size="15"/></td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td><input type="text" name="phone" size=10></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="add"></td>
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
