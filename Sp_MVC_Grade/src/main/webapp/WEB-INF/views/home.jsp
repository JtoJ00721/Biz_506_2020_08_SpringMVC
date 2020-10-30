<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>성적표</title>
<style>
table {
	border-collapse: collapse;
	width: 100%;
	border: 5px dashed olive;
	width: 100%;
}

td {
	border: 1px solid gray;
	text-align: center;
}

tbody tr {
	cursor: pointer;
}

tbody tr:hover {
	background-color: rgba(0, 0, 0, 0.2);
}
</style>
</head>
<body>

	<table>
		<thead>
			<tr>
				<th>학번</th>
				<th>이름</th>
				<th>국어</th>
				<th>영어</th>
				<th>수학</th>
				<th>총점</th>
				<th>평균</th>
				<th>기타</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty LIST}">
				<tr>
					<td colspan="8">데이터 없지롱</td>
				</tr>
			</c:if>

			<c:forEach items="${LIST}" var="item">
				<tr class="list_item" data-id="${item.seq}">
					<td>${item.seq}</td>
					<td>${item.name}</td>
					<td>${item.guk}</td>
					<td>${item.young}</td>
					<td>${item.su}</td>
					<td>${item.sum}</td>
					<td>${item.avg}</td>
					<td><a href="${rootPath}/delete?seq=${item.seq}">삭제</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<div id="aholder">
		<a id="write_new" href="${rootPath}/input">새로작성</a>
	</div>

</body>
<script>
$(function(){
	$(".List_item").click(function(){
		let seq = $(this).data("id")
		document.location.href ="${rootPath}/update?seq=" + seq
	})
})
</script>
</html>