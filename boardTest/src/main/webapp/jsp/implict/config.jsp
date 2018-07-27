<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//jsp 기본 객체 : request, response, session, out, application
	//config : 설정 -> application객체를 통해서 대체 가능 
	config.getInitParameter("ADMIN");
	application.getInitParameter("ADMIN_USER");


%>
	config.getInitParameter("ADMIN") : <%=config.getInitParameter("ADMIN") %> <br>
	application.getInitParameter("ADMIN_USER") : <%=application.getInitParameter("ADMIN_USER") %>
</body>
</html>