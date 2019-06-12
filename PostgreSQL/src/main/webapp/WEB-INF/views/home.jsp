<%@ page session="false"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css" media="screen" />
<script src="${pageContext.request.contextPath}/resources/js/home.js"></script>
<title>Home</title>
</head>
<body>
	<button id="goWrite">글쓰기로 이동</button>
	<button id="truncate">truncate</button>
	<p id="time">The time on the server is ${serverTime}.</p>

	<table id="table_list" border="1">
		<thead>
			<tr>
				<th><input type="checkbox" id="allCheck"></th>
				<th>fore each index</th>
				<th>게시글 번호</th>
				<th>사용자 아이디</th>
				<th width="15">제목</th>
				<th>내용</th>
				<th>날짜</th>
				<th>날짜 포맷 변환</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="board_list" items="${board_list}" varStatus="status">
				<tr>
					<td><input type="checkbox" class="check" id=""></td>
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
		
	</script>
</body>
	</html>