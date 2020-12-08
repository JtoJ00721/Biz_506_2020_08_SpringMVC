<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>버스 노선 검색</title>
<style>
* {
	box-sizing: border-box;
	padding: 0px;
	margin: 0px;
}

header {
	padding: 2rem;
	background-color: green;
	text-align: center;
	margin-bottom: 0px;
}

nav.main-nav ul {
	display: flex;
	list-style: none;
	background-color: cornflowerblue;
	color: white;
}

nav.main-nav li:nth-child(2), nav.main-nav li:nth-child(3) {
	margin-left: auto;
}

.main-nav li {
	padding: 0.5rem;
	margin: 3px;
	cursor: pointer;
	transition: all 0.7s;
	border: 2px dashed black;
	cursor: pointer;
}

nav.main-nav li:hover {
	background-color: gray;
	color: black;
}

.hosp-list {
	border-collapse: collapse;
	border-spacing: 0;
	width: 90%;
	border: 1px solid #ccc;
	margin: 20px auto;
}

.hosp-list th {
	text-align: left;
}

.hosp-list tr {
	border: 1px solid #ddd;
	transition: all 0.5s;
}

.hosp-list tr:nth-child(even) {
	background-color: #ccc;
}

.hosp-list tr:nth-child(odd) {
	background-color: #fff;
}

.hosp-list tr:hover {
	background-color: #ddd;
	cursor: pointer;
}

.hosp-list td, hosp-list th {
	padding: 8px;
	vertical-align: top;
	white-space: nowrap; /* table의 text를 줄바꿈하지 말라 */
}
</style>


</head>
<body>
	<header>
		<h2>공공DB 활용</h2>
	</header>
	<nav class="main-nav">
		<ul>
			<li>Home</li>
			<li><input /></li>
			<li>
				<form>
					<input type="search" name="hosp" placeholder="동물병원 이름을 입력한 후 Enter" />
				</form>
			</li>
			<li class="get-station">정보 가져오기</li>
		</ul>
	</nav>

	<section>
		<table class="hosp-list">
			<tr>
				<th>병원이름</th>
				<th>도로명주소</th>
				<th>지번주소</th>
				<th>전화번호</th>
				<th>위도</th>
				<th>경도</th>
				<th>데이터기준일</th>
			</tr>
			<c:choose>
				<c:when test="${empty H_LIST}">
					<tr>
						<td colspan="7">데이터가 없지롱</td>
					</tr>
				</c:when>
				<c:otherwise>
					<c:forEach items="${H_LIST}" var="hs">
						<tr>
							<td>${hs.apiDongName}</td>
							<td>${hs.apiNewAddress}</td>
							<td>${hs.apiOldAddress}</td>
							<td>${hs.apiTel}</td>
							<td>${hs.apiLat}</td>
							<td>${hs.apiLng}</td>
							<td>${hs.apiRegDate}</td>
						</tr>
					</c:forEach>
				</c:otherwise>
			</c:choose>
		</table>
	</section>
</body>
<script>
	document.addEventListener("DOMContentLoaded", function() {

		let getStationButton = document
				.querySelector("nav.main-nav .get-station");
		getStationButton.onclick = function() {
			document.location.href = "${rootPath}/bis/station";
		}
	})
</script>
</html>