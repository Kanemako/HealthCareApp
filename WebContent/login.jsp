<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Apollo - ログイン画面</title>

<link rel="shortcut icon" href="images/icon.png">

<link rel="stylesheet" href="css/style.css">

</head>

<div class="container">

<header>
	<h1><img src = "images/app_image.png" alt = "アプリアイコン" width = "100" heigth = "100" class = "app_icon"></h1>
</header>

<section>
	<div class="card">
		<p class="error">${errorMsg}</p>

		<form action="LoginServlet" method="post">
			<input class="form-control" type="text" name="name" placeholder="ユーザID">
			<input class="form-control" type="password" name="pass" placeholder="パスワード"><br>
			<br>
			<div style = "inline-flex">
			<input class="btn btn-lg btn-primary btn-block" type="submit" value="ログイン"><br>
			</div>
		</form><br>
		<form action ="LoginServlet" method="get">
		<input type = "submit" class = "btn btn-lg btn-primary btn-block" href = "LoginServlet" value="新規登録">
		</form>
		
		
		
		
	</div>
</section>

</div>

<!-- CDN : Bootstrap Bundle with Popper -->
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"
></script>

</body>
</html>
