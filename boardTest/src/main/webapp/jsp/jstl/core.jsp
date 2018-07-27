<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--jst 사용을 하기 위해  taglib 지시자 작성 --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- jstlCoreServlet -->
	<!-- localhost:8180/jstlServlet -->
	request.userId : ${usrId} / ${requestScope.userId} <br>
	
	<!-- ser : 특정영역에 변수를 새로 생성(defaulst : page) -->
	<%
	
	pageContext.setAttribute("test","testValue");
	
	%>
	c:ser : <c:set var="test" value="testValue"/> ${test }
	pageContext.getAttribute("test") : <%=pageContext.getAttribute("test") %> <br>
	
	<h3>c:set scope</h3>
	<c:set var="test" value="testSessionValue"  scope="session"/> ${test } / ${sessionScope.test}<br>
	<!-- testValue가 나온다. 영역이 작은 순서부터 나오기 때문 -->
	
	<h3>c:set target, property</h3>
	<!--request객체의 속성 출력  -->
	${studentVo }<br>	
	<!-- vo객체에 값 설정 -->
	<c:set target="${studentVo }" property="name" value="brown"/>
	${studentVo}
	
	
	
	
	
	
	
	
	
</body>
</html>