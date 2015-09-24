<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="scripts/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
<link href="scripts/icons/general/stylesheets/general_foundicons.css" media="screen" rel="stylesheet" type="text/css" />  
    <link href="scripts/icons/social/stylesheets/social_foundicons.css" media="screen" rel="stylesheet" type="text/css" />
     <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome.min.css">
    <!--[if IE 7]>
        <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome-ie7.min.css">
    <![endif]-->

    <link href="scripts/carousel/style.css" rel="stylesheet" type="text/css" />
    <link href="scripts/camera/css/camera.css" rel="stylesheet" type="text/css" />

    <link href="http://fonts.googleapis.com/css?family=Allura" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Aldrich" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet" type="text/css">

    <link href="styles/custom.css" rel="stylesheet" type="text/css" />
<!--     開始(hui)=================js版本有衝突，要刪掉其一========================== -->
<link rel="stylesheet"
	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<script src="scripts/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="scripts/default.js" type="text/javascript"></script>


<script src="scripts/carousel/jquery.carouFredSel-6.2.0-packed.js" type="text/javascript"></script>
<script type="text/javascript">$('#list_photos').carouFredSel({ responsive: true, width: '100%', scroll: 2, items: {width: 320,visible: {min: 2, max: 6}} });</script>
<script src="scripts/camera/scripts/camera.min.js" type="text/javascript"></script>
<script src="scripts/easing/jquery.easing.1.3.js" type="text/javascript"></script>
<script type="text/javascript">function startCamera() {$('#camera_wrap').camera({ fx: 'scrollLeft', time: 2000, loader: 'none', playPause: false, navigation: true, height: '65%', pagination: true });}$(function(){startCamera()});</script>

<title>會員登入</title>
<jsp:include page="/page/header.jsp"/>
</head>
<script type="text/javascript">
//忘記密碼Start
$(function() {
	
	$("#dialog3").dialog({
		autoOpen : false,
		show : {
			effect : "blind",
			duration : 1000
		},
		hide : {
			effect : "explode",
			duration : 1000
		}
	});
	
	$("#opener3").click(function() {
		
		$("#dialog3").dialog("open");
	});
});//忘記密碼End

//登入與密碼錯誤訊息Start
$(function() {
	$("#dialog0").dialog({
		autoOpen : false,
		show : {
			effect : "blind",
			duration : 1000
		},
		hide : {
			effect : "explode",
			duration : 1000
		}
	});
	${error.open}
});
//登入與密碼錯誤訊息End

</script>

<body>

<%-- <jsp:include page="/page/header.jsp"/> --%>
	<!--==================================== -->
	<div title="登入" >
		<form
			action="${pageContext.request.contextPath}/LoginServlet.controller"
			method="post">
			<div>
				<label><span style="color: red">*</span>帳號:</label><input
					type="text" name="loginaccount" size="25" required="" value="${param.loginaccount}"/>
				<dir>${error.username1}</dir>
			</div>
			<div>
				<label><span style="color: red">*</span>密碼:</label><input
					type="password" name="loginpwd" size="25" required=""
					maxlength="20" />
				<dir>${error.password1}</dir>	
			</div>
			<br>
			<div id="submit">
				<input type="submit" value="送出" /> <input type="reset" value="清除" />
				<button id="opener3">忘記密碼</button> <a href="${pageContext.request.contextPath}/index.jsp">回首頁</a>
			</div>
		</form>
	</div>
	<div id="dialog3" title="忘記密碼" style="display: none;">
		<form
			action="${pageContext.request.contextPath}/ForgetpwsServlet.controller"
			method="post">
			<div>
				<label><span style="color: red">*</span>帳號:</label><input
					type="text" name="forgetaccount" size="25" required="" />

			</div>
			<div>
				<label><span style="color: red">*</span>E-mail:</label><input
					type="email" name="forgetmail" size="25" required="" maxlength="40" />
			</div>
			<br>
			<div id="submit">
				<input type="submit" value="送出" /> <input type="reset" value="清除" />
			</div>
		</form>
	</div>

	<!--==================================== -->
	<!-- =========登入錯誤========== -->
	<div id="dialog0">
	<p>${error.username1}</p>
	<p>${error.password1}</p>
	<p>${error.er1}</p>
	<p>${error.success1}</p>
	<!-- =========忘記密碼錯誤========== -->
	<p>${error.in}</p>
	<p>${error.mailer}</p>
	<!-- =========停權========== -->
	<p>${error.stop}</p>
	</div>
<jsp:include page="/page/footer.jsp"/>
</body>
</html>