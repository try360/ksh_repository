<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<html>
<head>
<title>login page</title>
</head>
<body>
	<input type="button" id="login" onclick="location.href='${pageContext.request.contextPath}/list_board'" value="login">
	<input type="button" id="sign_up" onclick="location.href='${pageContext.request.contextPath}/sign_up'" value="sign up"> 
	<script>
		
	</script>
</body>
</html>
