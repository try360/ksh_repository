<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/insertBoard.js"></script>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form id="insertForm">
<input type="text" name="user_id" ></input>
<br>
<input type="text" name="title" placeholder="제목을 입력하세요"></input>
<br>
<textarea name="content" placeholder="내용을 입력하세요"></textarea>
</form>
<button id="insert_btn">글쓰기</button>
<br>
글쓰기 결과 : <div id="div_writing_result"> </div>
<br>
<button id="go_home">홈으로</button>

<script>

</script>
</body>
</html>