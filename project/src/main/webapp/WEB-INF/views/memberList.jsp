<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	
<!DOCTYPE html>
<!-- 아래 html5 규정  -->
<html lang="ko-kr">
<head>
<meta charset="UTF-8"> 
<title>회원 목록</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
<script language="javascript">

</script> 
</head>
<body>
<br>
<hr>
<h1 align="center"> 회원 목록 </h1>

<hr>
<br><button name="to_main"  style= " float : right ;" onclick="location.href='${pageContext.request.contextPath}/'"> 메인으로</button><br><br>
<table border="1" align="center">
<thead>
<td align="center">가입 순서</td>
<td align="center" width=150>회원 ID</td>
<td align="center" width=120>회원 비밀 번호</td>
<td align="center" width=250>회원 E-mail 주소</td>
<td align="center" width=150> 가입 날짜  </td>
</thead>
<tbody>
<c:forEach items="${memberList}" var="member" varStatus="st"> <!--  controller에서 members로 넘겼다   -->
		<tr>
			<td align="center">${st.count}</td>
			<td> &nbsp;&nbsp;&nbsp; ${member.id}</td>
		    <td>&nbsp;&nbsp; ${member.password}</td>
		     <td>&nbsp;&nbsp; ${member.email}</td>
			<td align="center">${dateList.get(st.index)}</td>
       </tr>	
   	</c:forEach>
 </tbody>
</table>
</body>
</html>

