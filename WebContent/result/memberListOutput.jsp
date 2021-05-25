<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dev.vo.MemberVO" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
	table, th, td {
		border: 1px solid #000000;
		border-collapse: collapse;
	}
	
	th, td {
		padding: 5px 10px;
	}
</style>
<title>MemberList</title>
</head>
<% ArrayList<MemberVO> List = (ArrayList<MemberVO>)request.getAttribute("List"); %>
<body>
	<h3>List Complete</h3>
	<%if(!List.isEmpty()){ %>
	<table>
		<tr>
			<th>ID</th>
			<th>Password</th>
			<th>Name</th>
		</tr>
	<%
		for(int i = 0; i < List.size(); ++i){
			MemberVO member = List.get(i);
	%>
		<tr>
			<td><%=member.getId() %></td>
			<td><%=member.getPwd() %></td>
			<td><%=member.getName() %></td>
		</tr>
	<%
		}
	%>
	</table><br>
	<%
	} else {
	%>
	<h3>등록된 멤버가 없습니다.</h3>
	<%
	}
	%>
	<%@ include file="home.jsp" %>
</body>
</html>