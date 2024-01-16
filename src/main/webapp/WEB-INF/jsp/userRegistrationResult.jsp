<%@page import="beans.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User</title>
</head>
<body>
	<%
	out.println("送信された情報＞");
	UserBean userBean = (UserBean)request.getAttribute("user");
	out.println(userBean);
	out.println("ユーザ登録が完了しました!");
	%>
</body>
</html>