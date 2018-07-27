<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<!-- 	pw.write("<table>");
		for(int k = 1; k<=9; k++){
			pw.write("<tr>");
			for(int i =2; i<=9; i++){
				pw.write("<td>"+i +" * "+k+" = " +i*k + "	"+"</td>");
			}
			pw.write("</tr>");
		}
		pw.write("</table>"); -->
	<table border = "1">
		<c:forEach var="i" begin="1" end="9">
			<tr>
				<c:forEach var="j" begin="2" end="9">
					<td>${j}* ${i} = ${i*j}</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>

</body>
</html>