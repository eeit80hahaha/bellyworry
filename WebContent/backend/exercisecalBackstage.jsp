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

    <title>【BellyWorry後台】運動項目管理</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/backend/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->

    <link href="css/sb-admin.css" rel="stylesheet">
<!-- 	<script src="//code.jquery.com/jquery-1.11.3.min.js"></script> -->
<!-- 	<script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script> -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  	<script src="//code.jquery.com/jquery-1.10.2.js"></script>
  	<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<!--   	<link rel="stylesheet" href="/resources/demos/style.css"> -->
	

			<!-- hui Git Mark -->
<%--     <link href="${pageContext.request.contextPath}/backend/css/sb-admin.css" rel="stylesheet"> --%>
			<!-- hui Git Mark -->

    <!-- Custom Fonts -->

    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
	<script src="../ckeditor/ckeditor.js"></script>
			<!-- hui Git Mark -->
<%--     <link href="${pageContext.request.contextPath}/backend/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"> --%>
			<!-- hui Git Mark -->

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
<script>
  function add1(){
	  //$("#add").append("<input type=\"text\">");
// 	  int i=2;
      var counts = parseInt($("#itemCounts").val()) + 1;

	  $("#add1").append("<div class='row'>          	<div class='col-lg-4'>					<label>名稱：</label>			<input type='text' name='itemname"+ counts +"' size='15' autocomplete='off' required='required' class='form-control'>		</div>		<div class='col-lg-4'>			<label>類型：</label>			<input type='text' name='itemclass"+ counts +"' size='15' autocomplete='off' required='required' class='form-control'>		</div>		<div class='col-lg-4'>			<label>份量：</label>			<input type='text' name='itemweight"+ counts +"' size='15' autocomplete='off' required='required' class='form-control'>		</div>	</div>");
	  
	  $("#itemCounts").val(counts);
//  	i=i+1;	 
  }
  function add2(){
	  //$("#add").append("<input type=\"text\">");
// 	  int i=2;
	  $("#add2").append("<br><label class=\"title\">作法"+":</label><input type=\"text\" name=\"weight\" size=\"20\" autocomplete=\"off\" required=\"\" />");
//  	i=i+1;	 
  }
//   function del(){
// 	  //$("#add").append("<input type=\"text\">");
// // 	  int i=2;
// 	  $("#add").remove("<label class=\"title\">作法"+":</label><input type=\"text\" name=\"weight\" size=\"20\" autocomplete=\"off\" required=\"\" />");
// //  	i=i+1;	 
//   }
//===============訊息顯示======================
$(function() {
    $( "#dialog" ).dialog({
      autoOpen: false,
      show: {
        effect: "blind",
        duration: 1000
      },
      hide: {
        effect: "explode",
        duration: 1000
      }
    });
	${error.open}
});


//===============訊息顯示======================
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
                        	運動項目管理
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-table"></i> <a href="../ranking/execiseCal.controller?exerciseNo=&name=&calHour=&execrisecalion=Select">查詢運動項目</a>
                            </li>                                      
							<!-- hui Git Mark -->
<%--                                 <i class="fa fa-table"></i> <a href="${pageContext.request.contextPath}/backend/foodCalManage.jsp">查詢菜色項目</a> --%>
<!--                             </li> -->
							<!-- hui Git Mark -->
                            <li class="active">
                                <i class="fa fa-edit"></i> 新增運動項目
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                	<form role="form" enctype="multipart/form-data" method="post" action="../backend/exerciseCalingproduct.jsp">
                    <div class="col-lg-6">

                        

                            <div class="form-group">
                                <label>運動編號 :</label>
                                <input type="text" name="exerciseNo" value="${param.exerciseNo}" size="20" autocomplete="off" required="required" class="form-control">
<!--                                 <p class="help-block">(為必填欄位)</p> -->
								<br><span style="color:red">${error.exerciseNo}</span>
                            </div>
                            <div class="form-group">
                                <label>運動名稱 :</label>
                                <input type="text" name="name" value="${param.name}" size="20" autocomplete="off" required="required" class="form-control">
<!--                                 <p class="help-block">(為必填欄位)</p> -->
									<br><span style="color:red"></span>
                            </div>
                            <div class="form-group">
                                <label>每小時消耗熱量 :</label>
                                <input type="text" name="calHour" value="${param.calHour}" size="20" autocomplete="off" required="required" class="form-control">
<!--                                 <p class="help-block">(為必填欄位)</p> -->
								<br><span style="color:red">${error.calHour}</span>
                            </div>                            
                            <br/>

                            <button type="submit" class="btn btn-default">新增資料</button>
                            <button type="reset" class="btn btn-default">清空表單</button>

                        

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
<!--     <script src="js/jquery.js"></script> -->
			<!-- hui Git Mark -->
<%--     <script src="${pageContext.request.contextPath}/backend/js/jquery.js"></script> --%>
			<!-- hui Git Mark -->

    <!-- Bootstrap Core JavaScript -->

    <script src="js/bootstrap.min.js"></script>
	<script type="text/javascript">CKEDITOR.replace('way');</script>
	
	
	<div id="dialog" title="新增菜色">
	${error.action}
	
	</div>
	
				<!-- hui Git Mark -->
<%--     <script src="${pageContext.request.contextPath}/backend/js/bootstrap.min.js"></script> --%>

				<!-- hui Git Mark -->
</body>

</html>
