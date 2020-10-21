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

#detail-menu a:first-child {
	
}

#detail-menu a:nth-child(2) {
}

#bbs-button-box {
	width: 50%;
	margin: 10px auto;
	text-align: right;
}

#bbs-button-box button {
	background-color: crimson;
	margin: 10px;
	padding: 10px 16px;
	border: 3px solid black;
	outline: none;
	border-radius: 5px;
	color: white;
	font-weight: bolder;
	transition: all 0.7s;
	margin: 10px;
}

#bbs-button-box button:nth-child(2) {
	background-color: yellowgreen;
}

#bbs-button-box button:nth-child(3) {
	background-color: navy;
}

#bbs-button-box button:hover {
	box-shadow: 3px 3px 3px rgba(0, 0, 0, 0.5);
	background-color: gray;
	border: 3px dotted coral;
	color: black;
}


</style>
<section id="bbs-detail-header">
	<article>
		<a href="${rootPath}/upload/${BBSVO.b_file}" target=_new><img
			src="${rootPath}/upload/${BBSVO.b_file}" width="200px"></a>
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

<section id="bbs-button-box">
	<button class="list">리스트로</button>
	<button class="update">수정</button>
	<button class="delete">삭제</button>
</section>

<script>
	//------------------------------- 신형 -------------------------------------
	document.addEventListener("DOMContentLoaded", function() {
		document.querySelector("section#bbs-button-box").addEventListener(
				"click", function(e) {
					let url = "${rootPath}/bbs/${BBSVO.b_seq}/"
					if (e.target.tagName === ("BUTTON")) {

						if (e.target.className == "delete") {
							if (!confirm("정말 삭제? ><")) {
								alert("역시 이것은 귀중한 수박")
								return false;
							} else {
								alert("다시 봐도 허접하지? 날려버렸지롱 ><")
							}
						}

						document.location.href = url + e.target.className
					}
				})
	})

	//------------------------------- 구형 -------------------------------------

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