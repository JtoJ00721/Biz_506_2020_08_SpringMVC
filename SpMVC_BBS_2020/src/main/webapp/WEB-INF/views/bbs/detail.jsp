<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<style>
* {
	box-sizing: border-box;
	margin: 0;
	padding: 0;
}

html, body {
	height: 100%;
	width: 100%;
}

#detail-main {
	width: 90%;
	display: flex;
	margin: 20px auto;
	justify-content: center;
}

#detail_interface {
	margin: 10px;
	width: 50%;
	height: 50%;
	border: 30px double gray;
	padding: 15px;
}

#detail_interface h3, #detail_interface p {
	display: inline-block;
	padding: 8px;
	margin: 8px 4px;
	border-bottom: 2px solid gray;
}

#detail_interface h3 {
	width: 30%;
	color: green;
	font-weight: bold;
	text-align: center;
	border-bottom: none;
}

#detail_interface p {
	width: 60%;
}

hr {
	width: 90%;
	border: 3px solid #ddd;
	margin: 0 auto;
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

<section id="detail-main">
	<article id="detail-img">
		<img src="${rootPath}/upload/${BBSVO.b_file}" width="200px">
	</article>
	<article id="detail_interface">
		<div>${BBSVO.b_subject}</div>
		<div>${BBSVO.b_date}</div>
		<div>${BBSVO.b_writer}</div>
	</article>
</section>
<section id="detail-content">${BBS.b_content}</section>

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