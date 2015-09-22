<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <title>YouBike路線規劃</title>
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

		#info,#startDiv,#endDiv{
			display: none;			
	    }

#panel {
  position: absolute;
  top: 10px;
  left: 25%;
  z-index: 5;
  background-color: #fff;
  padding: 5px;
  border: 1px solid #999;
  text-align: center;
}

#panel, .panel {
  font-family: 'Roboto','sans-serif';
  line-height: 30px;
  padding-left: 10px;
}

#panel select, #panel input, .panel select, .panel input {
  font-size: 15px;
}

#panel select, .panel select {
  width: 100%;
}

#panel i, .panel i {
  font-size: 12px;
}

      .panel {
        height: 100%;
		overflow: auto;
      }


		
    </style>
</head>
<body id="pageBody">
<c:set var="funcName" value="FUN" scope="session"/>
<jsp:include page="/page/header.jsp"/>

<div id="contentOuterSeparator"></div>

<div class="container">

    <div class="divPanel page-content">

        <div class="breadcrumbs">
			<a href="index.jsp">首頁</a> &nbsp;/&nbsp; <span>YouBike路線規劃</span>
		</div> 
        <!--Edit Main Content Area here-->
        <div class="row-fluid">
			<div class="span8" id="divMain">
				<h1>YouBike路線規劃</h1>
				<div class="row-fluid">
					<div class="span6"><p>出發地：<input type="text" class="input-large" placeholder="出發地位置" style="width:80%" id="inputStart"></p></div>
					<div class="span6"><p>目的地：<input type="text" class="input-large" placeholder="目的地位置"  style="width:80%" id="inputEnd"></p></div>
				</div>
				<div id="map"></div>
			</div>
				<!--Edit Sidebar Content Area here-->
                <div class="span4 sidebar">

                    <div class="sidebox">
                        <h3 class="sidebox-title">YouBike 站點資訊</h3>
						<div class="row-fluid" id="initInfo">
							<p class="span12">請先於左側輸入出發地、目的地</p>
						</div>
						<div class="row-fluid" id="startDiv">
							<p class="span12">選擇出發地周邊站點
								<select class="span12" multiple="multiple" id="startSelect">
									
								</select>
							</p>
						</div>
						<div class="row-fluid" id="endDiv">
							<p class="span12">選擇目的地周邊站點
								<select class="span12" multiple="multiple" id="endSelect">
									
								</select>
							</p>
						</div>
				        <div class="row-fluid" id="info">
				        <hr>
<!-- 				        		<div class="span12"> -->
<!-- 				        			<p>Total Distance: <span id="total"></span></p> -->
<!-- 				        		</div> -->
<!-- 						        <div id="directionsPanel" class="panel" style="float:right;height:350px"></div> -->
							
						</div>		 


	
                    </div>
                    
                </div>
				<!--End Sidebar Area here-->
            </div>
			<!--End Main Content Area here-->

        <div id="footerInnerSeparator"></div>
    </div>

</div>

<div id="footerOuterSeparator"></div>

<jsp:include page="/page/footer.jsp"/>

<script src="scripts/jquery.min.js" type="text/javascript"></script> 
<script src="scripts/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="scripts/default.js" type="text/javascript"></script>
<script src="map/maker.js" type="text/javascript"></script>
<script>
		var start = null;
		var startName = null;
		var end = null;
		var endName = null;
		var startStation = null;
		var startStationName = null;
		var endStation = null;
		var endStationName = null;
		
		var map = null;
		var markers = [];
		var directionsService;
		var directionsDisplay;
		
		//初始化地圖
		function initMap() {
			map = new google.maps.Map(document.getElementById('map'), {
				center : {
					lat : 25.0332663,
					lng : 121.5439115
				},
				zoom : 9
			});
			
			var inputStart = document.getElementById('inputStart');
			var inputEnd = document.getElementById('inputEnd');
			var searchStart = new google.maps.places.SearchBox(inputStart);
			var searchEnd = new google.maps.places.SearchBox(inputEnd);
// 			map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

			directionsService = new google.maps.DirectionsService;	//路線規劃服務
			directionsDisplay = new google.maps.DirectionsRenderer({
				draggable: true,
				map: map,
				panel: document.getElementById('directionsPanel'),
				suppressMarkers : true
			});
			directionsDisplay.addListener('directions_changed', function() {	//挪動路線就重新計算距離
				computeTotalDistance(directionsDisplay.getDirections());
			});

			// Bias the SearchBox results towards current map's viewport.
			map.addListener('bounds_changed', function() {
				searchStart.setBounds(map.getBounds());
				searchEnd.setBounds(map.getBounds());
			});

			markers = [];
			// [START region_getplaces]
			// Listen for the event fired when the user selects a prediction and retrieve
			// more details for that place.
			
			//事件監聽，起點變更執行
			searchStart.addListener('places_changed', function() {
				startStation = null;
				startStationName = null;
				start = searchStart.getPlaces();
				startName = inputStart.value;
				if (start.length == 0) {
					return;
				}
				var startSel = document.getElementById('startSelect');
				temp(start[0].geometry.location,startSel);
				if (end == null) {
					setStartMap(markers, start);
				} else {
					displayRoute(start[0].geometry.location, end[0].geometry.location,
							directionsService, directionsDisplay);
				}
			});
			//事件監聽，終點變更執行
			searchEnd.addListener('places_changed', function() {
				endStation = null;
				endStationName = null;
				end = searchEnd.getPlaces();
				endName = inputEnd.value;
				if (end.length == 0) {
					return;
				}
				var endSel = document.getElementById('endSelect');
				temp(end[0].geometry.location,endSel);
				if (start == null) {
					setStartMap(markers, end);
				} else {
					displayRoute(start[0].geometry.location, end[0].geometry.location,
							directionsService, directionsDisplay);
				}
			});
			document.getElementById('startSelect').addEventListener('change', function() {
				startStationName = this.options[this.selectedIndex].text;
				var lat1 = this.value.split(",")[0];
				var lng1 = this.value.split(",")[1];
				startStation = new google.maps.LatLng(lat1, lng1);
				displayRoute(start[0].geometry.location, end[0].geometry.location,
						directionsService, directionsDisplay);
			});
			document.getElementById('endSelect').addEventListener('change', function() {
				endStationName = this.options[this.selectedIndex].text;
				var lat1 = this.value.split(",")[0];
				var lng1 = this.value.split(",")[1];
				endStation = new google.maps.LatLng(lat1, lng1);
				displayRoute(start[0].geometry.location, end[0].geometry.location,
						directionsService, directionsDisplay);
			});
		}
		//建立單點MAP
		var setStartMap = function(markers, places) {
			// Clear out the old markers.
			markers.forEach(function(marker) {
				marker.setMap(null);
			});
			markers = [];

			// For each place, get the icon, name and location.
			var bounds = new google.maps.LatLngBounds();
// 			places.forEach(function(place) {
			var place = places[0];
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
// 			});
			map.fitBounds(bounds);
		}
		var setEndMap = function(name,point) {
// 			markers.forEach(function(marker) {
// 				marker.setMap(null);
// 			});
// 			markers = [];
			
			end = point;
			map.setCenter(point);
			map.setZoom(15);
			markers = [];
			addMarker(point);
		}
		function addMarker(location) {
			var marker = new google.maps.Marker({
				position : location,
				map : map,
// 				animation : google.maps.Animation.BOUNCE
				animation : google.maps.Animation.DROP
			});
			markers.push(marker);
		}
		//get the point-to-point length
		function distHaversine(p1, p2) {
            var rad = function (x) { return x * Math.PI / 180; }
            var R = 6371; // earth's mean radius in km
            var dLat = rad(p2.lat() - p1.lat());
            var dLong = rad(p2.lng() - p1.lng());

            var a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                    Math.cos(rad(p1.lat())) * Math.cos(rad(p2.lat()))
                    * Math.sin(dLong / 2) * Math.sin(dLong / 2);
            var c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            var d = R * c;

            return parseFloat(d.toFixed(3));
        }
		
		//取得資料庫的所有站點，並且取出與目標點最近的5個點放進SELECT
		function temp(point,sel){
			//station data
			<jsp:useBean id="YouBike" class="fun.model.YouBikeService">
				var temp = ${YouBike.jsonDataFromFile}
			</jsp:useBean>
			var temp2 = temp.result.results;
			var stations = new Array;
			for(var i=0;i<temp2.length;i++)
			{
				var station = new Object;
				station.name = temp2[i].sna;
				station.lat = temp2[i].lat;
				station.lng = temp2[i].lng;
				stations = stations.concat(station);
			}
			
			var curLatLng = point;
			for (var i = 0; i < stations.length; i++) {
                var station = stations[i];
                station.distance = //計算兩個LatLng間的距離
                        distHaversine(new google.maps.LatLng(station.lat,station.lng), curLatLng);
            }
			stations.sort(function (a, b) {
                if (a.distance == b.distance) return 0;
                return (a.distance > b.distance) ? 1 : -1;
            });
			
// 			for (var i = 0; i < station.length; i++) {
			sel.innerHTML="";
			for (var i = 0; i < 5; i++) {
				var b = stations[i];
				var opt = document.createElement("option");
				opt.setAttribute("value",b.lat+","+b.lng)
				var txtOpt = document.createTextNode(b.name);
				opt.appendChild(txtOpt);
				sel.appendChild(opt);
			}
		}
		//清除所有Marker
		function clearMarker() {
			// Clear out the old markers.
			markers.forEach(function(marker) {
				marker.setMap(null);
			});
			markers = [];
		}
		//路線規劃
		function displayRoute(origin, destination, service, display) {
			document.getElementById("initInfo").style.display="none";
			document.getElementById("startDiv").style.display="block";
			document.getElementById("endDiv").style.display="block";
			clearMarker();

			var waypoints = [];
			if(startStation!=null && endStation!=null){
				waypoints = [{location:startStation},{location:endStation}];
			}else if(startStation==null && endStation!=null){
				waypoints = [{location:endStation}];
			}else if(startStation!=null && endStation==null){
				waypoints = [{location:startStation}];
			}
			service.route({
				origin: origin,
				destination: destination,
				waypoints: waypoints,		//中間道路陣列
// 				waypoints: [],	//中間道路陣列

				travelMode: google.maps.TravelMode.WALKING,
				avoidTolls: true,	//避開收費道路
				avoidHighways:true	//避開高速公路
			}, function(response, status) {
				if (status === google.maps.DirectionsStatus.OK) {
					display.setDirections(response);
					clearMarker();
					showSteps(response);
				} else {
					alert('Could not display directions due to: ' + status);
				}
			});
		}
		//計算距離
		function computeTotalDistance(result) {
			var total = 0;
			var myroute = result.routes[0];
			for (var i = 0; i < myroute.legs.length; i++) {			// legs 似乎是總路線的步驟數
				total += myroute.legs[i].distance.value;				//	distance.value 距離
			}
			total = total / 1000;
// 			document.getElementById('total').innerHTML = total + ' km';
			console.log(result);
// 			console.log(result.routes[0].legs[1].distance.value);	//兩個腳踏車站點距離;
			if(startStation!=null && endStation!=null){
				document.getElementById("info").style.display="block";
				document.getElementById('info').innerHTML = '<hr>約需騎乘自行車' + (result.routes[0].legs[1].distance.value)/17000*60 + '分鐘';
			}else{
				document.getElementById("info").style.display="none";
				document.getElementById('info').innerHTML = '<hr>';
			}
		}
		
		
		function showSteps(directionResult) {
			var myRoute = directionResult.routes[0];
			var pointName = new Array();
			if(myRoute.legs.length==1){
				pointName = [startName+"(起點)",endName+"(終點)"];
			}else if(myRoute.legs.length==2){
				if(startStationName==null){
					pointName = [startName+"(起點)",endStationName,endName+"(終點)"];
				}else{
					pointName = [startName+"(起點)",startStationName,endName+"(終點)"];
				}
			}else if(myRoute.legs.length==3){
				pointName = [startName+"(起點)",startStationName,endStationName,endName+"(終點)"];
			}
			for (var i = 0; i < myRoute.legs.length; i++) {
				var marker = new google.maps.Marker({
					position: myRoute.legs[i].steps[0].start_point, 
					map: map,
					icon: createMarkerIcon(pointName[i], {bgColor: "brown"}),
				});
				markers.push(marker);
			}
			var marker = new google.maps.Marker({
				position: myRoute.legs[i-1].steps[(myRoute.legs[i-1].steps.length-1)].end_point,
				map: map,
				icon: createMarkerIcon(pointName[myRoute.legs.length], {bgColor: "brown"})
			});
		}
//	 	function attachInstructionText(marker, text) {
//	 	    google.maps.event.addListener(marker, 'click', function() {
//	 	      // Open an info window when the marker is clicked on,
//	 	      // containing the text of the step.
//	 	      stepDisplay.setContent(text);
//	 	      stepDisplay.open(mapCanvas, marker);
//	 	    });
//	 	  }
		
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA558ZIHYucpFnkLnuKFxdAqdRnz4H92io&libraries=places&callback=initMap"
		async defer></script>

</body>
</html>