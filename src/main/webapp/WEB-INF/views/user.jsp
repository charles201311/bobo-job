
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<script type="text/javascript" src="/resource/js/jquery-3.2.1.js"></script>

</head>
<body>

	<div class="container">

		<table class="table  table-striped">
			<tr>
				<td colspan="2">姓名:${user.name }</td>

			</tr>
			<tr>
				<td colspan="2">性别:${user.sex }</td>

			</tr>
			<tr>
				<td colspan="2">生日:${user.birthday }</td>

			</tr>
			<tr>
				<td colspan="2">照片:<img alt="" src="/pic/${user.picUrl}" style="width: 100px;hight: 180px"></td>

			</tr>
			<c:forEach items="${user.list}" var="s">
				<tr>
					<td>职位:${s.position.name }</td>
					<td>分数:${s.score }</td>

				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>