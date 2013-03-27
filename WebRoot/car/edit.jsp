<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>编辑车型-BMW汽车销售系统</title>
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
     
      <h2>编辑车型</h2>
<form class="form-horizontal" action="editsave.do" method="post" enctype="multipart/form-data">
  <div class="control-group">
    <label class="control-label" for="inputcarname">车型名</label>
    <div class="controls">
      <input type="text" class="input-xlarge" id="inputcarname" name="inputcarname" maxlength="80" required value="${cv.carname}">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputprice">售价</label>
    <div class="controls">
    <div class="input-prepend input-append">
    	<span class="add-on">￥</span>
      <input type="number" name="inputprice"  step="0.01" min="15.00" max="600.00" id="inputprice" required value="${cv.price}">
       <span class="add-on">万元起</span>
       </div>
    </div>
  </div>
    <div class="control-group">
    <label class="control-label" for="inputstock">库存</label>
    <div class="controls">
    <div class="input-prepend input-append">
      <input type="number" name="inputstock"   min="0" max="50" id="inputstock" value="${cv.stock}">
       <span class="add-on">辆</span>
       </div>
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputcolor">颜色</label>
    <div class="controls">
      <select name="inputcolor" class="span5" required>
   <option>雪山白</option>
  <option>宝石青</option>
  <option>米兰诺米色</option>
  <option>太空灰</option>
  <option>泰坦银</option>
  <option>午夜蓝</option>
  <option>蒙特卡罗蓝</option>
  <option>墨尔本红</option>
   <option>黑色</option>
   <option>磨砂棕</option>
</select>
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputengine">发动机</label>
    <div class="controls">
      <input type="text" class="input-xlarge" id="inputengine" maxlength="20" name="inputengine" required value="${cv.engine}" >
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="pic">车辆图片</label>
    <div class="controls">
      <input type="file" accept="image/x-png,image/jpeg"  class="input-xlarge" id="pic"  name="pic" >请选择120*90px大小的jpg图片
    </div>
  </div>
  <div class="form-actions">
      <button type="submit" class="btn btn-primary">保存</button>
       <a href="main.do" class="btn">取消</a>
  </div>
  <input type="text" name="carid" value="${cv.carid}" style="display:none">
  <input type="text" name="carpic" value="${cv.carpic}" style="display:none">
</form>
      
    </div>
  </div>
</div>
<jsp:include page="../index/bottom.jsp"></jsp:include>
</body>
<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"> </script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"> </script>
<script>
 $(".pinpai").addClass("active");//选中的添加acrive
 document.getElementsByTagName("select")[0].value="${cv.color}";
</script>
</html>