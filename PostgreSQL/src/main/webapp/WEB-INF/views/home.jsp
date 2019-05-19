<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<html>
<head>
<title>Home</title>
<style>
td{
text-align : center ;
}
thead{
background-color : purple ;
}
#table_list{
left : 40px ;
}
input[type=checkbox]{
height : 20px;
width : 20px;
}
</style>
</head>
<body>
     <button onclick="location='${pageContext.request.contextPath}/insert/write'">글쓰기로 이동</button>
     <button id="btn_truncate">truncate</button>
	  <p id="time">The time on the server is ${serverTime}.</p>

<table id="table_list" border="1" >
<thead>
        <tr> 
             <td><input type="checkbox"></td>
             <td>fore each index</td>
             <td>게시글 번호</td>
             <td>사용자 아이디</td>
             <td>제목</td>
             <td>내용</td>
             <td>날짜</td>
             <td>날짜 포맷 변환</td>
          </tr>
</thead>
<tbody>
	<c:forEach var="board_list" items="${board_list}" varStatus="status">
		   <tr>
		     <td><input type="checkbox"></td>
		     <td>${status.index}</td>
		     <td>${board_list.board_id}</td>
		     <td>${board_list.user_id}</td>
		     <td>${board_list.title}</td>
		     <td>${board_list.content}</td>
		     <td>${board_list.insert_date}</td>
		     <td>${board_list.insert_date}</td>
		   </tr>
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
					window.location.href="${pageContext.request.contextPath}/home"
				}

			});
		})
	</script>

</body>
</html>
