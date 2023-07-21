<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>ヘルスケア - メイン画面</title>

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
	<h1><a href="MainServlet">へるすけあ</a></h1>
	<a href="LogoutServlet" class="block-right">ログアウト</a>
</header>

<section>
	<img class="profile-img" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
	<h4>${user.name}</h4>
</section>

<hr>

<p class="error">${errorMsg}</p>

<section>
	<div class="card card-smart">
		<h4>TODO の トピック</h4>
		<a class="card-link-text" href="TodoServlet">>>TODOへ</a>

		<c:choose>
			<c:when test="${todoTopic == null}" >
				<p>実行待ちのTODOはありません</p>
			</c:when>

			<c:otherwise>
				<div class="table-responsive">
					<table id="targetTable" class="table table-striped">
					<thead>
						<tr>
							<th>重要度</th>
							<th>内容</th>
							<th>期日</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${todoTopic.important}</td>
							<td>${todoTopic.info}</td>
							<td>${todoTopic.deadline}</td>
						</tr>
					</tbody>
					</table>
				</div>
			</c:otherwise>
		</c:choose>
	</div>
</section>

<!-- CDN : Bootstrap Bundle with Popper -->
<script
    src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
    crossorigin="anonymous"
></script>

</div>
</body>
</html>