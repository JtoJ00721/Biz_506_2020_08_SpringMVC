<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마지막 MVC 실습</title>
</head>
<body>
	<h1>마지막 MVC 실습</h1>
	<button type="button" id="new_nong" >농농이 클론 추가</button>

	<script>
		document.addEventListener("DOMContentLoaded", function() {
			let nong = document.querySelector("#new_nong");

			nong.addEventListener("click", function() {
				document.location.href = "${rootPath}/put"
			})
		})
	</script>
</body>
</html>