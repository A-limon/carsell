<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
 <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>登陆-BMW汽车销售系统</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link rel="stylesheet" href="${path}/css/bootstrap.min.css"/>
<link rel="stylesheet" href="${path}/css/bootstrap.res.css"/>
<link rel="stylesheet" href="${path}/css/base.css"/>
<script type="text/javascript" src="${path}/js/jquery-1.8.2.min.js"> </script>
<script type="text/javascript">
$(function(){   
	var btn = $('#btn');
    btn.click(function(){
        if($('#loginname').val().length==0 || $('#password').val().length==0){
        	alert("登录名或密码不能为空"); 
           
        }else{   
        	var servletUrl = "${pageContext.request.contextPath }/index/login.do";
            $.ajax({
                url:servletUrl,   //请求地址,即servlet路径
                data:{loginname:$('#loginname').val(),password:$('#password').val()},   //传递的数据，json格式，即key:value格式
                dataType:'json', //很重要!!!.预期服务器返回的数据类型   
                error:function(){   //出错以后用于提示
                    alert("oops,出了点问题，请刷新重试！");   
                },   
                success:function(data){   //回调函数,处理servlet执行完毕返回的结果
                    if(data.code == "1"){
                    	$('#showError').text(data.flag);//显示信息
                    }else{
                    	$('#showError').text(data.flag);
                    	location.href = "${pageContext.request.contextPath }/index/index.jsp";
                    }
                }
            });   
        }   
    });   
}); 
</script>
</head>
<body>
<div class="container">
	<div class="row login">
		<div class="span4 well offset3">
			<legend>请登录</legend>
          	<div class="alert alert-error" id="showError">
            </div>
          
			<input type="text" id="loginname" class="span4" name="loginname" placeholder="请输入登录名" required="required">
			<input type="password" id="password" class="span4" name="password" placeholder="请输入密码" required="required">
           
			<button name="submit" class="btn btn-info btn-block" id="btn">登陆</button>
		
		</div>
	</div>
</div>
<script type="text/javascript" src="${path}/js/bootstrap.min.js"> </script>
</body>
</html>
