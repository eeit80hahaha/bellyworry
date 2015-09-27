<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>exerciseCaling</title>
<script type="text/javascript">
function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>
</head>
<body>

<h3>後台管理系統</h3>

<h3>運動項目管理</h3>
<form action="<c:url value="/ranking/execiseCal.controller"/>" method="get">
<table>
	<tr>
		<td>ExerciseNo : </td>
 		<td><input type="text" name="exerciseNo" value="${param.exerciseNo}"></td>  <%--呼叫Servlet的String temp1 = request.getParameter("id") --%>
		<td><span class="error">${error.exerciseNo}</span></td>
	</tr>
	<tr>
		<td>Name : </td>
		<td><input type="text" name="name" value="${param.name}"></td>
		<td></td>
	</tr>
	<tr>
		<td>CalHour : </td>
		<td><input type="text" name="calHour" value="${param.calHour}"></td>
		<td><span class="error">${error.calHour}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="execrisecalion" value=Insert>
			<input type="submit" name="execrisecalion" value="Update">
		</td>	
		 <td>
			<input type="submit" name="execrisecalion" value="Delete">
			<input type="submit" name="execrisecalion" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<h3><span class="error">${errors.action}</span></h3>

<c:if test="${not empty delete}">
<h3>刪除資料 : ${delete} 筆資料被刪除了</h3>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty insert}">
<h3>新增成功: ${insert} 筆資料新增了</h3>
<table border="1">
	<tr><td>Id</td><td>${insert.exerciseNo}</td></tr>
	<tr><td>Name</td><td>${insert.name}</td></tr>
	<tr><td>CalHour</td><td>${insert.calHour}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>修改資料成功</h3>
<table border="1">
	<tr><td>Id</td><td>${update.exerciseNo}</td></tr>
	<tr><td>Name</td><td>${update.name}</td></tr>
	<tr><td>CalHour</td><td>${update.calHour}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

</body>
</html>