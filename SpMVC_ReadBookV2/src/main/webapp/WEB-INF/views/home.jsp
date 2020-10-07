<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Read Book 2020</title>
<link rel="stylesheet" href="${rootPath}/static/css/index.css?ver=123" />
<script src="https://code.jquery.com/jquery-latest.min.js?ver=1"></script>
<script>
	// js 파일에서 el tag의 ${rootPath} 값을 참조하기 위해서
	// rootPath 변수를 전역으로 선언해 둔다
	// 어쩔수 없이 var로 선언해야 잘 인식된다
	var rootPath = "${rootPath}"
</script>
<script src="${rootPath}/static/js/main-nav.js?ver=1">
	
</script>
</head>
<body>
	<header>
		<h1>Read Book 2020</h1>
		<h5>책속에 뽕이 찬다네.. yee게 무슨 개소리야!!</h5>
	</header>

	<nav id="main-nav">
		<ul>
			<li id="menu-home">Read Book</li>
			<li id="menu-books">도서정보</li>
			<li id="menu-read-book">독서록</li>
			<li>네이버 검색</li>

			<sec:authorize access="isAnonymous()">
				<li id="menu-join">회원가입</li>
				<li id="menu-login">로그인</li>
			</sec:authorize>

			<sec:authorize access="isAuthenticated()">
				<li id="menu-mypage">마이페이지</li>
				<li><form:form action="${rootPath}/logout">
						<button>로그아웃</button>
					</form:form></li>
			</sec:authorize>
			<sec:authorize access="hasRole('ADMIN')">
				<li>관리자</li>
			</sec:authorize>


		</ul>
	</nav>

	<section id="main-section">
		<c:choose>
			<c:when test="${BODY == 'BOOK-LIST' }">
				<%@ include file="/WEB-INF/views/books/book-list.jsp"%>
			</c:when>
			<c:when test="${BODY == 'BOOK-WRITE' }">
				<%@ include file="/WEB-INF/views/books/book-write.jsp"%>
			</c:when>
			<c:when test="${BODY == 'BOOK-DETAIL' }">
				<%@ include file="/WEB-INF/views/books/book-detail.jsp"%>
			</c:when>
			<c:when test="${BODY == 'MEMBER-JOIN' }">
				<%@ include file="/WEB-INF/views/member/member-write.jsp"%>
			</c:when>
			<c:otherwise>
				<%@ include file="/WEB-INF/views/main-body.jsp"%>
			</c:otherwise>
		</c:choose>
	</section>
	<footer>
		<address>CopuRight &copy; moonlf2000@naver.com</address>
	</footer>
</body>
</html>
