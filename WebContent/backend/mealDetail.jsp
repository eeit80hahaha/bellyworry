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
#table{width: 900px;border: 3px solid #01814a;border-collapse: collapse;margin: 0 auto}
td,th{border: 1px solid gray }
thead{text-transform: uppercase;border-bottom: 3px double #aa7700;background-color: #d7ffee }
tbody{text-align: center;background-color: #7affc6}
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
                        	套餐管理
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-table"></i>查詢套餐組合
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> <a href="mealDetailInsert.jsp">新增套餐組合</a>
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
			action="#"
			id="menuForm">
			<div style="margin: 20px 0 20px 20px;">
<!-- 				<select id="menuNo" name="menuNo"> -->
<!-- 					<option value="">請選擇..</option> -->
<%-- 					<c:forEach var="vo" items="${menu}"> --%>
<!-- 						Neil modified -->
<!-- 	 						original -->
<%-- 						<option value="${vo.menuNo}" >${vo.name}</option> --%>
<!-- 	 						original -->
<%-- 						<option value="${vo.mealNo}" ${vo.mealNo == selected ? 'selected="selected"' : ''}>${vo.name}</option> --%>
<!-- 						Neil modified -->
<%-- 					</c:forEach> --%>
<!-- 					<option value="0">所有類型</option> -->
<!-- 				</select> -->
			</div>
            
			<table id="table">
			<thead style="text-align:center;">
			<tr><th>套餐編號</th><th>套餐名稱</th><th>菜色名稱</th><th>修改</th><th>查詢</th></tr>
			</thead>
			<tbody>
			<c:forEach var="vo" items="${menu}">
			<tr>
				<td>${vo.mealNo}</td>
				<td>${vo.name}</td>
				<td>
				<c:forEach var="v1" items="${vo.foodcals}">
					<span>${v1.name}</span>
				</c:forEach>
				</td>
				<td><input type="button" name="" value="修改"  /></td>
				<td><input type="button" name="" value="刪除"  /></td>
			</tr>
			</c:forEach>
			
			</tbody>
			</table>
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

	function pagecount(pages) {
		$("#pages").val(pages);
		$("#menuForm").submit();
	}

</script>
</html>
