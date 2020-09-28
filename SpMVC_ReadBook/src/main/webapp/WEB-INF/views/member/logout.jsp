<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Insert title here</title>
<style>
form {
	width: 90%;
	margin: 10px auto;
}

input {
	display: inline-block;
	width: 80%;
}
</style>
</head>
<body>
	<h3>로그아웃</h3>
	<form method="POST" action="${rootPath}/logout">
		<input name="${_csrf.parametername}" value="">
		<button>로그아웃</button>
	</form>
</body>
</html>