<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>维修保养预约管理</title>
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
				<h2>维修保养预约管理</h2>
				<div class="span4">
					<a href="${path}/service/add.jsp" class="btn btn-primary">增加新预约</a>
				</div>
				<table class="table table-striped" >
					<tr>
						<td><strong>预约号</strong></td>
						<td><strong>预约时间</strong></td>
						<td><strong>客户ID</strong></td>
						<td><strong>客户姓名</strong></td>
						<td><strong>状态</strong></td>
						<td><strong>操作</strong></td>
					</tr>
					<c:forEach var="emp" items="${serlist }">
						<tr>
							<td>${emp.serid}</td>
							<td>${emp.serdate}</td>
							<td>${emp.clientid}</td>
							<td>${emp.clientname}</td>
							<td>${emp.serstate}</td>
							<td><a
								class="btn offset1"
								href="${path}/service/edit.do?serid=${emp.serid}"><i
									class="icon-pencil"></i>修改状态</a></td>
						</tr>
					</c:forEach>

				</table>

			</div>
		</div>
	</div>

	<jsp:include page="../index/bottom.jsp"></jsp:include>

	<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js">
		
	</script>
	<script type="text/javascript" src="${path}/js/bootstrap.min.js">
		
	</script>
	<script>
		$(".weixiu").addClass("active");//选中的添加acrive
	</script>
</body>
</html>
