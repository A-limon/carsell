<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>销售记录管理</title>
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
				<h2>销售记录管理</h2>
				<div class="span4">
					<a href="${path}/sell/add.jsp" class="btn btn-primary">增加新销售</a>
				</div>
				<div class="span4">
					
						<form class="form-search" action="${path}/sell/search.do" method="post">
							<input type="text" class="input-medium search-query" name="enginesearch"
								id="enginesearch" placeholder="发动机号">
							<button type="submit" class="btn btn-primary">搜索销售记录</button>
						</form>
				
				</div>
				<table class="table table-striped" >
					<tr>
						<td><strong>发动机号</strong></td>
						<td><strong>销售时间</strong></td>
						<td><strong>车型ID</strong></td>
						<td><strong>车型名称</strong></td>
						<td><strong>销售人员ID</strong></td>
						<td><strong>销售人员</strong></td>
						<td><strong>操作</strong></td>
					</tr>
					<c:forEach var="emp" items="${selists }">
						<tr>
							<td>${emp.engineid}</td>
							<td>${emp.selldate}</td>
							<td>${emp.carid}</td>
							<td>${emp.carname}</td>
							<td>${emp.userid}</td>
							<td>${emp.username}</td>
							<td><a
								class="btn offset1"
								href="${path}/sell/delete.do?engineid=${emp.engineid}"><i
									class="icon-remove"></i>删除</a></td>
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
		$(".xiaoshou").addClass("active");//选中的添加acrive
	</script>
</body>
</html>
