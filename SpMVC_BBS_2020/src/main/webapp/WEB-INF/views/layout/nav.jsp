<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<script type="text/javascript">
	// 화면에 content가 모두 loadint 되면
	document.addEventListener("DOMContentLoaded", function() {
		// id가 nav-bbs인 tag에 click 이벤트 설정
		document.querySelector("#nav-bbs").addEventListener("click",
				function() {
					document.location.href = "${rootPath}/bbs/list"
				})

		document.querySelector("#nav-home").addEventListener("click",
				function() {
					document.location.href = "${rootPath}"
				})
	})
</script>
<nav>
	<ul>
		<li id="nav-home">Home</li>
		<li id="nav-bbs">자유게시판</li>
	</ul>
</nav>