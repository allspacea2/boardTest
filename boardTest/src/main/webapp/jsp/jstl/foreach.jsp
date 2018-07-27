<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!--  from JstlForeachServlet -->
<title>Insert title here</title>
</head>
<body>
<h3>c:forEach </h3>
<table border ="1" >
	<th>status Index</th>
	<th>학생 id</th>
	<th>학생 이름</th>
	<th>학생 cnt</th>
	<!--  										0부터시작
												시작index		 건너뛰는범위			 현재실행중인 index
													│		│		│					│			-->
	<c:forEach  items="${studentList}" var="vo" begin="0" end="5" step="1" varStatus="status">
	<tr>
	<td>${status.index}</td>
	<td>${vo.id }</td>
	<td>${vo.name }</td>
	<td>${vo.call_cnt }</td>
	</tr>
	</c:forEach>
</table>
 <hr>
<h3>foreach map</h3>
<%-- map있는 값들을 전부 조회해서 출력
	map.get("name"), map.get("alias") 해야하는데 
	foreach 는 훨씬 간단
 --%>
 <c:forEach items="${map}" var="entry"> 
 	${entry.key} / ${entry.value}<br>
 </c:forEach>
 <hr>
 <h3>forTokens</h3>
 원래값2 : ${lineManager2}<br>
 <c:forTokens items="${lingeManager}" delims="," var="hot">
 	${hot}<br>
 </c:forTokens>
 
</body>
</html>











