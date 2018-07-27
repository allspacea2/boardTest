<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- db connection 얻는 방법 3가지 
	1.jdbc
	2.application connection pool
	3. was connection jndi connection pool
	
	각 방법열로 컨넥션을 생성하는 시간 profiling
-->
	<%
		//────────────────────────────────────────────────────────────────────────────────────────────────
		//1.jdbc가 걸린 시간 확인해보기 
		
		//db 설정에 대한 값 설정
		String driverClassName = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String userName = "pc10";
		String password = "java";

		Class.forName(driverClassName);

		long startTime = System.currentTimeMillis();
		
		//connection을 이용해서 100번 얻어오고 해제한다.
		int cnt = 0;
		for (int i = 0; i < 50; i++) {
			Connection conn = DriverManager.getConnection(url, userName, password);
			out.write("schema "+cnt+" : " + conn.getSchema() + "<br>");
			conn.close();
			cnt++;
		}
		long endTime = System.currentTimeMillis();
		out.write("걸린 시간 : 	"+(endTime-startTime)+"ms");
		
		//localhost:8180/jsp/jdbc/jdbc.jsp
	%>



































</body>
</html>