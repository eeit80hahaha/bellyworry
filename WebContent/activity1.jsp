<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
    <meta charset="utf-8">
    <title>活動情報</title>
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
    <link href="scripts/icons/general/stylesheets/general_foundicons.css" media="screen" rel="stylesheet" type="text/css">  
    <link href="scripts/icons/social/stylesheets/social_foundicons.css" media="screen" rel="stylesheet" type="text/css">
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
<!--     <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css"> -->
    <link href="http://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet" type="text/css">
    <link href="styles/custom.css" rel="stylesheet" type="text/css">
   
   
    <style type="text/css" media="screen">
    /*Tooltip and Pointer CSS*/
    .ui-tooltip { position:absolute; z-index:9999; font-size:11pt; font-family:Calibri;  text-align:left }
    body .ui-tooltip { border-width:2px; }

    .ui-button { display: inline-block; position: relative; padding: 0; margin: 0; margin-right: .3em; text-decoration: none !important; cursor: pointer; text-align: center; zoom: 1; overflow: visible; }
    /*button text element */
    .ui-button .ui-button-text { display: block; line-height: 0.4;  }
    .ui-button-text-only .ui-button-text { padding: .3em .45em; }
    .limit { background: #F4CAD6; } 

/*     a:link,a:visited */
/*     { */
/* 		color:#03c; */
/* 		text-decoration: none */
/*     } */

    a:hover 
    {
		color:#339;
		text-decoration:underline;
    }

    .splitline 
    { 
       border-top:1px solid green;
    }
    tr.rowbackgroundcolor .datecell
    {
        #background-color: #cccccc;
		#background-color: #cccccc;
		border-left:2px solid #999999;
		border-right:2px solid #FFFFFF;
    }
    tr:not(.rowbackgroundcolor)     .datecell
    {
        #background-color: #cccccc;
		#background-color: #cccccc;
		border-left:2px solid #FFFFFF;
		border-right:2px solid #999999;
    }
    
    .rowbackgroundcolor-select
    {
        background-color: #FFE178;
    }
    .select
    {
        background-color: #FFE178;
    }
    .gridview
    {
        border-color: #999999;
        border-style: solid;
        border-width: 1px;
        border-collapse: collapse;
        border-left-style: none;
        border-top-style: none;
    }
    #monthtag
    {
	position:absolute;
	background-color:lightgreen;
	color:MidnightBlue;
	
	top:-8px;
	left:16px;
	border-top: solid 1px #ccc;
	border-left: solid 1px #ccc;
	border-right: solid 1px #666;
	border-bottom: solid 1px #666;
	
	font-size:11px;
	font-weight:bold;
	line-height:14px;
    
	border-radius:5px;
	-moz-border-radius:5px;
	-webkit-border-radius:5px;
	-webkit-text-size-adjust:none;
	width:32px;
	text-align:center;
    }
    
    .newcell
    {
        vertical-align:top;
        border-style:none;
        background-color:White;
        border-top-style:hidden;
        width:35px;
	position:relative;
    }

    .oldactivity
    {
	color:#888;	
    }
    .oldactivity A:link { color:#888;}
    .oldactivity A:visited { color:#888;}
    .oldactivity A:hover { color:#888;}
    .oldactivity A:active { color:#888;}
    


    ul#menubar
    {
        border:1px solid #5F5F5F;
        margin:0px;list-style:none;padding:2px;margin-bottom:10px;
        -moz-border-radius:5px;-webkit-border-radius:5px;border-radius:5px;
        -webkit-box-shadow: #666 0px 2px 3px;     /*陰影for Google Chrome、Safari*/
        -moz-box-shadow: #666 0px 2px 3px;     /*陰影for Firefox*/
        box-shadow: #666 0px 2px 3px;     /*陰影for IE*/
        background: #dedede;
        background-image: -webkit-gradient(linear, 0 0, 0 bottom, from(#FFFFFF), to(#dedede));    /*漸層色for Google Chrome、Safari*/
        background: -moz-linear-gradient(#FFFFFF, #dedede);     /*漸層色for Firefox*/ 
        display:block;float:left;
    }
    ul#menubar ul
    {
        text-align:right;
    }
    
    ul#menubar li.menubar
    {
	    height:30px;line-height:30px; width:240px;
	}
	ul#menubar li
	{
	    display:block;white-space:nowrap;float:left;border-style:none;
	}
	
    
</style>

<script>
  var date =new Date();
//这里的date 是你打开jsp页面的本地时间,和服务器时间是有区别的
</script>

<script>
    function select(obj) 
    {
        if (obj.className=="rowbackgroundcolor-select" || obj.className=="select") 
	{
        	if (obj.className=="rowbackgroundcolor-select")
            		obj.className="rowbackgroundcolor"
        	else
            		obj.className=""
    	} 
    	else
	{
		if (obj.className=="")
	        	obj.className="select"
		else
			obj.className="rowbackgroundcolor-select"
	}
    }
</script>
</head>
<body id="pageBody" style="zoom: 1;">
<c:set var="funcName" value="ACT" scope="session"/>
<jsp:include page="/page/header.jsp"/>

<div id="contentOuterSeparator"></div>
<div class="container">

    <div class="divPanel page-content">

        <div class="breadcrumbs">
                <a href="index.jsp">首頁</a> &nbsp;/&nbsp; <span>活動情報</span>
            </div> 
        <!--Edit Main Content Area here-->
        <div class="row-fluid">
			<div class="span8" id="divMain">

	            <h1>活動情報</h1>
				<form id="selename0" action="${pageContext.request.contextPath}/activity.controller" method="get" >
					<select name="name" id="selename1">
						<option value="">選擇地區</option>
						<option value="台北">台北</option>
						<option value="宜蘭">宜蘭</option>
						<option value="台中">台中</option>
						<option value="高雄">高雄</option>
						<option value="">全部</option>
					</select>
					<input type="hidden" name="pageNo" value="1" />					
				</form>
				<c:choose>
				<c:when test="${findBySname == null}">
					<div id="paging">
					<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
						<table border="0">
						 	<tr>
						    	<td width='76'>
								<c:if test="${PagesActivityVO.pageNo > 1}">
						           <div id="pfirst">
						              <a href="<c:url value='/activity.controller?pageNo=1' />">第一頁</a>&nbsp;&nbsp;&nbsp;
						           </div>
								</c:if>
						     	</td>
						     	<td width='76'>
								<c:if test="${PagesActivityVO.pageNo > 1}">
						           <div id="pprev">
						              <a href="<c:url value='/activity.controller?pageNo=${PagesActivityVO.pageNo-1}' />">上一頁</a>&nbsp;&nbsp;&nbsp;
						           </div>
								</c:if>  
						     	</td>
						     	<td width='76'>
								<c:if test="${PagesActivityVO.pageNo != PagesActivityVO.totalPages}">
									<div id="pnext">
										<a href="<c:url value='/activity.controller?pageNo=${PagesActivityVO.pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
									</div>
								</c:if>
						    	</td>  
						    	<td width='76'>
								<c:if test="${PagesActivityVO.pageNo != PagesActivityVO.totalPages}">
									<div id="plast">
									    <a href="<c:url value='/activity.controller?pageNo=${PagesActivityVO.totalPages}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
									</div>
								</c:if>
						    	</td>
						    	<td width='176' align="center">
						        	  第${PagesActivityVO.pageNo}頁 / 共${PagesActivityVO.totalPages}頁
						    	</td>  
							</tr>
						</table>
					</div>
				
					<div>
						<table class="gridview" cellspacing="0" cellpadding="4" align="Center" id="GridView1" style="color: Black; background-color: White; font-size: 12px; border-collapse: collapse;">
							<tbody>
								<tr style="color: White; background-color: Black; font-weight: bold;">
									<th scope="col">活動名稱</th>
									<th scope="col">&nbsp;</th>
									<th scope="col">活動日期</th>
									<th scope="col">活動地點</th>
									<th scope="col">&nbsp;</th>
									<th scope="col">&nbsp;</th>
									<th scope="col">主辦廠商</th>
									<th scope="col">活動狀態</th>
								</tr>
								<c:forEach var="activity" items="${PagesActivityVO.activitypage}">
									<tr class="splitline" align="left">
											<td style="width: 340px;"><a href="${pageContext.request.contextPath}/activity.controller2?no=${activity.no}" >${activity.name}</a></td>
											<td align="right" style="width: 5px;"></td>
											<td class="datecell" style="width: 104px;">${activity.endTime}</td>
											<td class="datecell" style="width: 104px;">${activity.address}</td>
											<td></td>
											<td></td>
											<td style="width: 200px;">${activity.boss}</td>
											<td align="center" style="width: 130px;">
												<c:choose>
													<c:when test="${getDateTime < activity.endTime1}">
																		<p>未結束</p>
													</c:when>
													<c:otherwise>
																		<p>已結束</p>
													</c:otherwise>
												</c:choose>
											</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</c:when>
				<c:when test="${findBySname != null}">
				<div>
				<table class="gridview" cellspacing="0" cellpadding="4" align="Center" id="GridView1" style="color: Black; background-color: White; font-size: 12px; border-collapse: collapse;">
					<tbody>
						<tr style="color: White; background-color: Black; font-weight: bold;">
							<th scope="col">活動名稱</th>
							<th scope="col">&nbsp;</th>
							<th scope="col">活動日期</th>
							<th scope="col">活動地點</th>
							<th scope="col">&nbsp;</th>
							<th scope="col">&nbsp;</th>
							<th scope="col">主辦廠商</th>
							<th scope="col">活動狀態</th>
						</tr>
				<c:forEach var="activity" items="${findBySname}">
					<tr class="splitline" align="left">
							<td style="width: 340px;"><a href="${pageContext.request.contextPath}/activity.controller2?no=${activity.no}" >${activity.name}</a></td>
							<td align="right" style="width: 5px;"></td>
							<td class="datecell" style="width: 104px;">${activity.endTime}</td>
							<td class="datecell" style="width: 104px;">${activity.address}</td>
							<td></td>
							<td></td>
							<td style="width: 200px;">${activity.boss}</td>
							<td align="center" style="width: 130px;">
								<c:choose>
									<c:when test="${getDateTime < activity.endTime1}">
										<p>未結束</p>
									</c:when>
									<c:otherwise>
										<p>已結束</p>
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
				</c:forEach>
					</tbody>
				</table>
				</div>
				</c:when>
				</c:choose>


                </div>
				<!--Edit Sidebar Content Area here-->
                <div class="span4 sidebar">
<%-- ${findBySname[0].getPicture1 } --%>
                    <div class="sidebox">
                        <h3 class="sidebox-title">運動的好處</h3>
						<p>運動的好處 消耗身體過多的熱量，幫助減肥或維持適當體重 增強心肺功能，促進血液循環 減低患上心臟病、高血壓及糖尿病等慢性疾病的機會 增強身體抵抗力</p>
						<hr>
        <div class="row-fluid">		
		        <div class="span4">   
		        	<img src="data:image/jpg;base64,${selectallvo[8].picture1}" class="img-polaroid" style="margin:5px 0px 15px;width:100%; height:90px;" alt=""/>                        
                </div>          
                <div class="span8">            
                    <p>${selectallvo[8].content}
                    <a href="${pageContext.request.contextPath}/activity.controller2?no=${selectallvo[8].no}" >...詳細閱讀</a> 
                    </p>
                </div>		 
        </div>

        <div class="row-fluid">		
		        <div class="span4"> 		                                
                    <img src="data:image/jpg;base64,${selectallvo[4].picture1}"  class="img-polaroid" style="margin:5px 0px 15px;width:100%; height:90px;" alt=""/>
                </div>                                                     
        		<div class="span8">            
                    <p>${selectallvo[4].content}
                    <a href="${pageContext.request.contextPath}/activity.controller2?no=${selectallvo[4].no}"  >...詳細閱讀</a> 
                    </p>
                </div>	
        </div>
        
                <div class="row-fluid">		
		        <div class="span4"> 		                                
                    <img src="data:image/jpg;base64,${selectallvo[7].picture1}"  class="img-polaroid" style="margin:5px 0px 15px;width:100%; height:90px;" alt=""/>
                </div>                                                     
        		<div class="span8">            
                    <p>${selectallvo[7].content}
                    <a href="${pageContext.request.contextPath}/activity.controller2?no=${selectallvo[7].no}" >...詳細閱讀</a> 
                    </p>
                </div>	
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
<script src="scripts/ga.js" type="text/javascript"></script>



<script>
    $(function() {
        $("button").button().click(function( event ) {
                event.preventDefault();
            });
	$("button").tooltip({      track: true    });
    });
//     下拉選單觸發
    $('#selename1').change(function(){
    	$('#selename0').submit();
    	
    })
</script>



</body></html>
