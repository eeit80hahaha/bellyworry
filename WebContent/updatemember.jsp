<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form
		action="${pageContext.request.contextPath}/MemberServlet.controller"
		method="post">
		<fieldset>
			<legend>
				個人資料(<span style="color: red">*</span>為必填)
			</legend>
			<div>
				<label><span style="color: red">*</span> 姓:</label><input
					type="text" name="firstname" size="20" autofocus placeholder="請輸入"
					autocomplete="off" required="" />
			</div>
			<div>
				<label><span style="color: red">*</span> 名:</label><input
					type="text" name="lastname" size="20" autofocus placeholder="請輸入"
					autocomplete="off" required="" />
			</div>
			<div>
				<label>暱稱:</label><input type="text" name="nickname" size="20"
					autofocus placeholder="請輸入" autocomplete="off" required="" />
			</div>
			<div>
				<label><span style="color: red">*</span>帳號:</label><input
					type="text" name="account" size="20" required="" />
			</div>
			<div>
				<label><span style="color: red">*</span>密碼:</label><input
					type="password" name="pwd" size="20" required="" maxlength="20" />
			</div>
			<div>
				<label><span style="color: red">*</span>密碼確認:</label><input
					type="password" name="pwd" size="20" required="" maxlength="20" />
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
			<input type="submit" value="送出" /> <input type="reset" value="清除" />
		</div>
	</form>
</body>
</html>