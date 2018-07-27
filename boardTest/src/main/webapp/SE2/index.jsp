<%--------------------------------------------------------------------------------
	* 화면명 : Smart Editor 2.8 에디터 연동 페이지
	* 파일명 : /page/test/index.jsp
--------------------------------------------------------------------------------%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

<title>Jsp</title>

<script src="/js/jquery-1.12.4.js"></script>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">
<script src="/SE2/js/HuskyEZCreator.js"></script>
<script type="text/javascript">
	var oEditors = []; // 개발되어 있는 소스에 맞추느라, 전역변수로 사용하였지만, 지역변수로 사용해도 전혀 무관 함.

	//스마트 에디터 초기화하는 부분
	$(document).ready(function() {
		// Editor Setting
		nhn.husky.EZCreator.createInIFrame({
			oAppRef : oEditors, // 전역변수 명과 동일해야 함.
			elPlaceHolder : "smarteditor", // 에디터가 그려질 textarea ID 값과 동일 해야 함.
			sSkinURI : "/SE2/SmartEditor2Skin.html", // Editor HTML
			fCreator : "createSEditor2", // SE2BasicCreator.js 메소드명이니 변경 금지 X
			htParams : {
				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseToolbar : true,
				// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
				bUseVerticalResizer : true,
				// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
				bUseModeChanger : true,
			}
		});

		// 전송버튼 클릭이벤트
		$("#savebutton").click(function() {
			if (confirm("저장하시겠습니까?")) {
				// id가 smarteditor인 textarea에 에디터에서 대입
				oEditors.getById["smarteditor"].exec("UPDATE_CONTENTS_FIELD", []); //사용할 부분

				// 이부분에 에디터 validation 검증
				//if (validation()) {
					$("#frm").submit();
				//}
			}
		})
	});

	// 필수값 Check
	function validation() {
		var contents = $.trim(oEditors[0].getContents());
		if (contents === '&nbsp;' || contents === '') { // 기본적으로 아무것도 입력하지 않아도 <p>&nbsp;</p> 값이 입력되어 있음. 
			alert("내용을 입력하세요.");
			oEditors.getById['smarteditor'].exec('FOCUS');
			return false;
		}

		return true;
	}
</script>
</head>
<body>
	<%@ include file="/common/top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<!-- left.jsp -->
			<%@ include file="/common/left.jsp"%>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="row">
			<c:if test="${childPost eq null}">
				<form action="/insertPost" method="post" id="frm" name="frm">
					제목입력 : <input type="text" value="" name="title" width="100%">
					<textarea name="smarteditor"  id="smarteditor" rows="10" cols="100"
						style="width: 766px; height: 412px;" ></textarea>
						
				id : ${param.id}<%-- <%=request.getParameter("id") %> --%> <br>
				<input type="hidden" name="board_no" value="${param.id}">
				<input type="button" id="savebutton" value="서버전송" />
				</form>
			</c:if>
			
			<c:if test="${childPost != null}">
				<form action="/childPost" method="Post" id="frm" name="frm">
					제목입력 : <input type="text" value="" name="title" width="100%">
					<textarea name="smarteditor"  id="smarteditor" rows="10" cols="100"
						style="width: 766px; height: 412px;" ></textarea>
						
				id : ${param.id}<%-- <%=request.getParameter("id") %> --%> <br>
				<input type="hidden" name="std_num" value="${childPost.std_num}">
				<input type="hidden" name="board_no" value="${childPost.board_no}">
				<input type="hidden" name="post_gno" value="${childPost.post_gno}">
				<input type="hidden" name="post_pno" value="${childPost.post_pno}">
				<input type="button" id="savebutton" value="서버전송" />
				</form>
			</c:if>
			</div>
		</div>
	</div>
</body>
</html>