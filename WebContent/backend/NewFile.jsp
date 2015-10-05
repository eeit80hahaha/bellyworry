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

    <title>【BellyWorry後台】活動項目管理</title>

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

<body onload="init();">

    <div id="wrapper">

        <!-- Navigation -->
        <jsp:include page="/backend/page/header.jsp"/>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                        	活動項目管理
                        </h1>
                        <ol class="breadcrumb">
                            <li>
                                <i class="fa fa-table"></i>查詢活動項目
                            </li>
                            <li class="active">
                                <i class="fa fa-edit"></i> <a href="activityInsert.jsp">新增活動項目</a>
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
						<table>
						 	<tr>
						    	<td width='76'>
								<c:if test="${PagesActivityVO.pageNo > 1}">
						           <div id="pfirst">
						              <a href="<c:url value='/backend/activitybase1.controller?pageNo=1' />">第一頁</a>&nbsp;&nbsp;&nbsp;
						           </div>
								</c:if>
						     	</td>
						     	<td width='76'>
								<c:if test="${PagesActivityVO.pageNo > 1}">
						           <div id="pprev">
						              <a href="<c:url value='/backend/activitybase1.controller?pageNo=${PagesActivityVO.pageNo-1}' />">上一頁</a>&nbsp;&nbsp;&nbsp;
						           </div>
								</c:if>  
						     	</td>
						     	<td width='76'>
								<c:if test="${PagesActivityVO.pageNo != PagesActivityVO.totalPages}">
									<div id="pnext">
										<a href="<c:url value='/backend/activitybase1.controller?pageNo=${PagesActivityVO.pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
									</div>
								</c:if>
						    	</td>  
						    	<td width='76'>
								<c:if test="${PagesActivityVO.pageNo != PagesActivityVO.totalPages}">
									<div id="plast">
									    <a href="<c:url value='/backend/activitybase1.controller?pageNo=${PagesActivityVO.totalPages}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
									</div>
								</c:if>
						    	</td>
						    	<td width='176' align="center">
						        	  第${PagesActivityVO.pageNo}頁 / 共${PagesActivityVO.totalPages}頁
						    	</td>  
							</tr>
						</table>
					</div>
			<table>
			<thead>
			<tr><th>no</th><th>活動名稱</th><th>開始時間</th><th>結束時間</th><th>活動地點</th><th>活動圖片</th><th>主辦廠商</th><th></th></tr>
			</thead>
			<tbody>
			<c:forEach var="activity" items="${PagesActivityVO.activitypage}" varStatus="list">
			<tr>
				<td>${activity.no}</td>
				<td>${activity.name}</td>
				<td>${activity.startTime}</td>
				<td>${activity.endTime}</td>
				<td>${activity.address}</td>
				<td width="60" height="60"><img src="data:image/jpg;base64,${activity.picture1}" width="60"height="60" /></td>
<%-- 				<td>${activity.url}</td> --%>
				<td>${activity.boss}</td>				
				<td>
					<FORM  action="<c:url value='activityupdate.controller?no=${activity.no}' />" method="get">
			               <!-- 這些隱藏欄位都會送到後端 -->
			               <Input type='hidden' name='no' value='${activity.no}'><P/>
			               <Input type='hidden' name='name' value='${activity.name}'><P/>
<%-- 			               <Input type='hidden' name='content' value='${activity.content}'><P/> --%>
			               <Input type='hidden' name='startTime' value='${activity.startTime}'><P/>
			               <Input type='hidden' name='endTime' value='${activity.endTime}'><P/>
			               <Input type='hidden' name='address' value='${activity.address}'><P/>
			               <Input type='hidden' name='url' value='${activity.url}'><P/>
			               <Input type='hidden' name='boss' value='${activity.boss}'><P/>
<%-- 			               		<Input type='hidden' name='PictureBig' value='${activity.picture1}'><P/> --%>
			               <Input type='submit' value='修改'>
			       </FORM>
				</td>
<%-- 				<td><a href="${pageContext.request.contextPath}/backend/activityupdate.controller?no=${activity.no}" >修改</a></td> --%>
			</tr>
			
<%-- 		<FORM  action="<c:url value='BuyBook.do' />" method="POST"> --%>
<!--                這些隱藏欄位都會送到後端 -->
<%--                <Input type='hidden' name='bookID' value='${aBookBean.bookID}'><P/> --%>
<%--                <Input type='hidden' name='title' value='${aBookBean.title}'><P/> --%>
<%--                <Input type='hidden' name='author' value='${aBookBean.author}'><P/> --%>
<%--                <Input type='hidden' name='companyName' value='${aBookBean.companyName}'><P/> --%>
<%--                <Input type='hidden' name='price' value='${aBookBean.price}'><P/> --%>
<%--                <Input type='hidden' name='discount' value='${aBookBean.discount}'><P/> --%>
<%--                <Input type='hidden' name='pageNo' value='${param.pageNo}'><P/> --%>
<!--                <Input type='submit' value='加入購物車'> -->
<!--        </FORM> -->
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
<!-- <script type="text/javascript"> -->
<!-- //  function init(){ -->
<!-- //  	var contents = document.getElementsByName("activityContent"); -->
<%-- //  		for(var i =0; i<contents.length;i++){ --%>
<%-- //  			console.log(contents[i].firstChild.nodeValue); --%>
<%-- //  			contents[i].innerHTML = new String(contents[i].firstChild.nodeValue).substr(0,20); --%>
<%-- //  		} --%>
<%-- //  	var NewStr="${activity.content}"; --%>
<%-- //  } --%>
<!-- </script> -->

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
