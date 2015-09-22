<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#map {
	height: 700px;
}

.controls {
	margin-top: 10px;
	border: 1px solid transparent;
	border-radius: 2px 0 0 2px;
	box-sizing: border-box;
	-moz-box-sizing: border-box;
	height: 32px;
	outline: none;
	box-shadow: 0 2px 6px rgba(0, 0, 0, 0.3);
}

#pac-input {
	background-color: #fff;
	font-family: Roboto;
	font-size: 15px;
	font-weight: 300;
	margin-left: 12px;
	padding: 0 11px 0 13px;
	text-overflow: ellipsis;
	width: 300px;
}

#pac-input:focus {
	border-color: #4d90fe;
}

.pac-container {
	font-family: Roboto;
}

#type-selector {
	color: #fff;
	background-color: #4d90fe;
	padding: 5px 11px 0px 11px;
}

#type-selector label {
	font-family: Roboto;
	font-size: 13px;
	font-weight: 300;
}
</style>
</head>
<body>
	<input id="inputStart" class="controls" type="text"
		placeholder="請在此輸入出發地，例如：台北車站">
	<input id="inputEnd" class="controls" type="text"
		placeholder="請在此輸入目的地，例如：西門町">

	<div class="row-fluid">
		<p class="span12">
			起點站 <select class="span12" multiple="multiple" id="startSelect"></select>
		</p>
	</div>
	<div class="row-fluid">
		<p class="span12">
			終點站 <select class="span12" multiple="multiple" id="endSelect"></select>
		</p>
	</div>
	<div id="map"></div>




	<script src="../scripts/jquery.min.js" type="text/javascript"></script>
	<script>
		var start = null;
		var end = null;
		var map = null;
		var markers = [];
		var directionsService;
		var directionsDisplay;
		var startStation = null;
		var endStation = null;
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
				panel: document.getElementById('directionsPanel')
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
				start = searchStart.getPlaces();
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
				end = searchEnd.getPlaces();
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
				var name = this.options[this.selectedIndex].text;
				var lat1 = this.value.split(",")[0];
				var lng1 = this.value.split(",")[1];
				startStation = new google.maps.LatLng(lat1, lng1);
				console.log(startStation);
				displayRoute(start[0].geometry.location, end[0].geometry.location,
						directionsService, directionsDisplay);
			});
			document.getElementById('endSelect').addEventListener('change', function() {
				var name = this.options[this.selectedIndex].text;
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
				animation : google.maps.Animation.BOUNCE
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
			clearMarker();
// 			document.getElementById("info").style.display="block";
			var waypoints = [];
			if(startStation!=null && endStation!=null){
				waypoints = [{location:startStation},{location:endStation}];
			}else if(startStation==null && endStation!=null){
				waypoints = [{location:endStation}];
			}else if(startStation!=null && endStation==null){
				waypoints = [{location:startStation}];
			}
			console.log(waypoints);
			service.route({
				origin: origin,
				destination: destination,
				waypoints: waypoints,		//中間道路陣列
// 				waypoints: [],	//中間道路陣列

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
		//計算距離
		function computeTotalDistance(result) {
			var total = 0;
			var myroute = result.routes[0];
			for (var i = 0; i < myroute.legs.length; i++) {			// legs 似乎是總路線的步驟數
				total += myroute.legs[i].distance.value;				//	distance.value 距離
			}
			total = total / 1000;
// 			document.getElementById('total').innerHTML = total + ' km';
			console.log(result.routes[0].legs[1].distance.value);	//兩個腳踏車站點距離;
// 			console.log(result.routes[0].legs[1].distance.value);
		}
		
	</script>
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA558ZIHYucpFnkLnuKFxdAqdRnz4H92io&libraries=places&callback=initMap"
		async defer></script>




	<!--   temp.addEventListener("change", function(){alert("0")}, false);	//關鍵 呼叫同一個方法判斷 -->

</body>
</html>