<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stulesheet" type ="text/css" ref="mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">

::-placeholder { /* 크롬 4–56 */
   color: #9e9e9e;
   opacity:  1;
}
</style>
</head>
<div>
<body>
<form method="post" action="memberRegisterAction.do">
<table >
<tr>
<td>아이디</td>
<td><input type="text" name="id" id="id" size="15"/></td>
</tr>
<tr>
<td>패스워드</td>
<td><input type="text" name="password"  id="password"/></td>
</tr>
<tr>
<td>패스워드 확인</td>
<td><input type="text" name="pwch" id="pwch"/></td>
</tr>
<tr>
<td>이메일</td>
<td><input type="text" name="email" id="email" size="30" placeholder=" abcd123@email.com" /></td>
</tr>
<tr>
<td colspan="2" align="right"> <input type="submit"/></td>
</tr>
</table>
</form>
</div>
</body>
</html>