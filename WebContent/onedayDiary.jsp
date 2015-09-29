<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>日誌</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">

<link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="scripts/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet">

<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

<!-- Icons -->
<link href="scripts/icons/general/stylesheets/general_foundicons.css"
	media="screen" rel="stylesheet" type="text/css" />
<link href="scripts/icons/social/stylesheets/social_foundicons.css"
	media="screen" rel="stylesheet" type="text/css" />
<!--[if lt IE 8]>
        <link href="scripts/icons/general/stylesheets/general_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="scripts/icons/social/stylesheets/social_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
    <![endif]-->
<link rel="stylesheet"
	href="scripts/fontawesome/css/font-awesome.min.css">
<!--[if IE 7]>
        <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome-ie7.min.css">
    <![endif]-->


<link href="http://fonts.googleapis.com/css?family=Allura"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Aldrich"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Palatino+Linotype"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Calligraffitti"
	rel="stylesheet" type="text/css">

<link href="styles/custom.css" rel="stylesheet" type="text/css" />
<style>
#map {
	height: 700px;
}

#info {
	display: none;
}

#panel {
	position: absolute;
	top: 10px;
	left: 25%;
	z-index: 5;
	background-color: #fff;
	padding: 5px; */
	border: 1px solid #999;
	text-align: center;
}

#panel, .panel {
	font-family: 'Roboto', 'sans-serif';
	line-height: 30px;
	padding-left: 10px;
}

#panel select, #panel input, .panel select, .panel input {
	font-size: 15px;
}

#panel select, .panel select {
	width: 100%;
}

#panel i, .panel i {
	font-size: 12px;
}

.panel {
	height: 100%;
	overflow: auto;
}
</style>
</head>
<body id="pageBody">
	<c:set var="funcName" value="DIARY" scope="session" />
	<jsp:include page="/page/header.jsp" />

	<div id="contentOuterSeparator"></div>

	<div class="container">

		<div class="divPanel page-content">


			<div style="border: 2px solid blue; width: 100%; height: 100%;">
				<!-- blue至頂上條線 -->
			</div>

			<div id="${vo.date}"
				style="width: 33%; float: left; height: 100%; font-family: Microsoft JhengHei; border: 2px solid red;">
				<!-- red首頁日誌 -->


				<div>
					<!-- title & date -->
					<!-- 標題日期標頭 -->
					<span style="font-size: 0.5cm; color: #AAAAAA; line-height: 40px">${list.date}</span>
					<br> <span
						style="padding-left: 20px; font-size: 0.8cm; font-family: Microsoft JhengHei; font-weight: bold;">${list.title}</span>
				</div>
				<br>
				<br>
				<div style="height: 100%;">
					<!-- green首頁三餐活動 -->

					<fieldset>
						<legend>健康指標</legend>
						身高：
						<td>${list.height}</td> <br> 體重：
						<td>${list.weight}</td> <br> 腰圍：
						<td>${list.waistline}</td> <br> BMI：
						<td><fmt:formatNumber type="number" maxIntegerDigits="2"
								value="${list.weight/((list.height/100)*(list.height/100))}" /></td>


						<br> 建議：
						<!-- BMI -->

						<c:choose>
							<c:when
								test="${(list.weight/((list.height/100)*(list.height/100)) < 18.5 ) }">
								<td>體重過輕</td>
							</c:when>
							<c:when
								test="${ ( list.weight/((list.height/100)*(list.height/100)) < 24 ) }">
								<td>標準體重</td>
							</c:when>
							<c:when
								test="${(list.weight/((list.height/100)*(list.height/100)) < 27 ) }">
								<td>過重</td>
							</c:when>
							<c:when
								test="${(list.weight/((list.height/100)*(list.height/100)) < 30 ) }">
								<td>輕度肥胖</td>
							</c:when>
							<c:when
								test="${(list.weight/((list.height/100)*(list.height/100)) < 35 ) }">
								<td>中度肥胖</td>
							</c:when>
							<c:when
								test="${(list.weight/((list.height/100)*(list.height/100)) >= 35 ) }">
								<td>重度肥胖</td>
							</c:when>
						</c:choose>




					</fieldset>

				</div>

				<br>
				<br>
				<div style="border: 2px solid blue;">
<!-- 					<fieldset style="padding: 100%; border: 2px solid blue; width: 33%"> -->
<!-- 						<legend style="border: none;">飲食運動指南</legend> -->
飲食運動指南<br>
						<div style="width: 199.7px; height: 100%;">
							早上<br>
							<c:forEach var="eat" items="${list.eatVo}">
								<!-- 							eat_record因為很多筆相同時段.菜色,所以用foreach -->
								<c:if test="${eat.time == '早上' }">

									${eat.foodCalVO.name}
									${eat.foodCalVO.cal}
									${eat.foodCalVO.count}
									${eat.foodCalVO.weight}
									${eat.count}<br>
								</c:if>
							</c:forEach>
							<hr>
						</div>

						<div style="width: 199.7px; height: 100%;">
							中午<br>
							<c:forEach var="eat" items="${list.eatVo}">
								<c:if test="${eat.time =='中午'}">
			 							${eat.foodCalVO.name}
			 							${eat.foodCalVO.cal}
			 							${eat.foodCalVO.count}
			 							${eat.foodCalVO.weight}
			 							${eat.count}<br>
								</c:if>
							</c:forEach>
							<hr>
						</div>


						<div style="width: 199.7px; height: 100%;">
							晚上<br>
							<c:forEach var="eat" items="${list.eatVo}">
								<c:if test="${eat.time=='晚上'}">
			 							${eat.foodCalVO.name}
			 							${eat.foodCalVO.cal}
			 							${eat.foodCalVO.count}
			 							${eat.foodCalVO.weight}
			 							${eat.count}<br>
								</c:if>
							</c:forEach>
							<hr>
						</div>

						<div style="width: 199.7px; height: 100%; float: right">
							運動<br>
							<c:forEach var="exer" items="${list.exerVo}">
									${exer.exerciseCalVO.name}
									${exer.exerciseCalVO.calHour}
									${exer.count}<br>
							</c:forEach>
							<hr>
						</div>
						<div>飲食總熱量 ${eat.count*eat.foodCalVO.cal}</div>
						<div>運動總熱量</div>
						<hr>
<!-- 					</fieldset> -->
				</div>


			</div>





		</div>


		<div
			style="width: 65%; float: right; height: 100%; border: 3px solid yellow;">
			<!-- calendar right-hand -->

			<fieldset>
				<legend>我的日誌</legend>
				<br> 標題：
				<td>${list.title}</td> <br> 內容：
				<td>${list.content}</td> <br>

			</fieldset>
		</div>


<c:url value="diaryIndex.controller" var="path"> 
					<c:param name="no" value="${list.no}"></c:param>
				</c:url>
				<div>
					<button name="back" style="float: left">
						<a href="diaryIndex.controller">BACK</a>
					</button>
				</div>
				<div>
					<button name="edit">
						<a href="${path}">編輯</a>
					</button>
				</div>





















		<!-- 			<tr> -->
		<!-- 				日期： -->
		<%-- 				<td>${list.date}</td> --%>
		<!-- 				<br> 身高： -->
		<%-- 				<td>${list.height}</td> --%>
		<!-- 				<br> 體重： -->
		<%-- 				<td>${list.weight}</td> --%>
		<!-- 				<br> 腰圍： -->
		<%-- 				<td>${list.waistline}</td> --%>
		<!-- 				<br> BMI： -->
		<%-- 				<td><fmt:formatNumber type="number" maxIntegerDigits="2" --%>
		<%-- 						value="${list.weight/((list.height/100)*(list.height/100))}" /></td> --%>
		<!-- 				<br> 建議： -->
		<!-- 				BMI -->

		<%-- 				<c:choose> --%>
		<%-- 					<c:when --%>
		<%-- 						test="${(list.weight/((list.height/100)*(list.height/100)) < 18.5 ) }"> --%>
		<!-- 						<td>體重過輕</td> -->
		<%-- 					</c:when> --%>
		<%-- 					<c:when --%>
		<%-- 						test="${ ( list.weight/((list.height/100)*(list.height/100)) < 24 ) }"> --%>
		<!-- 						<td>標準體重</td> -->
		<%-- 					</c:when> --%>
		<%-- 					<c:when --%>
		<%-- 						test="${(list.weight/((list.height/100)*(list.height/100)) < 27 ) }"> --%>
		<!-- 						<td>過重</td> -->
		<%-- 					</c:when> --%>
		<%-- 					<c:when --%>
		<%-- 						test="${(list.weight/((list.height/100)*(list.height/100)) < 30 ) }"> --%>
		<!-- 						<td>輕度肥胖</td> -->
		<%-- 					</c:when> --%>
		<%-- 					<c:when --%>
		<%-- 						test="${(list.weight/((list.height/100)*(list.height/100)) < 35 ) }"> --%>
		<!-- 						<td>中度肥胖</td> -->
		<%-- 					</c:when> --%>
		<%-- 					<c:when --%>
		<%-- 						test="${(list.weight/((list.height/100)*(list.height/100)) >= 35 ) }"> --%>
		<!-- 						<td>重度肥胖</td> -->
		<%-- 					</c:when> --%>
		<%-- 				</c:choose> --%>
		<!-- 				<br> 標題： -->
		<%-- 				<td>${list.title}</td> --%>
		<!-- 				<br> 內容： -->
		<%-- 				<td>${list.content}</td> --%>
		<!-- 				<br> -->

		<!-- 				<div style="width: 199.7px; height: 100%;"> -->
		<!-- 					運動<br> -->
		<%-- 					<c:forEach var="exer" items="${list.exerVo}"> --%>
		<%-- 							${exer.exerciseCalVO.name} --%>
		<%-- 							${exer.exerciseCalVO.calHour} --%>
		<%-- 							${exer.count}<br> --%>
		<%-- 					</c:forEach> --%>
		<!-- 					<hr> -->
		<!-- 				</div> -->
		<!-- 		</div> -->
		<%-- 		<div>飲食總熱量 ${eat.count*eat.foodCalVO.cal}</div> --%>
		<!-- 		<div>運動總熱量</div> -->
		<!-- 		<hr> -->
		<!-- 		</tr> -->

		<!-- 		<div style="width: 199.7px; height: 100%;"> -->
		<!-- 			早上<br> -->
		<%-- 			<c:forEach var="eat" items="${list.eatVo}"> --%>
		<!-- 				eat_record因為很多筆相同時段.菜色,所以用foreach -->
		<%-- 				<c:if test="${eat.time == '早上' }"> --%>

		<%-- 											${eat.foodCalVO.name} --%>
		<%-- 											${eat.foodCalVO.cal} --%>
		<%-- 											${eat.foodCalVO.count} --%>
		<%-- 											${eat.foodCalVO.weight} --%>
		<%-- 											${eat.count}<br> --%>
		<%-- 				</c:if> --%>
		<%-- 			</c:forEach> --%>
		<!-- 			<hr> -->
		<!-- 		</div> -->



		<!-- 		<div style="width: 199.7px; height: 100%;"> -->
		<!-- 			中午<br> -->
		<%-- 			<c:forEach var="eat" items="${list.eatVo}"> --%>
		<%-- 				<c:if test="${eat.time =='中午'}"> --%>
		<%--  							${eat.foodCalVO.name} --%>
		<%--  							${eat.foodCalVO.cal} --%>
		<%--  							${eat.foodCalVO.count} --%>
		<%--  							${eat.foodCalVO.weight} --%>
		<%--  							${eat.count}<br> --%>
		<%-- 				</c:if> --%>
		<%-- 			</c:forEach> --%>
		<!-- 			<hr> -->
		<!-- 		</div> -->


		<!-- 		<div style="width: 199.7px; height: 100%;"> -->
		<!-- 			晚上<br> -->
		<%-- 			<c:forEach var="eat" items="${list.eatVo}"> --%>
		<%-- 				<c:if test="${eat.time=='晚上'}"> --%>
		<%--  							${eat.foodCalVO.name} --%>
		<%--  							${eat.foodCalVO.cal} --%>
		<%--  							${eat.foodCalVO.count} --%>
		<%--  							${eat.foodCalVO.weight} --%>
		<%--  							${eat.count}<br> --%>
		<%-- 				</c:if> --%>
		<%-- 			</c:forEach> --%>
		<!-- 			<hr> -->
		<!-- 		</div> -->




		<%-- 		<c:url value="diaryIndex.controller" var="path"> --%>
		<%-- 			<c:param name="no" value="${list.no}"></c:param> --%>
		<%-- 		</c:url> --%>
		<!-- 		<div> -->
		<!-- 			<button name="back" style="float: left"> -->
		<!-- 				<a href="diaryIndex.controller">BACK</a> -->
		<!-- 			</button> -->
		<!-- 		</div> -->
		<!-- 		<div> -->
		<!-- 			<button name="edit"> -->
		<%-- 				<a href="${path}">編輯</a> --%>
		<!-- 			</button> -->
		<!-- 		</div> -->





	</div>

	</div>






	<div id="footerOuterSeparator"></div>
	<jsp:include page="/page/footer.jsp" />

	<script src="scripts/jquery.min.js" type="text/javascript"></script>
	<script src="scripts/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="scripts/default.js" type="text/javascript"></script>
</body>
</html>