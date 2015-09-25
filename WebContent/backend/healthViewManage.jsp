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
                    <div class="col-lg-10">
							<div class="form-group">
                                <label>景點類別：</label>
                                <select name="viewClassNo" lang="10" id="viewClassNo" class="form-control">
									<option value="">全部</option>
									<jsp:useBean id="viewClass" class="fun.model.ViewClassService">
									<c:forEach var="row" items="${viewClass.all}">
										<option value="${row.viewClassNo}">${row.name}</option>
									</c:forEach>
									</jsp:useBean>
								</select>
                            </div>
                            
                            <!--<h3>健康景點管理</h3> -->
	                        <div class="table-responsive">
	                            <table class="table table-bordered table-hover table-striped">
	                            	<thead>
                                    <tr>
                                        <th>編號</th><th>健康景點名稱</th><th>景點類別</th><th>所在地緯度</th><th>所在地經度</th>
                                    </tr>
                                	</thead>
	                            	<tbody id="healthViewlist">
	                                	<c:forEach var="healthViewVO" items="${healthViewPageVO.healthViewPage}">
		                                    <tr><td>${healthViewVO.no}</td>
		                                    	<td>${healthViewVO.name}</td>
		                                    	<td>${healthViewVO.viewClassVO.name}</td>
		                                    	<td>${healthViewVO.lat}</td>
		                                    	<td>${healthViewVO.lng}</td>
		                                    </tr>
										</c:forEach>
									</tbody>
								</table>
	                        </div>
               				<div id="controllerbtn">
               					<table border="0">
									<tr>
									  <td width='76'>
									      <c:if test="${healthViewPageVO.pageNo > 1}">
									<div id="pfirst">
									   <a href="<c:url value='/healthViewlist.controller?pageNo=1' />">第一頁</a>&nbsp;&nbsp;&nbsp;
									</div>
									</c:if>
									</td>
									<td width='76'>
									   <c:if test="${healthViewPageVO.pageNo > 1}">
									<div id="pprev">
									   <a href="<c:url value='/healthViewlist.controller?pageNo=${healthViewPageVO.pageNo-1}' />">上一頁</a>&nbsp;&nbsp;&nbsp;
									</div>
									</c:if>  
									</td>
									<td width='76'>
									       <c:if test="${healthViewPageVO.pageNo != healthViewPageVO.totalPages}">
									<div id="pnext">
									   <a href="<c:url value='/healthViewlist.controller?pageNo=${healthViewPageVO.pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
									</div>
									</c:if>
									</td>  
									<td width='76'>
									       <c:if test="${healthViewPageVO.pageNo != healthViewPageVO.totalPages}">
									<div id="plast">
									    <a href="<c:url value='/healthViewlist.controller?pageNo=${healthViewPageVO.totalPages}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
									</div>
									</c:if>
									</td>
									<td width='176' align="center">
									      第${healthViewPageVO.pageNo}頁 / 共${healthViewPageVO.totalPages}頁
									     </td>  
									</tr>
									</table>
               					
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


<script type="text/javascript">
// function clearForm() {
// 	var inputs = document.getElementsByTagName("input");
// 	for(var i=0; i<inputs.length; i++) {
// 		if(inputs[i].type=="text") {
// 			inputs[i].value="";
// 		}
// 	}
// 	$("#viewClassNo option").prop("selected",false);	
// }
(function($) {
	$("#viewClassNo").on('change', function() {
// 		getViews($(this).val());
		
		$("#controllerbtn a").each(function(){
			$(this).attr("href");
		});
		$(this).attr("href" , $(this).attr("href")+$("#viewClass").val());
	});
	
// 	function getViews(value) {
// 		$.ajax({
// 			"type" : "get",
// 			"url" : "/healthViewlist.controller?pageNo=1&viewClassNo="+value,
// 			"dataType" : "json",
// 			"success" : function(data) {
// 				console.log(data);
// 				$.each(data, function() {
// 					$("#healthViewlist").empty();
// 					var val = this.no;
// 					var name = this.name;
// 					$("#healthview").append(
// //								"<option value='{lat:"+this.lat+", lng:"+this.lng+"}'>"
// 							"<option value='"+this.lat+","+this.lng+"'>"
// 									+ name + "</option>");

// 				});
// 			}
// 		})
// 	}
	
})(jQuery);


// &viewClassNo=
</script>

</body>

</html>
