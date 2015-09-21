<%@page import="java.util.*"%>
<%@page import="health.model.HealthDiaryVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>Belly Worry - Enjoy Your Life</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Html5TemplatesDreamweaver.com">
<META NAME="ROBOTS" CONTENT="NOINDEX, NOFOLLOW">
<!-- Remove this Robots Meta Tag, to allow indexing of site -->


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
<link rel="stylesheet" href="/resources/demos/style.css">



<style>
</style>


</head>
<body id="pageBody">

	<div id="decorative2">
		<div class="container">

			<div class="divPanel topArea notop nobottom">
				<div class="row-fluid">
					<div class="span12">

						<div id="divLogo" class="pull-left">
							<a href="index.html" id="divSiteTitle">Belly Worry</a><br /> <a
								href="index.html" id="divTagLine">Enjoy Your Life</a>
						</div>

						<div id="divMenuRight" class="pull-right">
							<div class="navbar">
								<button type="button"
									class="btn btn-navbar-highlight btn-large btn-primary"
									data-toggle="collapse" data-target=".nav-collapse">
									功能選單 <span class="icon-chevron-down icon-white"></span>
								</button>
								<div class="nav-collapse collapse">
									<ul class="nav nav-pills ddmenu">
										<!--
                                <li class="dropdown active"><a href="index.html">回首頁</a></li>
                            -->
										<li class="dropdown"><a href="page.html"
											class="dropdown-toggle">健康食譜<b class="caret"></b></a>
											<ul class="dropdown-menu">
												<li><a href="about.html">關於我</a></li>
												<li><a href="gallery.html">相片流</a></li>
												<li><a href="contact.html">與我聯絡(表單)</a></li>
												<li><a href="page.html">元件庫</a></li>
												<li><a href="../documentation/index.html">說明文件</a></li>
												<li class="dropdown"><a href="full.html"
													class="dropdown-toggle">分欄參考</a>
													<ul class="dropdown-menu sub-menu">
														<li><a href="full.html">單欄版型</a></li>
														<li><a href="2-column.html">兩欄版型</a></li>
														<li><a href="3-column.html">三欄版型</a></li>
													</ul></li>
											</ul></li>
										<li class="dropdown"><a href="about.html">熱量計算</a></li>
										<li class="dropdown"><a href="gallery.html">健康管理</a></li>
										<li class="dropdown"><a href="page.html"
											class="dropdown-toggle">運動趣<b class="caret"></b></a>
											<ul class="dropdown-menu">
												<li><a href="full.html">YouBike路線規劃</a></li>
												<li><a href="fun/healthView.controller">健康景點查詢</a></li>
											</ul></li>
										<li class="dropdown"><a href="about.html">活動情報</a></li>
										<li class="dropdown"><a href="gallery.html">英雄事蹟</a></li>
										<li class="dropdown"><a href="about.html">小學堂</a></li>
										<li class="dropdown"><a href="contact.html"
											id="dropdown-my">會員登入</a></li>
									</ul>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>

		</div>
	</div>

	<div id="contentOuterSeparator"></div>

	<div class="container">
		<div class="divPanel page-content">
			<div class="breadcrumbs">
				<a href="index.html">Home</a> &nbsp;/&nbsp; <span>健康管理日誌</span>
			</div>
			<div class="t" style="border: none;">
				<h2>Tabs</h2>
				<ul class="nav nav-tabs" style="background-color: white;">
					<li class="active"><a href="#t-1">日誌首頁</a></li>
					<li><a href="#t-2">今日紀錄</a></li>
					<li><a href="#t-3">歷史紀錄</a></li>
				</ul>
				<div id="t-1" style="height: 100%;">
					<div class="tab-content"
						style="height: 100%; width: 100%; border: 2px solid blue;">
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
									<td><c:forEach var="eat" items="${vo.eatVo}">${eat.time }<br>
										</c:forEach></td>
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
								日期：<input type="text" id="date">
								<div style="height: 500px;">
									<div class="accordion">
										<h3>瘦身指標</h3>
										<div style="height: 100%">
											身高<input type="text" name="height" value="">${errorMessage.heightError}<br>
											體重<input type="text" name="weight" value="">${errorMessage.weightError}<br>
											腰圍<input type="text" name="waistline" value="">${errorMessage.waistlineError}<br>
											<div>BMI</div>
											<div>建議</div>
										</div>
									</div>
									<div class="accordion">
										<h3>熱量計算</h3>
										<div>
											<div>
												早餐<br> 午餐<br> 晚餐<br> 飲食總熱量<br> 運動總熱量<br>
												差值<br>
											</div>
											<br>
										</div>
									</div>
								</div>
							</div>

							<!-- right -->
							<div
								style="width: 59%; float: right; border: 2px solid yellow; height: 100%;">
								<div style="height: 500px;">
									<div class="accordion" style="height: 100%">
										<h3>瘦身日誌</h3>
										<div style="height: 500px">
											日誌標題<input type="text" name="title" value=""><br>
											日誌內容<textarea class="ckeditor" name="content"></textarea>
										</div>
									</div>
								</div>
							</div>
							<input type="submit" value="SAVE">
							<button>
								<a href="#">back</a>
							</button>
						</form>
					</div>
				</div>
				<div id="t-3">
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
										<td>${fn:substring((list[i.index].weight - list[i.index-1].weight),0,6)}</td>
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






	<script src="ckeditor/ckeditor.js"></script>
	
	
	<script src="scripts/jquery.min.js" type="text/javascript"></script>
	<script src="scripts/bootstrap/js/bootstrap.min.js"
		type="text/javascript"></script>
	<script src="scripts/default.js" type="text/javascript"></script>
	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>

	<script src="scripts/carousel/jquery.carouFredSel-6.2.0-packed.js"
		type="text/javascript"></script>
	<script src="scripts/camera/scripts/camera.min.js"
		type="text/javascript"></script>
	<script src="scripts/easing/jquery.easing.1.3.js"
		type="text/javascript"></script>


	<script>
		(function($) {
			$(".accordion").accordion({
				collapsible : true
			});
			$(function() {
				$(".t").tabs();
			});
		})(jQuery);

		//日期
		$(function() {
			$("#date").datepicker();
		});
	</script>





</body>
</html>