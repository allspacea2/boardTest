<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<script language="javascript">
	function getSelectValue(frm){
		frm.textValue.value = frm.selectBox.options[frm.selectBox.selectedIndex].text;
		frm.optionValue.value = frm.selectBox.options[frm.selectBox.selectedIndex].value;
		
	}

</script>s
	

<body>
<hr>
<c:set value="김진영" var="userId"/>
<form action="/localeSelect" method="get">
	<select name = "locale" onchange="getSelectValue(this.form);" >
		<option value="ko" <c:if test="${param.locale =='ko'}">selected</c:if>>한국어</option>
		<option value="ja" <c:if test="${param.locale =='ja'}">selected</c:if>>일본어</option>
		<option value="en" <c:if test="${param.locale =='en'}">selected</c:if>>english</option>
	</select>
	<input type="submit" value="확인">
</form>
	<fmt:setLocale value="${param.locale}"/>
	<fmt:setBundle basename="kr.or.ddit.msg.msg" var="msg"/>
	<fmt:message bundle="${msg}" key="hello"/><br>
	<fmt:message bundle="${msg}" key="visitor">
		<fmt:param value="${userId }"/>
	</fmt:message>
</body>
</html>