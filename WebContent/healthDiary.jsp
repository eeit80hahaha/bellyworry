<%@page import="java.text.SimpleDateFormat"%>
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

<c:set var="funcName" value="DIARY" scope="session"/>
<jsp:include page="/page/header.jsp" />


</head>
<body id="pageBody">






	<div id="contentOuterSeparator"></div>

	<div class="container">
		<div class="divPanel page-content">
		<br><br>
			<div class="breadcrumbs">
				<a href="index.jsp">首頁</a> &nbsp;/&nbsp; <span>健康管理日誌</span>
			</div>
			<div id="tabs" class="headerr" style="border: none;">
<!-- 				<ul class="nav nav-tabs" style="background-color: white;"> -->
<!-- 					<li class="active"><a href="#t-1">日誌首頁</a></li> -->
<!-- 					<li><a href="#t-2">今日紀錄</a></li> -->
<!-- 					<li><a href="#t-3">歷史紀錄</a></li> -->
<!-- 				</ul> -->

				<div id="t-1" style="height: 100%;" title="日誌首頁">
					<div style="border: 2px solid white; width: 100%; height: 100%;"> <!-- blue至頂上條線 -->
					</div>
<br>

					<c:forEach var="vo" items="${list}">
						<c:url value="oneday.controller" var="path">
							<c:param name="no" value="${vo.no}"></c:param>
						</c:url>
						<c:url value="foodCal.controller?pageNo=1" var="foodCal">
							<c:param name="no" value="${vo.no}"></c:param>
						</c:url>
					<%-- 	<c:url value="oneday.controller" var="exerCal">
							<c:param name="no" value="${vo.no}"></c:param>
						</c:url> --%>
						
						
						<div id="${vo.date}" style="width: 70%; float: left; border: 1px solid white; height: 100%;font-family:Microsoft JhengHei;"> <!-- red首頁日誌 -->
							<div>
								<div style="border: 2px solid white;"> <!-- 標題日期標頭 -->
									<span style="font-size: 0.5cm;color: #AAAAAA;line-height: 40px">${vo.date}</span> <br>
									<span style="padding-left: 20px;font-size: 0.8cm;font-family:Microsoft JhengHei;font-weight: bold;">${vo.title}</span>
								</div>

								<div style="height: 200px; border: 2px solid white;padding-top: 15px">  <!-- green首頁三餐活動 -->

									<div
										style="border: 4px solid #FFEE99; width: 190.7px; height: 100%; float: left;border-radius:25px;margin: 2px;font-weight: 300;box-shadow:5px 5px 5px 2px #DDDDDD;">
										<h5 style="font-family:Microsoft JhengHei;font-weight: 600;color: #ee845e">&nbsp;<img src="images/bread.jpg" style="width: 40px;height: 30px">早上</h5>
										<div style="overflow : hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-line-clamp: 5;-webkit-box-orient: vertical;">
										<c:forEach var="eat" items="${vo.eatVo}">
											<!-- eat_record因為很多筆相同時段.菜色,所以用foreach -->
											<c:if test="${eat.time == '早上' }">&nbsp;
											
											${eat.foodCalVO.name}
											${eat.foodCalVO.cal} 卡
											${eat.count}
											${eat.foodCalVO.count}
											${eat.foodCalVO.weight}g<br>
											
											</c:if>
										</c:forEach></div>
									</div>

									<div
										style="border: 4px solid #FFEE99; width: 190.7px; height: 100%; float: left;border-radius:25px;margin: 2px;font-weight: 300;box-shadow:5px 5px 5px 2px #DDDDDD; ">
										<h5 style="font-family:Microsoft JhengHei;font-weight: 600;color: #ee845e">&nbsp;<img src="images/lunch.jpg" style="width: 40px;height: 30px">中午</h5>
										<div style="overflow : hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-line-clamp: 5;-webkit-box-orient: vertical;">
										<c:forEach var="eat" items="${vo.eatVo}">
											<c:if test="${eat.time =='中午'}">&nbsp;
 							${eat.foodCalVO.name} 
 							${eat.foodCalVO.cal} 卡
 							${eat.count}
 							${eat.foodCalVO.count} 
 							${eat.foodCalVO.weight}g<br>
											</c:if>
										</c:forEach></div>
									</div>
									<div
										style="border: 4px solid #FFEE99; width: 190.7px; height: 100%; float: left;border-radius:25px;margin: 2px;font-weight: 300;box-shadow:5px 5px 5px 2px #DDDDDD;">
										<h5 style="font-family:Microsoft JhengHei;font-weight: 600;color: #ee845e";>&nbsp;<img src="images/dinner.jpg" style="width: 40px;height: 30px">晚上</h5>
										<div style="overflow : hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-line-clamp: 5;-webkit-box-orient: vertical;">
										<c:forEach var="eat" items="${vo.eatVo}">
											<c:if test="${eat.time=='晚上'}">&nbsp;
 							${eat.foodCalVO.name} 
 							${eat.foodCalVO.cal} 卡  
 							${eat.count}
 							${eat.foodCalVO.count} 
 							${eat.foodCalVO.weight}g<br>
 							
											</c:if>
										</c:forEach></div>
									</div>
									<div
										style="border: 4px solid #FFCCCC; width: 190.7px; height: 100%; float: left;border-radius:25px;margin: 2px;font-weight: 300;box-shadow:5px 5px 5px 2px #DDDDDD;">
										<h5 style="font-family:Microsoft JhengHei;font-weight: 600;color: #32CD32">&nbsp;<img src="images/exer.jpg" style="width: 25px;height: 25px">活動</h5>
										<div style="overflow : hidden;text-overflow: ellipsis;display: -webkit-box;-webkit-line-clamp: 5;-webkit-box-orient: vertical;">
										<c:forEach var="exer" items="${vo.exerVo}">&nbsp;
							${exer.exerciseCalVO.name}
							${exer.exerciseCalVO.calHour}大卡  
							${exer.count}hour<br>
										</c:forEach></div>
									</div>
								</div><br>
<!-- 								<div>飲食總熱量</div> -->
<!-- 								<div>運動總熱量</div> -->
								<div>
									<a href="${path}">詳讀內文</a>
								</div>
							
								<hr>
							</div>
						</div>
					</c:forEach>
					<div
						style="width: 29%; float: right; height: 100%;"> <!-- calendar right-hand -->

						<div style="width: 100%;"></div>
						<div id="cc" class="easyui-calendar"
							style="width: 335px; height: 360px; position: absolute; top: 235px"></div>
					</div>

				</div>
				<div id="t-2" title="填寫日誌">

					<div style="width: 95%; height: 100%;"> <!-- 大外框blue -->
						<form action="health.collection" method="post">
							<!-- left -->
							<div
								style="width: 40%; float: left;height: 100%;"> <!-- 左邊框 border: 2px solid red;  -->
								<!-- 時間!!! -->
								日期： <input class="easyui-datebox" name="date"
									value="${bean.date} <fmt:formatDate pattern="yyyy-MM-dd" value="${healthDate}" />/>"></input>

<!--  <div class="easyui-accordion" style="width:500px;height:300px;"> -->
<!--         <div title="About" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;"> -->
<!--             <h3 style="color:#0099FF;">Accordion for jQuery</h3> -->
<!--             <p>Accordion is a part of easyui framework for jQuery. It lets you define your accordion component on web page more easily.</p> -->
<!--         </div> -->




								<div style="height: 100%; cursor: pointer; display: block; font-size: 100%;">
									<div class="easyui-accordion" style="border: 1px solid white;">
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
									<div class="easyui-accordion" style="border: 1px solid white;">
										<div title="熱量計算" data-options="iconCls:'icon-ok'" style="overflow:auto;padding:10px;border: 1px solid #DDDDDD;">
<!-- 										<h3 style="background-color: #FFDD55" style="border: 1px solid #DDDDDD;">熱量計算</h3> -->
										<div>
											<div>
											早餐：<br>
											<c:forEach var="eatBK" items="${eatBreakfast}">
											${eatBK.foodCalVO.name}&nbsp;
											${eatBK.foodCalVO.cal}cal&nbsp;
											${eatBK.count}
											${eatBK.foodCalVO.count}&nbsp;
											${eatBK.foodCalVO.weight}g
											<br>
											</c:forEach>
											<c:forEach var="eat" items="${bean.eatVo}">
											<c:if test="${eat.time == '早上' }">
												${eat.foodCalVO.name}&nbsp;
												${eat.foodCalVO.cal}cal&nbsp;
												${eat.count}
												${eat.foodCalVO.count}&nbsp;
												${eat.foodCalVO.weight}g
												<br>
											</c:if>
											</c:forEach>
											午餐：<br>
											<c:forEach var="eatLunch" items="${eatLunch}">
											${eatLunch.foodCalVO.name}&nbsp;
											${eatLunch.foodCalVO.cal}cal&nbsp;
											${eatLunch.count}
											${eatLunch.foodCalVO.count}&nbsp;
											${eatLunch.foodCalVO.weight}g
											<br>
											</c:forEach>
											<c:forEach var="eat" items="${bean.eatVo}">
											<c:if test="${eat.time == '中午' }">										
												${eat.foodCalVO.name} &nbsp;
												${eat.foodCalVO.cal}cal&nbsp;
												${eat.count}
												${eat.foodCalVO.count}&nbsp;
												${eat.foodCalVO.weight}g
												<br>
											</c:if>
												</c:forEach>	
												晚餐：<br>
										<c:forEach var="eatDinner" items="${eatDinner}">
											${eatDinner.foodCalVO.name}&nbsp;
											${eatDinner.foodCalVO.cal}cal&nbsp;
											${eatDinner.count}
											${eatDinner.foodCalVO.count}&nbsp;
											${eatDinner.foodCalVO.weight}g
											<br>
											</c:forEach>
											<c:forEach var="eat" items="${bean.eatVo}">
											<c:if test="${eat.time == '晚上' }">
												
												${eat.foodCalVO.name}&nbsp;
												${eat.foodCalVO.cal}cal&nbsp;
												${eat.count}
												${eat.foodCalVO.count}&nbsp;
												${eat.foodCalVO.weight}g
												<br>
											</c:if>
												</c:forEach>
												運動：<br>
												<c:forEach var="exer" items="${bean.exerVo}">
												${exer.exerciseCalVO.name}&nbsp;
												${exer.exerciseCalVO.calHour}&nbsp;
												${exer.count}<br>
												</c:forEach>
												
<!-- 												飲食總熱量<br>  -->
<!-- 												運動總熱量<br> -->
<!-- 												差值<br> -->
											</div>
											<br>
										</div>
										<div>
										<a href="${foodCal}">計算飲食熱量卡路里</a><br>
										<a href="${path}">計算運動熱量卡路里</a>
										</div>
										
<!-- 			<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true"> -->
<!--                     <div class="modal-header"> -->
<!--                         <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button> -->
<!--                         <h3 id="myModalLabel">Modal Heading</h3> -->
<!--                     </div> -->
<!--                     <div class="modal-body"> -->
<%--                     	<jsp:include page="/foodCal.controller" flush="false"> --%>
<%--                     		 <jsp:param name="pageNo" value="1" /> --%>
<%--                     		  <jsp:param name="date" value="1" /> --%>
<%--                     	</jsp:include> --%>
<%--                     	<jsp:include page='<c:url value="/health.collection"/>' /> --%>
<!--                     </div> -->
<!--                     <div class="modal-footer"> -->
<!--                         <button class="btn" data-dismiss="modal">Close</button> -->
<!--                         <button class="btn btn-primary">Save changes</button> -->
<!--                     </div> -->
<!--                 </div> -->
<!--                 <a data-toggle="modal" href="#myModal" class="btn btn-primary btn-large">Launch demo modal</a> -->
                
                
                
                
                
										
										</div>
									</div>
								</div>
							</div>

							<!-- right -->
							<div
								style="width: 59%; float: right;height: 100%;"> <!--right hand border: 2px solid yellow;   -->
								<div style="height: 500px;">
									<div class="easyui-accordion" style="height: 500px; border: 1px solid white;">
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
									style="width: 110px; height: 45px; margin: 5px">
								<button style="width: 110px; height: 45px;">
									<a href="#">back</a>
								</button>
							</div>
						</form>
					</div>
				</div>
				<div id="t-3" title="歷史紀錄">
				
				<div>
				    <div style="margin:20px 0"></div>
				    <select id="year" class="easyui-combobox" name="state" style="width:70px;">
				        <option value="2014">2014年</option>
				        <option value="2015" selected="selected">2015年</option>
				    </select>
				    
				    <select id="month" class="easyui-combobox" name="state" style="width:70px;">
				        <option value="1">1月</option>
				        <option value="2">2月</option>
				        <option value="3">3月</option>
				        <option value="4">4月</option>
				        <option value="5">5月</option>
				        <option value="6">6月</option>
				        <option value="7">7月</option>
				        <option value="8">8月</option>
				        <option value="9">9月</option>
				        <option value="10" selected="selected">10月</option>
				        <option value="11">11月</option>
				        <option value="12">12月</option>
				    </select>
				</div>
				
					<div id="container"
						style="width: 1000px; height: 400px; margin: 0 auto"></div>
						
					<br>
					<table border='2' style="float: left;text-align:center;margin-left:120px">
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
									<c:when test="${i.last}">
										<td>--</td>
									</c:when>
									<c:when test="${i.index >= 0}">
										<%--<td>${list[i.index].weight - list[i.index-1].weight}</td> --%>
										<!-- 未切字串,一坨拉庫 -->
										<c:choose>
											<c:when
												test="${(list[i.index].weight - list[i.index+1].weight) > 0}">
												<td style="color: red">+<fmt:formatNumber type="number"
														maxIntegerDigits="2"
														value="${(list[i.index].weight - list[i.index+1].weight)}" /></td>
											</c:when>
											<c:otherwise>
												<td style="color: green;"><fmt:formatNumber
														type="number" maxIntegerDigits="2"
														value="${(list[i.index].weight - list[i.index+1].weight)}" /></td>
											</c:otherwise>
										</c:choose>
									</c:when>
								</c:choose>
							</tr>
						</c:forEach>
					</table>
					<table border='2' style="float: left;text-align:center">
						<tr>
							<th width='130'>BMI</th>
							<th width='130'>歷史變化量</th>
						</tr>
						<c:forEach var='vo' varStatus="a" items="${list}">
							<tr>
								<td><fmt:formatNumber type="number" maxIntegerDigits="2"
										value="${vo.weight/((vo.height/100)*(vo.height/100))}" /></td>
								<c:choose>
									<c:when test="${a.last}">
										<td>--</td>
									</c:when>
									<c:when test="${a.index >= 0}">
										<c:choose>
											<c:when
												test="${(list[a.index].weight/((list[a.index].height/100)*(list[a.index].height/100)) - list[a.index+1].weight/((list[a.index+1].height/100)*(list[a.index+1].height/100))) >0}">
												<td style="color: red">+<fmt:formatNumber type="number"
														maxIntegerDigits="2"
														value="${(list[a.index].weight/((list[a.index].height/100)*(list[a.index].height/100)) - list[a.index+1].weight/((list[a.index+1].height/100)*(list[a.index+1].height/100)))}" /></td>
											</c:when>
											<c:otherwise>
												<td style="color: green"><fmt:formatNumber
														type="number" maxIntegerDigits="2"
														value="${(list[a.index].weight/((list[a.index].height/100)*(list[a.index].height/100)) - list[a.index+1].weight/((list[a.index+1].height/100)*(list[a.index+1].height/100)))}" /></td>

											</c:otherwise>
										</c:choose>
										<!-- 										取小數第二位，切字串 -->
									</c:when>
								</c:choose>
							</tr>
						</c:forEach>
					</table>
					<table border='2' style="float: left;text-align:center">
						<tr>
							<th width='130'>腰圍</th>
							<th width='130'>歷史變化量</th>
						</tr>
						<c:forEach var='vo' varStatus="i" items="${list}">
							<tr>
								<td>${vo.waistline}</td>
								<c:choose>
									<c:when test="${i.last}">
										<td>--</td>
									</c:when>
									<c:when test="${i.index >= 0}">
										<c:choose>
											<c:when
												test="${(list[i.index].waistline - list[i.index+1].waistline) >0}">
												<td style="color: red">+<fmt:formatNumber type="number"
														maxIntegerDigits="2"
														value="${(list[i.index].waistline - list[i.index+1].waistline)}" /></td>
											</c:when>
											<c:otherwise>
												<td style="color: green"><fmt:formatNumber
														type="number" maxIntegerDigits="2"
														value="${(list[i.index].waistline - list[i.index+1].waistline)}" /></td>
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
			var year,month,day,memberNo;
			memberNo = "${user.memberNo}"
			year = $('#year').val();
			month = $('#month').val();
// 			console.log($('#year option:selected').val())

		var a = function(){
			$.getJSON("json.view",{"id":memberNo,"year":year,"month":month},function(data){
				var date = [];
				for(var i=1;i<=31;i++){
					date.push(i);
				}
				$.each(data,function(p,data){
					$('#container').highcharts(
							{
								title : {
									text : '體重、BMI、腰圍變化量',
									x : -20
								//center
								},
								subtitle : {
									text : 'Weight.BMI.Waistline',
									x : -10
								},
								xAxis : {
									categories :date
								},
								yAxis : {

									title : {
										text : 'kg,cm,BMI'
									},
									plotLines : [ {
										value : 0,
										width : 1,
										color : '#808080'
									} ]
								},
								legend : {
									layout : 'vertical',
									align : 'right',
									verticalAlign : 'middle',
									borderWidth : 0
								},
								series : [
										{
											name : 'weight (kg)',
											data : data.weight,
											tooltip : {
												headerFormat:'<b>weight</b><br/>',
												valueSuffix : 'kg'
											}},
										{
											name : 'waistline (cm)',
											data : data.waistline,
											tooltip : {
												headerFormat:'<b>waistline</b><br/>',
												valueSuffix : 'cm'
											}},
										{
											name :'BMI',
											data : data.BMI,
											tooltip : {
												headerFormat:'<b>BMI</b><br/>',
											}}
										]
					})
				})
			});
			}
			a();

			$("#year").combobox({
				onSelect:function(record){
					year = record.value;
					a();
				}
			});
			$("#month").combobox({
				onSelect:function(record){
					month = record.value;
					a();
				}
			});
			
			
			$("#cc").calendar(
					{
						onSelect : function(date) {
// 							console.log(date.getFullYear()+"-"+(date.getMonth()+1)+"-"+date.getDate())
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
// 							console.log(date.getFullYear()+"-"+month+"-"+day);
							 $('html,body').animate({scrollTop:$('#'+date.getFullYear()+"-"+month+"-"+day).offset().top -150}, 1000);							
						}
					})
		
					
			
			$(".easyui-datebox").datebox({				
				onSelect:function(date){
					var time;
					year = date.getFullYear();
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
					time = year+'-'+month+'-'+day;
// 					console.log(time);
					$.get("healthDaySessionServlet.collection",{"time":time});
				}
			});
			$(".accordion").accordion({
				animate:false
			});
			
			$("#tabs").tabs({
					
			});
			

			//日期
// 			$(function() {
// 				$("#date").datepicker();
// 			});

		})(jQuery);
	</script>





</body>
</html>