<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
세션 ID 정보:   ${sessionScope.login.id}
<br>
세션 정보  :   ${sessionScope.login}

<script type="text/javascript">
alert(" 환영합니다. ${sessionScope.login.id} 님 "); // " " 안에 el태그 바로 가능
self.location="${pageContext.request.contextPath}/"; 

// 이 jsp가 읽히면 다음 경로로 이동
</script>
</body>
</html>