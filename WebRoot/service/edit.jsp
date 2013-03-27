<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>完成维修保养预约</title>
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
		 <h2>完成维修保养预约</h2>
<form class="form-horizontal" action="${path}/service/editsave.do" method="post">
  <div class="control-group">
    <label class="control-label" for="inputclientid">客户ID</label>
    <div class="controls">
     <input type="number" class="input-large uneditable-input" id="inputclientid" maxlength="10" min="1" max="9999" name="inputclientid" value="${ssv.serid}" >
    </div>
  </div>
 
  <div class="control-group">
    <label class="control-label" for="inputdate">预约日期</label>
    <div class="controls">
      <input type="date" name="inputdate" id="inputdate" required value="${ssv.serdate}">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputstc">维修保养结果</label>
    <div class="controls">
      <select name="inputstc" required>
  <option>预约</option>
  <option>完成</option>
</select>
    </div>
  </div>
  
  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn btn-primary">保存</button>
       <a href="main.do" class="btn">取消</a>
    </div>
  </div>
   <input type="text" name="serid" value="${ssv.serid}" style="display:none">
</form>

    </div>
  </div>
</div>

<jsp:include page="../index/bottom.jsp"></jsp:include>

<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"> </script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"> </script>
<script>
 $(".weixiu").addClass("active");//选中的添加acrive
</script>
</body>
</html>
