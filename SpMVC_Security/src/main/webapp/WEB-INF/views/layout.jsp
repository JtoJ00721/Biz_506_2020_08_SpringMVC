<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>와 타일이다</title>
<style>
* {
	box-sizing: border-box;
	padding: 0;
	margin: 0;
}

html, body {
	width: 100%;
	height: 100%;
}

body {
	display: flex;
	flex-direction: column;
}

header {
	margin: 0;
	padding: 0;
	text-align: center;
	height: 180px;
	background-color: cornflowerblue;
	color: brown;
	border-bottom: 15px double gray;
	height: 180px;
	font-size: 30px;
	font-weight: bold;
	text-shadow: 3px 3px darkgray;
	line-height: 180px;
	text-align: center;
}

#main-nav ul {
	list-style: none;
	display: flex;
	background-color: blue;
}

#main-nav li {
	padding: 8px 16px;
	margin: 0px 5px;
	border-bottom: 3px solid transparent;
	cursor: pointer;
	color: white;
	transition: all 1s;
}

footer {
	background-color: black;
	color: white;
	text-align: center;
	padding: 0.7rem;
	line-height: 100%;
}

#main-nav li:hover {
	border-bottom: 3px solid yellow;
}

#main-nav li:nth-child(3) {
	margin-left: auto;
}
</style>
</head>
<body>
	<tiles:insertAttribute name="header" />
	<tiles:insertAttribute name="menu" />
	<tiles:insertAttribute name="content" />
	<tiles:insertAttribute name="footer" />
</body>
</html>