<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/input.css">
<link rel="shortcut icon" href="images/icon.png">
<title>APOLLO 新規アカウント登録画面</title>
</head>
<body>
<h1><img src = "images/app_image.png" alt = "アプリアイコン" width = "100" heigth = "100" class = "app_icon">APOLLO</h1>
<h2>登録手続き</h2>
<p class="error">${registerErrorMsg}</p>
<form action="RegisterServlet" method="post">
　ユーザー名　：<input type="text" name="name"><br>
　パスワード　：<input type="password" name="pass1"><br>
　再 度 入 力　：<input type="password" name="pass2"><br>
　性　　　別　：<input type="text" name="gender"><br>
　生年　月日　：<input type="text" name="birthday"><br>
　年　　　齢　：<input type="text" name="age"><br>
<input type="submit" value="登録" class="button">
</form>
<form action="RegisterServlet" method="get">
<br>
<input type="submit" value="ログイン画面へ" class="button">
</form>
</body>
</html>