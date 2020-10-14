<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
	// 현재 화면의 DOM이 load 된 후
	// DOMContentLoaded와 비슷한 event로 load event가 있는데
	// load event 는 좀 오래전에 지정된 event이다.
	// 원래 이 event window.onload() event를 감싸는 핸들링이다.
	// 최근의 JS에서는 별로 사용을 권하지 않는 event이다.
	window.addEventListener("load", function() {
		document.querySelector("#menu-join").addEventListener("click",
				function() {
					// alert("회원가입")
					document.location.href = "${rootPath}/user/join"
				})

		document.querySelector("#menu-login").addEventListener("click",
				function() {
					// alert("회원가입")
					document.location.href = "${rootPath}/user/login"
				})
		document.querySelector("#menu-mypage").addEventListener("click",
				function() {
					// alert("회원가입")
					document.location.href = "${rootPath}/user/mypage"
				})
	})
</script>
<nav id="main-nav">
	<ul>
		<li>Home</li>
		<li>Center</li>
		<li id="menu-join">회원가입</li>
		<li id="menu-login">로그인</li>
		<li id="menu-mypage">Mypage</li>
		<li>로그아웃</li>
	</ul>
</nav>