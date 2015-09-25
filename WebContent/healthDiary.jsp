<%@page import="java.util.*"%>
<%@page import="health.model.HealthDiaryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<!-- head -->
<title>Belly Worry - Enjoy Your Life</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Html5TemplatesDreamweaver.com">
<META NAME="ROBOTS" CONTENT="NOINDEX, NOFOLLOW">
<!-- Remove this Robots Meta Tag, to allow indexing of site -->

<!--今日日誌時間用 -->
<link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="scripts/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif] -->

<!-- Icons -->
<link href="scripts/icons/general/stylesheets/general_foundicons.css"
	media="screen" rel="stylesheet" type="text/css" />
<link href="scripts/icons/social/stylesheets/social_foundicons.css"
	media="screen" rel="stylesheet" type="text/css" />
<!--[if lt IE 8]>
        <link href="scripts/icons/general/stylesheets/general_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="scripts/icons/social/stylesheets/social_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
    <![endif] -->
<link rel="stylesheet"
	href="scripts/fontawesome/css/font-awesome.min.css">
<!--[if IE 7]>
        <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome-ie7.min.css">
    <![endif] -->

<link href="scripts/carousel/style.css" rel="stylesheet" type="text/css" />
<link href="scripts/camera/css/camera.css" rel="stylesheet"
	type="text/css" />

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
<!--     <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css"> -->
<link href="http://fonts.googleapis.com/css?family=Calligraffitti"
	rel="stylesheet" type="text/css">
<link href="styles/custom.css" rel="stylesheet" type="text/css" />

<!-- head -->



<link rel="stylesheet" href="/resources/demos/style.css">
<!-- <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> -->
<!-- 因為edit受侷限,且css一動則動全身,所以暫時關閉 -->
<link rel="stylesheet" type="text/css" href="jeasyui/easyui.css">
<link rel="stylesheet" type="text/css" href="jeasyui/icon.css">
<link rel="stylesheet" type="text/css" href="jeasyui/demo.css">

<!-- 以上月曆用 -->


<jsp:include page="/page/header.jsp" />

</head>
<body id="pageBody">






	<div id="contentOuterSeparator"></div>

	<div class="container">
		<div class="divPanel page-content">
		<br><br>
			<div class="breadcrumbs">
				<a href="index.jsp">Home</a> &nbsp;/&nbsp; <span>健康管理日誌</span>
			</div>
			<div class="headerr" style="border: none;">
<!-- 				<ul class="nav nav-tabs" style="background-color: white;"> -->
<!-- 					<li class="active"><a href="#t-1">日誌首頁</a></li> -->
<!-- 					<li><a href="#t-2">今日紀錄</a></li> -->
<!-- 					<li><a href="#t-3">歷史紀錄</a></li> -->
<!-- 				</ul> -->

				<div id="t-1" style="height: 100%;">
					<div style="border: 2px solid blue; width: 100%; height: 100%;">
					</div>


					<c:forEach var="vo" items="${list}">
						<c:url value="oneday.controller" var="path">
							<c:param name="no" value="${vo.no}"></c:param>

						</c:url>
						<div id="${vo.date}" style="width: 70%; float: left; border: 2px solid red; height: 100%;">
							<div>
								<div style="border: 2px solid;">
									<span style="font-size: 0.5cm">${vo.date}</span> <span
										style="padding-left: 20px; font-size: 0.8cm">${vo.title}</span>
								</div>

								<div style="height: 200px; border: 2px solid green;">

									<div
										style="border: 2px solid orange; width: 199.7px; height: 100%; float: left;">
										早上<br>
										<c:forEach var="eat" items="${vo.eatVo}">
											<!-- eat_record因為很多筆相同時段.菜色,所以用foreach -->
											<c:if test="${eat.time == '早上' }">
											
											${eat.foodCalVO.name}
											${eat.foodCalVO.cal} 卡
											${eat.count}
											${eat.foodCalVO.count}
											${eat.foodCalVO.weight}g<br>
											
											</c:if>
										</c:forEach>
									</div>

									<div
										style="border: 2px solid orange; width: 199.7px; height: 100%; float: left;">
										中午<br>
										<c:forEach var="eat" items="${vo.eatVo}">
											<c:if test="${eat.time =='中午'}">
 							${eat.foodCalVO.name}
 							${eat.foodCalVO.cal} 卡
 							${eat.count}
 							${eat.foodCalVO.count}
 							${eat.foodCalVO.weight}g<br>
											</c:if>
										</c:forEach>
									</div>
									<div
										style="border: 2px solid orange; width: 199.7px; height: 100%; float: left;">
										晚上<br>
										<c:forEach var="eat" items="${vo.eatVo}">
											<c:if test="${eat.time=='晚上'}">
 							${eat.foodCalVO.name}
 							${eat.foodCalVO.cal} 卡
 							${eat.count}
 							${eat.foodCalVO.count}
 							${eat.foodCalVO.weight}g<br>
 							
											</c:if>
										</c:forEach>
									</div>
									<div
										style="border: 2px solid orange; width: 199.7px; height: 100%; float: left;">
										活動<br>
										<c:forEach var="exer" items="${vo.exerVo}">
							${exer.exerciseCalVO.name}
							${exer.exerciseCalVO.calHour}大卡
							${exer.count}min<br>
										</c:forEach>
									</div>
								</div>
								<div>飲食總熱量</div>
								<div>運動總熱量</div>
								<div>
									<a href="${path}">詳讀內文</a>
								</div>
								<hr>
							</div>
						</div>
					</c:forEach>
					<div
						style="width: 29%; float: right; border: 2px solid yellow; height: 100%;">

						<div style="width: 100%;"></div>
						<div id="cc" class="easyui-calendar"
							style="width: 335px; height: 360px; position: absolute; top: 272px"></div>

						







					</div>

					<div class="tab-content" style="height: 100%; width: 100%;">
						<table border='1'>
							<tr>
								<th width='70'>會員編號</th>
								<th width='70'>健康管理id</th>
								<th width='70'>日期</th>
								<th width='70'>身高</th>
								<th width='70'>體重</th>
								<th width='70'>腰圍</th>
								<th width='70'>BMI</th>
								<th width='70'>建議</th>
								<th width='70'>日誌標題</th>
								<th width='70'>日誌內容</th>
								<th width='70'>同意分享日誌</th>


								<th width='70'>日期</th>
								<th width='70'>運動</th>
								<th width='70'>每一小時消耗熱量</th>
								<th width='70'>分量</th>


								<th width='70'>日期</th>
								<th width='70'>時段</th>
								<th width='70'>菜色名稱</th>
								<th width='70'>熱量</th>
								<th width='70'>一搬份量</th>
								<th width='70'>每份公克數</th>
								<th width='70'>份量</th>
								<th width='70'>總熱量</th>
							</tr>
							<c:forEach var="vo" items="${list}">
								<tr>
									<td>${vo.memberNo}</td>
									<td>${vo.no}</td>
									<td>${vo.date}</td>
									<td>${vo.height}</td>
									<td>${vo.weight}</td>
									<td>${vo.waistline}</td>
									<td>${vo.weight/((vo.height/100)*(vo.height/100))}</td>
									<!-- BMI -->
									<c:choose>
										<c:when
											test="${(vo.weight/((vo.height/100)*(vo.height/100)) < 18.5 ) }">
											<td>體重過輕</td>
										</c:when>
										<c:when
											test="${ ( vo.weight/((vo.height/100)*(vo.height/100)) < 24 ) }">
											<td>標準體重</td>
										</c:when>
										<c:when
											test="${(vo.weight/((vo.height/100)*(vo.height/100)) < 27 ) }">
											<td>過重</td>
										</c:when>
										<c:when
											test="${(vo.weight/((vo.height/100)*(vo.height/100)) < 30 ) }">
											<td>輕度肥胖</td>
										</c:when>
										<c:when
											test="${(vo.weight/((vo.height/100)*(vo.height/100)) < 35 ) }">
											<td>中度肥胖</td>
										</c:when>
										<c:when
											test="${(vo.weight/((vo.height/100)*(vo.height/100)) >= 35 ) }">
											<td>重度肥胖</td>
										</c:when>
									</c:choose>

									<td>${vo.title}</td>
									<td>${vo.content}</td>
									<td>${vo.share}</td>

									<td>${vo.exerVo[0].date}</td>
									<td><c:forEach var="exer" items="${vo.exerVo}">${exer.exerciseCalVO.name}</c:forEach></td>
									<td><c:forEach var="exer" items="${vo.exerVo}">${exer.exerciseCalVO.calHour}</c:forEach></td>
									<td><c:forEach var="exer" items="${vo.exerVo}">${exer.count}</c:forEach></td>





									<td>${vo.eatVo[0].date}</td>
									<td><c:forEach var="eat" items="${vo.eatVo}">${eat.time }<br></c:forEach></td>
									<td><c:forEach var="eat" items="${vo.eatVo}">${eat.foodCalVO.name}<br>
										</c:forEach></td>
									<td><c:forEach var="eat" items="${vo.eatVo}">${eat.foodCalVO.cal}<br>
										</c:forEach></td>
									<td><c:forEach var="eat" items="${vo.eatVo}">${eat.foodCalVO.count}<br>
										</c:forEach></td>
									<td><c:forEach var="eat" items="${vo.eatVo}">${eat.foodCalVO.weight}<br>
										</c:forEach></td>
									<td><c:forEach var="eat" items="${vo.eatVo}"> ${eat.count}<br>
										</c:forEach></td>
									<td><c:forEach var="eat" items="${vo.eatVo}"> ${eat.count*eat.foodCalVO.cal}<br>
										</c:forEach></td>
								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
				<div id="t-2">

					<div style="border: 2px solid blue; width: 95%; height: 100%;">
						<form action="health.collection" method="post">
							<!-- left -->
							<div
								style="width: 40%; float: left; border: 2px solid red; height: 100%;">


								<!--     								<input class="easyui-datebox" ></input> -->

								<!-- 時間!!! -->
								日期： <input class="easyui-datebox" name="date"
									value="${bean.date}"></input>


<!--  <div class="easyui-accordion" style="width:500px;height:300px;"> -->
<!--         <div title="About" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;"> -->
<!--             <h3 style="color:#0099FF;">Accordion for jQuery</h3> -->
<!--             <p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web page more easily.</p> -->
<!--         </div> -->




								<div style="height: 500px; cursor: pointer; display: block; font-size: 100%;">
									<div class="easyui-accordion" style="border: 1px solid #DDDDDD;">
									<div title="瘦身指標" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;border: 1px solid #DDDDDD;">
<!-- 										<h3	style="background-color: #FFDD55; border: 1px solid #DDDDDD;">瘦身指標</h3> -->
										<div style="height: 100%">
											身高<input type="text" name="height" value="${bean.height}">${errorMessage.heightError}<br>
											體重<input type="text" name="weight" value="${bean.weight}">${errorMessage.weightError}<br>
											腰圍<input type="text" name="waistline"
												value="${bean.waistline}">${errorMessage.waistlineError}<br>
										</div>
										</div>
									</div>
									<div class="easyui-accordion" style="border: 1px solid #DDDDDD;">
										<div title="熱量計算" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;border: 1px solid #DDDDDD;">
<!-- 										<h3 style="background-color: #FFDD55" style="border: 1px solid #DDDDDD;">熱量計算</h3> -->
										<div>
											<div>
												早餐<br> 
												午餐<br> 
												晚餐<br> 
												飲食總熱量<br> 
												運動總熱量<br>
												差值<br>
											</div>
											<br>
										</div>
										</div>
									</div>
								</div>
							</div>

							<!-- right -->
							<div
								style="width: 59%; float: right; border: 2px solid yellow; height: 100%;">
								<div style="height: 500px;">
									<div class="easyui-accordion" style="height: 500px; border: 1px solid #DDDDDD;">
									<div title="瘦身日誌" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;border: 1px solid #DDDDDD;">
										
										<div>
											日誌標題<input type="text" name="title" value="${bean.title}"><br>
											日誌內容
											<textarea class="ckeditor" name="content">${bean.content}</textarea>
										</div>
									</div>
									</div>
								</div>
							</div>
							<div>
								<input type="submit" value="SAVE"
									style="width: 110px; height: 45px; margin: 10px">
								<button style="width: 110px; height: 45px;">
									<a href="#">back</a>
								</button>
							</div>
						</form>
					</div>
				</div>
				<div id="t-3">
					<div id="container"
						style="min-width: 310px; height: 400px; margin: 0 auto"></div>
					<br>
					<table border='2' style="float: left;">
						<tr>
							<th width='130'>日期</th>
							<th width='130'>體重</th>
							<th width='130'>歷史變化量</th>

						</tr>
						<c:forEach var='vo' varStatus="i" items="${list}">
							<tr>
								<td>${vo.date}</td>
								<td>${vo.weight}</td>

								<c:choose>
									<c:when test="${i.index == 0}">
										<td>--</td>
									</c:when>
									<c:when test="${i.index > 0}">
										<%--<td>${list[i.index].weight - list[i.index-1].weight}</td> --%>
										<!-- 未切字串,一坨拉庫 -->
										<c:choose>
											<c:when
												test="${(list[i.index].weight - list[i.index-1].weight) > 0}">
												<td style="color: red">+<fmt:formatNumber type="number"
														maxIntegerDigits="2"
														value="${(list[i.index].weight - list[i.index-1].weight)}" /></td>
											</c:when>
											<c:otherwise>
												<td style="color: green;"><fmt:formatNumber
														type="number" maxIntegerDigits="2"
														value="${(list[i.index].weight - list[i.index-1].weight)}" /></td>
											</c:otherwise>
										</c:choose>
									</c:when>
								</c:choose>
							</tr>
						</c:forEach>
					</table>
					<table border='2' style="float: left;">
						<tr>
							<th width='130'>BMI</th>
							<th width='130'>歷史變化量</th>
						</tr>
						<c:forEach var='vo' varStatus="a" items="${list}">
							<tr>
								<td><fmt:formatNumber type="number" maxIntegerDigits="2"
										value="${vo.weight/((vo.height/100)*(vo.height/100))}" /></td>
								<c:choose>
									<c:when test="${a.index == 0}">
										<td>--</td>
									</c:when>
									<c:when test="${a.index > 0}">
										<c:choose>
											<c:when
												test="${(list[a.index].weight/((list[a.index].height/100)*(list[a.index].height/100)) - list[a.index-1].weight/((list[a.index-1].height/100)*(list[a.index-1].height/100))) >0}">
												<td style="color: red">+<fmt:formatNumber type="number"
														maxIntegerDigits="2"
														value="${(list[a.index].weight/((list[a.index].height/100)*(list[a.index].height/100)) - list[a.index-1].weight/((list[a.index-1].height/100)*(list[a.index-1].height/100)))}" /></td>
											</c:when>
											<c:otherwise>
												<td style="color: green"><fmt:formatNumber
														type="number" maxIntegerDigits="2"
														value="${(list[a.index].weight/((list[a.index].height/100)*(list[a.index].height/100)) - list[a.index-1].weight/((list[a.index-1].height/100)*(list[a.index-1].height/100)))}" /></td>

											</c:otherwise>
										</c:choose>
										<!-- 										取小數第二位，切字串 -->
									</c:when>
								</c:choose>
							</tr>
						</c:forEach>
					</table>



					<table border='2' style="float: left;">
						<tr>
							<th width='130'>腰圍</th>
							<th width='130'>歷史變化量</th>

						</tr>
						<c:forEach var='vo' varStatus="i" items="${list}">
							<tr>
								<td>${vo.waistline}</td>

								<c:choose>
									<c:when test="${i.index == 0}">
										<td>--</td>
									</c:when>
									<c:when test="${i.index > 0}">
										<c:choose>
											<c:when
												test="${(list[i.index].waistline - list[i.index-1].waistline) >0}">
												<td style="color: red">+<fmt:formatNumber type="number"
														maxIntegerDigits="2"
														value="${(list[i.index].waistline - list[i.index-1].waistline)}" /></td>
											</c:when>
											<c:otherwise>
												<td style="color: green"><fmt:formatNumber
														type="number" maxIntegerDigits="2"
														value="${(list[i.index].waistline - list[i.index-1].waistline)}" /></td>
											</c:otherwise>
										</c:choose>
										<%--<td>${list[i.index].weight - list[i.index-1].weight}</td> --%>
										<!-- 未切字串,一坨拉庫 -->
										<!-- 取小數第二位，切字串 -->
									</c:when>
								</c:choose>
							</tr>
						</c:forEach>
					</table>









				</div>
			</div>
		</div>
	</div>





































	<div id="footerOuterSeparator"></div>

	<div id="divFooter" class="footerArea">

		<div class="container">

			<div class="divPanel">

				<div class="row-fluid">
					<div class="span6" id="footerArea1">

						<h3>關於我</h3>

						<p>Belly Worry
							希望幫助每個為卡路里煩腦的人，輕鬆做好個人卡路里控制，並且提供您良好的介面：查詢運動景點、健康知識等相關情報，讓你天天擁有美好的健康生活。</p>

						<p>
							<a href="#" title="Terms of Use">開始使用</a><br /> <a href="#"
								title="FAQ">常見問題</a><br /> <a href="#" title="Sitemap">網站地圖</a>
						</p>

					</div>

					<div class="span6" id="footerArea2">

						<h3>聯絡我們</h3>

						<ul id="contact-info">
							<li><i class="general foundicon-phone icon"></i> <span
								class="field">電話:</span> <br /> (02) 6631 6666 / 6631 6667</li>
							<li><i class="general foundicon-mail icon"></i> <span
								class="field">Email:</span> <br /> <a
								href="mailto:EEIT80hahaha@gmail.com" title="Email">BellyWorry@gmail.com</a>
							</li>
							<li><i class="general foundicon-home icon"
								style="margin-bottom: 50px"></i> <span class="field">地址:</span>
								<br /> 台北市大安區復興南路一段390號2樓201室</li>
						</ul>

					</div>
				</div>

				<br /> <br />
				<div class="row-fluid">
					<div class="span12">
						<p class="copyright">Copyright © 2015 Belly Worry. All Rights
							Reserved.</p>

						<p class="social_bookmarks">
							<a href="#"><i class="social foundicon-facebook"></i> Facebook</a>
							<a href=""><i class="social foundicon-twitter"></i> Twitter</a> <a
								href="#"><i class="social foundicon-pinterest"></i> Pinterest</a>
							<a href="#"><i class="social foundicon-rss"></i> Rss</a>
						</p>
					</div>
				</div>
				<br />

			</div>

		</div>

	</div>



	
	<script type="text/javascript" src="jeasyui/jquery.min.js"></script>
<!-- 	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>   有地雷!!不要開!!!-->
	
	<script type="text/javascript" src="jeasyui/jquery.easyui.min.js"></script>
	
	
	
<!-- 	<script src="jeasyui/jquery.calendar.js"></script> -->

<!-- 	<script type="text/javascript" src="jeasyui/jquery.calendar.js"></script> -->
	
	<script type="text/javascript" src="jeasyui/easyui-lang-zh_TW.js"></script>
	
	<script src="ckeditor/ckeditor.js"></script>
	
	
	
	
	<!-- 	<script src="scripts/jquery.min.js" type="text/javascript"></script> -->
		
		<script src="js/highcharts.js"></script>
		<script src="js/modules/exporting.js"></script>

		<script src="scripts/bootstrap/js/bootstrap.min.js"
			type="text/javascript"></script>
		<script src="scripts/default.js" type="text/javascript"></script>
		<script src="scripts/carousel/jquery.carouFredSel-6.2.0-packed.js"
			type="text/javascript"></script>
		<script src="scripts/camera/scripts/camera.min.js"
			type="text/javascript"></script>
		<script src="scripts/easing/jquery.easing.1.3.js"
			type="text/javascript"></script>
			

	



	<script>
		(function($) {
// 			$.get("diaryIndex.controller");
			$("#cc").calendar(
					{
						onSelect : function(date) {
							console.log(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate())
							var month,day;
							if((date.getMonth()+1)<10){
								month = '0'+(date.getMonth()+1);
							}else{
								month = (date.getMonth()+1);
							}
							if(date.getDate() < 10){
								day = '0'+date.getDate();
							}else{
								day = date.getDate();
							}
							console.log(date.getFullYear()+"-"+month+"-"+day);
							 $('html,body').animate({scrollTop:$('#'+date.getFullYear()+"-"+month+"-"+day).offset().top -150}, 1000);							
						}
					})

			$(".accordion").accordion({
				animate:false
			});
			$(function() {
				$(".headerr").tabs();
			});

			//日期
// 			$(function() {
// 				$("#date").datepicker();
// 			});

			//圖表
			$('#container').highcharts(
					{
						title : {
							text : 'Monthly Average Temperature',
							x : -20
						//center
						},
						subtitle : {
							text : 'Source: WorldClimate.com',
							x : -20
						},
						xAxis : {
							categories : [ 'Jan', 'Feb', 'Mar', 'Apr', 'May',
									'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov',
									'Dec' ]
						},
						yAxis : {
							title : {
								text : 'Temperature (°C)'
							},
							plotLines : [ {
								value : 0,
								width : 1,
								color : '#808080'
							} ]
						},
						tooltip : {
							valueSuffix : '°C'
						},
						legend : {
							layout : 'vertical',
							align : 'right',
							verticalAlign : 'middle',
							borderWidth : 0
						},
						series : [
								{
									name : 'Tokyo',
									data : [ 7.0, 80, 9.5, 14.5, 18.2, 21.5,
											25.2, 26.5, 23.3, 18.3, 13.9, 9.6 ]
								},
								{
									name : 'New York',
									data : [ -0.2, 0.8, 5.7, 11.3, 17.0, 22.0,
											24.8, 24.1, 20.1, 14.1, 8.6, 2.5 ]
								},
								{
									name : 'Berlin',
									data : [ -0.9, 0.6, 3.5, 8.4, 13.5, 17.0,
											18.6, 17.9, 14.3, 9.0, 3.9, 1.0 ]
								},
								{
									name : 'London',
									data : [ 3.9, 4.2, 5.7, 8.5, 11.9, 15.2,
											17.0, 16.6, 14.2, 10.3, 6.6, 4.8 ]
								} ]
					});
		})(jQuery);
	</script>





</body>
</html>