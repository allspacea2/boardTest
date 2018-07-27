<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
table {
	text: center
}
</style>
</head>
<body>
	<!-- 07.06 oracle db의 student 테이블을 조회하여 화면에 출력 -->

	<%
		Connection conn = null;	//connection객체
		Statement stmt = null;	//connection객체를 이용해서 연결객체생성
		ResultSet rs = null;	//결과값을 담을 객체 (select문만 해당)
		
		// 1. 드라이버를 로딩(동적 바인딩)
		// 프로그램 실행시 드라이버를 로딩한다.
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//──────────────────────────────────────────────────────────────────
		
		// 2. DB접속 ==> Connection 객체 생성
		//							     자기컴퓨터   오라클버전에따라다름
		//									│		   │			
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "PC10"; 	//Oracle Id
		String pass = "java";	//Oracle 비번
		conn = DriverManager.getConnection(url, user, pass);
		
		//──────────────────────────────────────────────────────────────────
		
		// 3. Statetment 객체 생성
		// Statement 객체는 Connection 객체를 이용해 생성한다.
		stmt = conn.createStatement();
		
		//──────────────────────────────────────────────────────────────────
		
		// 4. SQL문을 Statement 객체를 이용해 실행하고 
		//	실행 결과를 ResultSet 객체에 저장한다(Select문만 해당)
		String sql = "select * from student";
		rs = stmt.executeQuery(sql);
	%>
	<h3>학생 성적표!</h3>
	<table cellspacing="0" border="1">
		<tr>
			<td>이름</td>
			<td>학번</td>
			<td>국어</td>
			<td>수학</td>
			<td>영어</td>
		</tr>
		<%
		// 5. 결과처리 ==> ResultSet 객체에 저장되어 있는 자료를
		//		    	  반복문을 이용해 차례로 읽어와 처리한다.
		/*
						ResultSet 객체에 담겨 있는 데이터에 접근하기 위해 
						현재 작업을 진행하는 레코드를 가리키는 것이 있는데 
						이것을 커서(Cursor)라고 한다. 
						next()메서드는 이 커서의 위치를 다음 레코드 위치로 이동시키고 
						그 자리에 데이터가 있으면 true, 없으면 false를 반환한다. 
		*/
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getString("std_name")%></td>
			<td><%=rs.getString("std_num")%></td>
			<td><%=rs.getInt("std_kor")%></td>
			<td><%=rs.getInt("std_eng")%></td>
			<td><%=rs.getInt("std_mat")%></td>
		</tr>
		<%}%>
	</table>
	<%
		rs.close();
		stmt.close();
		conn.close();
	%>

</body>
</html>