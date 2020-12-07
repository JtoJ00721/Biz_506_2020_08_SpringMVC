<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마지막 MVC 실습</title>
<style>

div {
	margin: 15px 0px;
}

#userinter button {
	padding: 12px;
	background-color: cornflowerblue;
	color: white;
}

#textinter button {
	padding: 12px;
	background-color: crimson;
}

</style>
</head>
<body>
	<h1>마지막 MVC 실습</h1>
	<div id="userinter">
		<button type="button" id="new_nong">농농이 클론 추가</button>
		<button type="button" id="user_list">모든 사용자 보기</button>
		<button type="button" id="select_user">선택한 사용자 보기</button>
		<button type="button" id="update_user">사용자 업데yee트</button>
	</div>
	
	<div id="textinter">
		<button type="button" id="new_text">농농이가 끄적인 글 추가</button>
		<button type="button" id="text_list">모든 글 보기</button>
		<button type="button" id="select_text">선택한 글 보기</button>
		<button type="button" id="update_text">글 업데yee트</button>
	</div>

	<script>
		document.addEventListener("DOMContentLoaded", function() {
			let nong = document.querySelector("#new_nong");
			let userList = document.querySelector("#user_list")
			let selectUser = document.querySelector("#select_user")
			let updateUser = document.querySelector("#update_user")

			nong.addEventListener("click", function() {
				document.location.href = "${rootPath}/emp/put"
			})
			
			userList.addEventListener("click", function() {
				document.location.href = "${rootPath}/emp/list"
			})
			
			selectUser.addEventListener("click", function() {
				document.location.href = "${rootPath}/emp/select/3"
			})
			
			updateUser.addEventListener("click", function() {
				document.location.href = "${rootPath}/emp/update/3"
			})

			//-------------------------------------------------------------
			
			let text = document.querySelector("#new_text");
			let textList = document.querySelector("#text_list")
			let selectText = document.querySelector("#select_text")
			let updateText = document.querySelector("#update_text")

			text.addEventListener("click", function() {
				document.location.href = "${rootPath}/notice/put"
			})
			
			textList.addEventListener("click", function() {
				document.location.href = "${rootPath}/notice/list"
			})
			
			selectText.addEventListener("click", function() {
				document.location.href = "${rootPath}/notice/select/3"
			})
			
			updateText.addEventListener("click", function() {
				document.location.href = "${rootPath}/notice/update/3"
			})
		})
	</script>
</body>
</html>