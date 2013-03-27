<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set value="${pageContext.request.contextPath}" var="path"
	scope="page" />
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>搜索员工</title>
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
				<h2>员工搜索结果</h2>
				<div class="span4">
					<a href="${path}/employee/add.jsp" class="btn btn-primary">增加新员工</a>
				</div>
				<div class="span4">
					
						<form class="form-search" action="${path}/employee/search.do" method="post">
							<input type="text" class="input-medium search-query" name="username"
								id="username" placeholder="员工姓名">
							<button type="submit" class="btn btn-primary">搜索员工</button>
						</form>
					
				</div>
				<table class="table table-striped" width="800px">
					<tr>
						<td><strong>ID</strong></td>
						<td><strong>姓名</strong></td>
						<td><strong>密码</strong></td>
						<td><strong>性别</strong></td>
						<td><strong>年龄</strong></td>
						<td><strong>登陆名</strong></td>
						<td><strong>部门</strong></td>
						<td><strong>操作</strong></td>
					</tr>
					<c:forEach var="empsearch" items="${empsearchlist }">
						<tr>
							<td>${empsearch.id}</td>
							<td>${empsearch.name}</td>
							<td>${empsearch.password}</td>
							<td>${empsearch.sex}</td>
							<td>${empsearch.age}</td>
							<td>${empsearch.loginname}</td>
							<td>${empsearch.department}</td>
							<td><a href="${path}/employee/edit.do?id=${empsearch.id}"
								class="btn "><i class="icon-pencil"></i>修改</a><a
								class="btn offset1"
								href="${path}/employee/delete.do?id=${empsearch.id}"><i
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
		$(".yuangong").addClass("active");//选中的添加acrive
	</script>
</body>
</html>
