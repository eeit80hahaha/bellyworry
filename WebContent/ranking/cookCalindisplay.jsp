<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />

<title>Display</title>
</head>
<body>

<h3>Select Product Table Result : ${fn:length(select)} row(s) selected</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>FoodNo</th>
		<th>Name</th>
		<th>MenuNo</th>
		<th>Cal</th>
		<th>Count</th>
		<th>Weight</th>
		<th>CookNo</th>
<!-- 		<th>Picture</th> -->
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/ranking/cookCalingproduct.jsp" var="path">
			<c:param name="foodNo" value="${row.foodNo}" />
			<c:param name="name" value="${row.name}" />
			<c:param name="menuNo" value="${row.menuNo}" />
			<c:param name="cal" value="${row.cal}" />
			<c:param name="count" value="${row.count}" />
			<c:param name="weight" value="${row.weight}" />
			<c:param name="cookNo" value="${row.cookNo}" />
<%-- 			<c:param name="picture" value="${row.picture}" /> --%>
		</c:url>
	<tr>
		<td><a href="${path}">${row.foodNo}</a></td>
		<td>${row.name}</td>
		<td>${row.menuNo}</td>
		<td>${row.cal}</td>
		<td>${row.count}</td>
		<td>${row.weight}</td>
		<td>${row.cookNo}</td>
<%-- 		<td>${row.picture}</td> --%>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/ranking/cookCalingproduct.jsp" />">Product Table</a></h3>

</body>
</html>