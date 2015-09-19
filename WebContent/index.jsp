﻿<!DOCTYPE HTML>
<html>
<head>
    <meta charset="utf-8">
    <title>Belly Worry - Enjoy Your Life</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">      
	<meta name="author" content="Html5TemplatesDreamweaver.com">
	<META NAME="ROBOTS" CONTENT="NOINDEX, NOFOLLOW"> <!-- Remove this Robots Meta Tag, to allow indexing of site -->
    
    <link href="scripts/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="scripts/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet">

    <!-- Le HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
      <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
    <![endif]-->

    <!-- Icons -->
    <link href="scripts/icons/general/stylesheets/general_foundicons.css" media="screen" rel="stylesheet" type="text/css" />  
    <link href="scripts/icons/social/stylesheets/social_foundicons.css" media="screen" rel="stylesheet" type="text/css" />
    <!--[if lt IE 8]>
        <link href="scripts/icons/general/stylesheets/general_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
        <link href="scripts/icons/social/stylesheets/social_foundicons_ie7.css" media="screen" rel="stylesheet" type="text/css" />
    <![endif]-->
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
<!--<=====這裡-->
<script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css">
<!--     //結束(hui)=================js版本有衝突，要刪掉其一========================== -->
<script type="text/javascript">
	//註冊開始(hui)============================
	//日期Start
	$(function() {
		$("#datepicker").datepicker({
			changeMonth : true,
			changeYear : true
		});
	});//日期End

	//新增會員Start
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
		$("#opener").click(function() {
			$("#dialog").dialog("open");
		});
	});//新增會員End
	
	//註冊訊息Start
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

	//註冊訊息End
	//註冊結束(hui)==============================================
</script>

</head>

<body id="pageBody">

<div id="decorative2">
    <div class="container">

        <div class="divPanel topArea notop nobottom">
            <div class="row-fluid">
                <div class="span12">

                    <div id="divLogo" class="pull-left">
                        <a href="index.html" id="divSiteTitle">Belly Worry</a><br />
                        <a href="index.html" id="divTagLine">Enjoy Your Life</a>
                    </div>

                    <div id="divMenuRight" class="pull-right">
<!-- 登入成功秀修改登出-->     <div class="navbar"><h2>${user.id}</h2><span>${suc.update}</span><span>${suc.out}</span>
                        <button type="button" class="btn btn-navbar-highlight btn-large btn-primary" data-toggle="collapse" data-target=".nav-collapse">
                            功能選單 <span class="icon-chevron-down icon-white"></span>
                        </button>
                        <div class="nav-collapse collapse">
                            <ul class="nav nav-pills ddmenu">
                            <!--
                                <li class="dropdown active"><a href="index.html">回首頁</a></li>
                            -->
                                <li class="dropdown">
                                    <a href="page.html" class="dropdown-toggle">健康食譜<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="about.html">關於我</a></li>
                                        <li><a href="${pageContext.request.contextPath}/Menuservelt.controller">filter</a></li>
                                        <li><a href="${pageContext.request.contextPath}/logout.controller">登出</a></li>
                                        <li><a href="${pageContext.request.contextPath}/updatemember.jsp">更新</a></li>
                                        <li><a href="../documentation/index.html">說明文件</a></li>
                                        <li class="dropdown">
                                        <a href="full.html" class="dropdown-toggle">分欄參考</a>
                                        <ul class="dropdown-menu sub-menu">
                                        <li><a href="full.html">單欄版型</a></li>
                                        <li><a href="2-column.html">兩欄版型</a></li>
                                        <li><a href="3-column.html">三欄版型</a></li>
                                        </ul>
                                        </li>
                                    </ul>
                                </li>
                                <li class="dropdown"><a href="about.html">熱量計算</a></li>
                                <li class="dropdown"><a href="diaryIndex.controller">健康管理</a></li>
                                <li class="dropdown">
                                    <a href="page.html" class="dropdown-toggle">運動趣<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="full.html">YouBike路線規劃</a></li>
                                        <li><a href="fun/healthView.controller">健康景點查詢</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown"><a href="about.html">活動情報</a></li>
                                <li class="dropdown"><a href="gallery.html">英雄事蹟</a></li>
                                <li class="dropdown"><a href="about.html">小學堂</a></li>
                                <li class="dropdown"><a href="${pageContext.request.contextPath}/login.jsp" id="dropdown-my">會員登入</a></li>
                            </ul>
                        </div>
                    </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>

<div id="decorative1" style="position:relative">
    <div class="container">

        <div class="divPanel headerArea">
            <div class="row-fluid">
                <div class="span12">
    
                    <div id="headerSeparator"></div>

                    <div class="row-fluid">
                        <div class="span6">

                            <div id="divHeaderText" class="page-content">
                                <div id="divHeaderLine1">Your Header Text Here!</div><br />
                                <div id="divHeaderLine2">2nd line header text for calling extra attention..</div><br />
                                <div id="divHeaderLine3">                                
                                <a class="btn btn-danger" id="opener">註冊新會員</a>
										<div id="dialog" title="註冊會員" style="display: none;">
											<form
												action="${pageContext.request.contextPath}/MemberServlet.controller"
												method="post">
												<fieldset>
													<legend>
														個人資料(<span style="color: red">*</span>為必填)
													</legend>
													<div>
														<label><span style="color: red">*</span> 姓:</label><input
															type="text" name="firstname" size="20" autofocus
															placeholder="請輸入" autocomplete="off" required="" />
													</div>
													<div>
														<label><span style="color: red">*</span> 名:</label><input
															type="text" name="lastname" size="20" autofocus
															placeholder="請輸入" autocomplete="off" required="" />
													</div>
													<div>
														<label>暱稱:</label><input type="text" name="nickname"
															size="20" autofocus placeholder="請輸入" autocomplete="off"
															required="" />
													</div>
													<div>
														<label><span style="color: red">*</span>帳號:</label><input
															type="text" name="account" size="20" required="" />
													</div>
													<div>
														<label><span style="color: red">*</span>密碼:</label><input
															type="password" name="pwd" size="20" required=""
															maxlength="20" />
													</div>
													<div>
														<label><span style="color: red">*</span>密碼確認:</label><input
															type="password" name="pwd1" size="20" required=""
															maxlength="20" />
													</div>
													<div>
														<label><span style="color: red">*</span>Mail:</label> <input
															type="email" name="mail" size="20" autofocus
															placeholder="請輸入E-mail" autocomplete="off" />
													</div>
													<div>
														<label><span style="color: red">*</span>生日:</label> <input
															type="text" name="date" id="datepicker">
													</div>
													<div>
														<label><span style="color: red">*</span>性別:</label><input
															type="radio" name="gender" size="20" value="males" />男 <input
															type="radio" name="gender" size="20" value="female" />女
													</div>
												</fieldset>
												<div>
													<input type="submit" value="送出" /> <input type="reset"
														value="清除" />
												</div>
											</form>
									<!-- ==============註冊錯誤訊息=================================================================== -->
									<div id="dialog0">										
<%-- 										<p>${error.open}</p> --%>
										<p>${error.add}</p>
										<p>${error.password1}</p>
										<p>${error.username}</p>
										<p>${error.password}</p>
										<p>${error.firstName}</p>
										<p>${error.lastName}</p>
										<p>${error.email}</p>
										<p>${error.birth}</p>
										<p>${error.gender}</p>
										<p>${error.er}</p>
										<p>${error.success}</p>
					<!-- ==============忘記密碼寄信成功訊息=================================================================== -->
										<p>${error.success2}</p>
									</div>
					<!-- ======================================================================================== -->
                               		 </div>
                            	</div>

                        </div>
                        <div class="span6">
                            <!--Edit Camera Slider here-->
                            <div id="camera_wrap">
<div data-src="images/caprese.jpg" ><div class="camera_caption fadeFromBottom cap1">Lorem Ipsum is simply dummy text of the printing.</div></div><div data-src="images/plate.jpg" ><div class="camera_caption fadeFromBottom cap2">Lorem Ipsum is simply dummy text of the printing.</div></div>
<div data-src="images/gourmandises.jpg" ><div class="camera_caption fadeFromBottom cap1">Lorem Ipsum is simply dummy text of the printing.</div></div>
                            </div>
							<!--End Camera Slider here-->

                        </div>
                    </div>

                    <div id="headerSeparator2"></div>
        
                </div>
            </div>
   
        </div>

    </div>
</div>

<div id="contentOuterSeparator"></div>

<div class="container">

    <div class="divPanel page-content">
        <!--Edit Main Content Area here-->
        <div class="row-fluid">

                <div class="span12" id="divMain">

                    <h1>Welcome</h1>

                    <p><strong>Lorem ipsum dolor sit amet,</strong> consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat.</p>
					
					<p>At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. </p>

                    <hr style="margin:45px 0 35px" />
					
				<div class="row-fluid">
				
                    <div class="span4">
                    <h4>About Us</h4>
                    <img src="images/home-1.jpg" class="img-polaroid" style="margin:5px 0px 15px;" alt="">                
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.  <br /></p>
					<p><a class="btn btn-primary" style="margin:5px 0px 15px;">Learn more</a></p>
                    </div>
					
                    <div class="span4">                
                    <h4>Our Passion</h4>
                    <img src="images/home-2.jpg" class="img-polaroid" style="margin:5px 0px 15px;" alt="">  
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.   <br /></p>
					<p><a class="btn btn-primary" style="margin:5px 0px 15px;">Learn more</a></p>
                    </div>
					
                    <div class="span4">                
                    <h4>Special Events</h4>
                    <img src="images/home-3.jpg" class="img-polaroid" style="margin:5px 0px 15px;" alt="">  
                    <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.   <br /></p>
					<p><a class="btn btn-primary" style="margin:5px 0px 15px;">Learn more</a></p>
                    </div>
					
			    </div>
				
				    <hr style="margin:45px 0 35px" />

                    <div class="lead">
                        <h1>Lorem ipsum dolor sit amet.</h1> 
                        <h3>Vivamus leo ante, consectetur sit amet vulputate vel, dapibus sit amet lectus.</h3>
                    </div>
                    <br />

                    <div class="list_carousel responsive">
                        <ul id="list_photos">
                            <li><img src="carousal/muffin.jpg" class="img-polaroid">  </li>
                            <li><img src="carousal/strawberries.jpg" class="img-polaroid">  </li>
                            <li><img src="carousal/cheesecake.jpg" class="img-polaroid">  </li>
                            <li><img src="carousal/peppers.jpg" class="img-polaroid">  </li>
                            <li><img src="carousal/pomengranates.jpg" class="img-polaroid">  </li>
                            <li><img src="carousal/refreshment.jpg" class="img-polaroid">  </li>
                            <li><img src="carousal/kitchen.jpg" class="img-polaroid">  </li>
                            <li><img src="carousal/soup.jpg" class="img-polaroid">  </li>                            
                        </ul>
                    </div> 
					
					</br>
					
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer eu metus risus. Mauris a facilisis justo, sit amet ornare lorem. In volutpat laoreet nisi, ac tempus dui convallis eget. Ut id lorem at leo suscipit dignissim. Donec eleifend porta sagittis. Aliquam at ullamcorper sem, et commodo quam.</p></br>
					<!--Edit Blockquote here-->
					<blockquote>
					
                    <h3 class="text-success">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer posuere erat a ante.</h3>
                    <small>Someone famous <cite title="Source Title">Source Title</cite></small>
					
                    </blockquote>
					<!--/End Blockquote-->	
					<p>Aenean vulputate magna ipsum, vitae elementum tortor aliquam eu. Nullam rutrum erat eu purus cursus, a volutpat orci lacinia. Sed sed sem mollis, egestas tellus vel, posuere sapien. Sed at ipsum ullamcorper, ultrices elit at, accumsan nulla. Suspendisse lobortis neque ac diam vehicula, gravida commodo sem adipiscing. Quisque nec libero nibh.</p>
                    				
                   

                </div>

            </div>
			<!--End Main Content Area here-->

        <div id="footerInnerSeparator"></div>
    </div>

</div>

<div id="footerOuterSeparator"></div>

<div id="divFooter" class="footerArea">

    <div class="container">

        <div class="divPanel">

            <div class="row-fluid">
                <div class="span6" id="footerArea1">
                
                    <h3>關於我</h3>

                    <p>Belly Worry 希望幫助每個為卡路里煩腦的人，輕鬆做好個人卡路里控制，並且提供您良好的介面：查詢運動景點、健康知識等相關情報，讓你天天擁有美好的健康生活。</p>
                    
                    <p> 
                        <a href="#" title="Terms of Use">開始使用</a><br />
                        <a href="#" title="FAQ">常見問題</a><br />
                        <a href="#" title="Sitemap">網站地圖</a>
                    </p>

                </div>
                
                <div class="span6" id="footerArea2">

                    <h3>聯絡我們</h3>  
                                                               
                    <ul id="contact-info">
                    <li>                                    
                        <i class="general foundicon-phone icon"></i>
                        <span class="field">電話:</span>
                        <br />
                        (02) 6631 6666 / 6631 6667                                                                      
                    </li>
                    <li>
                        <i class="general foundicon-mail icon"></i>
                        <span class="field">Email:</span>
                        <br />
                        <a href="mailto:EEIT80hahaha@gmail.com" title="Email">BellyWorry@gmail.com</a>
                    </li>
                    <li>
                        <i class="general foundicon-home icon" style="margin-bottom:50px"></i>
                        <span class="field">地址:</span>
                        <br />
                        台北市大安區復興南路一段390號2樓201室
                    </li>
                    </ul>

                </div>
            </div>

            <br /><br />
            <div class="row-fluid">
                <div class="span12">
                    <p class="copyright">
                        Copyright © 2015 Belly Worry. All Rights Reserved.
                    </p>

                    <p class="social_bookmarks">
                        <a href="#"><i class="social foundicon-facebook"></i> Facebook</a>
			<a href=""><i class="social foundicon-twitter"></i> Twitter</a>
			<a href="#"><i class="social foundicon-pinterest"></i> Pinterest</a>
			<a href="#"><i class="social foundicon-rss"></i> Rss</a>
                    </p>
                </div>
            </div>
            <br />

        </div>

    </div>
    
</div>

<!-- <script src="scripts/jquery.min.js" type="text/javascript"></script>  -->
<script src="scripts/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="scripts/default.js" type="text/javascript"></script>


<script src="scripts/carousel/jquery.carouFredSel-6.2.0-packed.js" type="text/javascript"></script>
<script type="text/javascript">$('#list_photos').carouFredSel({ responsive: true, width: '100%', scroll: 2, items: {width: 320,visible: {min: 2, max: 6}} });</script>
<script src="scripts/camera/scripts/camera.min.js" type="text/javascript"></script>
<script src="scripts/easing/jquery.easing.1.3.js" type="text/javascript"></script>
<script type="text/javascript">function startCamera() {$('#camera_wrap').camera({ fx: 'scrollLeft', time: 2000, loader: 'none', playPause: false, navigation: true, height: '65%', pagination: true });}$(function(){startCamera()});</script>


</body>
</html>