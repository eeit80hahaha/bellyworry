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
                    <div class="col-lg-12">
							<div class="form-group">
                                <label>景點類別：</label>
                                <select name="viewClassNo" lang="10" id="viewClassNo" class="form-control">
									<option value="100000">全部</option>
									<jsp:useBean id="viewClass" class="fun.model.ViewClassService">
									<c:forEach var="row" items="${viewClass.all}">
										<c:if test="${nowViewClassVO.viewClassNo == row.viewClassNo}">
											<option value="${row.viewClassNo}" selected>${row.name}</option>
										</c:if>
										<c:if test="${nowViewClassVO.viewClassNo != row.viewClassNo}">
											<option value="${row.viewClassNo}">${row.name}</option>
										</c:if>
									</c:forEach>
									</jsp:useBean>
								</select>
                            </div>
                            
                            <!--<h3>健康景點管理</h3> -->
	                        <div class="table-responsive">
	                            <table class="table table-bordered table-hover table-striped">
	                            	<thead>
                                    <tr>
                                        <th>編號</th><th>健康景點名稱</th><th>景點類別</th><th>所在地緯度</th><th>所在地經度</th><th>編輯</th>
                                    </tr>
                                	</thead>
	                            	<tbody id="healthViewlist">
	                                	<c:forEach var="healthViewVO" items="${healthViewPageVO.healthViewPage}">
		                                    <tr><td>${healthViewVO.no}</td>
		                                    	<td>${healthViewVO.name}</td>
		                                    	<td>${healthViewVO.viewClassVO.name}</td>
		                                    	<td>${healthViewVO.lat}</td>
		                                    	<td>${healthViewVO.lng}</td>
		                                    	<td align="center"><button type="button" class="btn btn-default" name="prodaction" value="Update">修改</button>　<button type="button" class="btn btn-default" name="prodaction" value="Delect">刪除</button></td>
		                                    </tr>
										</c:forEach>
									</tbody>
								</table>
	                        </div>
               				<div id="controllerbtn">
               					<table border="0">
									<tr>
										<td width='76'>
											<div id="pfirst">
											<c:if test="${healthViewPageVO.pageNo > 1}">
												<a href="<c:url value='/healthViewlist.controller?pageNo=1&viewClassNo=${nowViewClassVO.viewClassNo}' />">第一頁</a>
											</c:if>
											</div>
										</td>
										<td width='76'>
											<div id="pprev">
											<c:if test="${healthViewPageVO.pageNo > 1}">
												<a href="<c:url value='/healthViewlist.controller?pageNo=${healthViewPageVO.pageNo-1}&viewClassNo=${nowViewClassVO.viewClassNo}' />">上一頁</a>
											</c:if>
											</div>
										</td>
										<td width='76'>
											<div id="pnext">
											<c:if test="${healthViewPageVO.pageNo != healthViewPageVO.totalPages}">
												<a href="<c:url value='/healthViewlist.controller?pageNo=${healthViewPageVO.pageNo+1}&viewClassNo=${nowViewClassVO.viewClassNo}' />">下一頁</a>
											</c:if>
											</div>
										</td>  
										<td width='76'>
											<div id="plast">
											<c:if test="${healthViewPageVO.pageNo != healthViewPageVO.totalPages}">
												<a href="<c:url value='/healthViewlist.controller?pageNo=${healthViewPageVO.totalPages}&viewClassNo=${nowViewClassVO.viewClassNo}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
											</c:if>
											</div>
										</td>
										<td width='176' align="center" id="pinfo">
											      第${healthViewPageVO.pageNo}頁 / 共${healthViewPageVO.totalPages}頁
									     </td>  
									</tr>
									</table>
               					
               				</div>             

                            
                            
                            
                            
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
	var viewNo = "${nowViewClassVO.viewClassNo}";
	var viewName = "${nowViewClassVO.name}";

(function($) {
	$("#viewClassNo").on('change', function() {
		location.replace('${pageContext.request.contextPath}/healthViewlist.controller?pageNo=1&viewClassNo='+$("#viewClassNo").val());
// 		getViews($(this).val());
// 		$("#controllerbtn a").each(function(){
// 			$(this).attr("href" , $(this).attr("href")+"&viewClassNo"+$("#viewClassNo").val());
// 		});
	});
	
// 	function getViews(value) {
// // 		console.log(value);
// 		$.ajax({
// 			"type" : "get",
// 			"url" : "${pageContext.request.contextPath}/healthViewlist.controller?pageNo=1&viewClassNo="+value,

// 			"dataType" : "json",
// 			"success" : function(data) {
// 				$("#healthViewlist").empty();
// 				console.log(data);
//  				//console.log(typeof(test));

// 				var a = [];
// 				var i = 0;
// 				$.each(data.healthViews, function(key,value) {	//排序
// 					a[a.length]=key;
// 				});
				
// 				a.sort();
// 				$.each(a, function(index,value) {	//改表格
// 					//console.log(value);	//healthView0,healthView1,healthView2....
// 					console.log(data.healthViews[value]); //所有物件
// 					$("#healthViewlist").append("<tr><td>"+data.healthViews[value].no
// 							+"</td><td>"+data.healthViews[value].name
// 							+"</td><td>"+data.healthViews[value].viewClass
// 							+"</td><td>"+data.healthViews[value].lat
// 							+"</td><td>"+data.healthViews[value].lng+"</td></tr>");
// 					console.log("print");
// 				});
// 				$("#pfirst").empty();
// 				$("#pprev").empty();
// 				console.log(data.pageNo);
// 				console.log(data.totalPage);
// 				var viewOpt = "&viewClassNo="+$("#viewClassNo").val();
// 				$("#pnext").empty();
// 				$("#plast").empty();
// 				if(data.pageNo!=data.totalPage){
// 					console.log("123");
// 					$("#pnext").empty();
// 					$("#pnext").append("<a>下一頁</a>");
// 					$("#pnext>a").attr("href","${pageContext.request.contextPath}/healthViewlist.controller?pageNo="+(data.pageNo+1)+"&viewClassNo="+$("#viewClassNo").val());
// 					$("#plast").empty();
// 					$("#plast").append("<a>最後頁</a>");
// 					$("#plast>a").attr("href","${pageContext.request.contextPath}/healthViewlist.controller?pageNo="+(data.totalPage)+"&viewClassNo="+$("#viewClassNo").val());
// 				}
// 				$("#pinfo").text("第"+data.pageNo+"頁 / 共"+data.totalPage+"頁");
// 			}
// 		})
// 	}
})(jQuery);


</script>

</body>

</html>
