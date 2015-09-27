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
		<th>ExerciseNo</th>
		<th>Name</th>
		<th>CalHour</th>
<!-- 		<th>Picture</th> -->
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/ranking/exerciseCalingproduct.jsp" var="path">
			<c:param name="exerciseNo" value="${row.exerciseNo}" />
			<c:param name="name" value="${row.name}" />
			<c:param name="calHour" value="${row.calHour}" />
<%-- 			<c:param name="picture" value="${row.picture}" /> --%>
		</c:url>
	<tr>
		<td><a href="${path}">${row.exerciseNo}</a></td>
		<td>${row.name}</td>
		<td>${row.calHour}</td>
<%-- 		<td>${row.picture}</td> --%>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/ranking/exerciseCalingproduct.jsp" />">Product Table</a></h3>

</body>
</html>