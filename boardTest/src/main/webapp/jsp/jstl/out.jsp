<%@page import="java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- /*localhost:8180/jsp/jstl/out.jsp  */ -->
<%
	FileReader reader = new FileReader(application.getRealPath("/jsp/main.jsp"));
	pageContext.setAttribute("reader", reader);
	application.setAttribute("reader", reader);
%>
<c:out value="${reader}"/><!-- 자동으로 reader 객체를close 하기 때문에 아래에서는 사용이 불가하다. -->

 <hr>
<c:out value="${applicationScope.reader}"/>
<hr> 
</body>
</html>