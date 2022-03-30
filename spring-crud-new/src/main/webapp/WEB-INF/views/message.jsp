<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false"%>
<meta charset="ISO-8859-1">
<title>message</title>
</head>
<body>
	<div align="center">
		${msg}
		<h3>
			<a href="${pageContext.request.contextPath}" id=>Home</a>
		</h3>
	</div>
</body>
</html>