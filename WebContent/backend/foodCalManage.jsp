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
/* table { */
/*  border-collapse: separate; */
/*  border-spacing: 3px; */
/*  border: 3px solid #000000; */
/* } */

/* tr td { */
/*  border: 2px solid #000000; */
/* } */
#table{border: 3px solid #000000;border-spacing: 3px;border-collapse: separate;width: 800px;border: 3px double #000000;margin:auto;} 
td,th{border: 2px solid #000000;} 
thead{text-align: center;text-transform: uppercase;border-bottom: 3px double #aa7700;background-color: #d7ffee }
tbody{text-align: center;background-color: #7affc6 border: 1px double gray}
tbody tr:nth-child(2n){background-color: #FFEE99}
tbody tr:nth-child(2n+1){background-color: #FFFFBB}
tbody tr:hover{background-color: #ffffff}
input[type="button"]:disabled{
	color: #888888;
}
</style>
    <title>【BellyWorry後台】菜色項目管理</title>

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
                        	菜色項目管理
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-table"></i>查詢菜色項目
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> <a href="foodCalInsert.jsp">新增菜色項目</a>
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
            <form method="post"
			action="${pageContext.request.contextPath}/backend/SelectAllMenuServlet.controller"
			id="menuForm">
			<div style="margin: 20px 0 20px 20px;">
				<select id="menuNo" name="menuNo">
					<option value="">請選擇..</option>
					<c:forEach var="vo" items="${option}">
						<!-- Neil modified -->
						<!--original
						<option value="${vo.menuNo}" >${vo.name}</option>
						-->
						<option value="${vo.menuNo}" ${vo.menuNo == selected ? 'selected="selected"' : ''}>${vo.name}</option>
						<!-- Neil modified -->
					</c:forEach>
					<option value="0">所有類型</option>
				</select>
			</div>
            
			<table id="table">
			<thead style="text-align:center;">
			<tr><th style="text-align:center;">編號</th><th style="text-align:center;">圖片</th>
			<th style="text-align:center;">菜色分類</th><th style="text-align:center;">菜色名稱</th><th style="text-align:center;">修改</th><th style="text-align:center;">刪除</th></tr>
			</thead>
			<tbody>
			<c:forEach var="vo" items="${menu}">
			<tr>
				<td>${vo.foodNo}</td>
				<input type="hidden" name="foodNo" value="${vo.foodNo}" />
				<td width="60" height="60">
				<c:choose>
					<c:when test="${empty vo.picture1}">
						<img src="../images/empty.jpg" width="60"
											height="60" />
					</c:when>
					<c:otherwise>
						<img src="data:image/jpg;base64,${vo.picture1}" width="60"
											height="60" />
					</c:otherwise>
				</c:choose>				
				</td>
				<td>${vo.menus.name}</td>
				<td>${vo.name}</td>
				<td><input type="button" name="" value="修改" onclick="#" /></td>
				<td><input type="button" name="" value="刪除" onclick="#" /></td>
			</tr>
			</c:forEach>
			</tbody>
			</table>
			<br>
			<div style="text-align:center;">
			<input type="button" name="" value="第一頁" onclick="pagecount('1')" />
			<input type="button" name="" value="上一頁"
				onclick="pagecount('${pagecount-1}')" ${pagecount==1?'disabled="true"':""}/> 
			<input type="button" name="" value="下一頁" onclick="pagecount('${pagecount+1}')" ${pagecount==listPage?'disabled="true"':""}/>
			<input type="button" name="" value="最末頁" onclick="pagecount('${listPage}')" />
			<input type="hidden" id="pages" name="pages" value="1" />
			</div>
		</form>	
        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>
	
</body>
<script type="text/javascript">
	$(function() {
		$("#menuNo").change(function() {
			if ($("#menuNo option:selected").val() == "") {
				return false;
			}
// 			alert($("#menuNo option:selected").text());
			$("#menuForm").submit();
		});
	});

	function pagecount(pages) {
		$("#pages").val(pages);
		$("#menuForm").submit();
	}
	function deleteFood(foodNo) {
		$("#menuForm").attr("action","${pageContext.request.contextPath}/backend/UpdateandDeleteServlet.controller");
		$("#menuForm").submit();
	}
</script>
</html>
