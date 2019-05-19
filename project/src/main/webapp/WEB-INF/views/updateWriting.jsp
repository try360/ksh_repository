<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="utf-8"%>
	<%-- <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%> <%-- 스프링 폼 태그 --%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 수정</title>
<script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="http://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script language="javascript">
  $(document).ready(
	  function(){
		 
   	$("#submit").click(function updateWriting() {
   	    
   		//var reviseForm =$("#updateWritingForm").serialize(); // 파일첨부 안보내짐
   		
   	    var reviseForm =$("#updateWritingForm")[0]; 	 	
   	 	var reviseFormData= new FormData(reviseForm); //FormData는 JS 클래스다  
   	  
   	 	$.ajax({
   	 		
   	 		cashe: false,
	 		async:false,
	 		processData : false,
            contentType : false,
   	 		
 			type : 'post', 
 			url : '${pageContext.request.contextPath}/updateWritingAction.do', // 경로 설정  
 			data : reviseFormData,
 			success : function success()
 			{
 				alert("수정 성공");
 				self.close();
 			},// success
 			error : function error()
 			{ 
 				alert("파일 업로드에 실패했습니다.");
 			}//error
			//data : { "id" : $("#id").val(),"model_name" : $("#model_name").val(),"model_picture" : $("#model_picture").val(), "title" : $("#title").val(), "content" : $("#content").val() },
 		}); 
 	} ); 
   	 
 } );  
	  
</script>

</head>
<body>
<%-- <form:form name="writingVO" id="writingVO" action="${pageContext.request.contextPath}/writingAction.do" method="post">
 --%>	
   <form enctype="mutipart/form-data" id="updateWritingForm" name="updateWritingForm" action="${pageContext.request.contextPath}/updateWritingAction.do" method="post">
     <div>
       <input type="hidden" id="w_no" name="w_no" value="${writingVO.w_no}" />
		작성자 : ${sessionScope.login.id}
		<br> 
		<input type="hidden" id="id" name="id" style="width: 120pt; " value="${sessionScope.login.id}" readonly /></input>
		<br> 
		<노트북 모델명>
		<br>
		<input type="text" id="model_name" name="model_name" value="${writingVO.model_name}" style="width: 200pt;" /></input>
		<br><br>  
              수정할  노트북 사진을 첨부하세요 -> &nbsp;&nbsp;
	    <input type="file" id="r_imageFile" name="r_imageFile" value="이미지 선택">
		<br><br>  
		제  목 
		<br> 
		<input type="text" id="title" name="title" value="${writingVO.title}" style="width: 480pt; height: 15pt" />
		<br><br>  
		내용
		<br>
		<textarea rows="15" id="content" name="content" cols="100">${writingVO.content}</textarea>
		<br>
		<input type="button" id="submit" name="submit" value="저장"  style="float: right">
	</div>
</form>
</body>
</html>