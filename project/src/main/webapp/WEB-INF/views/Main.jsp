<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<!-- 아래 html5 규정  -->
<html lang="ko-kr">
<head>
<meta charset="UTF-8">
<title>Main</title>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">
<script src="//code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
<script>
	function openWriting() {
		window.open(
				"../writing.do",
				"writing",
				"width=800,height=660,toolbar=no,status=no,location=no,scrollbars=yes,menubar=no,resizable=yes,left=50,right=50");
	}
	function openRegister() {
		window.open(
				"../memberRegister.do",
				"memberRegister",
				"width=400,height=400,toolbar=no,status=no,location=no,scrollbars=yes,menubar=no,resizable=yes,left=50,right=50");
	}
	function logout() {
		location.href = "../logout";
		alert('로그아웃 되었습니다')
	}
	function referWriting(w_no) {
		window.open(
				"../writingDetail.do?w_no=" + w_no,
				"writing",
				"width=1100,height=1000,toolbar=no,status=no,location=no,scrollbars=yes,menubar=no,resizable=yes,left=50,right=50");
	}
</script>
<style>
button{
border-radius : 10px ;
}
input[type=button]{
border-radius : 10px ;
}
input[type=submit]{
border-radius : 10px ; 
}
table {
  border-collapse: separate;
  border-spacing: 0 15px;
}
</style>
</head>
<body style="margin : 30px;  ;background-image: url('../resources/images/notebook.jpg');background-size: 95% ; ">
<br><br><br>
	<%-- ${writingList.get(0)} &nbsp;&nbsp;현재 접속자 세션 ID 정보 : ${sessionScope.login.id}&nbsp;&nbsp;
	<br>
	<!-- 인자들 -->
	<div>
		총 게시글 수 : ${pageInfo.listCount}&nbsp; 현재 페이지 : ${pageInfo.page}&nbsp;
		&nbsp;총 페이지 : ${pageInfo.maxPage}&nbsp; 시작 페이지 : ${pageInfo.startPage}&nbsp;
		&nbsp;끝 페이지 : ${pageInfo.endPage}&nbsp;한 페이지당 보여줄 게시물수 : ${limit}
	</div> --%>
	<h1 align="center">
		<a href="${pageContext.request.contextPath}/boardList.do/1"> 노트북 평가 커뮤니티 0위 </a>
	</h1>
	<hr><!-- 네비게이션 시작 -->
	<div id="navi" style="width:100%  ; ">
	<div style="float:left; width: 30%; " >
		<c:if test="${sessionScope.login.id =='fany305'}">
		관리자 모드 입니다 &nbsp;
			<button type="button" onclick="location.href='../memberList.do'">회원목록으로</button> &nbsp;
			<button type="button" onclick="location.href= '../truncateAll'">모든 게시글 삭제</button>
		</c:if>
	</div>
		<c:choose>
			<c:when test='${not empty sessionScope.login}'>
						<div style="float : right" align="right">
						<a style="color : purple ;""> ${sessionScope.login.id}</a> &nbsp; 님 접속중입니다.
					<input type="button" value="로그아웃" onclick="logout()">
					</div>
			</c:when>
		<c:otherwise>
	      <div style="float : right; algin : right" align="right">
				<form method="post" action="${pageContext.request.contextPath}/user/loginCheck">
				<font color="red" >로그인</font>을 하면 글쓰기가 가능합니다. &nbsp;&nbsp;&nbsp;
					<input type="text" name="id" placeholder="아이디" value="fany305"></input>
					<input type="password" name="password" placeholder="패스워드" value="ghks1217"></input>
				    <input type="submit" value="로그인"></input>
			  &nbsp;<input type="button" value="회원가입" onclick="openRegister()"></input>&nbsp;
				</form>
			</div>
			</c:otherwise>
		</c:choose>

	</div> <!-- 네비게이션 끝 -->
	<br>
	<hr>
	<br>
	<c:if test='${not empty sessionScope.login }'>
	<div style="float : left ; width : 70% ; text-align : right ; background : activeborder ;" >
	<input style=" "  type="button" value="글쓰기" onclick="openWriting()">
	</div>
	</c:if>
	<!-- 검색 부분  -->
	 <form style="text-align:right" name="searchForm" method="post" action="${pageContext.request.contextPath}/boardList.do/1">
              검색 조건 :  <select name="searchOption">
            <!-- 검색조건을 검색처리후 결과화면에 보여주기위해  c:out 출력태그 사용, 삼항연산자 -->
            <option value="id"  >이름</option>
            <option value="content"  >내용</option>
            <option value="title"  >제목</option>
        </select>
        <input name="keyword"  placeholder="검색어를 입력하세요">
        <input type="submit" value="검색">
    </form>
	 &nbsp;&nbsp;
	<section id="listForm" style="width: 900; margin: auto;">
		<c:if test="${not empty writingList && pageInfo.listCount > 0}">
			<!-- 게시판 리스트 시작 -->
			<table  align="center" style=" border : 0 ; align:center ; padding : 10 0 0 0 ;  " >
				<thead>
					<tr style="background-color: silver;">
						<td align="center" width=85>목록 번호</td>
						<td align="center" width=80>글 번호</td>
						<td align="center" width=150>제품 사진</td>
						<td align="center" width=300>모델명</td>
						<td align="center" width=360>제 목</td>
						<td align="center" width=150>글 쓴 이</td>
						<td align="center" width=250>작성 날짜</td>
						<td align="center" width=70>조회수</td>
						<td align="center" width=85>평가점수</td>
					</tr>
				</thead>
				<tbody>
					<!--  controller에서 로 넘겼다   -->
					<c:forEach items="${writingList}" var="writingList" varStatus="st">
						<tr>
							<td align="center">${st.count}</td>
							<td align="center">${writingList.w_no}</td>
							<td align="center">
							<c:if test="${not empty writingList.thumbnail_name}"> 
							 <img src="<c:url value='/image/thumbnail/${writingList.thumbnail_name}'/>" />
					        </c:if>
							<c:if test="${empty writingList.thumbnail_name}"> 사진 없음 </c:if></td>
							<td align="center">${writingList.model_name}</td>
							<td>&nbsp;&nbsp;&nbsp;<a href="#" onclick="referWriting('${writingList.w_no}');">
									${writingList.title}</a>&nbsp;&nbsp;<span style="color:blue;">(${writingList.reply_count})</span></td>
							<td align="center">&nbsp;&nbsp; ${writingList.id}</td>
							<td align="center">${writingList.w_date}</td>
							<td align="center">&nbsp;&nbsp; ${writingList.viewcnt}</td>
							<td align="center" style=" font-size : 12px ; ">
							<c:if test="${not empty writingList.avg_design_score and writingList.avg_design_score and  writingList.avg_durablity_score }" >
							${writingList.avg_design_score}
							<br>${writingList.avg_prr_score}
							<br>${writingList.avg_durablity_score}
							</c:if>  
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br>
			<!-- 페이징(paging) -->
			<section align="center" id="pageList">
				<c:choose>
					<c:when test="${pageInfo.page <= 1}">
						<!-- 주의) 이 부분에서 bootstrap 페이징 적용시 불가피하게 <a> 기입. <a>없으면 적용 안됨. -->
						<a href="${pageContext.request.contextPath}/boardList.do/1">이전</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/boardList.do/${pageInfo.page - 1}"><button>◀이전</button></a>
					</c:otherwise>
				</c:choose>
				&nbsp;
				<c:forEach var="a" begin="${pageInfo.startPage}"
					end="${pageInfo.endPage}">

					<c:choose>
						<c:when test="${a == pageInfo.page}">
							<!-- 주의) 이 부분에서 bootstrap 페이징 적용시 불가피하게 <a> 기입. <a>없으면 적용 안됨. -->
							<a class="active"
								href="${pageContext.request.contextPath}/boardList.do/${a}">${a}</a>
                               &nbsp;
                            </c:when>
						<c:otherwise>
							<a href="${pageContext.request.contextPath}/boardList.do/${a}">${a}</a>
                                &nbsp;
                            </c:otherwise>
					</c:choose>
				</c:forEach>

				<c:choose>
					<c:when test="${pageInfo.page >= pageInfo.maxPage}">
						<!-- 주의) 이 부분에서 bootstrap 페이징 적용시 불가피하게 <a> 기입. <a>없으면 적용 안됨.
                                                  링크 교정 => page=${pageInfo.page} -->
						<a href="${pageContext.request.contextPath}/boardList.do/${pageInfo.page}">다음</a>
					</c:when>
					<c:otherwise>
						<a href="${pageContext.request.contextPath}/boardList.do/${pageInfo.page + 1}"><button>다음
								▶</button></a>
					</c:otherwise>
				</c:choose>
			</section>

			<!-- 페이징 끝 -->
		</c:if>

		<!-- 등록글 없을 경우 -->
		<c:if test="${empty writingList || pageInfo.listCount==0}">
			<section id="emptyArea" align="center">
				<h4>등록된 글이 없습니다.</h4>
			</section>
		</c:if>
	</section>
</body>
</html>

