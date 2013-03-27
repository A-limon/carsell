<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加销售记录</title>
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
		 <h2>添加销售记录</h2>
<form class="form-horizontal" action="${path}/sell/add.do" method="post">
  <div class="control-group">
    <label class="control-label" for="inputengineid">发动机号</label>
    <div class="controls">
     <input type="number" class="input-large" id="inputengineid" maxlength="10" min="1" max="9999999999" name="inputengineid" placeholder="请输入7位唯一发动机号" >
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputcarid">车辆ID</label>
    <div class="controls">
      <input type="number" id="inputcarid" maxlength="4" min="1" max="9999" name="inputcarid" required placeholder="请到车型信息页面查询">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputuserid">销售人员ID</label>
    <div class="controls">
      <input type="number" id="inputuserid" maxlength="2" min="1" max="99" name="inputuserid" placeholder="请到员工信息页面查询" required>
    </div>
  </div>
  
  <div class="control-group">
    <label class="control-label" for="inputdate">销售日期</label>
    <div class="controls">
      <input type="date" name="inputdate" id="inputdate" required>
    </div>
  </div>
  
  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn btn-primary">添加</button>
       <a href="main.do" class="btn">取消</a>
    </div>
  </div>
</form>

    </div>
  </div>
</div>

<jsp:include page="../index/bottom.jsp"></jsp:include>

<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"> </script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"> </script>
<script>
 $(".xiaoshou").addClass("active");//选中的添加acrive
</script>
</body>
</html>
