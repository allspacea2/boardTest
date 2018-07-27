<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>REDIRECT TEST</title>
</head>
<body>
<!-- localhost:8180/jsp/jstl/redirect.jsp -->
<c:redirect url="/jsp/main.jsp">
	<c:param name="redirectFrom" value="redirect.jsp"/>
</c:redirect>
</body>
</html>