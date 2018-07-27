<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Signin Template for Bootstrap</title>

<!-- Bootstrap core CSS -->
<link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom styles for this template -->
<%@ include file="/common/jquery.jsp"%>
<script>
	function getCookie(name) {
		var cookies = document.cookie;

		var cookieArr = cookies.split("; ");
		var cookieResult = "";
		for ( var i in cookieArr) {
			var cookie = cookieArr[i];
			var cookieNameValue = cookie.split("=");

			var cookieName = cookieNameValue[0];
			var cookieValue = cookieNameValue[1];

			if (name == cookieName) {
				cookieResult = cookieValue;
				break;
			}
		}
		return cookieResult;
	}
	
	//쿠키추가
	function setCookie(cookieName, cookieValue, expires){
		var dt = new Date();
		dt.setDate(dt.getDate()+parseInt(expires));
		//우리는 특수문자가 들어가지 않기 때문에 그냥 써도되지만 
		document.cookie = cookieName + "=" + cookieValue + "; path=/; expires = "+ dt.toGMTString();
	}
	
	
	
	
	
	
	//쿠키삭제
	function deleteCookie(cookieName){
		setCookie(cookieName, "", -1);
	}
	
	
	function setCookieValue(cookieName){
		var expireDate = new Date();
		expireDate.setDate( expireDate.getDate() -1);
		document.cooki = cookieName+ "; path=/; expires="+ expireDate()
	}

	//문서 로딩 완료후 실행
	$(function() {
		if (getCookie("rememberMe") == "y") {
			//userId input에 userId cookie 값을 설정
			$("#userId").val(getCookie("userId"));
			$("#rememberMe").attr("checked", true);
			$("#rememberMe").val(getCookie("rememberMe"));
		}
		
		//rememberMe 체크박스 클릭이벤트
		$("#rememberMe").on("click", function() {
			if ($(this).is(":checked")) {
				//rememberMe cookie 설정
				setCookie("rememberMe","y",30);
				setCookie("userId",$("#userId").val(),30);
			}else{
				//쿠키제거
				deleteCookie("rememberMe");
			}
		});

	});
</script>
</head>
<!-- html이 모두 로딩 된 후에 jsp실행되게 하기  -->
<body>

	<!--
  
  		1.사용자가 로그인 화면을 접속한다 (localhost:8180/login/login.jsp)
  		2.사용자가 id와 pw을 입력 후 singin 버튼을 클릭 
  			-signin 버튼이 속한 form 태그의 action 속성에 설정된 url로 요청
  		3.LoginServlet 파라미터(userId, password)를 확인 후 고정된 값을 비교.
  			-같을 경우 rersponse객체의 writer 객체를 이용하여 화면에 "접속 성공"
  			 틀릴경우 "접속실패" 메세지 출력. 
    -->

	<div class="container">
		ssesion.getId() :
		<%=session.getId()%>
		<form class="form-signin" action="/loginServlet" method="post">
			<h2 class="form-signin-heading">─〓제발 입력해〓─</h2>

			<label for="std_id" class="sr-only">Student_ID</label> 
			<%-- <%
				String userId = request.getParameter("userId");
				userId = userId == null ? "" : userId;
			%> --%>
			<input type="text"	id="userId" name="std_id" class="form-control" placeholder="Id 입력"
				required autofocus value="${param.std_id}"> 
			<label for="Password" class="sr-only">Password</label>
			<input type="password" id="Password" name="pw" class="form-control"
				placeholder="Pw 입력" required>

			<div class="checkbox">
				<label> <input type="checkbox" id="rememberMe"
					name="rememberMe" value=""> Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
		</form>

	</div>
	<!-- /container -->
</body>
</html>
