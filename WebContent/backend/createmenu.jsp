<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
@import url('styles/form.css');
</style>
<link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="//code.jquery.com/jquery-1.10.2.js"></script>
  <script src="//code.jquery.com/ui/1.11.4/jquery-ui.js"></script>
  <link rel="stylesheet" href="/resources/demos/style.css">
  <script>
  $(function() {
    $( "#tabs" ).tabs();
  });
  function add1(){
	  //$("#add").append("<input type=\"text\">");
// 	  int i=2;
	  $("#add1").append("<label class='title'>名稱:</label><input type='text' name='itemname'"+
				"size='15' autocomplete='off' required=''/> 類型:<input type='text' name='itemclass'"+ 
			"size='15' autocomplete='off' required='' /> 份量:<input type='text' name='itemweight'"+
			"size='15' autocomplete='off' required='' />");
//  	i=i+1;	 
  }
  function add2(){
	  //$("#add").append("<input type=\"text\">");
// 	  int i=2;
	  $("#add2").append("<br><label class=\"title\">作法"+":</label><input type=\"text\" name=\"weight\" size=\"20\" autocomplete=\"off\" required=\"\" />");
//  	i=i+1;	 
  }
//   function del(){
// 	  //$("#add").append("<input type=\"text\">");
// // 	  int i=2;
// 	  $("#add").remove("<label class=\"title\">作法"+":</label><input type=\"text\" name=\"weight\" size=\"20\" autocomplete=\"off\" required=\"\" />");
// //  	i=i+1;	 
//   }
  
  </script>
<title>Insert title here</title>
</head>
<body>
	<div id="tabs">
		<ul>
			<li><a href="#tabs-1">菜色管理</a></li>
			<li><a href="#tabs-2">套餐組合管理</a></li>
			<li><a href="#tabs-3">一日套餐組合</a></li>		
		</ul>
		<div id="tabs-1">
			<form action="">
				<div class="st1">
					<label class="title">菜色名稱:</label><input type="text"
						name="foodname" size="20" autocomplete="off" required="" />
				</div>
				<div class="st1">
					<label class="title">菜色分類:</label><select name="collection" >
						<option value="1">即食食品/零食類</option>
						<option value="2">新北市</option>
						<option value="3">桃園市</option>
						<option value="4">新竹縣</option>
					</select>
				</div>
				<div class="st1">
					<label class="title">熱量(cal):</label><input type="text" name="cal"
						size="20" autocomplete="off" required="" />
				</div>
				<div class="st1">
					<label class="title">份量單位:</label><input type="text" name="count"
						size="20" autocomplete="off" required="" />
				</div>
				<div class="st1">
					<label class="title">每份公克數:</label><input type="text" name="weight"
						size="20" autocomplete="off" required="" /> 
				</div>
				<div id="add1" class="st1">	
					食材:<br>		
					<label class="title">名稱:</label><input type="text" name="itemname"
						size="15" autocomplete="off" required="" /> 
					類型:<input type="text" name="itemclass" 
						size="15" autocomplete="off" required="" />
					份量:<input type="text" name="itemweight"
						size="15" autocomplete="off" required="" />&nbsp<input type="button"
						value="+" onclick="add1();" />
				</div>
				<div id="add2" class="st1">
					<label class="title">作法1:</label><input type="text" name="way"
						size="20" autocomplete="off" required="" />&nbsp<input type="button"
						value="+" onclick="add2();" /> &nbsp <input type="button"
						value="-" onclick="del();" />
				</div>
				<div class="st1">
					<label class="title">大圖片:</label><input type="file"
						name="PictureBig" multiple="" />
				</div>
				<div class="st1">
					<label class="title">小圖片:</label><input type="file"
						name="PictureSmall" multiple="" />
				</div>

				<div id="submit">
					<input type="submit" value="新增" /> <input type="submit" value="修改" />
					<input type="submit" value="查詢" /> <input type="reset" value="清除"
						onclick="abc();" />
				</div>
			</form>
		</div>

		<div id="tabs-2">
			<form action="">
				<div class="st1">
					<label class="title">套餐名稱:</label><input type="text"
						name="foodname" size="20" autocomplete="off" required="" />
				</div>
				<div class="st1">
					<label class="title">套餐名稱:</label><input type="text"
						name="foodname" size="20" autocomplete="off" required="" />
				</div>

				<div id="submit">
					<input type="submit" value="新增" /> <input type="submit" value="修改" />
					<input type="submit" value="查詢" /> <input type="reset" value="清除"
						onclick="abc();" />
				</div>
			</form>
		</div>

		<div id="tabs-3">
			<form>
				<div class="st1">
					<label class="title">一日套餐名稱:</label><input type="text"
						name="foodname" size="20" autocomplete="off" required="" />
				</div>
				<div class="st1">
					<label class="title">早餐:</label><input type="text" name="foodname"
						size="20" autocomplete="off" required="" />
				</div>
				<div class="st1">
					<label class="title">中餐:</label><input type="text" name="foodname"
						size="20" autocomplete="off" required="" />
				</div>
				<div class="st1">
					<label class="title">晚餐:</label><input type="text" name="foodname"
						size="20" autocomplete="off" required="" />
				</div>

				<div id="submit">
					<input type="submit" value="新增" /> <input type="submit" value="修改" />
					<input type="submit" value="查詢" /> <input type="reset" value="清除"
						onclick="abc();" />
				</div>
			</form>
		</div>
	</div>
</body>
</html>