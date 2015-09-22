<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Your Name Here - Simple</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="scripts/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
    <link href="scripts/icons/general/stylesheets/general_foundicons.css" media="screen" rel="stylesheet" type="text/css" />  
    <link href="scripts/icons/social/stylesheets/social_foundicons.css" media="screen" rel="stylesheet" type="text/css" />
  	<link rel="stylesheet" href="scripts/fontawesome/css/font-awesome.min.css">
    <link href="http://fonts.googleapis.com/css?family=Allura" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Aldrich" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet" type="text/css">
    <link href="styles/custom.css" rel="stylesheet" type="text/css" />
    
<div id="decorative2">
    <div class="container">

       <div class="divPanel topArea notop nobottom">
            <div class="row-fluid">
                <div class="span12">

                    <div id="divLogo" class="pull-left">
                        <a href="index.html" id="divSiteTitle">Belly Worry</a><br />
                        <a href="index.html" id="divTagLine">Enjoy Your Life</a>
                    </div>

                    <div id="divMenuRight" class="pull-right" ">
<!-- 登入成功秀修改登出-->     <div class="navbar">
                        <button type="button" class="btn btn-navbar-highlight btn-large btn-primary" data-toggle="collapse" data-target=".nav-collapse">
                            功能選單 <span class="icon-chevron-down icon-white"></span>
                        </button>
                        <div class="nav-collapse collapse">
                        
              <!-- 登入登出 --><div style="position:absolute; top:20px; right:20px;">
              					<c:choose>
              						<c:when test="${empty user.id}">
              							<a href="${pageContext.request.contextPath}/login.jsp" id="dropdown-my">會員登入</a>
              						</c:when>
              						<c:otherwise>	
              							${user.id}&nbsp;您好&nbsp;<span>${suc.update}</span>&nbsp;<span>${suc.out}</span>
              						</c:otherwise>
              					</c:choose>
              				</div>                            
                            
                            <ul class="nav nav-pills ddmenu">
                                <li class="dropdown">
                                    <a href="page.html" class="dropdown-toggle">健康食譜<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="about.html">關於我</a></li>
                                        <li><a href="${pageContext.request.contextPath}/Menuservelt.controller">filter</a></li>
                                        <li><a href="${pageContext.request.contextPath}/logout.controller">登出</a></li>
                                        <li><a href="${pageContext.request.contextPath}/updatemember.jsp">更新</a></li>
                                        <li><a href="../documentation/index.html">說明文件</a></li>
                                        <li class="dropdown">
                                        <a href="full.html" class="dropdown-toggle">分欄參考</a>
                                        <ul class="dropdown-menu sub-menu">
                                        <li><a href="full.html">單欄版型</a></li>
                                        <li><a href="2-column.html">兩欄版型</a></li>
                                        <li><a href="3-column.html">三欄版型</a></li>
                                        </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li class="dropdown"><a href="about.html">熱量計算</a></li>
                                <li class="dropdown"><a href="diaryIndex.controller">健康管理</a></li>
                                <c:if test="${ funcName != 'FUN' }">
                                <li class="dropdown" >
                                </c:if>
                                <c:if test="${ funcName == 'FUN' }"> 
					            <li class="dropdown active" >
					            </c:if>
                                    <a href="#" class="dropdown-toggle">運動趣<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="full.html">YouBike路線規劃</a></li>
                                        <li><a href="${pageContext.request.contextPath}/healthView.jsp">健康景點查詢</a></li>
                                    </ul>
                                </li>
	                            
                                <li class="dropdown"><a href="about.html">活動情報</a></li>
                                <li class="dropdown"><a href="${pageContext.request.contextPath}/hero.controller">英雄事蹟</a></li>
                                <li class="dropdown"><a href="about.html">小學堂</a></li>                                
                            </ul>
                        </div>
                    </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>