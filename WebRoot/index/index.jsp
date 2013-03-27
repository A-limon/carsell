<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>首页-BMW汽车销售系统</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${path}/css/bootstrap.res.css"/>
<link rel="stylesheet" href="${path}/css/base.css"/>
</head>
<body>

<jsp:include page="../index/top.jsp"></jsp:include>
<div class="container-fluid" id="main">
  <div class="row-fluid">
    <div class="span2"> 
      <jsp:include page="../index/left.jsp"></jsp:include>
    </div>
    <div class="span10"> 
     
      <div class="hero-unit righthello">
        <h2>${user}您好,欢迎使用宝马4S店汽车销售系统</h2>
        <p>请点击左侧目录进行相应操作</p>
        <p>当前在线人数：<c:out value="${usernum }"/>
        今日访问量：<c:out value="${visit }"/></p>
      </div>
      
    </div>
  </div>
</div>
<jsp:include page="../index/bottom.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"> </script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"> </script>
<script>
 $(".homepage").addClass("active");//选中的添加acrive
</script>
</html>