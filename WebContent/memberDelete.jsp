<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.dev.vo.MemberVO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberSearch.do" method="post">
		ID : <input type="text" name="id">
		<input type="hidden" name="job" value="delete">
		<input type="submit" value="Search">
	</form>
	
	<%
		MemberVO member = (MemberVO)request.getAttribute("member");
		if(member != null){
	%>
	<h3>Delete Information</h3>
	${member.id } / ${member.pwd } / ${member.name }
	<form action="memberDelete.do" method="post">
		<input type="hidden" name="id" readonly value="${member.id }"><br>
		<input type="submit" value="Delete">
	</form>
	<%} else{ %>
		${result}
	<%} %>
</body>
</html>