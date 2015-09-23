<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<tr>
		日期：	<td>${list.date}</td><br>
		 身高：<td>${list.height}</td><br>
		  體重：<td>${list.weight}</td><br>
		   腰圍：<td>${list.waistline}</td><br>
		 BMI：<td>${list.weight/((list.height/100)*(list.height/100))}</td><br>
		  建議：
		<!-- BMI -->
		<c:choose>
			<c:when
				test="${(list.weight/((list.height/100)*(list.height/100)) < 18.5 ) }">
				<td>體重過輕</td>
			</c:when>
			<c:when
				test="${ ( list.weight/((list.height/100)*(list.height/100)) < 24 ) }">
				<td>標準體重</td>
			</c:when>
			<c:when
				test="${(list.weight/((list.height/100)*(list.height/100)) < 27 ) }">
				<td>過重</td>
			</c:when>
			<c:when
				test="${(list.weight/((list.height/100)*(list.height/100)) < 30 ) }">
				<td>輕度肥胖</td>
			</c:when>
			<c:when
				test="${(list.weight/((list.height/100)*(list.height/100)) < 35 ) }">
				<td>中度肥胖</td>
			</c:when>
			<c:when
				test="${(list.weight/((list.height/100)*(list.height/100)) >= 35 ) }">
				<td>重度肥胖</td>
			</c:when>
		</c:choose><br>


		標題：	<td>${list.title}</td><br> 
		內容：	<td>${list.content}</td><br> 
		運動：<td>${list.exerVo.exerciseCalVO.name}</td><br>
		份量：<br>
		 運動消耗熱量：<br>
		 
		 
		  時段：<br> 
		  菜色： <br>
		  份量：<br>
		   飲食熱量：<br>


		<td>${list.exerVo[0].date}</td>
		<td><c:forEach var="exer" items="${list.exerVo}">${exer.exerciseCalVO.name}</c:forEach></td>
		<td><c:forEach var="exer" items="${list.exerVo}">${exer.exerciseCalVO.calHour}</c:forEach></td>
		<td><c:forEach var="exer" items="${list.exerVo}">${exer.count}</c:forEach></td>





		<td>${list.eatVo[0].date}</td>
		<td><c:forEach var="eat" items="${list.eatVo}">${eat.time }<br>
			</c:forEach></td>
		<td><c:forEach var="eat" items="${list.eatVo}">${eat.foodCalVO.name}<br>
			</c:forEach></td>
		<td><c:forEach var="eat" items="${list.eatVo}">${eat.foodCalVO.cal}<br>
			</c:forEach></td>
		<td><c:forEach var="eat" items="${list.eatVo}">${eat.foodCalVO.count}<br>
			</c:forEach></td>
		<td><c:forEach var="eat" items="${list.eatVo}">${eat.foodCalVO.weight}<br>
			</c:forEach></td>
		<td><c:forEach var="eat" items="${list.eatVo}"> ${eat.count}<br>
			</c:forEach></td>
		<td><c:forEach var="eat" items="${list.eatVo}"> ${eat.count*eat.foodCalVO.cal}<br>
			</c:forEach></td>
	</tr>















</body>
</html>