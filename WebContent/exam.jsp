<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>小學堂</title>
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
<!--     <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css"> -->
    <link href="http://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet" type="text/css">
    <link href="styles/custom.css" rel="stylesheet" type="text/css" />


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
</head>
<body id="pageBody" style="zoom: 1;">
<c:set var="funcName" value="EXAM" scope="session"/>
<jsp:include page="/page/header.jsp"/>

<div id="contentOuterSeparator"></div>
<div class="container">


	<div class="divPanel page-content">

        <div class="breadcrumbs">
                <a href="index.jsp">首頁</a> &nbsp;/&nbsp; <span>小學堂</span>                
        </div> 
        <!--Edit Main Content Area here-->
        <div class="row-fluid">
                <div class="span8" id="divMain">
               <h1>小學堂</h1>
<%
	int[] numbers = new int[5];
	for (int i = 1; i < 5; i++) {
		numbers[i] = i;
	}

	for (int j = 0; j < 10; j++) {
		int m = (int) (Math.random() * 4 + 1);
		int n = (int) (Math.random() * 4 + 1);
		int p = numbers[m];
		numbers[m] = numbers[n];
		numbers[n] = p;
	}

	for (int k = 1; k <= 4; k++) {
// 		System.out.print(numbers[k] + "\t");
	}
%>

<table>

${PageExamVO.exampage[0].content}

<form action="${pageContext.request.contextPath}/examsession.controller" method="get">
	<div class="question-body clearfix notranslate ">
		<c:if test="<%=numbers[1] ==1%>">
			<div class="answer-option-cell">		
				<div class="radio-button-container">
					<input  name="ans" type="radio" class="radio-button-input" value="10"> 
						<label class="answer-label radio-button-label no-touch touch-sensitive clearfix" for="644496188_7455644669"> 
							<span class="radio-button-display"></span> 
							<span class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].correct}<br/></span>
						</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[1]==2%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio" class="radio-button-input" value="0"> 
						<label class="answer-label radio-button-label no-touch touch-sensitive clearfix checked" for="644496188_7455644670"> 
							<span class="radio-button-display"></span> 
							<span class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optA}<br/></span>
						</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[1]==3%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644671"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optB}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		
		<c:if test="<%=numbers[1]==4%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644672"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optC}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[2] ==1%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="10"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644669"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].correct}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[2]==2%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix checked"
						for="644496188_7455644670"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optA}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[2]==3%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644671"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optB}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[2]==4%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644672"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optC}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[3] ==1%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="10"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644669"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].correct}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[3]==2%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix checked"
						for="644496188_7455644670"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optA}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[3]==3%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644671"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optB}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[3]==4%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644672"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optC}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[4] ==1%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="10"> 
						<label
							class="answer-label radio-button-label no-touch touch-sensitive clearfix"for="644496188_7455644669"> 
							<span class="radio-button-display"></span> 
							<span class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].correct}<br/>
							</span>
					    </label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[4]==2%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix checked"
						for="644496188_7455644670"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optA}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[4]==3%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644671"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optB}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>
		<c:if test="<%=numbers[4]==4%>">
			<div class="answer-option-cell">
				<div class="radio-button-container">
					<input  name="ans" type="radio"
						class="radio-button-input" value="0"> <label
						class="answer-label radio-button-label no-touch touch-sensitive clearfix"
						for="644496188_7455644672"> <span
						class="radio-button-display"></span> <span
						class="radio-button-label-text question-body-font-theme user-generated">${PageExamVO.exampage[0].optC}<br/>
					</span>
					</label>
				</div>
			</div>
		</c:if>

		</div>		
<input type="submit" value="確認送出">
</form>
</table>

<div id="paging">
<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
<table border="0">
  <tr>
    <td width='76'>
        <c:if test="${PageExamVO.pageNo > 1}">
           <div id="pfirst">
              <a href="<c:url value='/exam.controller?pageNo=1' />">第一題</a>&nbsp;&nbsp;&nbsp;
           </div>
        </c:if>
     </td>
     <td width='76'>
        <c:if test="${PageExamVO.pageNo > 1}">
           <div id="pprev">
              <a href="<c:url value='/exam.controller?pageNo=${PageExamVO.pageNo-1}' />">上一題</a>&nbsp;&nbsp;&nbsp;
           </div>
        </c:if>  
     </td>
     <td width='76'>
            <c:if test="${PageExamVO.pageNo != PageExamVO.totalPages}">
                <div id="pnext">
                   <a href="<c:url value='/exam.controller?pageNo=${PageExamVO.pageNo+1}' />">下一題</a>&nbsp;&nbsp;&nbsp;
                </div>
            </c:if>
     </td>  
     <td width='76'>
            <c:if test="${PageExamVO.pageNo != PageExamVO.totalPages}">
                <div id="plast">
                    <a href="<c:url value='/exam.controller?pageNo=${PageExamVO.totalPages}' />">最末題</a>&nbsp;&nbsp;&nbsp;
                </div>
            </c:if>
     </td>
     <td width='176' align="center">
           第${PageExamVO.pageNo}題 / 共${PageExamVO.totalPages}題
     </td>  
</tr>
</table>
</div>

				


	
			
                    
		</div>
		<div class="span2"></div>
				<!--End Sidebar Area here-->
	</div>
			<!--End Main Content Area here-->
</div>
        <div id="footerInnerSeparator"></div>
</div>
<div id="footerOuterSeparator"></div>
<jsp:include page="/page/footer.jsp"/>

<script src="scripts/jquery.min.js" type="text/javascript"></script>
<script src="scripts/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="scripts/default.js" type="text/javascript"></script>
</body>
</html>
