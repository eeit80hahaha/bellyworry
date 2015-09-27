<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>健康紀錄</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="scripts/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Icons -->
    <link href="scripts/icons/general/stylesheets/general_foundicons.css" media="screen" rel="stylesheet" type="text/css" />  
    <link href="scripts/icons/social/stylesheets/social_foundicons.css" media="screen" rel="stylesheet" type="text/css" />
    <!--[if lt IE 8]>
        <link href="scripts/icons/general/stylesheets/general_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="scripts/icons/social/stylesheets/social_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
    <![endif]-->
    <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome.min.css">
    <!--[if IE 7]>
        <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome-ie7.min.css">
    <![endif]-->


    <link href="http://fonts.googleapis.com/css?family=Allura" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Aldrich" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet" type="text/css">

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
  padding: 5px;
  border: 1px solid #999;
  text-align: center;
}

#panel, .panel {
  font-family: 'Roboto','sans-serif';
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

<jsp:include page="/page/header.jsp"/>

<div id="contentOuterSeparator"></div>

<div class="container">

	<div class="divPanel page-content">

		<div class="breadcrumbs">
			<a href="index.jsp">首頁</a> &nbsp;/&nbsp; 
			<a href="${pageContext.request.contextPath}/hero.controller">英雄事蹟</a> &nbsp;/&nbsp; 
			<a href="${pageContext.request.contextPath}/herolist.controller?memberNo=${herovo.membervo.memberNo}&pageNo=${pageNo}">健康事蹟</a> &nbsp;/&nbsp; 
			<span>健康紀錄</span>
		</div> 
        <!--Edit Main Content Area here-->
        <div class="row-fluid">
			<div class="span8" id="divMain">

				<h1>${herovo.membervo.nickname} (${herovo.membervo.id}) ${healthdiary.date} 健康紀錄</h1>
				<p><a href="${pageContext.request.contextPath}/reflectdiary.controller?memberno=${healthdiary.memberNo}&date=${healthdiary.date}&pageNo=${pageNo}">日誌檢舉</a></p>
				
				<fmt:formatNumber type="number" 
				value="${healthdiary.weight / ((healthdiary.height / 100 )* (healthdiary.height / 100 ))}" 
				maxFractionDigits="2" var="bmi" />
				
				<h1>健康日誌</h1>
				<table>
					<tr>
						<td colspan="4">標題：${healthdiary.title}</td>
					</tr>
					<tr>
						<td>身高：${healthdiary.height}</td>
						<td>體重：${healthdiary.weight}</td>
						<td>腰圍：${healthdiary.waistline}</td>
						<td>BMI：${bmi}</td>
					</tr>
					<tr><td colspan="4">日誌：${healthdiary.content}</td></tr>
				</table>
				
				<c:if test="${healthdiary.eatVo != '[]'}">
				<h1>飲食紀錄</h1>
				<%-- ${healthdiary.eatVo} --%>
				<!-- <hr/> -->
				<table>
					<tr>
						<th>時段</th>
						<th>名稱</th>
						<th>熱量(Cal/100g)</th>
						<th>每份公克數</th>
						<th>攝取份量</th>
					</tr>	
					<c:forEach var="eatVo" items="${healthdiary.eatVo}">
						<tr>
							<td>${eatVo.time}</td>
							<td>${eatVo.foodCalVO.name}</td>
							<td>${eatVo.foodCalVO.cal}</td>
							<td>${eatVo.foodCalVO.weight}</td>
							<td>${eatVo.count}</td>
						</tr>
					</c:forEach>
				</table>
				</c:if>
				
				<c:if test="${healthdiary.exerVo != '[]'}">
				<h1>運動紀錄</h1>
				<%-- ${healthdiary.exerVo} --%>
				<!-- <hr/> -->
				<table>
					<tr>
						<th>名稱</th>
						<th>每小時消耗熱量</th>
						<th>運動份量</th>
					</tr>
					<c:forEach var="exerVo" items="${healthdiary.exerVo}">
						<tr>
							<td>${exerVo.exerciseCalVO.name}</td>
							<td>${exerVo.exerciseCalVO.calHour}</td>
							<td>${exerVo.count}</td>
						</tr>
					</c:forEach>
				</table>
				</c:if>

				


	
			</div>
                    
		</div>
				<!--End Sidebar Area here-->
	</div>
			<!--End Main Content Area here-->

        <div id="footerInnerSeparator"></div>
</div>
<div id="footerOuterSeparator"></div>
<jsp:include page="/page/footer.jsp"/>

<script src="scripts/jquery.min.js" type="text/javascript"></script>
<script src="scripts/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="scripts/default.js" type="text/javascript"></script>
</body>
</html>