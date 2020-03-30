<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Get All Same Names </title>
</head>
<body>
	<form:form action="getByName" method="post" modelAttribute="student">
		<table>

	<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><input type="reset" name="reset" value="Reset" /></td>
				<td><input type="submit" name="submit" value="Submit" />
				 <a	href="getAll"><input type="button" name="home" value="home" /></a></td>
			</tr>
		</table>

	</form:form>
			
	
</body>
</html>