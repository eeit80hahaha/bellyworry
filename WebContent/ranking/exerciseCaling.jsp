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
<title>exerciseCal</title>
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
<p>日期: <input type="text" id="datepicker"></p>
<div>
<table border=1 width=23% id="table1">



<c:forEach var="vo1" items="${ExerciseNo}" varStatus="varStatus">
	<tr>
		<td>
		<p>${vo1.name}&nbsp;&nbsp;消耗熱量<span>${vo1.calHour}</span></p>
			<form action="${pageContext.request.contextPath}/ranking/ExerciseCalSessionServlect" method="GET">
<!-- 				<select >					 -->
<!-- 					<option value="運動">運動</option> -->
<!-- 				</select>								 -->
				<Input type='hidden' name='exerciseNo' value='${vo1.exerciseNo}'><P/>			<!--exerciseNo-->				
				<Input type='hidden' name='name' value='${vo1.name}'><P/>			<!--name-->				
				<Input type='hidden' name='calHour' value='${vo1.calHour}'><P/>	<!--page-->				
				<Input type='submit' name="execrisecalion" value='加入'>
				<Input type='submit' name="execrisecalion" value='清除'>
			</form>
<%-- 		<div class="tt">運動:<span>${vo1.name}</span> 每小時消耗熱量<span>${vo1.calHour}</span></div> --%>
		</td>
	</tr>
</c:forEach>
</table>
</div>
       <div>
		<H3 class="textArea5"></H3>
		<form ><textarea class="for4" cols=40 rows=4  id="textArea14" ></textarea></form><br>
		<input type="submit" name="write" value="保存紀錄">
		<h1 id="Totalcals"></h1>	
		</div>
</body>
</html>