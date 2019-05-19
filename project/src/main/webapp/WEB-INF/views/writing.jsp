<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
	<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%> <%-- 스프링 폼 태그 --%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script language="javascript">

 // 게시글 보내기 
 
  $(document).ready(function(){
   	 $("#submit").click(function() {
   		var form =$('form#writingForm')[0]; 	 	
   	 	var formData= new FormData(form); //FormData는 JS 클래스다
     
   	 	$.ajax({
   	 		cashe: false,
   	 		async:false,
   	 		contentType:false,
   	 		processData:false,
   	 		
 			type : 'post', 
 			url : '${pageContext.request.contextPath}/writingAction.do', // 경로 설정  
 			data : formData,
 			success : function()
 			{
 				alert("작성완료");
 				window.opener.parent.location.reload();
 				window.close();
 			}
			//data : { "id" : $("#id").val(),"model_name" : $("#model_name").val(),"model_picture" : $("#model_picture").val(), "title" : $("#title").val(), "content" : $("#content").val() },//$('form').serialize(),

 		}); 
 	}); 
 });  
/*input 커서 놓으면 value값 사라지게  */ 
  function clearText(y){ 
	  if (y.defaultValue==y.value) 
	  y.value = "" 
	  } 
</script>
<style>
input:focus::-webkit-input-placeholder  {color: transparent;}
textarea:focus::-webkit-input-placeholder  {color: transparent;}
</style>
</head>
<body>
<%-- <form:form name="writingVO" id="writingVO" action="${pageContext.request.contextPath}/writingAction.do" method="post">
 --%>	
	<form enctype="mutipart/form-data" id="writingForm" name="writingForm" action="${pageContext.request.contextPath}/writingAction.do" method="post">
	     <div>
			작성자  :  ${sessionScope.login.id}
			<br> 
			<input type="hidden" id="id" name="id" style="width: 120pt; " value="${sessionScope.login.id}" readonly /></input>
			<br>  
			<노트북 모델명>
			<br>
			<input type="text" id="model_name" name="model_name" placeHolder="모델명" style="width: 200pt;" onFocus="clearText(this)" /></input>
			<br><br>  
	              노트북 사진을 첨부하세요 -> &nbsp;&nbsp;
		    <input type="file" name="imageFile" value="이미지 선택">
			<br><br>  
			제  목 
			<br> 
			<input type="text" id="title" name="title" placeHolder="글 제목" style="width: 480pt; height: 15pt" onFocus="clearText(this)" />
			<br><br>  
			내용
			<br>
			<textarea rows="15" id="content" name="content" cols="100" onFocus="clearText(this)" placeholder="글 내용"></textarea>
			<br>
			<input type="button" id="submit" name="submit" value="글쓰기"  style="float: right">
		</div>
	</form>
</body>
</html>