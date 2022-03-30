<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
	"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>update</title>
</head>
<body>
	<div align="center">
		<h1>Update Contact</h1>
		<form action="update" method="post">
			<table>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name" ></td>
				</tr>
				<tr>
					<td>Phone:</td>
					<td><input type="text" name="phone"
						value=<%=request.getParameter("phone")%> readonly="readonly"></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="submit"
						value="Update"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>