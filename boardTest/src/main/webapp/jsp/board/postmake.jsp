<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


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
</head>


<body>

	<%@ include file="/common/top.jsp"%>
	<script>
		$(function(){
			$("table tbody tr[data-id]").on("click", function(){
				//tr태그의 data-id 속성 값을 읽어서 input 태그의 id값으로 설정
				//form 태그를 submit
				$("#id").val($(this).data("id"));
				$("#frm ").submit();
			});
		});
	</script>
	<form  id="frm" action="/postDetail" method="get">
		<input type="hidden" name="id" id="id">
	</form>
	<div class="container-fluid">
		<div class="row">

			<%@ include file="/common/left.jsp"%>
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">


				<div class="row">
					<div class="col-sm-10 blog-main">
						<h2 class="sub-header">${boardName}</h2>
						<div class="table-responsive">
							<table width ="100%" style=TABLE-layout:fixed class="table table-striped">
								<thead>
									<tr>
										<th width="10%">No</th>
										<th width="60%">제목</th>
										<th width="10%">작성자</th>
										<th width="20%">작성일</th>
									</tr>
								</thead>
								<tbody>
								<% request.setAttribute("nbsp", " "); %>
								<% int a = 1; %>
									<c:forEach items="${postVo}" var="vo">
										<c:if test="${vo.post_ava eq 'y' }">
											<tr  data-id="${vo.post_no}" >
												<td>${vo.rn}</td>
												<td style="text-overflow : ellipsis;overflow : hidden;">
												<nobr>
												${fn:replace(vo.title, nbsp, '&nbsp;')}
												</nobr>
												</td>
												<td>${vo.std_name }</td>
												<td><fmt:formatDate value="${vo.post_date}" pattern="yyyy-MM-dd"/></td>
											</tr>
										</c:if>
										<c:if test="${vo.post_ava eq 'n' }">
											<tr>
												<td>${vo.rn}</td>
												<td style="text-overflow : ellipsis;overflow : hidden;">
													<nobr>
													[&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;삭제된 게시물입니다&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;]
													</nobr>
												</td>
												<td>${vo.std_name }</td>
												<td><fmt:formatDate value="${vo.post_date}" pattern="yyyy-MM-dd"/></td>
											</tr>	
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<input type="hidden" value="${board_num}" name="id" id="id">
						<a class="btn btn-default pull-right" href="/SE2/index.jsp?id=${board_num }">새글 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<%=request.getAttribute("pageNavi")%>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
