<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>客户信息管理</title>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css" />
<link rel="stylesheet" href="${path}/css/bootstrap.res.css" />
<link rel="stylesheet" href="${path}/css/base.css" />
</head>
<body>

	<jsp:include page="../index/top.jsp"></jsp:include>

	<div class="container-fluid" id="main">
		<div class="row-fluid">
			<div class="span2">
				<jsp:include page="../index/left.jsp"></jsp:include>
			</div>
			<div class="span10">
				<h2>客户信息管理</h2>
				<div class="span4">
					<a href="${path}/client/add.jsp" class="btn btn-primary">增加新客户</a>
				</div>
				<div class="span4">
					
						<form class="form-search" action="${path}/client/search.do" method="post">
							<input type="text" class="input-medium search-query" name="clientname"
								id="clientname" placeholder="客户姓名">
							<button type="submit" class="btn btn-primary">搜索客户</button>
						</form>
				
				</div>
				<table class="table table-striped" >
					<tr>
						<td><strong>ID</strong></td>
						<td><strong>姓名</strong></td>					
						<td><strong>性别</strong></td>
						<td><strong>年龄</strong></td>
						<td><strong>电话</strong></td>
						<td><strong>邮箱</strong></td>
						<td><strong>发动机号</strong></td>
						<td><strong>购买日期</strong></td>
						<td><strong>购买车型</strong></td>
						<td><strong>操作</strong></td>
					</tr>
					<c:forEach var="emp" items="${iclist }">
						<tr>
							<td>${emp.clientid}</td>
							<td>${emp.clientname}</td>
							<td>${emp.clientsex}</td>
							<td>${emp.clientage}</td>
							<td>${emp.clientphone}</td>
							<td>${emp.clientmail}</td>
							<td>${emp.engineid}</td>
							<td>${emp.selldate}</td>
							<td>${emp.carname}</td>
							<td><a href="${path}/client/edit.do?clientid=${emp.clientid}"
								class="btn "><i class="icon-pencil"></i>修改</a>
								<a class="btn"  href="${path}/client/mail.do?clientid=${emp.clientid}">
								<i class="icon-envelope"></i>邮件</a>
								<a class="btn"  href="${path}/client/delete.do?clientid=${emp.clientid}">
								<i class="icon-remove"></i>删除</a></td>
						</tr>
					</c:forEach>

				</table>

			</div>
		</div>
	</div>

	<jsp:include page="../index/bottom.jsp"></jsp:include>
	<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="${path}/js/bootstrap.min.js"></script>
	<script>
		$(".kehu").addClass("active");//选中的添加acrive
	</script>
</body>
</html>
