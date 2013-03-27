<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>修改员工</title>
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
		 <h2>修改员工</h2>
<form class="form-horizontal" action="${path}/employee/editsave.do" method="post">
  <div class="control-group">
    <label class="control-label" for="inputusername">姓名</label>
    <div class="controls">
      <input type="text" id="inputusername" name="inputusername" maxlength="8" required placeholder="员工姓名" value="${emv.name}">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputloginname">登录名</label>
    <div class="controls">
      <input type="text" id="inputloginname" maxlength="16" name="inputloginname" required placeholder="员工登录名" value="${emv.loginname}">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputPassword">密码</label>
    <div class="controls">
      <input type="password" id="inputPassword" maxlength="16" name="inputPassword" placeholder="登录密码" required value="${emv.password}">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputsex">性别</label>
    <div class="controls">
      <label class="radio">
        <input type="radio" name="optionsRadios" id="inputsex" value="男">
        男 </label>
      <label class="radio">
        <input type="radio" name="optionsRadios" id="inputsex" value="女 ">
        女 </label>
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputage">年龄</label>
    <div class="controls">
      <input type="number" name="inputage"  min="18" max="55" id="inputage" required placeholder="员工年龄" value="${emv.age}">
    </div>
  </div>
  <div class="control-group">
    <label class="control-label" for="inputdep" >部门</label>
    <div class="controls">
      <select name="inputdep" required >
  <option>经理</option>
  <option>销售</option>
  <option>维修</option>
</select>
    </div>
  </div>
  <div class="control-group">
    <div class="controls">
      <button type="submit" class="btn btn-primary">保存</button>
      <a href="main.do" class="btn">取消</a>
    </div>
  </div>
   <input type="text" name="id" value="${emv.id}" style="display:none">
</form>

    </div>
  </div>
</div>

<jsp:include page="../index/bottom.jsp"></jsp:include>

<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"> </script>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"> </script>
<script>
 $(".yuangong").addClass("active");//选中的添加acrive
 document.getElementsByTagName("select")[0].value="${emv.department}";
 var rObj = document.getElementsByName("optionsRadios");  
  	 if(rObj[0].value == "${emv.sex}"){  
       	rObj[0].checked =  'checked';} 
  	 else{
  		rObj[1].checked =  'checked';
  	 }	
</script>
</body>
</html>
