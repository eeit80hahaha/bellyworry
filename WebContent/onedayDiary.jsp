<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<tr>
		日期：
		<td>${list.date}</td>
		<br> 身高：
		<td>${list.height}</td>
		<br> 體重：
		<td>${list.weight}</td>
		<br> 腰圍：
		<td>${list.waistline}</td>
		<br> BMI：
		<td><fmt:formatNumber type="number" maxIntegerDigits="2" value="${list.weight/((list.height/100)*(list.height/100))}" /></td>
		<br> 建議：
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
		</c:choose>
		<br> 標題：
		<td>${list.title}</td>
		<br> 內容：
		<td>${list.content}</td>
		<br>

		<div style="width: 199.7px; height: 100%;">
			運動<br>
			<c:forEach var="exer" items="${list.exerVo}">
							${exer.exerciseCalVO.name}
							${exer.exerciseCalVO.calHour}
							${exer.count}<br>
			</c:forEach>
			<hr>
		</div>
		</div>
		<div>飲食總熱量 ${eat.count*eat.foodCalVO.cal}</div>
		<div>運動總熱量</div>
		<hr>


		<div style="width: 199.7px; height: 100%;">
			早上<br>
			<c:forEach var="eat" items="${list.eatVo}">
				<!-- eat_record因為很多筆相同時段.菜色,所以用foreach -->
				<c:if test="${eat.time == '早上' }">
											
											${eat.foodCalVO.name}
											${eat.foodCalVO.cal}
											${eat.foodCalVO.count}
											${eat.foodCalVO.weight}
											${eat.count}<br>
				</c:if>
			</c:forEach>
			<hr>
		</div>



		<div style="width: 199.7px; height: 100%;">
			中午<br>
			<c:forEach var="eat" items="${list.eatVo}">
				<c:if test="${eat.time =='中午'}">
 							${eat.foodCalVO.name}
 							${eat.foodCalVO.cal}
 							${eat.foodCalVO.count}
 							${eat.foodCalVO.weight}
 							${eat.count}<br>
				</c:if>
			</c:forEach>
			<hr>
		</div>


		<div style="width: 199.7px; height: 100%;">
			晚上<br>
			<c:forEach var="eat" items="${list.eatVo}">
				<c:if test="${eat.time=='晚上'}">
 							${eat.foodCalVO.name}
 							${eat.foodCalVO.cal}
 							${eat.foodCalVO.count}
 							${eat.foodCalVO.weight}
 							${eat.count}<br>
				</c:if>
			</c:forEach>
			<hr>
		</div>
		<c:url value="diaryIndex.controller" var="path">
			<c:param name="no" value="${list.no}"></c:param>
		</c:url>
		<div><button name="back" style="float: left"><a href="diaryIndex.controller">BACK</a></button></div>
		<div><button name="edit"><a href="${path}">編輯</a></button></div>
		
		
</body>
</html>