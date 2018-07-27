<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FMT TEST</title>
<!-- localhost:8180/jsp/jstl/locale.jsp -->
</head>
<body>
<c:set value="linePowerRanger" var="userId"/>
<!-- 		작성된 msg파일
			msg.properties		> default
			msg_ko_properties	> 한국어
			msg_en_properties	> 영어
			msg_ja_properties	> 일본어				-->	 
<%
	//pageContext.setAttribute("userId", "brown");
%>
<!--  name이라는 변수에 brown을 넣어준다. -->	
<c:set value="linePowerRanger" var="userId"/>
<!-- setLocale 태그를 통해 임의로 로케일을 수정 -->
<fmt:setLocale value="ja"/>

			<!--경로만 쓰면된다. p~~는 안써도됨
					  │						-->					
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="hello"/><br>
	<fmt:message key="visitor">
		<!--위에서 넣은 name변수를 EL을 이용해 표현한다 -->
		<fmt:param value="${userId}_"/> 
	</fmt:message>
</fmt:bundle>

<hr>
<h3>setBundle</h3>
<fmt:setLocale value="en"/>
<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg"/>
<fmt:message bundle="${msg}" key="hello"/><br>
<fmt:message bundle="${msg}" key="visitor">
	<fmt:param value="${userId }"/>
</fmt:message>


</body>
</html>















