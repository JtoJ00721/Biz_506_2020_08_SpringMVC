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
</head>
<body>
	<form method="POST" action="${rootPath}/logout">
		<button>Logout</button>
		<input name="${_csrf.parameterName}" value="${_csrf.token}">
	</form>

</body>
</html>