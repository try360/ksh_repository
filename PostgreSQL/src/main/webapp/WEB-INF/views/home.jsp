<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<html>
<head>
<title>Home</title>
</head>
<body>
     <button onclick="location='${pageContext.request.contextPath}/insert/write'">글쓰기로 이동</button>
	<p id="time">The time on the server is ${serverTime}.</p>

	<div id="animate_test">여기는 animate test</div>
	<br>
	<br>
	<form id="fowardForm" style="background-color: yellow">
		<input type="text" name="text1"> <br> <select
			name="select1">
			<option selected disabled>보낼 값을 선택하세요
			<option>
			<option value="1">1
			<option>
			<option value="2">2
			<option>
			<option value="3">3
			<option>
		</select> <br>
		<button id="submit">전송</button>
	</form>

<table>
<thead>
</thead>
<tbody>
	<c:forEach var="item" items="${list.board}" varStatus="status">
	
	
	</c:forEach>
</tbody>
</table>

	<script>
		$(function() {
			$('#time').on('mouseover', function() {
				$(this).css({
					color : 'red'
				});
			});
			$('#time').on('mouseout', function() {
				$(this).css({
					backgroundColor : 'white',
					color : 'black'
				});

			});
			$('#time').click(function() {
				$(this).css('background-color', 'gold');
			});

		})

		$('#submit').click(function() {
			$.ajax({
				url : "${pageContext.request.contextPath}/Insert/getData", // 클라이언트가 요청을 보낼 서버의 URL 주소
				data : $('#fowardForm').serialize(), // HTTP 요청과 함께 서버로 보낼 데이터
				type : "post",
				dataType : "text",
				success : function() {
					alert(" 데이터 보내기 성공");
				}

			});
		})
	</script>
</body>
</html>
