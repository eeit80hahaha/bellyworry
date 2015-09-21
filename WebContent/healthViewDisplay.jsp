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

<h3>搜尋結果 : ${fn:length(select)} 列資料被搜尋</h3>
<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>No</th>
		<th>Name</th>
		<th>ViewClassNo</th>
		<th>Lat</th>
		<th>Lng</th>
	</tr>
	</thead>
	<tbody>
	
	<c:forEach var="row" items="${select}">
		<c:url value="/healthViewCRUD.jsp" var="path">
			<c:param name="no" value="${row.no}" />
			<c:param name="name" value="${row.name}" />
			<c:param name="viewClassNo" value="${row.viewClassVO.viewClassNo}" />
			<c:param name="lat" value="${row.lat}" />
			<c:param name="lng" value="${row.lng}" />
		</c:url>
	<tr>
		<td><a href="${path}">${row.no}</a></td>
		<td>${row.name}</td>
		<td>${row.viewClassVO.name}</td>
		<td>${row.lat}</td>
		<td>${row.lng}</td>
	</tr>
	</c:forEach>
	
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/healthViewCRUD.jsp" />">回操作系統</a></h3>

</body>
</html>