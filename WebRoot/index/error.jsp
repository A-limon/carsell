<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>错误-BMW汽车销售系统</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap.res.css"/>
<link rel="stylesheet" href="../css/base.css"/>
</head>
<body>
<div class="alert alert-error">
 <h2>oops,出错了~</h2>
</div>
<div class="span10">
	<a href="${pageContext.request.contextPath }/index/index.jsp">返回首页</a>
</div>
</body>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"> </script>
<script type="text/javascript" src="../js/bootstrap.min.js"> </script>
</html>
