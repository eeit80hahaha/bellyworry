<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div id="decorative2">
    <div class="container">

        <div class="divPanel topArea notop nobottom">
            <div class="row-fluid">
                <div class="span12">

                    <div id="divLogo" class="pull-left">
                        <a href="index.html" id="divSiteTitle">Belly Worry</a><br />
                        <a href="index.html" id="divTagLine">Enjoy Your Life</a>
                    </div>

                    <div id="divMenuRight" class="pull-right">
                    <div class="navbar">
                        <button type="button" class="btn btn-navbar-highlight btn-large btn-primary" data-toggle="collapse" data-target=".nav-collapse">
                            功能選單 <span class="icon-chevron-down icon-white"></span>
                        </button>
                        <div class="nav-collapse collapse">
                            <ul class="nav nav-pills ddmenu">
                            <!--
                                <li class="dropdown active"><a href="index.html">回首頁</a></li>
                            -->
                                <li class="dropdown">
                                    <a href="page.html" class="dropdown-toggle">健康食譜<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="about.html">關於我</a></li>
                                        <li><a href="gallery.html">相片流</a></li>
                                        <li><a href="contact.html">與我聯絡(表單)</a></li>
                                        <li><a href="page.html">元件庫</a></li>
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
                                <li class="dropdown"><a href="gallery.html">健康管理</a></li>
                                <li class="dropdown active" >
                                    <a href="page.html" class="dropdown-toggle">運動趣<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="full.html">YouBike路線規劃</a></li>
                                        <li><a href="fun/healthView.controller">健康景點查詢</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown"><a href="about.html">活動情報</a></li>
                                <li class="dropdown"><a href="gallery.html">英雄事蹟</a></li>
                                <li class="dropdown"><a href="about.html">小學堂</a></li>
                                <c:choose>
                                	<c:when test="${1!=1}">
                                		<li class="dropdown"><a href="contact.html" id="dropdown-my">會員登入</a></li>
                                	</c:when>
                                	<c:when test="${1==1}">
                                		<li class="dropdown">
		                                    <a href="#" class="dropdown-toggle dropdown-my">會員中心<b class="caret"></b></a>
		                                    <ul class="dropdown-menu">
		                                        <li><a class="dropdown-my" href="會員修改密碼網址">修改資料</a></li>
		                                        <li><a class="dropdown-my" href="登出功能網址">會員登出</a></li>
		                                    </ul>
		                                </li>
                                	</c:when>
                                </c:choose>
                            </ul>
                        </div>
                    </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>