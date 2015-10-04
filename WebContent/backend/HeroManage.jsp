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
                	
                
                ${reflectok}<br/>
			<c:if test="${!empty reflectpagevo.reflectpage}"> 		
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
				                   <a href="<c:url value='/backend/heromanage.controller?pageNo=${reflectpagevo.pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
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
                		
						<table class="table table-bordered table-hover table-striped">
							<tr>
								<th>檢舉日誌</th>
								<th>檢舉會員</th>
								<th>投訴會員</th>
								<th>檢舉時間</th>
								<th>操作</th>
							</tr>
							<c:forEach var="reflectpage" items="${reflectpagevo.reflectpage}">
								<tr>
									<td>
										<fmt:formatDate 
                		value="${reflectpage.reflectedDate}" type="date" />
									</td>
									<td>${reflectpage.reflectedId}</td>
									<td>${reflectpage.authorId}</td>
									<td>
										<fmt:formatDate 
                		value="${reflectpage.authorDate}" type="date" />
									</td>
									<td>
										<form action="${pageContext.request.contextPath}/backend/herodaymanage.controller" method="get">
                            			<input type="hidden" name="reflectedNo" value="${reflectpage.reflectedNo}">
                            			<input type="hidden" name="reflectedId" value="${reflectpage.reflectedId}">
                            			<input type="hidden" name="authorDate" value="${reflectpage.reflectedDate}">
                            			<input type="submit" value="查看日誌">
                            	</form>
									</td>
								</tr>
								
							</c:forEach>
							</table>
			</c:if>
			<c:if test="${empty reflectpagevo.reflectpage}">
				<h2>查無資料</h2>
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
