<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />

<style>
form#read-book-write {
	display: flex;
	padding: 5px;
}

form#read-book-write input, form#read-book-write button {
	flex: 1;
	margin: 5px 2px;
	border: 1px solid; # ccc;
	outline: none;
	padding: 8px;
}

form#read-book-write input[name='r_comment'] {
	flex: 5;
}
</style>

<form:form id="read-book-write" action="${rootPath}/read/write" modelAttribute="readBookVO">
<form:input path="r_book_seq" type="hidden" value="${BOOKVO.seq}"/>
	<form:input path="r_date" type="date" placeholder="읽은 날짜" />
	<form:input path="r_stime" placeholder="읽기 시작 시간" />
	<form:input path="r_etime" placeholder="읽기 마침 시간" />
	<form:input path="r_comment" placeholder="읽은 소감" />
	<button>저장</button>
</form:form>

<table>
	<tr>
		<th>읽은날짜</th>
		<th>시작</th>
		<th>종료</th>
	</tr>
	<c:forEach items="${READ_BOOK}" var="vo">
		<tr>
			<td>${vo.r_date}</td>
			<td>${vo.r_stime}</td>
			<td>${vo.r_etime}</td>
		</tr>
	</c:forEach>
</table>