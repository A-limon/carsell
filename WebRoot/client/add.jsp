<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>添加客户</title>
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
		 <h2>添加新客户</h2>
<form class="form-horizontal" action="${path}/client/add.do" method="post">
  <div class="control-group">
    <label class="control-label" for="inputclientname">姓名</label>
    <div class="controls">
      <input type="text" class="input-large" id="inputclientname" name="inputclientname" maxlength="8" required placeholder="客户姓名">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputengineid">发动机编号</label>
    <div class="controls">
      <input type="number" class="input-large" id="inputengineid" maxlength="10" min="1" max="9999999999" name="inputengineid" placeholder="发动机编号" >
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputsex">性别</label>
    <div class="controls">
      <label class="radio">
        <input type="radio" name="optionsRadios" id="inputsex" value="男 " checked>
        男 </label>
      <label class="radio">
        <input type="radio" name="optionsRadios" id="inputsex" value="女">
        女 </label>
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputage">年龄</label>
    <div class="controls">
      <input type="number" name="inputage"  min="18" max="70" id="inputage" required placeholder="客户年龄">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputphone">电话</label>
    <div class="controls">
      <input class="input-large" type="tel" name="inputphone"  maxlength="11" id="inputphone" required placeholder="手机号码">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputemail">邮箱</label>
    <div class="controls">
      <input class="input-large" type="email" name="inputemail" id="inputemail" required placeholder="电子邮件">
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
 $(".kehu").addClass("active");//选中的添加acrive
</script>
</body>
</html>
