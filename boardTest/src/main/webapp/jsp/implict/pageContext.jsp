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
		//request, response, session, out, application
		//config
		//pageContext : 다른 객체에 대한 전반적인 정보를 갖고 있습니다. 
		pageContext.getRequest();
	
		//application -->
		pageContext.getServletContext();	//application
		pageContext.getSession();			//session
		pageContext.getOut();				//out
	%>
		<!-- html -->
		pageContext.getRequest() == request         :  <%=request.equals(pageContext.getRequest()) %>  <br>
		pageContext.getServletContext() == request 	:  <%=request.equals(pageContext.getServletContext()) %><br>
		pageContext.getSession() == request 		:  <%=request.equals(pageContext.getSession()) %><br>
		pageContext.getOut() == request 			:  <%=request.equals(pageContext.getOut()) %><br>

</body>
</html>