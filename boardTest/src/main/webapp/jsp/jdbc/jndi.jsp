<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
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
	3. was connection jndi connecti on pool
	
	각 방법열로 컨넥션을 생성하는 시간 profiling
-->
	<%
		//────────────────────────────────────────────────────────────────────────────────────────────────
		//1.JNDI 걸린 시간 확인해보기 

		Context context = new InitialContext();
		//톰캣에 설정된 Resource name에 따라 호출하는녀석
		DataSource dataSource = (DataSource) context.lookup("java:comp/env/jdbc/oracleDB");
		/* Connection conn = null; */
		long startTime = System.currentTimeMillis();

		//connection을 이용해서 50번 얻어오고 해제한다.
		int cnt = 0;
		for (int i = 0; i <1000; i++) {
			Connection conn = dataSource.getConnection();
			out.write("JNDI schema " + cnt + " : "
					+ conn.getSchema() + "<br>");
			conn.close();
			cnt++;
		}
		long endTime = System.currentTimeMillis();
		out.write("걸린 시간 : 	" + (endTime - startTime) + "ms");

		//localhost:8180/jsp/jdbc/jndi.jsp
	%>



































</body>
</html>