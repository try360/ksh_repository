<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>sign_up page</title>
</head>
<body>
    <form action="sign_up.do">
        <input type="text" name="id" placeholder="아이디를 입력하세요" required maxlength="">
        <input type="password" id="pass" name="password" placeholder="비밀번호를 입력하세요" required maxlength="">
        <input type="password" id="pass_chk" required>
        <input type="email" name="email_addr" placeholder="" required maxlength="">
        <button type="submit">가입</button>
    </form>

<script>
$(function(){
	
})
</script>
</body>
</html>
