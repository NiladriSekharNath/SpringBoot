0<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
	<h1>Enter ID to be Deleted</h1>


	<form:form action="delete" method="post" modelAttribute="student">
		<table>
			<tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id" /></td>
			</tr>
			<tr>
				<td><input type="reset" name="reset" value="Reset" /></td>
				<td><input type="submit" name="submit" value="Delete" />
				 <a	href="getAll"><input type="button" name="home" value="home" /></a></td>
			</tr>
		</table>

	</form:form>


</body>
</html>