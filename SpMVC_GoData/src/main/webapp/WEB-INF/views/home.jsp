<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
* {
	box-sizing: border-box;
	padding: 0px;
	margin: 0px;
}

header {
	padding: 2rem;
	background-color: green;
	text-align: center;
	margin-bottom: 0px;
}

nav.main-nav ul {
	display: flex;
	list-style: none;
	background-color: cornflowerblue;
	color: white;
}

nav.main-nav li:nth-child(2), nav.main-nav li:nth-child(3) {
	margin-left: auto;
}

.main-nav li {
	padding: 0.5rem;
	cursor: pointer;
	transition: all 0.7s;
}

nav.main-nav li:hover {
	background-color: gray;
	color: black;
}
</style>
</head>
<body>
	<header>
		<h2>광주버스</h2>
	</header>
	<nav class="main-nav">
		<ul>
			<li>Home</li>
			<li><input /></li>
			<li>노선정보 가져오기</li>
		</ul>
	</nav>
</body>
</html>