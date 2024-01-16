
<%@page import="beans.ConcreteBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="beans.EmployeeBean"%>
<%@page import="beans.UserBean"%><%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//変数の取得
List<EmployeeBean> employeeList = (ArrayList<EmployeeBean>)request.getAttribute("employeeList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>社員一覧</title>
</head>
<body>
	<h1>社員一覧</h1>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>AGE</th>
			<th>DEPARTMENT</th>			
		</tr>
		<% for(EmployeeBean employee : employeeList){ %>
		<tr>
			<td><% out.print(employee.getId());%></td>
			<td><% out.print(employee.getName());%></td>
			<td><% out.print(employee.getAge());%></td>
			<td><% out.print(employee.getDepartment());%></td>
		</tr>
		<% } %>
	</table>
</body>
</html>