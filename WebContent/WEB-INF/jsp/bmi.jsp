<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="shortcut icon" href="images/icon.png">

<!-- CDN : Bootstrap CSS -->
<link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous"
/>

<link rel="stylesheet" href="css/bmi.css">
<title>BMI登録画面</title>
</head>
<body>
  <h1><img src = "images/app_image.png" alt = "アプリアイコン" width = "100" heigth = "100" class = "app_icon">APOLLO</h1>
  <h2>BMI登録手続き</h2>
  <p class="error">${errorMsg}</p>
  <form action="BmiServlet" method="post" id = "contact">
    <table>
      <tr>
       <td><label for="heightId">身長</label></td>
       <td><input type="text" name="height" placeholder="cmで入力" id = "heigthId"></td>
    </tr>
    <tr>
       <td><label for="weightId">体重</label></td>
       <td><input type="text" name="weight" placeholder="kgで入力" id="weightId"></td>
    </tr>
    </table>
    <td><input type="submit" value="登録" class="incert_btn"></td>
  </form><br>
  </form><br>
<a href="http://localhost:8080/HealthCareApp/MainServlet" class = "btn btn-flat"><span>戻る</span></a>
</form>

<section>
	<div class="table-responsive">
		<table id="targetTable" class="table table-striped">
		<thead>
			<tr>
				<th>日付</th>
				<th>身長</th>
				<th>体重</th>
				<th>BMI</th>
				<th>メッセージ</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="bmi" items="${bmiList }">
				<tr>
					<td><c:out value="${bmi.day} "/></td>
					<td><c:out value="${bmi.height}" /></td>
					<td><c:out value="${bmi.weight}" /></td>
					<td><c:out value="${bmi.bmi}" /></td>
					<td><c:out value="${bmi.msg}" /></td>
				</tr>
			</c:forEach>
		</tbody>
		</table>
	</div>
</section>
  


</body>
</html>