<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
    <style>
		#map {
			height: 700px;
		}

		#info {
			display: none;			
	    }
	    
/* 	    #Sidebar{ */
/* 			　width:120px; */
/* 			　float:left; */
/* 			　height:280px; */
/* 			　text-align:center; */
/* 			　line-height:280px; */
/* 			　font-size:15px; */
/* 			　color:#ffffff; */
/* 			　font-weight:bold; */
/* 			　background-color:#cecece; */
/* 		} */
/* 		#body{ */
/* 		　width:240px; */
/* 		　height:280px; */
/* 		　text-align:center; */
/* 		　line-height:280px; */
/* 		　font-size:15px; */
/* 		　color:#f9c81e; */
/* 		　font-weight:bold; */
/* 		　background-color:#fffaf3; */
/* 		　float:left; */
/* 		} */
#panel {
  position: absolute;
  top: 10px;
  left: 25%;
  z-index: 5;
  background-color: #fff;
  padding: 5px;
  border: 1px solid #999;
  text-align: center;
}

#panel, .panel {
  font-family: 'Roboto','sans-serif';
  line-height: 30px;
  padding-left: 10px;
}

#panel select, #panel input, .panel select, .panel input {
  font-size: 15px;
}

#panel select, .panel select {
  width: 100%;
}

#panel i, .panel i {
  font-size: 12px;
}

      .panel {
        height: 100%;
		overflow: auto;
      }


		
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker({
      showWeek: true,
      firstDay: 1
    });
  });
</script>
<title>cookCal</title>
<style>
 .test {
        width:90%; 
		border:#000 solid 1px;
     } 
 .tt {  
 		text-align:left
 		;
 } 
/*  .for1 {  */
/*  		position:relative; top:20px; left:20px; */
/*  		; */
/*  }	 */
</style>
</head>
<body id="pageBody">

<jsp:include page="/page/header.jsp"/>

<div id="contentOuterSeparator"></div>

<div class="container">

	<div class="divPanel page-content">

		<div class="breadcrumbs">

		</div> 
        <!--Edit Main Content Area here-->
        <div class="row-fluid">
			<div class="span8" id="divMain">

			<!-- suuk所使用樣板 -->				


<div id="A" style="display: inline;">
<!-- 				<div  id="Sidebar" > -->
		<table border=1 width=23% id="table1">
		

		
		<c:forEach var="vo" items="${PagesFoodCalVO1.foodCalpage}" varStatus="varStatus">
			<tr>
				<td>
				<h4>${vo.name}</h4>
				<img class="test" src="data:image/jpg;base64,${vo.picture1}"/>
		<%-- 			<form action="<c:url value='FoodCalSessionServlect' />" method="GET"> --%>
					<form action="${pageContext.request.contextPath}/foodCalSessionServlect" method="GET">
						<select name="time">													<!--time-->
							<option value="早上">早餐 </option>
							<option value="午餐">中餐 </option>
							<option value="晚餐">晚餐 </option>	
						</select>
<%-- 						<input type="text" name="count" value="" />${errors.count}<P/>										<!--count--> --%>
						<input type="text" name="count" value="" /><P/>										<!--count-->
		
						<Input type='hidden' name='foodNo' value='${vo.foodNo}'><P/>			<!--foodNo-->
						<Input type='hidden' name='name' value='${vo.name}'><P/>				<!--name-->
						<Input type='hidden' name='cal' value='${vo.cal}'><P/>					<!--cal-->
						
						<Input type='hidden' name='page' value='${PagesFoodCalVO1.pageNo}'><P/>	<!--page-->
						
						<Input type='submit' name="prodaction" value='加入'>
						<Input type='submit' name="prodaction" value='清除'>
					</form>
				<div class="tt">熱量:<span>${vo.cal}</span> 每份公克數<span>${vo.weight}</span></div>
				</td>
			</tr>
		<%-- 		<p>菜色編號${vo.foodNo}</p> --%>
		<%-- 		<p>菜色${vo.name}</p> --%>
		<%-- 		<p>一般份量${vo.count}</p> --%>
		<%-- 		<p>菜色分類${vo.menuNo}</p> --%>
		<%-- 		<p>熱量:${vo.cal}</p> --%>
		<%-- 		<p>每份公克數${vo.weight}</p> --%>
		<%-- 		<p>食譜編號${vo.cookNo}</p> --%>
		</c:forEach>
		</table>
<!-- 		</div> -->
		<div id="paging">
		<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
		<table border="0">
		  <tr>
		    <td width='76'>
		        <c:if test="${PagesFoodCalVO1.pageNo > 1}">
		           <div id="pfirst">
		              <a href="<c:url value='/foodCal.controller?pageNo=1' />">第一頁</a>&nbsp;&nbsp;&nbsp;
		           </div>
		        </c:if>
		     </td>
		     <td width='76'>
		        <c:if test="${PagesFoodCalVO1.pageNo > 1}">
		           <div id="pprev">
		              <a href="<c:url value='/foodCal.controller?pageNo=${PagesFoodCalVO1.pageNo-1}' />">上一頁</a>&nbsp;&nbsp;&nbsp;
		           </div>
		        </c:if>  
		     </td>
		     <td width='76'>
		            <c:if test="${PagesFoodCalVO1.pageNo != PagesFoodCalVO1.totalPages}">
		                <div id="pnext">
		                   <a href="<c:url value='/foodCal.controller?pageNo=${PagesFoodCalVO1.pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
		                </div>
		            </c:if>
		     </td>  
		     <td width='76'>
		            <c:if test="${PagesFoodCalVO1.pageNo != PagesFoodCalVO1.totalPages}">
		                <div id="plast">
		                    <a href="<c:url value='/foodCal.controller?pageNo=${PagesFoodCalVO1.totalPages}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
		                </div>
		            </c:if>
		     </td>
		     <td width='176' align="center">
		           第${PagesFoodCalVO1.pageNo}頁 / 共${PagesFoodCalVO1.totalPages}頁
		     </td>
		       
</tr>
</table>
</div>
</div>
<div id="b" style="display: inline;">
<div id="Body">
		早餐紀錄<br/>
		<c:forEach var="eatb" items="${eatBreakfast}">
			${eatb}<br/>
		</c:forEach>
		午餐紀錄<br/>
		<c:forEach var="eatl" items="${eatLunch}">
			${eatl}<br/>
		</c:forEach>
		晚餐紀錄<br/>
		<c:forEach var="eatd" items="${eatDinner}">
			${eatd}<br/>
		</c:forEach>		
		<hr/>
		錯誤訊息:
		${errors.count}
		${errors.eatr}
		<hr/>			
<c:if test="${login == 600 }">
<!-- 	<input type="button" value="text"> -->
		<a href="${pageContext.request.contextPath}/FoodCalServletSave">保存測試</a>
</c:if>		
</div>
</div>
	
			</div>
                    
		</div>
				<!--End Sidebar Area here-->
	</div>
			<!--End Main Content Area here-->

        <div id="footerInnerSeparator"></div>
</div>
<div id="footerOuterSeparator"></div>
<jsp:include page="/page/footer.jsp"/>

<script src="scripts/jquery.min.js" type="text/javascript"></script>
<script src="scripts/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="scripts/default.js" type="text/javascript"></script>
</body>
</html>