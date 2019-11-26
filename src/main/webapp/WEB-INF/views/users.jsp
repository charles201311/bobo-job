
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
<script type="text/javascript">
	function goPage(page) {
		location.href = "/driver/cars?page=" + page
	}
</script>

</head>
<body>

	<div class="container">
	<a href="/add">录入</a>
		<table class="table table-striped">
			<tr>
				<td>序号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>生日</td>
				<td>平均分</td>
				<td>操作</td>
			</tr>

			<c:forEach items="${info.list}" var="u" varStatus="i">

				<tr>
					<td>${i.index+1}</td>
					<td>${u.name }</td>
					<td>${u.sex}</td>
					<td>${u.birthday}</td>
					<td>${u.avgScore }</td>
					<td><a href="/select?id=${u.id }"> 详情</a></td>

				</tr>


			</c:forEach>

		</table>

		<%-- <div style="clear: both;">
			<jsp:include page="pages.jsp" />
		</div> --%>

	</div>
</body>
</html>