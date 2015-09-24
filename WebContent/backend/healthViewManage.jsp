<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>【BellyWorry後台】健康景點管理</title>

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
<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
	$("#viewClassNo option").prop("selected",false);
	
}
</script>
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
                        	健康景點管理
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-table"></i> 查詢健康景點
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> <a href="${pageContext.request.contextPath}/backend/healthViewInsert.jsp">新增健康景點</a>
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                	<form action="<c:url value="/healthView.controller" />" method="get" role="form">
                    <div class="col-lg-6">

                        

                            <div class="form-group">
                                <label>健康景點名稱：</label>
                                <input type="text" name="name" value="${param.name}" class="form-control" required="required">
                                <span class="alert-danger">${error.name}</span>
<!--                                 <p class="help-block">(為必填欄位)</p> -->
                            </div>
                            <div class="form-group">
                                <label>景點類別：</label>
                                <select name="viewClassNo" lang="10" id="viewClassNo" class="form-control">
									<jsp:useBean id="viewClass" class="fun.model.ViewClassService">
									<c:forEach var="row" items="${viewClass.all}">
										<c:choose>
											<c:when test="${param.viewClassNo == row.viewClassNo}">
												<option value="${row.viewClassNo}" selected>${row.name}</option>
											</c:when>
											<c:otherwise>
												<option value="${row.viewClassNo}">${row.name}</option>
											</c:otherwise>
										</c:choose>>
									</c:forEach>
									</jsp:useBean>
								</select>
                            </div>
                            <div class="form-group">
                                <label>所在地緯度：</label>
                                <input type="text" name="lat" value="${param.lat}" class="form-control" required="required">
                                <span class="alert-danger">${error.lat}</span>
<!--                                 <p class="help-block">(為必填欄位)</p> -->
                            </div>
                            <div class="form-group">
                                <label>所在地經度：</label>
                                <input type="text" name="lng" value="${param.lng}" class="form-control" required="required">
                                <span class="alert-danger">${error.lng}</span>
<!--                                 <p class="help-block">(為必填欄位)</p> -->
                            </div>
                            
                            <br/>
                            <br/>
                            <br/>
                            <br/>

                            <button type="submit" class="btn btn-default" name="prodaction" value="Insert">新增資料</button>
                            <button type="reset" class="btn btn-default" onclick="clearForm()">清空表單</button>
                            <br/><br/>
                            <h3><span class="error">${error.action}</span></h3>
                            
							
                        

                    </div>
                    <div class="col-lg-6">
                    <c:if test="${not empty insert}">
                        <h4>新增資料成功</h4>
                        <div class="table-responsive">
                            <table class="table table-bordered table-hover table-striped">
                            
                                <tbody>
                                    <tr><td>編號</td><td>${insert.no}</td></tr>
                                    <tr><td>健康景點名稱</td><td>${insert.name}</td></tr>
                                    <tr><td>景點類別</td><td>${insert.viewClassVO.name}</td></tr>
									<tr><td>所在地緯度</td><td>${insert.lat}</td></tr>
									<tr><td>所在地經度</td><td>${insert.lng}</td></tr>
								</tbody>
							</table>
                        </div>
                        <script type="text/javascript">clearForm();</script>
                    </c:if>
                    </div>
                    </form>
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
