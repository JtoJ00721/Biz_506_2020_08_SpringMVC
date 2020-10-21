<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
section#bbs-detail-header {
	width: 50%;
	border: 1px solid blue;
	margin: 20px auto;
	display: flex;
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5)
}

section#bbs-detail-header article:first-child {
	flex: 1;
}

section#bbs-detail-header article:last-child {
	flex: 2;
}

section#bbs-detail-header div {
	margin: 5px;
	padding: 10px;
	border-bottom: 1px solid #ddd
}

section#bbs-detail-header .title {
	display: inline-block;
	width: 25%;
	background-color: #ddd;
	font-weight: bold;
	text-align: right;
}

section#bbs-detail-header .content {
	display: inline-block;
	width: 60%;
}

section#bbs-detail-header img {
	margin: 5px;
	border-radius: 5px;
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5)
}

section#bbs-detail-body {
	width: 50%;
	margin: 10px auto;
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5)
}

#detail-menu {
	width: 100%;
	text-align: center;
}

#detail-menu a {
	display: inline-block;
	padding: 8px 16px;
	margin: 8px 4px;
	text-decoration: none;
	background-color: navy;
	border: 3px solid black;
	border-radius: 5px;
	color: white;
	transition: all 0.7s;
}

#detail-menu a:first-child {
	background-color: crimson;
}

#detail-menu a:nth-child(2) {
	background-color: yellowgreen;
}

#detail-menu a:hover {
	background-color: gray;
	border: 3px dotted coral;
	font-weight: bold;
	color: black;
}
</style>
<section id="bbs-detail-header">
	<article>
		<img src="${rootPath}/upload/${BBSVO.b_file}" width="200px">
	</article>
	<article>
		<div class="title">제목</div>
		<div class="content">${BBSVO.b_subject}</div>
		<div class="title">작성일시</div>
		<div class="content">${BBSVO.b_date},${BBSVO.b_time}</div>
		<div class="title">작성자</div>
		<div class="content">${BBSVO.b_writer}</div>
	</article>
</section>
<section id="bbs-detail-body">${BBSVO.b_content}</section>

<section id="detail-menu">
	<a href="${rootPath}/bbs/list">리스트로</a> <a
		href="${rootPath}/bbs/update?id=${vo.b_seq}">수정</a> <a
		href="javascript:void(0)" id="list-delete" data-id="${vo.b_seq}">삭제</a>
</section>

<script>
	document.addEventListener("DOMContentLoaded", function() {
		document.querySelector("#list-delete").addEventListener(
				"click",
				function() {
					let id = document.querySelector("#list-delete")
							.getAttribute("data-id");
					if (confirm("정말 삭제? ><")) {
						document.location.replace(`${rootPath}/bbs/delete/?id=`
								+ id);
					}
				});
	});
</script>