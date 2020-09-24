<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Read Book 2020</title>
<link rel="stylesheet" href="${rootPath}/static/css/index.css?ver=1" />
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script>
	// js 파일에서 el tag의 ${rootPath} 값을 참조하기 위해서
	// rootPath 변수를 전역으로 선언해 둔다
	// 어쩔수 없이 var로 선언해야 잘 인식된다
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/main-nav.js">
</script>
</head>
<body>
	<header>
		<h1>Read Book 2020</h1>
		<h5>책속에 뽕이 찬다네.. yee게 무슨 개소리야!!</h5>
	</header>
	<nav id="main-nav">
		<ul>
			<li>Read Book</li>
			<li>도서정보</li>
			<li>독서록</li>
			<li>네이버 검색</li>
			<li>회원가입</li>
			<li>로그인</li>
			<li>마이페이지</li>
			<li>로그아웃</li>
		</ul>
	</nav>
	<section id="main-section">
	<c:choose>
		<c:when test="${BODY == 'BODY-LIST }">
			<%@ include file="/WEB-INF/views/books/book-list.jsp" %>
		</c:when>
	</c:choose>
	Are You Experienced?</section>
	<footer>
		<address>CopuRight &copy; moonlf2000@naver.com</address>
	</footer>
</body>
</html>
