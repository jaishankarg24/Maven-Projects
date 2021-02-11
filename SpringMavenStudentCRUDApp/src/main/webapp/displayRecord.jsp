<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.abc.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Output Page</title>
<style type="text/css">
	tr{
	background: white;
	}
</style>
</head>
<body bgcolor="grey">
	<br>
	<br>
	<br>
	<%!Student student;%>
	<%
		student = (Student) request.getAttribute("student");
	%>
	<center>
		<h1>Student Record is:</h1>
		<table border="3">
			<tr>
				<td>SID</td>
				<td><%=student.getSid()%></td>

			</tr>
			<tr>
				<td>SNAME</td>
				<td><%=student.getSname()%></td>

			</tr>
			<tr>
				<td>SAGE</td>
				<td><%=student.getSage()%></td>

			</tr>
			<tr>
				<td>SADDRESS</td>
				<td><%=student.getSaddress()%></td>

			</tr>

		</table>
	</center>

</body>
</html>