<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name='viewport' content='width=device-width, initial-scale=1'>
<title>Insert title here</title>
</head>
<body>

<table>
	<tr>
		<td><img src="${bookVO.image}"></td>
		<td>
			<table>
				<tr><th>도서명</th><td>title</td></tr>
				<tr><th>저자</th><td>author</td></tr>
				<th>도서정가</th><td>price</td></tr>
				<tr><th>할인가격</th><td>discount</td></tr>
				<tr><th>출판사</th><td>publisher</td></tr>
				<tr><th>ISBN</th><td>isbn</td></tr>
				<tr><th>출간일</th><td>pubdate</td></tr>
			</table>
		</td>
	</tr>
	<tr>
	<th>상세정보</th><td>description</td>
	</tr>
	<tr>	
		<th>구입가격</th><td>buyprice</td>
		<th>구입처</th><td>buystore</td>
	</tr>
	
	<th>구입일</th><td>buydate</td>
	<th>상세정보</th><td>link</td>
	
</table>

</body>
</html>