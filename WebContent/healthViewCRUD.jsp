<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>Product</title>
<script src="scripts/jquery.min.js" type="text/javascript"></script>
<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
	$("#viewClassNo option").prop("selected",false);
	
}
</script>
</head>
<body>

<h3>歡迎使用後台管理系統</h3>

<h3>健康景點管理</h3>

<form action="<c:url value="/healthView.controller" />" method="get">
<table>
	<tr>
		<td>no : </td>
		<td><input type="text" name="no" value="${param.no}"></td>
		<td><span class="error">${error.no}</span></td>
	</tr>
	<tr>
		<td>name : </td>
		<td><input type="text" name="name" value="${param.name}"></td>
		<td><span class="error">${error.name}</span></td>
	</tr>

	<tr>
		<td>viewClassNo : </td>
		<td>
			<select name="viewClassNo" lang="10" id="viewClassNo">
				<jsp:useBean id="viewClass" class="fun.model.ViewClassService">
				<c:forEach var="row" items="${viewClass.all}">
					<c:choose>
						<c:when test="${param.viewClassNo == row.viewClassNo}">
							<option value="${row.viewClassNo}" selected>${row.name}</option>
						</c:when>
						<c:otherwise>
							<option value="${row.viewClassNo}">${row.name}</option>
						</c:otherwise>
					</c:choose>>
				</c:forEach>
				</jsp:useBean>
			</select>
		</td>
		<td><span class="error">${error.viewClassNo}</span></td>
	</tr>
	<tr>
		<td>lat : </td>
		<td><input type="text" name="lat" value="${param.lat}"></td>
		<td><span class="error">${error.lat}</span></td>
	</tr>
	<tr>
		<td>lng : </td>
		<td><input type="text" name="lng" value="${param.lng}"></td>
		<td><span class="error">${error.lng}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="prodaction" value="Insert">
			<input type="submit" name="prodaction" value="Update">
		</td>
		<td>
			<input type="submit" name="prodaction" value="Delete">
			<input type="submit" name="prodaction" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<h3><span class="error">${error.action}</span></h3>

<c:if test="${not empty delete}">
<h3>刪除資料 : ${delete} 筆資料被刪除了！</h3>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty insert}">
<h3>新增資料成功</h3>
<table border="1">
	<tr><td>Id</td><td>${insert.no}</td></tr>
	<tr><td>Name</td><td>${insert.name}</td></tr>
	<tr><td>ViewClassNo</td><td>${insert.viewClassVO.name}</td></tr>
	<tr><td>lat</td><td>${insert.lat}</td></tr>
	<tr><td>lng</td><td>${insert.lng}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>修改資料成功</h3>
<table border="1">
	<tr><td>No</td><td>${update.no}</td></tr>
	<tr><td>Name</td><td>${update.name}</td></tr>
	<tr><td>ViewClassNo</td><td>${update.viewClassVO.name}</td></tr>
	<tr><td>lat</td><td>${update.lat}</td></tr>
	<tr><td>lng</td><td>${update.lng}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

</body>
</html>