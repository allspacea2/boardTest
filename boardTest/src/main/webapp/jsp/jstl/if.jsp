<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--1 jstl 추가하기 -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>c:if</h3>
<!--0 jstlIfServlet -->
<!--2 request 객체에 code 속성이 "02" 값으로 존재 -->
<%

/* 	if(1==2)
		out.write("brown"); */
%>
<!--  
	test : 참, 거짓 조건 테스트, c:if에는 else가 없다 --choose가 일반적인 if문과 같다.
			  속성	    값
			   │		│	-->
<c:if test="${code == '02'}">
	My name is Brown
</c:if>
<hr>
<h3>c:choose</h3>
<c:choose>
	<c:when test="${code == '01' }">brown</c:when>
	<c:when test="${code == '02' }">sally</c:when>
	<c:when test="${code == '03' }">cony</c:when>
	<c:otherwise>line rangers</c:otherwise>
</c:choose>




</body>
</html>