<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>작성창</title>
</head>
<body>
	<form method="POST">
		<div>
			<label>보내는 이메일</label> <input name="from_email"
				value="${EMS.from_email}" />
		</div>
		<div>
			<label>받는 이메일</label> <input name="to_email" value="${EMS.to_email}" />
		</div>
		<div>
			<label>보내는 날짜</label> <input name="s_date" value="${EMS.s_date}" />
		</div>
		<div>
			<label>보내는 시각</label> <input name="s_time" value="${EMS.s_time}" />
		</div>
		<div>
			<label>제목</label> <input name="s_subject" value="${EMS.s_subject}" />
		</div>
		<div>
			<label>내용용이</label>
			<textarea name="s_content">${EMS.s_content}</textarea>
		</div>
		<div>
			<label>첨부파일</label> <input name="file1" /> <input name="file2" />
		</div>
		<div>
			<button>저장</button>
			<button type="button" onclick="tolist()">리스트로</button>
		</div>
	</form>
</body>
<script>
	function tolist() {
		document.location.href = "${rootPath}"
	}
</script>
</html>