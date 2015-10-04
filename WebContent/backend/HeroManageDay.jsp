<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>【BellyWorry後台】日誌檢舉管理</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/backend/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/backend/css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/backend/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <jsp:include page="/backend/page/header.jsp"/>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                        	日誌檢舉管理
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-table"></i> 檢舉清單
                            </li>
                            <li class="active">
                                <i class="fa fa-table">
<%--                                 <a href="${pageContext.request.contextPath}/backend/#">帳號查詢</a> --%>
                            	帳號查詢
                            	<form action="${pageContext.request.contextPath}/backend/heromanage.controller"
                            	 method="get" style="display: inline;" >
                            		<input type="hidden" name="pageNo" value="1">
                            		<input type="text" name="id" value="">
                            		<input type="submit" value="查詢">
                            	</form>
                            	</i>
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                	
<%-- 				<p><a href="${pageContext.request.contextPath}/reflectdiary.controller?memberno=${healthdiary.memberNo}&date=${healthdiary.date}&pageNo=${pageNo}">日誌檢舉</a></p> --%>
			<form action="${pageContext.request.contextPath}/backend/dayreflectmanage.controller" method="get">
				<input type="hidden" name="reflectedNo" value="${healthdiary.memberNo}">
				<input type="hidden" name="reflectedID" value="${herovo.membervo.id}">
				<input type="hidden" name="date" value="${healthdiary.date}">
				<input type="submit" value="日誌封鎖">
			</form>

			<h1>${herovo.membervo.nickname} (${herovo.membervo.id}) ${healthdiary.date} 健康紀錄</h1>

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
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/backend/js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/backend/js/bootstrap.min.js"></script>



</body>

</html>
