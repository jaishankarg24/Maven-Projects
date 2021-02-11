<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.abc.dto.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit Record Page</title>
</head>
<body bgcolor="grey">
	<br>
	<br>
	<%!Student student;%>
	<%
		student = (Student) request.getAttribute("student");
	%>

	<center>
		<form action="./controller" method='post'>

			<table>
				<tr>
					<td>SID</td>
					<td><%=student.getSid()%></td>
					<td><input type="hidden" name="sid"
						value=<%=student.getSid()%>></td>
				</tr>
				<tr>
					<td>SNAME</td>
					<td><input type='text' name='sname'
						value=<%=student.getSname()%>></td>
				</tr>
				<tr>
					<td>SAGE</td>
					<td><input type="text" name='sage'
						value=<%=student.getSage()%>></td>

				</tr>
				<tr>
					<td>SADDRESS</td>
					<td><input type="text" name='saddress'
						value=<%=student.getSaddress()%>></td>

				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value='edit' name='action' /></td>
				</tr>

			</table>


		</form>



	</center>


</body>
</html>