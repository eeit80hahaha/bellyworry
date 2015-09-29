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
	$(function() {
		$("#dialog").dialog({   
			autoOpen : false,
			width : 480,
			height : 220,
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

<title>套餐組合</title>
<!-- <link rel="stylesheet" -->
<!-- 	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> -->
<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> -->
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<script>
	$(function() {
		$(".accordion").accordion({
			event : "click hoverintent"
		});
	});

	$.event.special.hoverintent = {
		setup : function() {
			$(this).bind("mouseover", jQuery.event.special.hoverintent.handler);
		},
		teardown : function() {
			$(this).unbind("mouseover",
					jQuery.event.special.hoverintent.handler);
		},
		handler : function(event) {
			var currentX, currentY, timeout, args = arguments, target = $(event.target), previousX = event.pageX, previousY = event.pageY;

			function track(event) {
				currentX = event.pageX;
				currentY = event.pageY;
			}
			;

			function clear() {
				target.unbind("mousemove", track).unbind("mouseout", clear);
				clearTimeout(timeout);
			}

			function handler() {
				var prop, orig = event;

				if ((Math.abs(previousX - currentX) + Math.abs(previousY
						- currentY)) < 7) {
					clear();

					event = $.Event("hoverintent");
					for (prop in orig) {
						if (!(prop in event)) {
							event[prop] = orig[prop];
						}
					}

					delete event.originalEvent;

					target.trigger(event);
				} else {
					previousX = currentX;
					previousY = currentY;
					timeout = setTimeout(handler, 100);
				}
			}
			timeout = setTimeout(handler, 100);
			target.bind({
				mousemove : track,
				mouseout : clear
			});
		}
	};
</script>

</head>
<body>
	<jsp:include page="/page/header.jsp" />
	<%-- ${menu} --%>
	<h2>套餐組合</h2>

	<div class="accordion">
		<c:forEach var="vo" items="${menu}">
			<h3>
				<a name="${vo.name}">${vo.name}</a>
			</h3>
			<div>
				<table style="">
					<tr>
						<c:forEach var="v1" items="${vo.foodcals}">
							<td onmouseover="moveon('foodcalNo_${v1.foodNo}')" onmouseout="moveoff('foodcalNo_${v1.foodNo}')"><img src="data:image/jpg;base64,${v1.picture1}"
								style="width: 150px; height: 150px;" /><br>
								<p style="vertical-align: text-top; text-align: center">${v1.name}</p></td>
							<td width="20">&nbsp;</td>
							<td style="display: none;">
							<div id="foodcalNo_${v1.foodNo}" style="display: none;">
								<TABLE border='1' width="450" height="150">
									<tr>
										<td rowspan="4" width="150" height="150"><c:choose>
												<c:when test="${empty v1.picture1}">
													<img
														src="${pageContext.request.contextPath}/images/empty.jpg"
														width="150" height="150" />
												</c:when>
												<c:otherwise>
													<img src="data:image/jpg;base64,${v1.picture1}" width="150"
														height="150" />
												</c:otherwise>
											</c:choose></td>
										<td colspan="4">菜色分類</td>
										<td colspan="4">${v1.menus.name}</td>
									</tr>
									<tr>
										<td colspan="4">菜色名稱</td>
										<td colspan="4">${v1.name}</td>
									</tr>
									<tr>
										<td colspan="2">份量</td>
										<td colspan="2">${v1.weight}公克/每${v1.count}</td>
										<td colspan="2">熱量</td>
										<td colspan="2">${v1.cal}卡/100g</td>
									</tr>
								</TABLE>
							</div>
							</td>
						</c:forEach>
					</tr>
				</table>
			</div>

		</c:forEach>
	</div>

	<h2>一日套餐組合</h2>
	<div class="accordion">
		<c:forEach var="vo" items="${menu1}">
			<h3>${vo.name}</h3>
			<div>
				<span><a href="#${vo.breakfastMealName.name}">${vo.breakfastMealName.name}</a></span>
				<span><a href="#${vo.lunchMealName.name}">${vo.lunchMealName.name}</a></span>
				<span><a href="#${vo.dinnerMealName.name}">${vo.dinnerMealName.name}</a></span>
			</div>

		</c:forEach>
	</div>
	<div id="dialog"></div>
	<jsp:include page="/page/footer.jsp" />
	
</body>
<script type="text/javascript">
var isDialogOpen = false;

function moveon(foodNo) {
	if(!isDialogOpen){
		isDialogOpen = true;
		$("#dialog").html($('#' + foodNo).html());
		$("#dialog").dialog("open");
	}
}
function moveoff(foodNo) {
	if(isDialogOpen){
		$("#dialog").on("dialogclose", function( event, ui ) { isDialogOpen = false; } );
		$("#dialog").dialog("close");
		
	}
}
</script>

</html>