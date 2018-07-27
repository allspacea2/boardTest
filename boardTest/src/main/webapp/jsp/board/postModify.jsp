\<%@page import="kr.or.ddit.board.model.post.PostVo"%>
<%@page import="kr.or.ddit.board.model.rep.RepVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@page import="java.text.SimpleDateFormat"%>


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
<link href="/css/common.css" rel="stylesheet">
<script>
	$(function() {
		$("table tbody tr").on("click", function() {
			//tr태그의 data-id 속성 값을 읽어서 input 태그의 id값으로 설정
			//form 태그를 submit
			$("#id").val($(this).data("id"));
			$("#frm").submit();
		});
	});
</script>
</head>


<body>
	<%
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	%>
	<%@ include file="/common/top.jsp"%>
	<form id="frm" action="/inputReply" method="get">
		<input type="hidden" name="id" id="id">
	</form>
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">

				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">글 수정하기</h2>
							<form action="/postDetail" name="fmt">
								<div class="table-responsive">
								<table class="table table-striped">
									<thead>
										<tr>
											<td>제목</td>
											<td><input type="text" value="${post.title}"
												name="modiTitle"></td>
											</tr>
											<tr>
												<td>글내용</td>
												<td><textarea rows="5" cols="30" name="modiContents">${post.post_contents}</textarea></td>
												<input type="hidden" value="${post.post_no}" name="id" />
											</tr>
											<tr>
												<td>첨부파일</td>
												<td>첨부파일</td>
											</tr>
										</thead>
									</table>
								</div>

							<button type="submit" value="${post.post_no}" name="id">글수정</button>
						</form>

						<div class="text-center">
							<ul class="pagination">
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
