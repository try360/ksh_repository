<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <fmt:parseDate var="dateString" value="${w_date}" pattern="yyyy-MM-dd hh:mm:ss" />  
날짜 : 		<fmt:formatDate value="${dateString}" type="date" pattern="yyyy-MM-dd hh:mm:ss" />  --%>

<Br>
<table>
<c:forEach items="${writingList}" var="writing" varStatus="st"> <!--  controller에서 members로 넘겼다   -->
		<tr>
			<td align="center">${st.count}</td>
			<td>${writing.title}</td>
		    <td>${writing.content}</td>
			 <td>asdf${w_dateList.get(st.index)}</td>
			<%-- <fmt:parseDate var="dateString" value="${writing.w_date}" pattern="yyyy-MM-dd hh:mm:ss" />   --%>
			<%-- <fmt:formatDate value="${w_dateList.get(0)}" type="date" pattern="yyyy-MM-dd hh:mm:ss"  /></td>  --%>
       </tr>	
   	</c:forEach>
<%-- <fmt:parseDate var="dateString" value="${w_date}" pattern="yyyy-MM-dd hh:mm:ss" />  
날짜 : 		<fmt:formatDate value="${dateString}" type="date" pattern="yyyy-MM-dd hh:mm:ss" /> --%>
</table>
</body>
</html>