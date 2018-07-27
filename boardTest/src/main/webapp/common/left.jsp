<%@page import="kr.or.ddit.board.model.board.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
		<li><a href="/studentDetail">학생</a></li>
		<!-- (/insertBoard) = InserteBoardServlet -->
		<li class="active"><a href="/jsp/board/insertBoardmain.jsp">-게시판 생성-</a></li>
		<c:forEach items="${avaBoard}" var="board" varStatus="status">
			<li class="active">
				<a href="/makePost?id=${board.board_no}&page=1&pageSize=10" >${board.board_name}</a>
			</li>
		</c:forEach>
		<!-- 생겨난 게시판이 이곳에 나타나게 해야한다. c:foreach 를 이용해보자. -->

		<!-- 메뉴를 클릭했을때 무조건 1페이지를 출력하게 만듦 -->
		<!-- <li><a href="/studentList?page=1&pageSize=10">학생</a></li> -->
	</ul>
</div>