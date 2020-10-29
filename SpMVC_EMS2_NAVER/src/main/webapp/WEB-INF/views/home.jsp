<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>내가보낸 메일</title>
<style>
table#ems-list {
	width: 80%;
	margin: 10px auto;
	margin-top: 30px;
	border-collapse: collapse;
	border: 3px dashed aqua;
	border-collapse: collapse;
}

#ems-list td {
	border: 1px solid gray;
	padding: 8px;
}

#ems-list thead th {
	padding: 10px 0px;
}

#ems-list tbody tr {
	cursor: pointer;
	transition: all 0.7s;
	text-align: center;
}

#ems-list tbody tr:hover {
	background-color: rgba(0, 0, 0, 0.2);
}
</style>
</head>
<body>
	<table id="ems-list">
		<thead>
			<tr>
				<th>발송 Email</th>
				<th>수신 Email</th>
				<th>발송일자</th>
				<th>발송 시각</th>
				<th>제목</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody>
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
					<td><a href="${rootPath}/update?id=${ems.id}">
							${ems.s_subject} </a></td>

					<td><a href="${rootPath}/delete?id=${ems.id}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<div>
		<a href="${rootPath}/write">메일작성</a>
	</div>
</body>
</html>