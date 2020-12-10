<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<link rel="stylesheet"
	href="${rootPath}/static/css/station.css?ver=2020-12-09-3" />
<article class="busstop-list">
	<table class="bis busstop-list">
		<thead>
			<tr>
				<th>노선번호</th>
				<th>현재위치</th>
				<th>도착예정시간</th>
				<th>남은 정류장</th>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty AR_LIST}">
				<tr>
					<td colspan="4">정류장을 클릭해야 하지롱</td>
				</tr>
			</c:if>
		</tbody>
	</table>
</article>

