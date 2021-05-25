<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="memberSearch.do" method="post">
		ID : <input type="text" name="id">
		<input type="hidden" name="job" value="search">
		<input type="submit" value="Search">
	</form>
</body>
</html>
