<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>평가글 조회</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css">

<script language="javascript">
  
 //일반 함수
 	function listReply(){//댓글 목록 띄우는 함수
	$.ajax({
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		type : "get",
		url : "${pageContext.request.contextPath}/reply/replyListJson.do?writing_no=${writing.w_no}",
		success : function(json) {
			
			var output = "";
	    	var jsonObj = JSON.parse(json); // 증요, json으로 파싱하는 것
	        var login_id = "${sessionScope.login.id}";
	    	
			 for (var i = 0; i < jsonObj.length; i++) { 
			 output += '<tr>';
	  			 output += '<td align="center" style="color : green">';
					 output += (i+1); 
				 output += '</td>';
			     output += '<td align="center">';
				 	output += jsonObj[i].reply_id+'&nbsp' + '&nbsp'; 
				 output += '</td>';
			     output += '<td>';
				 	output += jsonObj[i].reply_comment+'&nbsp' + '&nbsp';
				 output += '</td>';
			     output += '<td style="font-size : 12px ; ">';
				 	output +='디자인 : ' + jsonObj[i].design_score + '점'+'&nbsp' + '&nbsp'+'<br>';
				 	output +='가성비 : ' + jsonObj[i].prr_score + '점'+'&nbsp' + '&nbsp'+'<br>';
				 	output +='내구성 : ' + jsonObj[i].durablity_score + '점'+'&nbsp' + '&nbsp'+'<br>';
				 output += '</td>';
			     output += '<td>';
					 output += jsonObj[i].reply_date;
				 output += '</td>';
			  	 output += '<td align="center">';	
					if(login_id == jsonObj[i].reply_id)
					{output += '<button style="border : 1 ; background-color: #ffffff;"  id="delete_reply" name="delete_reply" onclick="deleteReply(' + jsonObj[i].reply_no + ') ;">';
					output += '<img heigh="15" width="15" src="resources/images/delete_reply.png" /></button>';}	
				 output += '</td>'; 
			 output += '</tr>';
				 
			}// for문닫기
			$("#listReplyTable_TBody").html( // 위에서 한 것들을 아래 html에 집어 넣겠다.
					output
		       		);  
				}//success
			});
 }
 // 댓글쓰는 함수
	function writeReply(){
		var replyForm = $("#replyForm").serialize();
		//serialize() : 입력된 모든Element(을)를 문자열의 데이터에 serialize 한다.
        var replyFormArr =$("#replyForm").serializeArray();
		
		$.ajax({
			type : "post",
			url : "${pageContext.request.contextPath}/reply/insert.do",
			data : replyForm, // 윗 줄같이 인자전달 가능
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
		    dataType: 'html',
			success : function() {
				alert("댓글이 등록되었습니다.");
				listReply(); // 위 함수 호출
			},//success
			error : function() {
				alert("점수 또는 공백이 있는지 확인 하세요 ");
			}
		}); 
	}
	
	//댓글 삭제
		function deleteReply(reply_number){
			var reply_no = reply_number;
	        
			if (confirm("평가댓글을 삭제하시겠습니까 ?"))
			{		
			$.ajax({
				type : "post",
				url : "${pageContext.request.contextPath}/reply/deleteReply.action",
				data : { reply_no : reply_no },
				dataType : 'html',
				success : function(){
					alert(" 성공 " + reply_no);
                  location.href="";				
				},//success
				error : function(){
					alert("전송실패");
				}//error  
			});
			}
			else{ return;}
		}
		
	//팝업창 띄우기
	function updatePopup() {
		var settings = 'toolbar=0, status=0, menubar=0, scrollbars=yes, height=600, width=800';
		var target = '${pageContext.request.contextPath}/to.updateWriting/?w_no='+${writing.w_no};
		window.open(target, '글 수정', settings); 
	} 
	
 //문서가 시작할때 호출
 $(document).ready(function(){
 
	 //게시물 수정 버튼 
  	 $("#correct").click(
  			 function updateReply() {
  		var referForm =$("#referForm").serialize();
  		// serialize() : 입력된 모든Element(을)를 문자열의 데이터에 serialize 한다.	
  	 	$.ajax({
			type : 'post', 
			url : '${pageContext.request.contextPath}/to.updateWriting',//?w_no='+ ${writing.w_no}, // 경로 설정  
			data : referForm,
			//data : { "id" : $("#id").val(),"model_name" : $("#model_name").val(),"model_picture" : $("#model_picture").val(), "title" : $("#title").val(), "content" : $("#content").val() },//$('form').serialize(),
			contentType: 'application/x-www-form-urlencoded; charset=UTF-8', 
			dataType: 'html',
			success : function(){
             alert("수정창으로 갑니다");
            updatePopup(); // 아래에서 정의한 팝업창 띄우기
				window.opener.parent.location.reload();
				window.close();
			}// success
  	 	})
	});
		 
  	// 게시물 삭제 버튼 
 		$("#delete").click(
 				function deleteBulletin() {
 					if (confirm("정말 삭제하시겠습니까?")) { // 시작
 						$.ajax({
 							type : 'post',
 							url : '${pageContext.request.contextPath}/deleteWriting.do?w_no='+ $('#w_no').val(), // 경로 설정  
 							success : function() {
 								window.opener.parent.location.reload();
 								window.close();
 							}
 								//data : { "id" : $("#id").val(),"model_name" : $("#model_name").val(),"model_picture" : $("#model_picture").val(), "title" : $("#title").val(), "content" : $("#content").val() },//$('form').serialize(),
 								}); // ajax 끝 */
 					}
 					else {
 						return;
 					    }//if else 끝
 				}); 
  	
        });//document.ready
 
</script>
<style>
input[type=button]{
border-radius : 10px ;
}
button{
border-radius : 10px ;
}
table {
  border-spacing: 0 5px;
}
</style>
</head>
<body style="margin : 2% ;" onload="listReply()">
	<form  id="referForm" name="referForm" action="${pageContext.request.contextPath}/to.updateWriting" method="post" >
	<div>
		  글 번호 &nbsp;&nbsp;:&nbsp;&nbsp;<span id="writing_no">${writing.w_no}</span><input type="hidden"	id="w_no" name="w_no" value="${writing.w_no}"></input>
		 <Br> <br> 작성자&nbsp;&nbsp;:&nbsp;&nbsp; ${writing.id}
		 <input type="hidden"  id="id" name="id"  value="  ${writing.id} "/> <br> <br> 
		  제목 &nbsp;&nbsp;:&nbsp;&nbsp;<input type="text" style="border : none ; " id="title" name="title" style="width: 550pt; height: 15pt" value="${writing.title}" readonly /></input>
		 <input type="hidden"  id="model_name" name="model_name"  value=" ${writing.model_name} "></input> 
		 <br><br> 
		 제품사진 &nbsp;&nbsp;:
		<input type="hidden"  id="image_name" name="image_name"  value=" ${writing.image_name} "></input> 
		<br>
		<p align="center">
			<img src="<c:url value='/image/${writing.image_name}'/>" />
		</p>
		<br><br> 내용 <br>
		<textarea style="vertical-align : middle ; " rows="10" id="content" name="content" cols="100" readonly>${writing.content}</textarea>
		<br> <br>
		<c:if test="${sessionScope.login.id eq writing.id}">
			<div style="float: right">
				<input type="button" id="correct" name="correct" value="수정">
				&nbsp; <input type="button" id="delete" name="delete" value="삭제">
			</div>
		</c:if>
	</div>
	</form>
	<br><br>
	<div style="width: 650px; text-align: center;">
		<!-- **로그인 한 회원에게만 댓글 작성폼이 보이게 처리 -->
		<c:choose>
			<c:when test="${sessionScope.login.id != null}">
			<form id="replyForm" name="replyForm">
		        <input type="hidden" id="w_no" name="w_no" value="${writing.w_no}"></input>
		        <input type="hidden" id="id" name="id" value="${writing.id}"></input>
		        <div align="left" style="float: left ; ">작성자  : ${sessionScope.login.id} 님 </div>
		        <div align="right" style="float:right; "> 평가 점수 :  &nbsp; 
		         <select name="design">
					<option selected>디자인</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				<select name="prr">
					<option selected>가성비</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select>
				<select name="durability">
					<option selected>내구성</option>
					<option value="1">1</option>
					<option value="2">2</option>
					<option value="3">3</option>
					<option value="4">4</option>
					<option value="5">5</option>
				</select></div>
				<br><br>
				<textarea rows="3" cols="80" id="replyText" name="replyText" >평가하세요!</textarea>
				<br>
				<button onclick="writeReply();" type="button" id="btnReply">댓글 작성</button>
				</form>
			</c:when>
			<c:otherwise>
				평가글을 남기시려면 로그인을 하세요!
			</c:otherwise>
		</c:choose>
	</div>
	<!-- json으로 댓글리스트 출력하는 곳  -->
	<!--  **댓글 목록 출력할 위치 -->
	<br>
	
	<table id="listReplyTable">
	<thead style="color: blue ; border-bottom : 1px solid silver ; border-top : 1px solid silver ; ">
	<tr>
	<td align="center" width="45">번호</td>
	<td align="center" width="80">작성자</td>
	<td align="center" width="700">내용</td>
	<td align="center" width="80">평점</td>
	<td align="center" width="150">평가 날짜</td>
	<td align="center" width="35"> 삭제 </td>
	</tr>
	</thead>
	
	<tbody id="listReplyTable_TBody">
	
	</tbody>
	</table>
	
</body>
</html>

	