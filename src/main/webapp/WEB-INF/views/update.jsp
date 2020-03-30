<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello everyone</h1>


	<form:form action="update" method="post" modelAttribute="employee">
		<table>
			<tr>
				<td><form:label path="id">Id</form:label></td>
				<td><form:input path="id" /></td>
			</tr>

			<tr>
				<td><form:label path="name">Name</form:label></td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td><form:label path="course">Course</form:label></td>
				<td><form:input path="course"/></td>
			</tr>

			<tr>
				<td><input type="reset" name="reset" value="Reset" /></td>
				<td><input type="submit" name="submit" value="UPDATE" /> <a
					href="getAll"><input type="button" name="home"
						value="home" /></a></td>
			</tr>
		</table>

	</form:form>


</body>
</html>