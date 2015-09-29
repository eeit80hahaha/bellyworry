<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
<style type="text/css">
#table1{width: 800px;border: 3px solid #01814a;border-collapse: collapse;margin: 0 auto}
td,th{border: 1px solid gray }
thead{text-transform: uppercase;border-bottom: 3px double #aa7700;background-color: #d7ffee }
tbody{text-align: center;background-color: #7affc6}
tbody tr:nth-child(2n){background-color: #ffcc22}
tbody tr:nth-child(2n+1){background-color: #ffaa33}
tbody tr:hover{background-color: #ffffff}
input[type="button"]:disabled{
	color: #888888;
}
</style>
    <title>【BellyWorry後台】小學堂項目管理</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">
<!-- 	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script> -->
<!-- 	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script> -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  	<link rel="stylesheet" href="/resources/demos/style.css">
	
    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<!-- 	<script src="../ckeditor/ckeditor.js"></script> -->
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
                        	小學堂項目管理
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-table"></i>查詢小學堂項目
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> <a href="examInsert.jsp">新增小學堂項目</a>
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                	
                </div>
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->
<%--             <form method="post" action="${pageContext.request.contextPath}/backend/SelectAllMenuServlet.controller" id="menuForm"> --%>
					<div id="paging">
					<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
						<table border="0">
						 	<tr>
						    	<td width='76'>
								<c:if test="${PageExamVO.pageNo > 1}">
						           <div id="pfirst">
						              <a href="<c:url value='/backend/exambase1.controller?pageNo=1' />">第一頁</a>&nbsp;&nbsp;&nbsp;
						           </div>
								</c:if>
						     	</td>
						     	<td width='76'>
								<c:if test="${PageExamVO.pageNo > 1}">
						           <div id="pprev">
						              <a href="<c:url value='/backend/exambase1.controller?pageNo=${PageExamVO.pageNo-1}' />">上一頁</a>&nbsp;&nbsp;&nbsp;
						           </div>
								</c:if>  
						     	</td>
						     	<td width='76'>
								<c:if test="${PageExamVO.pageNo != PageExamVO.totalPages}">
									<div id="pnext">
										<a href="<c:url value='/backend/exambase1.controller?pageNo=${PageExamVO.pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
									</div>
								</c:if>
						    	</td>  
						    	<td width='76'>
								<c:if test="${PageExamVO.pageNo != PageExamVO.totalPages}">
									<div id="plast">
									    <a href="<c:url value='/backend/exambase1.controller?pageNo=${PageExamVO.totalPages}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
									</div>
								</c:if>
						    	</td>
						    	<td width='176' align="center">
						        	  第${PageExamVO.pageNo}頁 / 共${PageExamVO.totalPages}頁
						    	</td>  
							</tr>
						</table>
					</div>
			<table>
			<thead>
			<tr><th>no</th><th>題目內容</th><th>答案</th><th>選項A</th><th>選項B</th><th>選項C</th><th></th></tr>
			</thead>
			<tbody>
			<c:forEach var="exam" items="${PageExamVO.exampage}" varStatus="list">
			<tr>
				<td>${exam.no}</td>
				<td>${exam.content}</td>
				<td>${exam.correct}</td>
				<td>${exam.optA}</td>
				<td>${exam.optB}</td>
				<td>${exam.optC}</td>
				<td><a href="${pageContext.request.contextPath}/backend/examupdate.controller?no=${exam.no}" >修改</a></td>
			</tr>
			</c:forEach>
			</tbody>
			</table>			
<!-- 		</form>	 -->
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js">
    
    </script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	
</body>
<script type="text/javascript">
// 	$(function() {
// 		$("#menuNo").change(function() {
// 			if ($("#menuNo option:selected").val() == "") {
// 				return false;
// 			}
// 			$("#menuForm").submit();
// 		});
// 	});

// 	function pagecount(pages) {
// 		$("#pages").val(pages);
// 		$("#menuForm").submit();
// 	}
</script>
</html>
