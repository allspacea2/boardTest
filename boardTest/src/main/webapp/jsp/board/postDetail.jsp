<%@page import="java.io.PrintWriter"%>
<%@page import="kr.or.ddit.board.model.rep.RepVo"%>
<%@page import="kr.or.ddit.board.model.student.StudentVo"%>
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
<link href="/bootstrap/css/bootstrap-theme.css" rel="stylesheet">
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

<script>
$("#addfile").on("click", function(e){
      $(".file").clone().appendTo(".fileList");
});
</script>
</head>


<body>
	<%SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); %>
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
						<h2 class="sub-header">글 상세보기</h2>
						<h3>${result}</h3>
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>
									<tr>
										<td>제목</td>
										<td>${post.title}</td>

									</tr>
									<tr>
										<td>글내용</td>
										<td>${post.post_contents}</td>
									</tr>
									<tr>
										<td>첨부파일</td>
										<div class="file"><td><input type="file" name ="filename"><input type="button" value="+" class="addfile"></td></div>
										<div> <div class="fileList"></div></div>
										
									
									</tr>
									<tr>
										<form name="inputReply" action="/inputReply">
											<td>댓글</td>
											<td>
												<p>
													<input type="text" value=""  name="insertBoardName"
														value='입력' onchange="getSelectValue(this.form);"
														onfocus="this.value=''"
														onblur="if(this.value =='') this.value='댓글입력란';">
													<input type="hidden" value="${post.post_no}" name="post_no">	
												</p>
											</td>
											<td><input type="submit" class="btn-info" value="입력" ></td>
										</form>
									</tr>
										<c:forEach items="${repVo}" var="vo" varStatus="status"> 
										<tr>
										<td>${status.index+1}</td>
										<td>${vo.rep_contents}&nbsp;&nbsp;&nbsp;[${vo.rep_writer }&nbsp;&nbsp;/&nbsp;&nbsp;${vo.rep_date }]</td>
										</tr>
											</c:forEach>
								</thead>
								<tbody>
								</tbody>
							</table>
						</div>
						<%
						StudentVo stdVo = (StudentVo)session.getAttribute("studentVo");
						request.setAttribute("std_num", stdVo.getStd_num());
						%>
						<form method = "Post" action="/postDetail">
							<input type="hidden" value="${post.std_num}" name="board_no">
						<c:if test="${std_num eq post.std_num }"><button class="btn-info" type="submit" value="${post.post_no}" name="post_no" >글수정<!-- <button type="submit" value="글수정"></button> --></button></c:if>
						</form>
							
						<form method = "Post" action="/postDelete" name="postDelete">	
							<c:if test="${std_num eq post.std_num }">
								<c:if test="${post.post_ava eq 'y' }">
									<input type="hidden" value="${post.post_no}" name = "delPost_num">
									<input type="hidden" value="${post.post_ava}" name = "delpostVo">
									<input type="hidden" value="${post.board_no}" name = "delBoard_no">
									<input type="submit" class="btn-warning"value="글삭제">
								</c:if>
							</c:if>
						</form>
						<form  method="get" action ="/childPost" name = "childPost">
							<input type="hidden" value="${post.std_num}" name ="std_num">
							<input type="hidden" value="${post.board_no}" name ="board_no">
							<input type="hidden" value="${post.post_gno}" name ="post_gno">
							<input type="hidden" value="${post.post_no}" name ="post_pno">
							<input type="submit" class="btn-primary" value="답글쓰기">
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
