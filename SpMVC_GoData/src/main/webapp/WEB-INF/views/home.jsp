<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버스 노선 검색</title>
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
	margin: 3px;
	cursor: pointer;
	transition: all 0.7s;
	border: 2px dashed black;
	cursor: pointer;
}

nav.main-nav li:hover {
	background-color: gray;
	color: black;
}
</style>


</head>
<body>
	<header>
		<h2>공공DB 활용</h2>
	</header>
	<nav class="main-nav">
		<ul>
			<li>Home</li>
			<li><input /></li>
			<li><input /></li>
			<li class="get-station">정보 가져오기</li>
		</ul>
	</nav>
</body>
<script>
	document.addEventListener("DOMContentLoaded", function() {

		let getStationButton = document.querySelector("nav.main-nav .get-station");
		getStationButton.onclick = function() {
			document.location.href = "${rootPath}/bis/station";
		}
	})
</script>
</html>