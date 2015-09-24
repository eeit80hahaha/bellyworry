<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>套餐組合</title>
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
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
	<%-- ${menu} --%>
	<h2>套餐組合</h2>

	<div class="accordion">
		<c:forEach var="vo" items="${menu}">
			<h3><a name="${vo.name}">${vo.name}</a></h3>
			<div>
				<table width="160">
					<tr>
						<c:forEach var="v1" items="${vo.foodcals}">
							<td><img src="data:image/jpg;base64,${v1.picture1}"
								width="150" height="150" /><br>
								<p style="vertical-align: text-top; text-align: center">${v1.name}</p></td>
							<td width="20">&nbsp;</td>
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
</body>
</html>