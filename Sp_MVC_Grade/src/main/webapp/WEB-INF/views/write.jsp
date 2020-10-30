<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>성적 입력창</title>
</head>
<body>
	<form method="POST">
		<div>
			<label>학생이름</label><input name="name" value="${INFO.name}"/>
		</div>
		<div>
			<label>국어점수</label><input name="guk" value="${INFO.guk}"/>
		</div>
		<div>
			<label>영어점수</label><input name="young" value="${INFO.young}"/>
		</div>
		<div>
			<label>수학점수</label><input name="su" value="${INFO.su}"/>
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