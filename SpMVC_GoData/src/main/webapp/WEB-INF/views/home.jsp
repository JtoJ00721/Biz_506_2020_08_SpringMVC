<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="rootPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공공DB 활용</title>
<link rel="stylesheet"
	href="${rootPath}/static/css/main.css?ver=2020-12-10-1">
	<link rel="stylesheet"
	href="${rootPath}/static/css/station.css?ver=2020-12-10-2" />
</head>
<body>
	<header>
		<h2>공공DB 활용</h2>
	</header>
	<nav class="main-nav">
		<ul>
			<li id="home-button">Home</li>
			<li>
				<form>
					<select name="cat">
						<option value="hosp">병원명</option>
						<option value="addr">주소</option>
					</select> <input type="search" name="search"
						placeholder="동물병원 이름을 입력한 후 Enter" />
				</form>
			</li>
			<li>
				<form action="${rootPath}/bis/station">
					<input name="station" placeholder="정류소 입력후 Enter" />
				</form>
			</li>
			<li class="get-station">노선정보 가져오기</li>
		</ul>
	</nav>

	<section class="main-body">
		<c:if test="${BODY == 'STATION'}">
			<%@ include file="/WEB-INF/views/station_view.jsp"%>
			<%@ include file="/WEB-INF/views/busstop_view.jsp"%>
		</c:if>

		<c:if test="${BODY == 'PET'}">
			<%@ include file="/WEB-INF/views/pet_view.jsp"%>
		</c:if>
	</section>

</body>
<script>
	document.addEventListener("DOMContentLoaded", function() {

		let getStationButton = document
				.querySelector("nav.main-nav .get-station");
		getStationButton.onclick = function() {
			document.location.href = "${rootPath}/bis/station";
		}

		let homeButton = document.querySelector("#home-button")
		homeButton.onclick = function() {
			document.location.href = "${rootPath}";
		}

		const select_cat = document.querySelector("select[name='cat']")
		select_cat.onchange = function(e) {
			// change 이벤트가 발생하면 value값을 추출하고
			const value = e.target.value
			let hopInput = document.querySelector("input[name='search']");
			// value값이 hosp이면
			if (value === 'hosp') {
				// placeholder의 내용을 변경
				hopInput.placeholder = "병원명 입력후 Enter"
			} else {
				hopInput.placeholder = "주소 입력후 Enter"
			}
		}

	})
</script>
</html>