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
<style>
table#ems-list {
	width: 80%;
	margin: 10px auto;
	border-collapse: collapse;
	border: 3px dashed aqua;
}
</style>
</head>
<body>
	<table id="ems-list">
		<tr>
			<th>발송 Email</th>
			<th>수신 Email</th>
			<th>발송일자</th>
			<th>발송 시각</th>
			<th>제목</th>
		</tr>

		<c:if test="${empty EMS_LIST}">
			<tr>
				<td colspan="5">데이터 없지롱</td>
			</tr>
		</c:if>
		
		<c:forEach items="${EMS_LIST}" var="ems">
			<tr>
				<td>${ems.from_email}</td>
				<td>${ems.to_email}</td>
				<td>${ems.s_date}</td>
				<td>${ems.s_time}</td>
				<td>${ems.s_subject}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="${rootPath}/write">메일작성</a>
	</div>
</body>
</html>