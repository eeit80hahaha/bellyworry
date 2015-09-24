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

    <title>【BellyWorry後台】菜色項目管理</title>

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
<script>
  function add1(){
	  //$("#add").append("<input type=\"text\">");
// 	  int i=2;
	  $("#add1").append("<div class='row'>          	<div class='col-lg-4'>					<label>名稱：</label>			<input type='text' name='itemname' size='15' autocomplete='off' required='required' class='form-control'>		</div>		<div class='col-lg-4'>			<label>類型：</label>			<input type='text' name='itemclass' size='15' autocomplete='off' required='required' class='form-control'>		</div>		<div class='col-lg-4'>			<label>份量：</label>			<input type='text' name='itemweight' size='15' autocomplete='off' required='required' class='form-control'>		</div>	</div>");
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
                        	菜色項目管理
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-table"></i> <a href="foodCalManage.jsp">查詢菜色項目</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> 新增菜色項目
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                	<form role="form">
                    <div class="col-lg-6">

                        

                            <div class="form-group">
                                <label>菜色名稱：</label>
                                <input type="text" name="foodname" size="20" autocomplete="off" required="required" class="form-control">
<!--                                 <p class="help-block">(為必填欄位)</p> -->
                            </div>
                            <div class="form-group">
                                <label>菜色分類：</label>
                                <select class="form-control" name="collection">
                                    <option value="1">即食食品/零食類</option>
                                    <option value="2">即食食品</option>
                                    <option value="3">零食類</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>熱量(cal)：</label>
                                <input type="text" name="cal" size="20" autocomplete="off" required="required" class="form-control">
<!--                                 <p class="help-block">(為必填欄位)</p> -->
                            </div>
                            <div class="form-group">
                                <label>份量單位：</label>
                                <input type="text" name="count" size="20" autocomplete="off" required="required" class="form-control">
<!--                                 <p class="help-block">(為必填欄位)</p> -->
                            </div>
                            <div class="form-group">
                                <label>每份公克數：</label>
                                <input type="text" name="weight" size="20" autocomplete="off" required="required" class="form-control">
<!--                                 <p class="help-block">(為必填欄位)</p> -->
                            </div>
                            <div class="form-group">
                                <label>大圖片：</label>
                                <input type="file">
                            </div>
                            <div class="form-group">
                                <label>小圖片：</label>
                                <input type="file">
                            </div>
                            <br/>

                            <button type="submit" class="btn btn-default">新增資料</button>
                            <button type="reset" class="btn btn-default">清空表單</button>

                        

                    </div>
                    <div class="col-lg-6">
						
						<label>食材清單：</label>&nbsp;<input type="button" value="+" onclick="add1();"><br/><br/>
                        <div id="add1" class="form-group">
							<div class='row'>
	                        	<div class='col-lg-4'>			
									<label>名稱：</label>
									<input type='text' name='itemname' size='15' autocomplete='off' required='required' class='form-control'> 
								</div>
								<div class='col-lg-4'>
									<label>類型：</label>
									<input type="text" name='itemclass' size='15' autocomplete='off' required='required' class='form-control'>
								</div>
								<div class='col-lg-4'>
									<label>份量：</label>
									<input type='text' name='itemweight' size='15' autocomplete='off' required='required' class='form-control'>
								</div>
							</div>
						</div>
						<div class="form-group">
                            <label>做法</label>
                            <textarea class="form-control" rows="3" name="way" autocomplete="off" required="required"></textarea>
                        </div>
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
