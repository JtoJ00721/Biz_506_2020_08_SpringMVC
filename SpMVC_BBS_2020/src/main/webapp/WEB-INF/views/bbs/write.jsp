<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<style>
form#write-form {
	width: 80%;
	margin: 10px auto;
}

form#write-form fieldset {
	border: 1px solid blue;
	border-radius: 10px;
}

form#write-form legend {
	color: blue;
	margin: 5px;
	padding: 5px;
}

form#write-form label {
	display: inline-block;
	width: 20%;
	padding: 4px;
	margin: 4px;
	text-align: right;
	font-weight: bold;
}

form#write-form input {
	display: inline-block;
	width: 70%;
	padding: 4px;
	margin: 4px;
}

form#write-form textarea {
	width: 70%;
}

div.button-box {
	text-align: right;
}

form#write-form .button-box button {
	color: white;
	cursor: pointer;
	outline: none;
	border: 0;
	padding: 10px 16px;
	margin: 5px;
	transition: all 0.5s;
	border: 0;
}

button:hover {
	box-shadow: 2px 2px 2px rgba(0, 0, 0, 0.5)
}

button#list {
	background-color: green;
}

button#save {
	background-color: blue;
}
</style>
<script>
	$(function() {
		$("#b_content").summernote({ lang:"ko-KR",width:"80%",height:"200px",toolbar : [
		['style',['style']]	
			
		]
		});
	})
</script>
<form id="write-form">
	<fieldset>
		<legend>글쓰기</legend>
		<div>
			<label>작성일자</label> <input name="b_date">
		</div>
		<div>
			<label>작성시각</label> <input name="b_time">
		</div>
		<div>
			<label>작성자</label> <input name="b_writer">
		</div>
		<div>
			<label>제목</label> <input name="b_subject">
		</div>
		<div>
			<label></label>
			<textarea id="b_content" rows="5" cols="20"></textarea>
		</div>
		<div class="button-box">
			<button type="button" id="list">리스트로</button>
			<button type="button" id="save">저장</button>
		</div>
	</fieldset>
</form>