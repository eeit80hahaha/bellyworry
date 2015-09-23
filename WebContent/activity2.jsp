<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
	/*#img2{
			padding: 0px;
			margin: 0;
	}*/
	#fig1{
		  border: 2px solid #00A600;
		  padding: 0px;
		  margin: 10px 10px 10px 10px;
		  float:left;
		  background-color: #FFFFFF;
		  border-radius: 5px;
		  box-shadow: 5px 5px 5px #548C00;
		  padding-bottom:25px;
		  width: 400px;
		  height: 300px;
	}
	
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1 style="color: #000079;margin-top: 0px" >${selectByPrimaryKey.name}</h1>
	<p>${selectByPrimaryKey}</p>
	<img class="test" src="data:image/jpg;base64,${selectByPrimaryKey.picture1}"/>
	<a href="${selectByPrimaryKey.url}">官方活動網站</a>
</body>
</html>