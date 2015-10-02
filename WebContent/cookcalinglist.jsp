<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>熱量計算</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="scripts/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Icons -->
    <link href="scripts/icons/general/stylesheets/general_foundicons.css" media="screen" rel="stylesheet" type="text/css" />  
    <link href="scripts/icons/social/stylesheets/social_foundicons.css" media="screen" rel="stylesheet" type="text/css" />
    <!--[if lt IE 8]>
        <link href="scripts/icons/general/stylesheets/general_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="scripts/icons/social/stylesheets/social_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
    <![endif]-->
    <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome.min.css">
    <!--[if IE 7]>
        <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome-ie7.min.css">
    <![endif]-->


    <link href="http://fonts.googleapis.com/css?family=Allura" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Aldrich" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet" type="text/css">

    <link href="styles/custom.css" rel="stylesheet" type="text/css" />
</head>
<body id="pageBody">
<c:set var="funcName" value="CAL" scope="session"/>
<jsp:include page="/page/header.jsp"/>

<div id="contentOuterSeparator"></div>

<div class="container">

    <div class="divPanel page-content">

        <div class="breadcrumbs">
                <a href="index.jsp">首頁</a> &nbsp;/&nbsp; <span>熱量計算</span>
            </div> 
        <!--Edit Main Content Area here-->
        <div class="row-fluid">
                <div class="span8" id="divMain">

                    <h1>熱量計算<span><fmt:formatDate value="${healthDate}" type="date" /></span></h1>
					<p>
                    <c:forEach var="vo" items="${PagesFoodCalVO1.foodCalpage}" varStatus="varStatus">
                    <div class="well">
                    	<div class="row-fluid">		
					        <div class="span4">                           
			                    <img src="data:image/jpg;base64,${vo.picture1}" class="img-polaroid" style="margin:5px 0px 15px;" alt=""/>
			                </div>          
			                <div class="span8">            
			                    <h4>${vo.name}</h4>
			                    <div class="tt">熱量:<span>${vo.cal}</span> 每份公克數<span>${vo.weight}</span></div>
			                    <form action="${pageContext.request.contextPath}/foodCalSessionServlect" method="GET">
			                    <select name="time">													<!--time-->
									<option value="早上">早上 </option>
									<option value="中午">中午</option>
									<option value="晚上">晚上 </option>	
								</select>
								<input type="text" name="count" value="" placeholder="食用份數" />				<!--count-->
		
								<Input type='hidden' name='foodNo' value='${vo.foodNo}'>			<!--foodNo-->
								<Input type='hidden' name='name' value='${vo.name}'>				<!--name-->
								<Input type='hidden' name='cal' value='${vo.cal}'>				<!--cal-->
								<Input type='hidden' name='weight' value='${vo.weight}'>				<!--cal-->
								
								<Input type='hidden' name='page' value='${PagesFoodCalVO1.pageNo}'>	<!--page-->
								
								<Input type='submit' name="prodaction" value='加入'>
								<Input type='submit' name="prodaction" value='清除'>
								</form>
								
			            	</div>		 
        				</div>
					</div>
					</c:forEach>
                    <div id="paging" class="row-fluid">
						<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
						<div id="pfirst" class="span2" align="center">
							<c:if test="${PagesFoodCalVO1.pageNo > 1}">
						    	<a href="<c:url value='/foodCal.controller?pageNo=1' />">第一頁</a>&nbsp;&nbsp;&nbsp;
						    </c:if>
						</div>
						<div id="pprev" class="span2" align="center">    
						    <c:if test="${PagesFoodCalVO1.pageNo > 1}">
						        <a href="<c:url value='/foodCal.controller?pageNo=${PagesFoodCalVO1.pageNo-1}' />">上一頁</a>&nbsp;&nbsp;&nbsp;
					        </c:if>
					    </div>
						<div class="span4" align="center">第${PagesFoodCalVO1.pageNo}頁 / 共${PagesFoodCalVO1.totalPages}頁</div>
						<div id="pnext" class="span2" align="center">
					        <c:if test="${PagesFoodCalVO1.pageNo != PagesFoodCalVO1.totalPages}">
						        <a href="<c:url value='/foodCal.controller?pageNo=${PagesFoodCalVO1.pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
					        </c:if>
					    </div>
					    <div id="plast" class="span2" align="center">
					       	<c:if test="${PagesFoodCalVO1.pageNo != PagesFoodCalVO1.totalPages}">
					            <a href="<c:url value='/foodCal.controller?pageNo=${PagesFoodCalVO1.totalPages}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
					        </c:if>
						</div>
					</div>




                </div>
				<!--Edit Sidebar Content Area here-->
                <div class="span4 sidebar">

                    <div>
                        <h3 class="sidebox-title">飲食清單</h3>
						<hr>
<!-- 						<li><i class="icon-food"></i> icon-food</li> -->
				        <div class="row-fluid">
				        	<div class="alert alert-block">                          
					                <h4>早上紀錄</h4>
					                <ul class="the-icons" style="list-style-type:none">
						                <c:forEach var="eatb" items="${eatBreakfast}">
						                <li style="line-height: 25px;"><i class="icon-food"></i> ${eatb.foodCalVO.name}   份量：${eatb.count}  
						                			熱量：${eatb.foodCalVO.cal * eatb.count * (eatb.foodCalVO.weight/100)} (大卡)</li>
										</c:forEach>
									</ul>           
					        </div>
					    </div>
					    <div class="row-fluid">
				        	<div class="alert alert-block">                          
					                <h4>中午紀錄</h4>
					                <ul class="the-icons" style="list-style-type:none">
						                <c:forEach var="eatl" items="${eatLunch}">
						                <li style="line-height: 25px;"><i class="icon-food"></i> ${eatl.foodCalVO.name}   份量：${eatl.count}  
						                			熱量：${eatl.foodCalVO.cal * eatl.count * (eatl.foodCalVO.weight/100)} (大卡)</li>
										</c:forEach>
									</ul>            
					        </div>
					    </div>
					    <div class="row-fluid">
				        	<div class="alert alert-block">                          
					                <h4>晚上紀錄</h4>
					                <ul class="the-icons" style="list-style-type:none">
						                <c:forEach var="eatd" items="${eatDinner}">
						                <li style="line-height: 25px;"><i class="icon-food"></i> ${eatd.foodCalVO.name}   份量：${eatd.count}  
						                			熱量：${eatd.foodCalVO.cal * eatd.count * (eatd.foodCalVO.weight/100)} (大卡)</li>
										</c:forEach>
									</ul>           
					        </div>
					    </div>
				        <div class="row-fluid">		
						        錯誤訊息:
						<h1 style="color:#FF0000">${errors.count}</h1>
						<h1 style="color:#FF0000">${errors.eatr}</h1>		 
				        </div>
				        <c:if test="${login == 600 }">
						<!-- 	<input type="button" value="text"> -->
								<a class="btn btn-warning" href="${pageContext.request.contextPath}/FoodCalServletSave">保存資料</a>
						</c:if>	
					</div>
                    
                </div>
				<!--End Sidebar Area here-->
            </div>
			<!--End Main Content Area here-->

        <div id="footerInnerSeparator"></div>
    </div>

</div>

<div id="footerOuterSeparator"></div>

<jsp:include page="/page/footer.jsp"/>

<script src="scripts/jquery.min.js" type="text/javascript"></script> 
<script src="scripts/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="scripts/default.js" type="text/javascript"></script>





</body>
</html>
