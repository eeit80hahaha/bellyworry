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

    <title>【BellyWorry後台】一日套餐組合</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/sb-admin.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

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
                        	一日套餐組合
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-table"></i> <a href="../backend/SelectDayMealServlet.controller">查詢一日套餐</a>
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> 新增一日套餐
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                	<form role="form">
                    <div class="col-lg-7">

                        

                            <div class="form-group">
                                <label>一日套餐名稱：</label>
                                <input type="text" name="foodname" size="20" autocomplete="off" required="required" class="form-control">
<!--                                 <p class="help-block">(為必填欄位)</p> -->
                            </div>
                            <div class="form-group">
                                <label>早餐：</label>
                                <select class="form-control" name="foodname">
                                    <option value="1">抵抗失戀沖喜套餐</option>
                                    <option value="2">美式經典餐</option>
                                    <option value="3">黃金套餐</option>
                                    <option value="4">優雅貓輕食套餐</option>
                                    <option value="5">享瘦套餐</option>
                                    <option value="6">樂活套餐</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>午餐：</label>
                                <select class="form-control" name="foodname">
                                    <option value="1">抵抗失戀沖喜套餐</option>
                                    <option value="2">美式經典餐</option>
                                    <option value="3">黃金套餐</option>
                                    <option value="4">優雅貓輕食套餐</option>
                                    <option value="5">享瘦套餐</option>
                                    <option value="6">樂活套餐</option>
                                </select>
                            </div>
                            <div class="form-group">
                                <label>晚餐：</label>
                                <select class="form-control" name="foodname">
                                    <option value="1">抵抗失戀沖喜套餐</option>
                                    <option value="2">美式經典餐</option>
                                    <option value="3">黃金套餐</option>
                                    <option value="4">優雅貓輕食套餐</option>
                                    <option value="5">享瘦套餐</option>
                                    <option value="6">樂活套餐</option>
                                </select>
                            </div>
                            
                            <br/>
                            <br/>
                            <br/>
                            <br/>

                            <button type="submit" class="btn btn-default">新增資料</button>
                            <button type="reset" class="btn btn-default">清空表單</button>
                            <br/><br/>

                        

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
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
