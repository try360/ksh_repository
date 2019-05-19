<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form id="insertForm">
<input type="text" name="user_id"></input>
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
$(function(){
	$('#insert_btn').click(function() {
		
		
		var formData = $("#insertForm").serialize();
		
		if($("input[name=user_id]").val()==""){
			alert("작성자를 입력하세요!");
		}else if($("input[name=title]").val()==""){
			alert("제목을 입력하세요!");
        }else if($("textarea[name=content]").val()==""){
        	alert("내용을 입력하세요!");
        }else{
        	  $.ajax({
                  url : "${pageContext.request.contextPath}/insert/regist", // 클라이언트가 요청을 보낼 서버의 URL 주소
                  data : formData, // HTTP 요청과 함께 서버로 보낼 데이터
                  type : "post",
                  dataType : "text",
                  success : function() {
                      $("#label_wirting_result").text("성공");                
                  },
                  error : function(){
                      $("#label_wirting_result").text("실패");         
                  }

              });
        }
    })
	
    $("#go_home").on("click",function(){
        location.href="${pageContext.request.contextPath}/home" ; 
    })
    
    
    
    
})


</script>
</body>
</html>