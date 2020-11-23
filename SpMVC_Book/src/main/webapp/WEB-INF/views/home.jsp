<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>여기는 제목</title>
</head>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.0/axios.min.js"></script>
<script>
	document.addEventlistener("DOMContentLoaded", function() {
		const data = {
			title : "민족 전래동화 농농이",
			author : "쩔쩔이",
			comp : "우리출판사",
			price : 200000000
		}

		axios.post("${rootPath}/api/insert", {
			title : "민족 전래동화 농농이",
			author : "쩔쩔이",
			comp : "우리출판사",
			price : 200000000
		}).then(document.location.href = "${rootPath}/api/list")
	})
</script>
<body>

</body>
</html>