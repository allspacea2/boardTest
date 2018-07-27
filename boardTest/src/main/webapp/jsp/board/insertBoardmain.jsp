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
</head>
<script >
	function getSelectValue(frm) {
		frm.textValue.value = frm.selectBox.options[frm.selectBox.selectedIndex].text;
		frm.optionValue.value = frm.selectBox.options[frm.selectBox.selectedIndex].value;
	}
</script>
<body>
	<!-- top.jsp -->
	<%@ include file="/common/top.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<!-- left.jsp -->
			<%@ include file="/common/left.jsp"%>
		</div>
		<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
			<div class="blog-header">
				<h1 class="blog-title">BOARD LIST</h1>
				<p class="lead blog-description"/>
				<table border ="2" >
					<th>BOARD NAME</th>
					<th>BOARD AVA</th>
					<th>UPDATE</th>
					
				<c:forEach items="${board}" var="boardVo" varStatus="status">
					<tr>
					<form action="/alterBoard" name="frm" id="frm" method="Post">
	                	<input type="hidden" id="${boardVo.board_no}" name="board_no" value="${boardVo.board_no}" >
						<input type="hidden" name ="oldBoardName" value="${boardVo.board_name }">
						<td><input type="text" name = "updateBoardName" value="${boardVo.board_name }"></td>
						<td>
						<select name="boardYN" onchange="getSelectValue(this.form);">
							<option value="y" <c:if test="${boardVo.board_ava == 'y'}">selected</c:if>>사용</option>
							<option value="n" <c:if test="${boardVo.board_ava== 'n'}">selected</c:if>>사용안함</option>
						</select>
						</td>
						<td><input type="submit" value="수정"></td>
						
						
					</form>
					</tr>
				</c:forEach>
				</table>	
				<!--  dddd -->
				    <%--   int board_no = Integer.parseInt(request.getParameter("board_no"));
				      String board_use_confirm = request.getParameter("update_use_confirm");
				      String board_name = request.getParameter("updateBoardName");
				
								<form action="/jspTest/updateBoard" method="get">
								<input type="text" name = "updateBoardName" value="${boardVo.board_name }
                                    <input type="text" name="updateBoardName" value="${boardVo.board_name}">
                                    <select id="update_use_confirm" name="update_use_confirm">
                                       <option value="${boardVo.board_use_confirm}">
                                          <c:choose>
                                             <c:when test="${boardVo.board_use_confirm == 'Y'}">사용</c:when>
                                             <c:when test="${boardVo.board_use_confirm == 'N'}">미사용</c:when>
                                          </c:choose>
                                       </option>
                                       <option value="Y">사용</option>
                                       <option value="N" >미사용</option>
                                    </select>
                                    <button id="btnUpdateBoard" class="btn btn-primary" type="submit">수정</button>                                    
                                 </form> --%>
				<!--  dddd -->
			</div>
			<div class="row">
				<div class="col-sm-8 blog-main">
					<div class="blog-post">
						<h1 class="blog-title">게시판 생성</h1>
						<br>
						<form action="/inserteBoard" name="insertForm" id="insertForm"
							method="Post">
							<table border="1">
								<tr>
									<td>게시판 이름 <input type="text" name="insertBoardName"
										value='게시판이름' onchange="getSelectValue(this.form);"
										onfocus="this.value=''"
										onblur="if(this.value =='') this.value='게시판이름';"></td>
									<td><select name="insertBoardYN"
										onchange="getSelectValue(this.form);">
											<option value="y"
												<c:if test="${boardYN == 'y'}">selected</c:if>>사용</option>
											<option value="n"
												<c:if test="${boardYN == 'n'}">selected</c:if>>사용안함</option>
									</select></td>
									<td><input type="submit" value="생성"></td>
								</tr>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
