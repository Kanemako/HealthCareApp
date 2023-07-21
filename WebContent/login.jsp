<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>ヘルスケア - ログイン画面</title>

<link rel="shortcut icon" href="images/favicon.ico">

<!-- CDN : Bootstrap CSS -->
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous"
/>

<link rel="stylesheet" href="css/style.css">

</head>

<body>
<div class="container">

<header>
	<h1>へるすけあ</h1>
</header>

<section>
	<div class="card">
		<p class="error">${errorMsg}</p>

		<form action="LoginServlet" method="post">
			<input class="form-control" type="text" name="name" placeholder="ユーザ名">
			<input class="form-control" type="password" name="pass" placeholder="パスワード">
			<br>
			<input class="btn btn-lg btn-primary btn-block" type="submit" value="ログイン">
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
