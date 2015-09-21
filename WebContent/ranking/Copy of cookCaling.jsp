<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>cookCal</title>
<style>
 .test {
        width:70%; 
		border:#000 solid 1px;
     } 
 .tt {  
 		text-align:left
 		;
 } 
 .for1 { 
 		position:relative; top:20px; left:20px;
 		;
 }	
</style>
</head>
<body>
<%-- 菜色編號:${foodNo[0].foodNo}<br> --%>
<%-- 菜色:${foodNo[0].name}<br> --%>
<%-- 一般份量:${foodNo[0].count}<br> --%>
<%-- 菜色分類:${foodNo[0].menuNo}<br> --%>
<%-- 熱量:${foodNo[0].cal}<br> --%>
<%-- 每份公克數:${foodNo[0].weight}<br> --%>
<%-- 食譜編號:${foodNo[0].cookNo}<br> --%>
<%-- 小照片:${foodNo[0].picture}<br> --%>

<%-- from:${foodNo}<br> --%>
<%-- from:${exerciseNo} --%>


<!-- <button  id="btn02">選擇</button> -->
<!-- <p class="tt" id="aaa">000</p> -->
<!-- <button onclick="document.getElementById('field2').value= document.getElementById('aaa').getAttribute('value')" id="btn01">111</button> -->

            <ul class="nav nav-tabs">
                <li class="active"><a href="#textArea1" data-toggle="tab">早餐</a></li>
                <li><a href="#profile" data-toggle="tab">中餐</a></li>
                <li><a href="#settings" data-toggle="tab">晚餐</a></li>
                <li><a href="#settings1" data-toggle="tab">運動</a></li>
            </ul>
<div>
<table border=1 width=23% id="table1">

<c:forEach var="vo" items="${foodNo}" varStatus="varStatus">
<c:set var="isItem" value="${varStatus.count}"/>

	<tr>
		<td><img class="test" src="data:image/jpg;base64,${vo.picture1}"/>
<%-- 			<button onclick="document.getElementById('field2').value= document.getElementsById('field1').value" id="btn${isItem}">選擇</button><br> --%>
			<button  id="btn${isItem}">選擇</button><br>
<%-- 		<div class="tt" id="field${isItem}">${vo.name} 熱量:${vo.cal} 每份公克數${vo.weight}</div> --%>
		<div class="tt" id="field${isItem}"><span>${vo.name}</span> 熱量:<span>${vo.cal}</span> 每份公克數<span>${vo.weight}</span></div>
	</tr>
<%-- 		<p>菜色編號${vo.foodNo}</p> --%>
<%-- 		<p>菜色${vo.name}</p> --%>
<%-- 		<p>一般份量${vo.count}</p> --%>
<%-- 		<p>菜色分類${vo.menuNo}</p> --%>
<%-- 		<p>熱量:${vo.cal}</p> --%>
<%-- 		<p>每份公克數${vo.weight}</p> --%>
<%-- 		<p>食譜編號${vo.cookNo}</p> --%>
</c:forEach>
</table>
</div>
		<form ><textarea class="for1" cols=60 rows=6 name=textBlock id="textArea1" ></textarea></form><br>
				<H3 id="textArea2"></H3>
			

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript">
 var list = new Array();

 var cals = 0;
	
  $(function(){
	  
	  $("#table1").find("button").each(function(){  //find尋找所有button  
		  $(this).on("click",function(){
// 			  console.log($(this).next().next().text());
 			  var a = $(this).next().next().text();
//  			  console.log(a);
//  			  console.log($("#textArea1").html());
//  			  console.log($("#textArea1").val());

				var obj = new Object;	//陣列的一筆紀錄
				obj.name=$(this).next().next().children("span:eq(0)").text();	//欄位name
				obj.cal=$(this).next().next().children("span:eq(1)").text();	//欄位cal
				obj.count=$(this).next().next().children("span:eq(2)").text();	//欄位count
				
// 				console.log(obj);
				list = list.concat(obj);	//把紀錄放到陣列內
				
				
				cals = 0; //歸零
				
				$("#textArea1").empty();	//清空文字欄位(和陣列無關)
				$.each(list,function(index,value){	//foreach 迴圈
// 					console.log(value.val);
					cals = (parseFloat(value.cal * value.count) + (cals*100))/100; //計算cal * count
					$("#textArea1").append(value.name+" "+value.cal+" "+value.count+"\n");	//把陣列每一筆記錄印到文字欄位
				})							
				console.log(cals);
				$("#textArea2").empty().append(cals);
	  
// 			  $("#textArea1").append(a+"\n");
				
		  })
	  })
	    
//  	 $("#btn01").on("click",function(){
//  		 $(this).data("stored",$("#field1").text());
//  	 })
 	
 	 $("#field2").on("click",function(){
 		 var str = $("#btn01").data("stored");
 		 alert(str);
 	 })
 
  })

  
  
 
 
</script>
</body>
</html>