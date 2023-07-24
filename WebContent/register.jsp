<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/input.css">
<link rel="shortcut icon" href="images/favicon.ico">
<title>TODOアプリログイン画面</title>
</head>
<body>
<h1>TODOアプリケーション</h1>
<h2>登録手続き</h2>
<p class="error">${registerErrorMsg}</p>
<form action="/S2A205/RegisterServlet" method="post">
　ユーザー名　：<input type="text" name="name"><br>
　パスワード　：<input type="password" name="pass1"><br>
　再 度 入 力　：<input type="password" name="pass2"><br>
メールアドレス：<input type="text" name="mail"><br>
　年　　　齢　：<input type="number" name="age"><br>
<input type="submit" value="登録" class="button">
</form>
<form action="/S2A205/RegisterServlet" method="get">
<br>
<input type="submit" value="ログイン画面へ" class="button">
</form>
</body>
</html>