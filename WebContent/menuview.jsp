<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<head>
<meta charset="utf-8">
<title>jQuery UI Dialog - Animation</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script>
	$(function() {
		$("#dialog").dialog({
			autoOpen : false,
			width : 440,
			height: 500,
			show : {
				effect : "blind",
				duration : 1000
			},
			hide : {
				effect : "explode",
				duration : 1000
			}
		});
	});
</script>
<jsp:include page="/page/header.jsp"/>
</head>
<body>
    <div style="position: relative; left:0; right:0; margin: 0 auto; width: 960px;">
	<form method="post"
		action="${pageContext.request.contextPath}/Menuservelt.controller"
		id="menuForm">
		<div style="margin: 20px 0 20px 20px;">
			<select id="menuNo" name="menuNo">
				<option value="">請選擇..</option>
				<c:forEach var="vo" items="${option}">
					<option value="${vo.menuNo}">${vo.name}</option>
				</c:forEach>
				<option value="0">所有類型</option>
			</select>
		</div>
		<c:forEach var="vo" items="${menu}">
			<div style="display: inline-block; margin: 20px 0 0 20px;">
				<TABLE border='1' width="450" height="150">
					<tr>
						<td rowspan="4" width="150" height="150"><img
							src="data:image/jpg;base64,${vo.picture1}" width="150"
							height="150" /></td>
						<td colspan="4">菜色分類</td>
						<td colspan="4">${vo.menus.name}</td>
					</tr>
					<tr>
						<td colspan="4">菜色名稱</td>
						<td colspan="4">${vo.name}</td>
					</tr>
					<tr>
						<td colspan="2">份量</td>
						<td colspan="2">${vo.weight}公克/每${vo.count}</td>
						<td colspan="2">熱量</td>
						<td colspan="2">${vo.cal}卡/100g</td>
					</tr>
					<tr>
						<td colspan="8">
						<c:choose>
              				<c:when test="${empty vo.cookNo}">
              					無食譜
              				</c:when>
              				<c:otherwise>	
              					<input type="button" name="" value="食譜" onclick="openCook('${vo.cookNo}')" />
              				</c:otherwise>
              			</c:choose>
						</td>
					</tr>
				</TABLE>
			</div>
		</c:forEach>
		<input type="button" name="" value="第一頁" onclick="pagecount('1')" />
		<input type="button" name="" value="上一頁" onclick="pagecount('${pagecount-1}')" />
		<input type="button" name="" value="下一頁" onclick="pagecount('${pagecount+1}')" />
		<input type="button" name="" value="最末頁" onclick="pagecount('${listPage}')" />
		
		<input type="hidden" id="pages" name="pages" value="1" />
	</form>
	<div>
	</div>
	</div>
	${cooksDiv}<!-- 食譜 -->

	<div id="dialog">
		

	</div>
</body>
</html>
<script type="text/javascript">
$(function() {
	$("#menuNo").change(function() {
		if($("#menuNo option:selected").val() == ""){
			return false;
		}
		alert($("#menuNo option:selected").text());
		$("#menuForm").submit();
	});
});

function openCook(cookNo){
	//alert($("#dialog").html());
	$("#dialog").html($('#cook_'+cookNo).html());
	$("#dialog").dialog("open");
}

function pagecount(pages){
	$("#pages").val(pages);
	$("#menuForm").submit();
}
</script>