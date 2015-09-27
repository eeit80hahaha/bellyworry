<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Html5TemplatesDreamweaver.com">
<META NAME="ROBOTS" CONTENT="NOINDEX, NOFOLLOW">
<!-- Remove this Robots Meta Tag, to allow indexing of site -->
<link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="scripts/bootstrap/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link href="scripts/icons/general/stylesheets/general_foundicons.css"
	media="screen" rel="stylesheet" type="text/css" />
<link href="scripts/icons/social/stylesheets/social_foundicons.css"
	media="screen" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="scripts/fontawesome/css/font-awesome.min.css">
<link href="scripts/carousel/style.css" rel="stylesheet" type="text/css" />
<link href="scripts/camera/css/camera.css" rel="stylesheet"
	type="text/css" />
<link href="http://fonts.googleapis.com/css?family=Allura"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Aldrich"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Open+Sans"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Pacifico"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Palatino+Linotype"
	rel="stylesheet" type="text/css">
<link href="http://fonts.googleapis.com/css?family=Calligraffitti"
	rel="stylesheet" type="text/css">
<link href="styles/custom.css" rel="stylesheet" type="text/css" />
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="scripts/bootstrap/js/bootstrap.min.js"
	type="text/javascript"></script>
<script src="scripts/default.js" type="text/javascript"></script>
<script src="scripts/carousel/jquery.carouFredSel-6.2.0-packed.js"
	type="text/javascript"></script>
<script type="text/javascript">
	$('#list_photos').carouFredSel({
		responsive : true,
		width : '100%',
		scroll : 2,
		items : {
			width : 320,
			visible : {
				min : 2,
				max : 6
			}
		}
	});
</script>
<script src="scripts/camera/scripts/camera.min.js"
	type="text/javascript"></script>
<script src="scripts/easing/jquery.easing.1.3.js" type="text/javascript"></script>
<script type="text/javascript">
	function startCamera() {
		$('#camera_wrap').camera({
			fx : 'scrollLeft',
			time : 2000,
			loader : 'none',
			playPause : false,
			navigation : true,
			height : '65%',
			pagination : true
		});
	}
	$(function() {
		startCamera()
	});
</script>

<title>食物熱量表&食譜</title>
<head>

<!-- <link rel="stylesheet" -->
<!-- 	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> -->
<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> -->
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<script>
	$(function() {
		$("#dialog").dialog({
			autoOpen : false,
			width : 440,
			height : 500,
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
<jsp:include page="/page/header.jsp" />
</head>
<body>
	<div
		style="position: relative; left: 0; right: 0; margin: 0 auto; width: 960px;">
		<form method="post"
			action="${pageContext.request.contextPath}/Menuservelt.controller"
			id="menuForm">
			<div style="margin: 20px 0 20px 20px;">
				<select id="menuNo" name="menuNo">
					<option value="">請選擇..</option>
					<c:forEach var="vo" items="${option}">
						<!-- Neil modified -->
						<!--original
						<option value="${vo.menuNo}" >${vo.name}</option>
						-->
						<option value="${vo.menuNo}" ${vo.menuNo == selected ? 'selected="selected"' : ''}>${vo.name}</option>
						<!-- Neil modified -->
					</c:forEach>
					<option value="0">所有類型</option>
				</select>
			</div>
			<c:forEach var="vo" items="${menu}">
				<div style="display: inline-block; margin: 20px 0 0 20px;">
					<TABLE border='1' width="450" height="150">
						<tr>
							<td rowspan="4" width="150" height="150">
								<c:choose>
									<c:when test="${empty vo.picture1}">
										<img src="${pageContext.request.contextPath}/images/empty.jpg" width="150"
											height="150" />
									</c:when>
									<c:otherwise>
										<img src="data:image/jpg;base64,${vo.picture1}" width="150"
											height="150" />
									</c:otherwise>
								</c:choose></td>
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
							<td colspan="8"><c:choose>
									<c:when test="${empty vo.cookNo}">
              					無食譜
              				</c:when>
									<c:otherwise>
										<input type="button" name="" value="食譜"
											onclick="openCook('${vo.foodNo}')" />
									</c:otherwise>
								</c:choose></td>
						</tr>
					</TABLE>
				</div>
			</c:forEach>
			<input type="button" name="" value="第一頁" onclick="pagecount('1')" />
			<input type="button" name="" value="上一頁"
				onclick="pagecount('${pagecount-1}')" ${pagecount==1?'disabled="true"':""} /> <input type="button"
				name="" value="下一頁" onclick="pagecount('${pagecount+1}')" ${pagecount==listPage?'disabled="true"':""}/> <input
				type="button" name="" value="最末頁" onclick="pagecount('${listPage}')" />

			<input type="hidden" id="pages" name="pages" value="1" />
			<!--Neil add-->
			<!-- <input type="hidden" id="menutype" name="menutype" /> -->
			<!--Neil add-->
		</form>
		<div></div>
	</div>
	${cooksDiv}
	<!-- 食譜 -->

	<div id="dialog"></div>
	<jsp:include page="/page/footer.jsp" />
</body>
</html>
<script type="text/javascript">
	$(function() {
		$("#menuNo").change(function() {
			if ($("#menuNo option:selected").val() == "") {
				return false;
			}
			/*Neil add*/
			//$("#menutype").val($("#menuNo option:selected").val());
			/*Neil add*/
			$("#menuForm").submit();
		});
	});

	function openCook(cookNo) {
		//alert($("#dialog").html());
		$("#dialog").html($('#cook_' + cookNo).html());//把DIV ID是#cook_' + cookNo塞到html內
		$("#dialog").dialog("open");
	}

	function pagecount(pages) {
		$("#pages").val(pages);
		$("#menuForm").submit();
	}
</script>