<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>herodiary</title>
</head>
<body>

<h1>${herovo.membervo.nickname} ${healthdiary.date} 健康紀錄</h1>
<p>會員帳號：${herovo.membervo.id}</p>
<p><a href="#">日誌檢舉</a></p>

<%-- ${healthdiary} --%>
<!-- <hr/> -->

<fmt:formatNumber type="number" 
value="${healthdiary.weight / ((healthdiary.height / 100 )* (healthdiary.height / 100 ))}" 
maxFractionDigits="2" var="bmi" />

<h1>健康日誌</h1>
<table>
	<tr>
		<td colspan="4">標題：${healthdiary.title}</td>
	</tr>
	<tr>
		<td>身高：${healthdiary.height}</td>
		<td>體重：${healthdiary.weight}</td>
		<td>腰圍：${healthdiary.waistline}</td>
		<td>BMI：${bmi}</td>
	</tr>
	<tr><td colspan="4">日誌：${healthdiary.content}</td></tr>
</table>

<c:if test="${healthdiary.eatVo != '[]'}">
<h1>飲食紀錄</h1>
<%-- ${healthdiary.eatVo} --%>
<!-- <hr/> -->
<table>
	<tr>
		<th>時段</th>
		<th>名稱</th>
		<th>熱量(Cal/100g)</th>
		<th>每份公克數</th>
		<th>攝取份量</th>
	</tr>	
	<c:forEach var="eatVo" items="${healthdiary.eatVo}">
		<tr>
			<td>${eatVo.time}</td>
			<td>${eatVo.foodCalVO.name}</td>
			<td>${eatVo.foodCalVO.cal}</td>
			<td>${eatVo.foodCalVO.weight}</td>
			<td>${eatVo.count}</td>
		</tr>
	</c:forEach>
</table>
</c:if>

<c:if test="${healthdiary.exerVo != '[]'}">
<h1>運動紀錄</h1>
<%-- ${healthdiary.exerVo} --%>
<!-- <hr/> -->
<table>
	<tr>
		<th>名稱</th>
		<th>每小時消耗熱量</th>
		<th>運動份量</th>
	</tr>
	<c:forEach var="exerVo" items="${healthdiary.exerVo}">
		<tr>
			<td>${exerVo.exerciseCalVO.name}</td>
			<td>${exerVo.exerciseCalVO.calHour}</td>
			<td>${exerVo.count}</td>
		</tr>
	</c:forEach>
</table>
</c:if>

</body>
</html>