<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Your Name Here - Simple</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

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


    <link href="http://fonts.googleapis.com/css?family=Allura" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Aldrich" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Pacifico" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Palatino+Linotype" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Calligraffitti" rel="stylesheet" type="text/css">

    <link href="styles/custom.css" rel="stylesheet" type="text/css" />
    <style>
		#map {
			height: 700px;
		}

		#info {
			display: none;			
	    }

		
    </style>
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
                    <div class="navbar">
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
                                        <li><a href="gallery.html">相片流</a></li>
                                        <li><a href="contact.html">與我聯絡(表單)</a></li>
                                        <li><a href="page.html">元件庫</a></li>
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
                                <li class="dropdown"><a href="gallery.html">健康管理</a></li>
                                <li class="dropdown active" >
                                    <a href="page.html" class="dropdown-toggle">運動趣<b class="caret"></b></a>
                                    <ul class="dropdown-menu">
                                        <li><a href="full.html">YouBike路線規劃</a></li>
                                        <li><a href="fun/healthView.controller">健康景點查詢</a></li>
                                    </ul>
                                </li>
                                <li class="dropdown"><a href="about.html">活動情報</a></li>
                                <li class="dropdown"><a href="gallery.html">英雄事蹟</a></li>
                                <li class="dropdown"><a href="about.html">小學堂</a></li>
                                <li class="dropdown"><a href="contact.html" id="dropdown-my">會員登入</a></li>
                            </ul>
                        </div>
                    </div>
                    </div>

                </div>
            </div>
        </div>

    </div>
</div>

<div id="contentOuterSeparator"></div>

<div class="container">

    <div class="divPanel page-content">

        <div class="breadcrumbs">
                <a href="index.html">首頁</a> &nbsp;/&nbsp; <span>健康景點查詢</span>
            </div> 
        <!--Edit Main Content Area here-->
        <div class="row-fluid">
                <div class="span8" id="divMain">

                    <h1>健康景點查詢</h1>
					<p>
                                             
							
<!--                     <img src="images/fingerfood-main.jpg" class="img-polaroid" style="margin:12px 0px;">  </p>     -->
                                                     
                    <div id="map"></div>

                </div>
				<!--Edit Sidebar Content Area here-->
                <div class="span4 sidebar">

                    <div class="sidebox">
                        <h3 class="sidebox-title">健康景點查詢</h3>
                        <div class="row-fluid">
							<input class="span12" id="pac-input" class="controls" type="text"
			placeholder="輸入出發地，例如：台北車站">
						</div>
						<div class="row-fluid">
							<p class="span12">景點類型
								<select class="span12" id="viewClass">
<%-- 								  <c:forEach var="row" items="${viewClass}"> --%>
<%-- 									<option value="${row.viewClassNo}">${row.name}</option> --%>
<%-- 								  </c:forEach> --%>
									
								</select>
							</p>
						</div>
						<div class="row-fluid">
							<p class="span12">景點選擇
								<select class="span12" multiple="multiple" id="healthview">
<!-- 								  <option>土城運動中心</option> -->
<!-- 								  <option>板橋運動中心</option> -->
<!-- 								  <option>樹林活動中心</option> -->
								</select>
							</p>
						</div>
				        <div class="row-fluid" id="info">
				        <hr>
				        		<div class="span12">
				        			<p>Total Distance: <span id="total"></span></p>
				        		</div>
						        <div id="directionsPanel" class="span12"></div>
						</div>		 

<!-- 				        <div class="row-fluid">		 -->
<!-- 						        <div class="span4">                            -->
<!-- 				                    <img src="images/placeholder.gif" class="img-polaroid" style="margin:5px 0px 15px;" alt="">   </div>           -->
<!-- 				                <div class="span8">             -->
<!-- 				                    <p>Lorem ipsum dolor sit amet, consectetuera dipiscing elied diam nonummy nibh euisod tincidunt ut laoreet dolore magna aliquam erat. <a href="#">Read More</a> </p> -->
<!-- 				                </div>		  -->
<!-- 				        </div>	 -->
	
                    </div>
                    
                </div>
				<!--End Sidebar Area here-->
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

<script src="scripts/jquery.min.js" type="text/javascript"></script> 
<script src="scripts/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="scripts/default.js" type="text/javascript"></script>

<script>
	(function($) {
		$("#viewClass").on('change', function() {
			getViews($(this).val());
		});
		$.ajax({
			"type" : "get",
			"url" : "services/viewclass",
			"dataType" : "json",
			"success" : function(data) {
				$.each(data, function() {
					var val = this.viewClassNo;
					var name = this.name;
					$("#viewClass")
							.append(
									"<option value='"+val+"'>" + name
											+ "</option>");
				});
				getViews($("#viewClass").val());
			}
		})

		function getViews(value) {
			$("#healthview").empty();
			$.ajax({
				"type" : "get",
				"url" : "services/healthview/" + value,
				"dataType" : "json",
				"success" : function(data) {
					$.each(data, function() {
						var val = this.no;
						var name = this.name;
						$("#healthview").append(
	//								"<option value='{lat:"+this.lat+", lng:"+this.lng+"}'>"
								"<option value='"+this.lat+","+this.lng+"'>"
										+ name + "</option>");

					});
				}
			})
		}
	})(jQuery);
</script>


<script>
	var start = null;
	var end = null;
	var start_test;
	var end_test;
	var map = null;
	var markers = [];
	var directionsService;
	var directionsDisplay;

	function initMap() {
		var start_test = new google.maps.LatLng(25.046112,121.517267);
		var end_test = new google.maps.LatLng(25.0332663,121.5439115);
		
		map = new google.maps.Map(document.getElementById('map'), {
			center : {
				lat : 25.0332663,
				lng : 121.5439115
			},
			zoom : 9
		});
		var input = document.getElementById('pac-input');

		var searchBox = new google.maps.places.SearchBox(input);
// 		map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

		directionsService = new google.maps.DirectionsService;	//路線規劃服務
		directionsDisplay = new google.maps.DirectionsRenderer({
			draggable: true,
			map: map,
			panel: document.getElementById('directionsPanel')
		});
		
		directionsDisplay.addListener('directions_changed', function() {	//挪動路線就重新計算距離
			computeTotalDistance(directionsDisplay.getDirections());
		});
		
		// Bias the SearchBox results towards current map's viewport.
		map.addListener('bounds_changed', function() {
			searchBox.setBounds(map.getBounds());
		});

		markers = [];
		// [START region_getplaces]
		// Listen for the event fired when the user selects a prediction and retrieve
		// more details for that place.
		searchBox.addListener('places_changed', function() {
			var places = searchBox.getPlaces();
			if (places.length == 0) {
				return;
			}
			start = places[0].geometry.location;
			if (end == null) {
				setStartMap(markers, places);
			} else {
				clearMarker();
				displayRoute(start, end, directionsService, directionsDisplay);
			}
		});
		document.getElementById('healthview').addEventListener('change', function() {
			var name = this.options[this.selectedIndex].text;
			var lat1 = this.value.split(",")[0];
			var lng1 = this.value.split(",")[1];
			end = new google.maps.LatLng(lat1, lng1);
			if (start == null) {
				setEndMap(name,end);
			} else {
				clearMarker();
				displayRoute(start, end, directionsService, directionsDisplay);
			}
		});
		//	displayRoute(start_test, end_test, directionsService, directionsDisplay);
	}
	var setStartMap = function(markers, places) {
		clearMarker();

		// For each place, get the icon, name and location.
		var bounds = new google.maps.LatLngBounds();
		places.forEach(function(place) {
			//var icon = {
			//	url : place.icon,
			//	size : new google.maps.Size(71, 71),
			//	origin : new google.maps.Point(0, 0),
			//	anchor : new google.maps.Point(17, 34),
			//	scaledSize : new google.maps.Size(25, 25)
			//};
			//
			////Create a marker for each place.
			//markers.push(new google.maps.Marker({
			//	map : map,
			//	icon : icon,
			//	title : place.name,
			//	position : place.geometry.location
			//}));
			addMarker(place.geometry.location);

			if (place.geometry.viewport) {
				// Only geocodes have viewport.
				bounds.union(place.geometry.viewport);
			} else {
				bounds.extend(place.geometry.location);
			}
		});
		map.fitBounds(bounds);
	}
	var setEndMap = function(name,point) {
			clearMarker();
			
		map.setCenter(point);
		map.setZoom(15);
		markers = [];
		addMarker(point);
	}
	function addMarker(location) {
		var marker = new google.maps.Marker({
			position : location,
			map : map,
			animation : google.maps.Animation.BOUNCE
		});
		markers.push(marker);
	}
	function clearMarker() {
		// Clear out the old markers.
		markers.forEach(function(marker) {
			marker.setMap(null);
		});
		markers = [];
	}
	function displayRoute(origin, destination, service, display) {
		document.getElementById("info").style.display="block";
		service.route({
			origin: origin,
			destination: destination,
		//		waypoints: [{location: 'Cocklebiddy, WA'}, {location: 'Broken Hill, NSW'}],		//中間道路陣列
			travelMode: google.maps.TravelMode.DRIVING,
			avoidTolls: true,	//避開收費道路
			avoidHighways:true	//避開高速公路
		}, function(response, status) {
			if (status === google.maps.DirectionsStatus.OK) {
				display.setDirections(response);
			} else {
				alert('Could not display directions due to: ' + status);
			}
		});
	}

	function computeTotalDistance(result) {
		var total = 0;
		var myroute = result.routes[0];
		for (var i = 0; i < myroute.legs.length; i++) {			// legs 似乎是總路線的步驟數
			total += myroute.legs[i].distance.value;				//	distance.value 距離
		}
		total = total / 1000;
		document.getElementById('total').innerHTML = total + ' km';
	}
	
</script>
<script
	src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA558ZIHYucpFnkLnuKFxdAqdRnz4H92io&signed_in=true&libraries=places&callback=initMap"
	async defer></script>


</body>
</html>