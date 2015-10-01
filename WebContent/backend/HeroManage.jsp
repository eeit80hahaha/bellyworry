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
                                <i class="fa fa-table"></i> <a href="${pageContext.request.contextPath}/backend/#">帳號查詢</a>
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                	
                
                
                		${reflectpagevo}
<%--                 		<h1>${reflectpagevo.reflectpage[0]}</h1> --%>
                		<hr/>
                		<div id="paging">
				<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
				<table border="0">
				  <tr>
				    <td width='76'>
				        <c:if test="${reflectpagevo.pageNo > 1}">
				           <div id="pfirst">
				              <a href="<c:url value='/backend/heromanage.controller?pageNo=1' />">第一頁</a>&nbsp;&nbsp;&nbsp;
				           </div>
				        </c:if>
				     </td>
				     <td width='76'>
				        <c:if test="${reflectpagevo.pageNo > 1}">
				           <div id="pprev">
				              <a href="<c:url value='/backend/heromanage.controller?pageNo=${reflectpagevo.pageNo-1}' />">上一頁</a>&nbsp;&nbsp;&nbsp;
				           </div>
				        </c:if>  
				     </td>
				     <td width='76'>
				            <c:if test="${reflectpagevo.pageNo != reflectpagevo.totalPages}">
				                <div id="pnext">
				                   <a href="<c:url value='/backend/heromanage.controller?pageNo=${herohealthdiaryvo.pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
				                </div>
				            </c:if>
				     </td>  
				     <td width='76'>
				            <c:if test="${reflectpagevo.pageNo != reflectpagevo.totalPages}">
				                <div id="plast">
				                    <a href="<c:url value='/backend/heromanage.controller?pageNo=${reflectpagevo.totalPages}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
				                </div>
				            </c:if>
				     </td>
				     <td width='176' align="center">
				           第${reflectpagevo.pageNo}頁 / 共${reflectpagevo.totalPages}頁
				     </td>  
				</tr>
				</table>
				</div>
                		
                		檢舉日誌：<fmt:formatDate 
                		value="${reflectpagevo.reflectpage[0].reflectedDate}" type="date" /><br/>
                		檢舉會員：${reflectpagevo.reflectpage[0].reflectedId}<br/>
                		投訴會員：${reflectpagevo.reflectpage[0].authorId}<br/>
                		檢舉時間：<fmt:formatDate 
                		value="${reflectpagevo.reflectpage[0].authorDate}" type="date" /><br/>
                		<hr/>
                
<%--                 	<form action="<c:url value="/healthView.controller" />" method="get" role="form"> --%>
<!--                     <div class="col-lg-12"> -->
<!-- 							<div class="form-group"> -->
<!--                                 <label>景點類別：</label> -->
<!--                                 <select name="viewClassNo" lang="10" id="viewClassNo" class="form-control"> -->
<!-- 									<option value="100000">全部</option> -->
<%-- 									<jsp:useBean id="viewClass" class="fun.model.ViewClassService"> --%>
<%-- 									<c:forEach var="row" items="${viewClass.all}"> --%>
<%-- 										<c:if test="${nowViewClassVO.viewClassNo == row.viewClassNo}"> --%>
<%-- 											<option value="${row.viewClassNo}" selected>${row.name}</option> --%>
<%-- 										</c:if> --%>
<%-- 										<c:if test="${nowViewClassVO.viewClassNo != row.viewClassNo}"> --%>
<%-- 											<option value="${row.viewClassNo}">${row.name}</option> --%>
<%-- 										</c:if> --%>
<%-- 									</c:forEach> --%>
<%-- 									</jsp:useBean> --%>
<!-- 								</select> -->
<!--                             </div> -->
                            
<!--                             <h3>健康景點管理</h3> -->
<!-- 	                        <div class="table-responsive"> -->
<!-- 	                            <table class="table table-bordered table-hover table-striped"> -->
<!-- 	                            	<thead> -->
<!--                                     <tr> -->
<!--                                         <th>編號</th><th>健康景點名稱</th><th>景點類別</th><th>所在地緯度</th><th>所在地經度</th><th>編輯</th> -->
<!--                                     </tr> -->
<!--                                 	</thead> -->
<!-- 	                            	<tbody id="healthViewlist"> -->
<%-- 	                                	<c:forEach var="healthViewVO" items="${healthViewPageVO.healthViewPage}"> --%>
<%-- 		                                    <tr><td>${healthViewVO.no}</td> --%>
<%-- 		                                    	<td>${healthViewVO.name}</td> --%>
<%-- 		                                    	<td>${healthViewVO.viewClassVO.name}</td> --%>
<%-- 		                                    	<td>${healthViewVO.lat}</td> --%>
<%-- 		                                    	<td>${healthViewVO.lng}</td> --%>
<!-- 		                                    	<td align="center"><button type="button" class="btn btn-default" name="prodaction" value="Update">修改</button>　<button type="button" class="btn btn-default" name="prodaction" value="Delect">刪除</button></td> -->
<!-- 		                                    </tr> -->
<%-- 										</c:forEach> --%>
<!-- 									</tbody> -->
<!-- 								</table> -->
<!-- 	                        </div> -->
<!--                				<div id="controllerbtn"> -->
<!--                					<table border="0"> -->
<!-- 									<tr> -->
<!-- 										<td width='76'> -->
<!-- 											<div id="pfirst"> -->
<%-- 											<c:if test="${healthViewPageVO.pageNo > 1}"> --%>
<%-- 												<a href="<c:url value='/healthViewlist.controller?pageNo=1&viewClassNo=${nowViewClassVO.viewClassNo}' />">第一頁</a> --%>
<%-- 											</c:if> --%>
<!-- 											</div> -->
<!-- 										</td> -->
<!-- 										<td width='76'> -->
<!-- 											<div id="pprev"> -->
<%-- 											<c:if test="${healthViewPageVO.pageNo > 1}"> --%>
<%-- 												<a href="<c:url value='/healthViewlist.controller?pageNo=${healthViewPageVO.pageNo-1}&viewClassNo=${nowViewClassVO.viewClassNo}' />">上一頁</a> --%>
<%-- 											</c:if> --%>
<!-- 											</div> -->
<!-- 										</td> -->
<!-- 										<td width='76'> -->
<!-- 											<div id="pnext"> -->
<%-- 											<c:if test="${healthViewPageVO.pageNo != healthViewPageVO.totalPages}"> --%>
<%-- 												<a href="<c:url value='/healthViewlist.controller?pageNo=${healthViewPageVO.pageNo+1}&viewClassNo=${nowViewClassVO.viewClassNo}' />">下一頁</a> --%>
<%-- 											</c:if> --%>
<!-- 											</div> -->
<!-- 										</td>   -->
<!-- 										<td width='76'> -->
<!-- 											<div id="plast"> -->
<%-- 											<c:if test="${healthViewPageVO.pageNo != healthViewPageVO.totalPages}"> --%>
<%-- 												<a href="<c:url value='/healthViewlist.controller?pageNo=${healthViewPageVO.totalPages}&viewClassNo=${nowViewClassVO.viewClassNo}' />">最末頁</a>&nbsp;&nbsp;&nbsp; --%>
<%-- 											</c:if> --%>
<!-- 											</div> -->
<!-- 										</td> -->
<!-- 										<td width='176' align="center" id="pinfo"> -->
<%-- 											      第${healthViewPageVO.pageNo}頁 / 共${healthViewPageVO.totalPages}頁 --%>
<!-- 									     </td>   -->
<!-- 									</tr> -->
<!-- 									</table> -->
               					
<!--                				</div>              -->

                            
                            
                            
                            
<%--                             <h3><span class="error">${error.action}</span></h3> --%>
                            
							
                        

<!--                     </div> -->
<!--                     </form> -->
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
