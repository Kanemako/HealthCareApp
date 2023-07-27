<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="images/icon.png">
<link rel="stylesheet" href="css/index.css">
<title>APOLLO 新規アカウント登録画面</title>


</head>
<body>
<h1>
<img src = "images/app_image.png" alt = "アプリアイコン" width = "100" heigth = "100" class = "app_icon">
<a>APOLLO</a>
</h1>
<h2>登録手続き</h2>

<p class="error">${registerErrorMsg}</p>
<form action="RegisterServlet" method="post" id = "contact">
<table>
    <tr>
       <td><label for="userId">ユーザーID</label></td>
       <td><input type="text" name="name" placeholder="jyoho_taro" id = "userId"></td>
    </tr>
    <tr>
       <td><label for="birthday">生年月日</label></td>
       <td><input type="text" name="birthday" placeholder="2000-01-01" id="birthday"></td>
    </tr>
    <tr>
       <td><label for="pass1">パスワード</td>
       <td><input type="password" name="pass1" id = "pass1"></td>
    </tr>
    <tr>
       <td><label for="pass2">パスワード再入力</label></td>
       <td><input type="password" name="pass2" id="pass2"></td>
    </tr>
    <tr>
       <td><label for="age">年齢</label></td>
       <td><input type="text" name="age" placeholder="20" id="age"></td>
    </tr>
    <tr>
       <td><label for="sex">性別</label></td>
       <td>男性<input type="radio" name = "gender" value="男性">女性<input type="radio" name = "gender" value="女性"></td>
    </tr>
</table>
 <td><input type="submit" value="登録" class="incert_btn"></td>
</form><br>
<a href="http://localhost:8080/HealthCareApp/RegisterServlet" class = "btn btn-flat"><span>ログイン画面へ</span></a>
</form>
</body>
</html>