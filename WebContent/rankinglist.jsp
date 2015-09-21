<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>rankinglist</title>
</head>
<body>
<h1>${herovo.membervo.nickname} ${year}年${month}月  健康紀錄</h1>
會員帳號：${herovo.membervo.id}<br/>

<%-- ${herohealthdiaryvo} --%>
<!-- <hr/> -->
<%-- ${herohealthdiaryvo.herohealdiarypage} --%>
<!-- <hr/> -->

<!-- <table> -->
<!-- 	<tr> -->
<%-- 		<td>標題：${herohealthdiaryvo.herohealdiarypage[0].title}</td> --%>
<%-- 		<td>時間：${herohealthdiaryvo.herohealdiarypage[0].date}</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<%-- 		<td>體重：${herohealthdiaryvo.herohealdiarypage[0].weight}</td> --%>
<%-- 		<td>BMI：${herohealthdiaryvo.herohealdiarypage[0].weight / ((healthdiarylist[0].height / 100 )* (healthdiarylist[0].height / 100 ))}</td> --%>
<%-- 		<td>腰圍：${herohealthdiaryvo.herohealdiarypage[0].waistline}</td> --%>
<!-- 	</tr> -->
<!-- 	<tr> -->
<%-- 		<td>飲食攝取總熱量：${herohealthdiaryvo.herohealdiarypage[0].eatcalcount}</td> --%>
<%-- 		<td>運動攝取總熱量：${herohealthdiaryvo.herohealdiarypage[0].exercalcount}</td> --%>
<!-- 		<td>詳情</td> -->
<!-- 	</tr> -->
<!-- </table> -->
<!-- <hr/> -->
<!-- <hr/> -->

<c:forEach var="healthdiary" items="${herohealthdiaryvo.herohealdiarypage}">

<fmt:formatNumber type="number" 
value="${healthdiary.weight / ((healthdiary.height / 100 )* (healthdiary.height / 100 ))}" 
maxFractionDigits="2" var="bmi" />

<table>
		<tr>
			<td>標題：${healthdiary.title}</td>
			<td></td>
			<td>時間：${healthdiary.date}</td>
		</tr>
		<tr>
			<td>體重：${healthdiary.weight}</td>
			<td>BMI：${bmi}</td>
			<td>腰圍：${healthdiary.waistline}</td>
		</tr>
		<tr>
			<td>飲食攝取總熱量：${healthdiary.eatcalcount}</td>
			<td>運動攝取總熱量：${healthdiary.exercalcount}</td>
			<td>
				<a href="${pageContext.request.contextPath}/herodiary.controller?memberno=${healthdiary.memberNo}&date=${healthdiary.date}">詳情</a>
			</td>
		</tr>
</table>					
</c:forEach>

<div id="paging">
<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
<table border="0">
  <tr>
    <td width='76'>
        <c:if test="${herohealthdiaryvo.pageNo > 1}">
           <div id="pfirst">
              <a href="<c:url value='/herolist.controller?memberNo=${memberNo}&pageNo=1' />">第一頁</a>&nbsp;&nbsp;&nbsp;
           </div>
        </c:if>
     </td>
     <td width='76'>
        <c:if test="${herohealthdiaryvo.pageNo > 1}">
           <div id="pprev">
              <a href="<c:url value='/herolist.controller?memberNo=${memberNo}&pageNo=${herohealthdiaryvo.pageNo-1}' />">上一頁</a>&nbsp;&nbsp;&nbsp;
           </div>
        </c:if>  
     </td>
     <td width='76'>
            <c:if test="${herohealthdiaryvo.pageNo != herohealthdiaryvo.totalPages}">
                <div id="pnext">
                   <a href="<c:url value='/herolist.controller?memberNo=${memberNo}&pageNo=${herohealthdiaryvo.pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
                </div>
            </c:if>
     </td>  
     <td width='76'>
            <c:if test="${herohealthdiaryvo.pageNo != herohealthdiaryvo.totalPages}">
                <div id="plast">
                    <a href="<c:url value='/herolist.controller?memberNo=${memberNo}&pageNo=${herohealthdiaryvo.totalPages}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
                </div>
            </c:if>
     </td>
     <td width='176' align="center">
           第${herohealthdiaryvo.pageNo}頁 / 共${herohealthdiaryvo.totalPages}頁
     </td>  
</tr>
</table>
</div>

</body>
</html>