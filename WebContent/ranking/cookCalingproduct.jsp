<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>foodCalProduct</title>
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

<h3>Welcome${user.custid}</h3>

<h3>foodCalProduct Table</h3>
<form action="<c:url value="/ranking/foodCal.product"/>" method="get">
<table>
	<tr>
		<td>FoodNo : </td>
 		<td><input type="text" name="foodNo" value="${param.foodNo}"></td>  <%--呼叫Servlet的String temp1 = request.getParameter("id") --%>
		<td><span class="error">${error.foodNo}</span></td>
	</tr>
	<tr>
		<td>Name : </td>
		<td><input type="text" name="name" value="${param.name}"></td>
		<td></td>
	</tr>
	<tr>
		<td>MenuNo : </td>
		<td><input type="text" name="menuNo" value="${param.menuNo}"></td>
		<td><span class="error">${error.menuNo}</span></td>
	</tr>
	<tr>
		<td>Cal : </td>
		<td><input type="text" name="cal" value="${param.cal}"></td>
		<td><span class="error">${error.cal}</span></td>
	</tr>
	<tr>
		<td>Count : </td>
		<td><input type="text" name="count" value="${param.count}"></td>
		<td><span class="error">${error.count}</span></td>
	</tr>
	<tr>
		<td>Weight : </td>
		<td><input type="text" name="weight" value="${param.weight}"></td>
		<td><span class="error">${error.weight}</span></td>
	</tr>
	<tr>
		<td>CookNo : </td>
		<td><input type="text" name="cookNo" value="${param.cookNo}"></td>
		<td><span class="error">${error.cookNo}</span></td>
	</tr>
	<tr>
		<td>Picture : </td>
		<td><input type="text" name="picture" value="${param.picture}"></td>
		<td><span class="error">${error.picture}</span></td>
	</tr>
	<tr>
		<td>
			<input type="submit" name="foodcalion" value=Insert>
			<input type="submit" name="foodcalion" value="Update">
		</td>	
		 <td>
			<input type="submit" name="foodcalion" value="Delete">
			<input type="submit" name="foodcalion" value="Select">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<%-- <h3><span class="error">${errors.action}</span></h3> --%>

<%-- <c:if test="${not empty delete}"> --%>
<%-- <h3>Delete Product Table Success : ${delete} row deleted</h3> --%>
<!-- <script type="text/javascript">clearForm();</script> -->
<%-- </c:if> --%>

<%-- <c:if test="${not empty insert}"> --%>
<!-- <h3>Insert Product Table Success</h3> -->
<!-- <table border="1"> -->
<%-- 	<tr><td>Id</td><td>${insert.id}</td></tr> --%>
<%-- 	<tr><td>Name</td><td>${insert.name}</td></tr> --%>
<%-- 	<tr><td>Price</td><td>${insert.price}</td></tr> --%>
<%-- 	<tr><td>Make</td><td>${insert.make}</td></tr> --%>
<%-- 	<tr><td>Expire</td><td>${insert.expire}</td></tr> --%>
<!-- </table> -->
<!-- <script type="text/javascript">clearForm();</script> -->
<%-- </c:if> --%>

<%-- <c:if test="${not empty update}"> --%>
<!-- <h3>Update Product Table Success</h3> -->
<!-- <table border="1"> -->
<%-- 	<tr><td>Id</td><td>${update.id}</td></tr> --%>
<%-- 	<tr><td>Name</td><td>${update.name}</td></tr> --%>
<%-- 	<tr><td>Price</td><td>${update.price}</td></tr> --%>
<%-- 	<tr><td>Make</td><td>${update.make}</td></tr> --%>
<%-- 	<tr><td>Expire</td><td>${update.expire}</td></tr> --%>
<!-- </table> -->
<!-- <script type="text/javascript">clearForm();</script> -->
<%-- </c:if> --%>

</body>
</html>