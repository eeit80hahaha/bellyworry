<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ranking</title>
</head>
<body>
<%-- from:${herovolist} --%>
<!-- <hr/> -->
<%-- vo:${herovolist[0].membervo} --%>
<!-- <hr/> -->
<%-- test:${herovolist[0].memberNo} --%>
<%-- 會員帳號:${herovolist[0].membervo.id} --%>
<%-- 會員暱稱:${herovolist[0].membervo.nickname} --%>
<%-- 差值:${herovolist[0].weightDiff} --%>
<%-- 日記篇數:${herovolist[0].num} --%>
<!-- <hr/> -->

<table>
	<tr><th>會員帳號</th><th>會員暱稱</th><th>差值</th><th>日記篇數</th></tr>
	<c:forEach var="hero" items="${herovolist}">
		<tr>
			<td>${hero.membervo.id}</td>
			<td>${hero.membervo.nickname}</td>
			<td>${hero.weightDiff}</td>
			<td>${hero.num}</td>
			<td>
				<a href="${pageContext.request.contextPath}/herolist.controller?memberNo=${hero.memberNo}&pageNo=1">
					觀看
				</a>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>