<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav side-nav">
        <li>
			
            <a href="${pageContext.request.contextPath}/ClassOptionServlet.controller"><i class="fa fa-fw fa-desktop"></i>　菜色項目管理</a>
			
<%--             <a href="${pageContext.request.contextPath}/backend/foodCalInsert.jsp"><i class="fa fa-fw fa-desktop"></i>　菜色項目管理</a> --%>

        </li>
        <li>
            <a href="${pageContext.request.contextPath}/backend/mealDetailInsert.jsp"><i class="fa fa-fw fa-desktop"></i>　套餐組合管理</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/backend/dayMealInsert.jsp"><i class="fa fa-fw fa-desktop"></i>　一日套餐組合</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/healthViewlist.controller?pageNo=1&viewClassNo=100000"><i class="fa fa-fw fa-desktop"></i>　健康景點管理</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/backend/heromanage.controller?pageNo=1"><i class="fa fa-fw fa-desktop"></i>　日誌檢舉管理</a>
        </li>
        
        <li class="active">
            <a href="${pageContext.request.contextPath}/backend/index.jsp"><i class="fa fa-fw fa-dashboard"></i> Dashboard</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/backend/activitybase1.controller?pageNo=1"><i class="fa fa-fw fa-bar-chart-o"></i>活動後台</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/backend/exambase1.controller?pageNo=1"><i class="fa fa-fw fa-table"></i>小學堂後台</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/backend/forms.jsp"><i class="fa fa-fw fa-edit"></i> Forms</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/backend/bootstrap-elements.jsp"><i class="fa fa-fw fa-desktop"></i> Bootstrap Elements</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/backend/bootstrap-grid.jsp"><i class="fa fa-fw fa-wrench"></i> Bootstrap Grid</a>
        </li>
        <li>
            <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Dropdown <i class="fa fa-fw fa-caret-down"></i></a>
            <ul id="demo" class="collapse">
                <li>
                    <a href="#">Dropdown Item</a>
                </li>
                <li>
                    <a href="#">Dropdown Item</a>
                </li>
            </ul>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/backend/blank-page.jsp"><i class="fa fa-fw fa-file"></i> Blank Page</a>
        </li>
<!--         <li> -->
<!--             <a href="index-rtl.jsp"><i class="fa fa-fw fa-dashboard"></i> RTL Dashboard</a> -->
<!--         </li> -->
    </ul>
</div>
