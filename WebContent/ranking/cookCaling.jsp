<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.4/jquery.min.js"></script>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#datepicker" ).datepicker({
      showWeek: true,
      firstDay: 1
    });
  });
</script>
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
/*  .for1 {  */
/*  		position:relative; top:20px; left:20px; */
/*  		; */
/*  }	 */
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
<p>日期: <input type="text" id="datepicker"></p>
<div>
<table border=1 width=23% id="table1">



<c:forEach var="vo" items="${PagesFoodCalVO1.foodCalpage}" varStatus="varStatus">
	<tr>
		<td>
		<p>${vo.name}</p>
		<img class="test" src="data:image/jpg;base64,${vo.picture1}"/>
<%-- 			<form action="<c:url value='FoodCalSessionServlect' />" method="GET"> --%>
			<form action="${pageContext.request.contextPath}/ranking/FoodCalSessionServlect" method="GET">
				<select name="time">													<!--time-->
					<option value="早上">早餐 </option>
					<option value="午餐">中餐 </option>
					<option value="晚餐">晚餐 </option>	
				</select>
				<input type="text" name="count" value="" />${errors.count}<P/>										<!--count-->

				<Input type='hidden' name='foodNo' value='${vo.foodNo}'><P/>			<!--foodNo-->
				<Input type='hidden' name='name' value='${vo.name}'><P/>				<!--name-->
				<Input type='hidden' name='cal' value='${vo.cal}'><P/>					<!--cal-->
				
				<Input type='hidden' name='page' value='${PagesFoodCalVO1.pageNo}'><P/>	<!--page-->
				
				<Input type='submit' name="prodaction" value='加入'>
				<Input type='submit' name="prodaction" value='清除'>
			</form>
		<div class="tt">熱量:<span>${vo.cal}</span> 每份公克數<span>${vo.weight}</span></div>
		</td>
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
<div id="paging">
<!-- 以下為控制第一頁、前一頁、下一頁、最末頁 等超連結-->
<table border="0">
  <tr>
    <td width='76'>
        <c:if test="${PagesFoodCalVO1.pageNo > 1}">
           <div id="pfirst">
              <a href="<c:url value='/ranking/foodCal.controller?pageNo=1' />">第一頁</a>&nbsp;&nbsp;&nbsp;
           </div>
        </c:if>
     </td>
     <td width='76'>
        <c:if test="${PagesFoodCalVO1.pageNo > 1}">
           <div id="pprev">
              <a href="<c:url value='/ranking/foodCal.controller?pageNo=${PagesFoodCalVO1.pageNo-1}' />">上一頁</a>&nbsp;&nbsp;&nbsp;
           </div>
        </c:if>  
     </td>
     <td width='76'>
            <c:if test="${PagesFoodCalVO1.pageNo != PagesFoodCalVO1.totalPages}">
                <div id="pnext">
                   <a href="<c:url value='/ranking/foodCal.controller?pageNo=${PagesFoodCalVO1.pageNo+1}' />">下一頁</a>&nbsp;&nbsp;&nbsp;
                </div>
            </c:if>
     </td>  
     <td width='76'>
            <c:if test="${PagesFoodCalVO1.pageNo != PagesFoodCalVO1.totalPages}">
                <div id="plast">
                    <a href="<c:url value='/ranking/foodCal.controller?pageNo=${PagesFoodCalVO1.totalPages}' />">最末頁</a>&nbsp;&nbsp;&nbsp;
                </div>
            </c:if>
     </td>
     <td width='176' align="center">
           第${PagesFoodCalVO1.pageNo}頁 / 共${PagesFoodCalVO1.totalPages}頁
     </td>  
</tr>
</table>
</div>
			<!-- 測試點 -->
早餐紀錄<br/>
${eatBreakfast}<br/>
午餐紀錄<br/>
${eatLunch}<br/>
晚餐紀錄<br/>
${eatDinner}<br/>
<hr/>
錯誤訊息:
${errors.count}
${errors.eatr}
<hr/>

<%-- ${errors}<br/>	 --%>
 

<!--        <div> -->
<!-- 		<H3 class="textArea2"></H3> -->
<!-- 		<form ><textarea class="for1" cols=40 rows=4  id="textArea11" ></textarea></form><br> -->
<!-- 		<H3 class="textArea3"></H3> -->
<!-- 		<form ><textarea class="for2" cols=40 rows=4  id="textArea12" ></textarea></form><br> -->
<!-- 		<H3 class="textArea4"></H3> -->
<!-- 		<form ><textarea class="for3" cols=40 rows=4  id="textArea13" ></textarea></form><br> -->
<!-- 		<H3 class="textArea5"></H3> -->
<!--  		<form ><textarea class="for4" cols=40 rows=4  id="textArea14" ></textarea></form><br>  -->
<!-- 		<input type="submit" name="write" value="保存紀錄"> -->
<!-- 		<h1 id="Totalcals"></h1>	 -->
<!-- 		</div> -->
	
${login}			
<c:if test="${login == 600 }">
	<input type="button" value="text">
</c:if>			
			

<script type="text/javascript">

//  var list = new Array();

//  var cals = 0;
	
//   $(function(){

// 				var obj = new Object;	//陣列的一筆紀錄
// 				obj.time=$("#time").val(); 
// 				obj.name=$(this).next().next().children("span:eq(0)").text();	//欄位name
// 				obj.cal=$(this).next().next().children("span:eq(1)").text();	//欄位cal
// 				obj.count=$(this).next().next().children("span:eq(2)").text();	//欄位count
// 				obj.foodNo=$(this).next().next().attr("name");	//欄位foodNo
// 				console.log(obj.foodNo);
// 				list = list.concat(obj);	//把紀錄放到陣列內
				
				
// 				Totalcals = 0; //歸零
// 				cals1 = 0;
// 				cals2 = 0;
// 				cals3 = 0;
				
// 				$("#textArea11").empty();	//清空文字欄位(和陣列無關)
// 				$("#textArea12").empty();	//清空文字欄位(和陣列無關)
// 				$("#textArea13").empty();	//清空文字欄位(和陣列無關)
// 				$.each(list,function(index,value){	//foreach 迴圈
// 					Totalcals = (parseFloat(value.cal * value.count) + (Totalcals*100))/100; //計算cal * count
					
// 					if(value.time==1) {
// 						cals1 = (parseFloat(value.cal * value.count) + (cals1*100))/100; //計算cal * count
// 						$("#textArea11").append(value.name+" "+value.cal+" "+value.count+"\n");	//把陣列每一筆記錄印到文字欄位
// 						$(".textArea2").empty().append("早餐熱量"+cals1);					
// 					}else if(value.time==2){
// 						cals2 = (parseFloat(value.cal * value.count) + (cals2*100))/100; //計算cal * count
// 						$("#textArea12").append(value.name+" "+value.cal+" "+value.count+"\n");	 //把陣列每一筆記錄印到文字欄位
// 						$(".textArea3").empty().append("午餐熱量"+cals2);
// 					}else if(value.time==3){
// 						cals3 = (parseFloat(value.cal * value.count) + (cals3*100))/100;  //計算cal * count
// 						$("#textArea13").append(value.name+" "+value.cal+" "+value.count+"\n");	//把陣列每一筆記錄印到文字欄位
// 						$(".textArea4").empty().append("晚餐熱量"+cals3);
// 					}
// 				})							
// 				console.log(Totalcals);
// 				Totalcals
// 				$("#Totalcals").empty().append("總熱量"+Totalcals);
				
// 		  })
// 	  })
</script>
</body>
</html>