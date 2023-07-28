<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>ヘルスケア - TODO画面</title>

<link rel="shortcut icon" href="images/icon.png">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Monoton&display=swap" rel="stylesheet">

<!-- CDN : Bootstrap CSS -->
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous"
/>

<link rel="stylesheet" href="css/todo.css">

<script>
function selectboxChange() {
	var row = document.getElementById("index").selectedIndex + 1;
	var table = document.getElementById('targetTable');
	document.getElementById("important").options[(5 - table.rows[row].cells[1].innerText)].selected = true;
	document.getElementById('info').value = table.rows[row].cells[2].innerText;
	document.getElementById('deadline').value = table.rows[row].cells[3].innerText;
	document.getElementById('momentum').value = table.rows[row].cells[4].innerText;
}
</script>

</head>

<body onload="selectboxChange();">
<div class="container">

<header>
	<h1><a href="MainServlet">
	<div>
  <span id="T" class="title">T</span>
  <span id="O" class="title">O</span>
  <span id="D" class="title">D</span>
  <span id="O" class="title">O</span></div></a></h1>
	<a href="LogoutServlet" class="block-right">ログアウト</a>
	<a href="MainServlet" class="block-left">&lt;&lt;メインへ</a>
	<img class="profile-img profile-fix-header" src="//ssl.gstatic.com/accounts/ui/avatar_2x.png" />
</header>

<h2>筋肉スケジュール</h2>

<p class="error">${errorMsg}</p>

<hr>

<section>
   <div class="card card-smart">
	<h4>登録</h4>
	<form action="TodoRegistServlet" method="post">
		<select name="important">
			<option value="5">5</option>
			<option value="4">4</option>
			<option value="3">3</option>
			<option value="2">2</option>
			<option value="1">1</option>
		</select>
		<input type="text" name="info" size="20" value="" placeholder="内容">
		<input type="date" name="deadline">
		<input type="text" name = "momentum"placeholder="目標運動量">
		<input type="submit" value="登録" class="incert_btn">
	</form>
   </div>
</section>

<hr>

<section>
 <div class="card card-smart">
 	<div class="table-responsive">
		<table id="targetTable" class="table table-striped">
		<thead>
			<tr>
				<th>No</th>
				<th>重要度</th>
				<th>内容</th>
				<th>期日</th>
				<th>運動量</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="todo" items="${todoList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${todo.important}</td>
					<td>${todo.info}</td>
					<td>${todo.deadline}</td>
					<td>${todo.momentum }</td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
  </div>
</section>

<hr>

<section>
   <div class="card card-smart">
	<h4>変更</h4>
	<form action="TodoUpdateServlet" method="post">
		<select name="index" id="index" onchange="selectboxChange();">
			<c:forEach items="${todoList}" varStatus="status">
				<option value="${status.index}">${status.count}</option>
			</c:forEach>
		</select>
		<select name="important" id="important">
			<option value="5">5</option>
			<option value="4">4</option>
			<option value="3">3</option>
			<option value="2">2</option>
			<option value="1">1</option>
		</select>
		<input type="text" name="info" id="info" size="20" value="">
		<input type="date" name="deadline" id="deadline" value="">
		<input type="text" name="momentum" id="momentum" value="">
		<input type="submit" value="変更" class="incert_btn">
	</form>
   </div>
</section>

<hr>

<section>
   <div class="card card-smart">
	<h4>削除</h4>
	<form action="TodoRemoveServlet" method="post">
		<select name="index">
			<c:forEach items="${todoList}" varStatus="status">
				<option value="${status.index}">${status.count}</option>
			</c:forEach>
		</select>
		<input type="submit" value="削除" class="incert_btn">
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