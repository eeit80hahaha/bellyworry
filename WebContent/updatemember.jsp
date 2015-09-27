<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">      
	<meta name="author" content="Html5TemplatesDreamweaver.com">
	<META NAME="ROBOTS" CONTENT="NOINDEX, NOFOLLOW"> <!-- Remove this Robots Meta Tag, to allow indexing of site -->
    <link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="scripts/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link href="scripts/icons/general/stylesheets/general_foundicons.css" media="screen" rel="stylesheet" type="text/css" />  
    <link href="scripts/icons/social/stylesheets/social_foundicons.css" media="screen" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="scripts/fontawesome/css/font-awesome.min.css">
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
	<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
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


<!--     開始(hui)=================js版本有衝突，要刪掉其一========================== -->
<!-- <link rel="stylesheet" -->
<!-- 	href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css"> -->
<!-- <script src="//code.jquery.com/jquery-1.10.2.js"></script> -->
<!-- <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script> -->
<!-- <link rel="stylesheet" href="/resources/demos/style.css"> -->
<!--  //結束(hui)=================js版本有衝突，要刪掉其一========================== --> 
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<script type="text/javascript">

//日期Start
$(function() {
	$("#datepicker").datepicker({
		changeMonth : true,
		changeYear : true
	});
});//日期End

//變更密碼Start
$(function() {	
	$("#dialog").dialog({
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
	
	$("#updatepwd").click(function() {
		$("#dialog").dialog("open");
	});	
});//變更密碼End
$(function() {	
	$("#dialog1").dialog({
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
	${up.open1}//
	${change.open}
});//變更密碼End

</script>
<title>修改會員資料</title>
</head>
<jsp:include page="/page/header.jsp"/>
<body>
	<form
		action="${pageContext.request.contextPath}/UpdateServlet.controller"
		method="post">
		<fieldset>
			<legend>
				個人資料(<span style="color: red">*</span>為必填)
			</legend>
			<div>
				<label><span style="color: red">*</span> 姓:</label><input
					type="text" name="firstname" size="20" autofocus placeholder="請輸入"
					autocomplete="off" required="" value="${user.getFirstName()}"/>
					<div>${up.firstName}</div>
			</div>
			<div>
				<label><span style="color: red">*</span> 名:</label><input
					type="text" name="lastname" size="20" autofocus placeholder="請輸入"
					autocomplete="off" required="" value="${user.getLastName()}"/>
					<div>${up.lastName}</div>
			</div>
			<div>
				<label>暱稱:</label><input type="text" name="nickname" size="20"
					autofocus placeholder="請輸入" autocomplete="off" required="" value="${user.getNickname()}"/>
					
			</div>
			<div>
				<label><span style="color: red">*</span>帳號:</label><input
					type="text" name="account" size="20" required="" value="${user.getId()}"/>
					<div>${up.username}</div>
			</div>
			<div>
				<label><span style="color: red">*</span>Mail:</label> <input
					type="email" name="mail" size="20" autofocus
					placeholder="請輸入E-mail" autocomplete="off" value="${user.getEmail()}"/>
					<div>${up.email}</div>
			</div>
			<div>
				<label><span style="color: red">*</span>生日:</label> <input
					type="text" name="date" id="datepicker" value="${user.getBirthday()}">
					<div>${up.birth}</div>		
			</div>
			<div>
				<label><span style="color: red">*</span>性別:</label><input
					type="radio" name="gender" size="20" value="males" />男 <input
					type="radio" name="gender" size="20" value="female" />女
					<div>${up.gender}</div>
			</div>
		</fieldset>
		<div>
			<input type="submit" value="送出" /> <input type="reset" value="清除" />
			<input type="button" id="updatepwd" value="變更密碼"/>
		</div>
	</form>

	<div id="dialog" title="變更密碼" style="display: none;">
		<form
			action="${pageContext.request.contextPath}/UpdatePwd.controller"
			method="post">
			<div>
				<label><span style="color: red">*</span>帳號:</label><input
					type="text" name="changeaccount" size="25" required="" />
				<div>${change.elaccount}</div>
			</div>
			<div>
				<label><span style="color: red">*</span>舊密碼:</label><input
					type="password" name="oldpwd" size="20" required="" maxlength="20" />
				<div>${change.eloldpwd}</div>
			</div>
			<div>
				<label><span style="color: red">*</span>新密碼:</label><input
					type="password" name="newpwd" size="20" required="" maxlength="20" />
				<div>${change.elnewpwd}</div>
			</div>
			<div>
				<label><span style="color: red">*</span>新密碼確認:</label><input
					type="password" name="checknewpwd" size="20" required="" maxlength="20" />
				<div>${change.elchecknewpwd}</div>
				<div>${change.erchecknewpwd}</div>
			</div>
			<br>
			<div id="submit">
				<input type="submit" value="送出" /> <input type="reset" value="清除" />
			</div>
		</form>
	</div>
	<div id="dialog1" title="會員資料修改" style="display: none;">
	<!-- 會員資料修改錯誤 -->
	${up.username}
	${up.firstName}	
	${up.lastName}
	${up.email}
	${up.birth}
	${up.gender}
	${up.er}
	<!-- 密碼修改錯誤 -->
	${change.elaccount}
	${change.eloldpwd}
	${change.elnewpwd}
	${change.elchecknewpwd}
	${change.erchecknewpwd}
	${change.error1}
	</div>
<jsp:include page="/page/footer.jsp"/>
</body>
</html>