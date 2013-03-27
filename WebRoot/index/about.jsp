<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>关于-BMW汽车销售系统</title>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<link rel="stylesheet" href="../css/bootstrap.min.css"/>
<link rel="stylesheet" href="../css/bootstrap.res.css"/>
<link rel="stylesheet" href="../css/base.css"/>
</head>
<body>
<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a> <a class="brand" href="#">BMW汽车销售系统</a>
      <div class="nav-collapse collapse">
        <ul class="nav">
          <li class="active"> <a href="../index/index.jsp"><i class="icon-home icon-white"></i>主页</a> </li>
          <li><a href="#dev">开发环境</a></li>
          <li><a href="#server">服务器信息</a></li>
          <li><a href="#sql">数据库信息</a></li>
          <li><a href="#tech">使用的技术</a></li>
          <li><a href="#sys">综合概述</a></li>
          <li><a href="#required">审核要求</a></li>
        </ul>
        <ul class="nav pull-right">
          <li class="divider-vertical"></li>
          <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown">欢迎你,${user}<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="#"><i class="icon-cog"></i>设置</a></li>
              <li><a href="#"><i class="icon-off"></i>登出</a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
</div>
<div class="container-fluid" id="main">
  <div class="row-fluid">
       <div class="span12"> 
    <section id="dev">
      <h3>开发环境</h3>
      <ul>
        <li>平台：Windows 7 SP1</li>
        <li>工具：Eclipse for Java EE3.7</li>
        <li>人员：杨健</li>
      </ul>
      </section>
      <section id="server">
      <h3>服务器信息</h3>
      <ul>
        <li>Web容器：Tomcat 7.0</li>
        <li>数据库：MySQL5.5</li>
        <li>环境：Java EE 1.7+JRE1.7</li>
        <li>邮件服务器：163邮箱 用户名：nicejava 密码：javaee</li>
      </ul>
      </section>
      <section id="sql">
      <h3>数据库信息</h3>
      <ul>
        <li>用户名：root</li>
        <li>密码：123</li>
        <li>配置：使用数据连接池连接</li>
      </ul>
      </section>
       <section id="tech">
      <h3>使用的技术</h3>
      <ul>
        <li>HTML5+CSS3+jQuery Bootstrap框架，支持响应式设计，要求使用Chrome等高级浏览器访问</li>
        <li>MySQL5.5 开源小巧的数据库</li>
        <li>Java EE 1.7+JRE1.7 开发设计</li>
      </ul>
      </section>
       <section id="sys">
      <h3>综合概述</h3>
      <ul>
        <li>
          <p>宝马4S店汽车销售系统使用javaEE开发，基于多种开原件构成，使用了五层MVC模式，用于4S店进行汽车销售中涉及到的，库存管理，销售统计，维修预约，客户信息管理等。方便了企业进行信息化管理。</p>
        </li>
        <li>
          <p>使用：Servlet，JSP，Filter，Listener，数据库连接池，JNDI，EL，JSTL，JavaMail, JDBC，I18N。页面使用JSP＋EL＋JSTL，在JSP页面中没有使用Java脚本代码。</p>
        </li>
      </ul>
      </section>
       <section id="required">
      <h3>审核要求</h3>
      <ul>
        <table width="800" class="table table-striped">
          <tbody>
           <tr>
              <td width="163"><strong>考核项目</strong></td>
              <td width="54"><strong>满数</strong></td>
              <td width="354"><strong>说明</strong></td>
              <td width="274">审核</td>
            </tr>
            <tr>
              <td width="163"  ><p   > JSP：20个以上 </p></td>
              <td width="54"  ><p   > 10 </p></td>
              <td width="354"  ><p   > 每个0.5分 </p></td>
              <td width="274"  > <label class="checkbox">
            	<input type="checkbox" >完成
            </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > Servlet：20个以上 </p></td>
              <td width="54"  ><p   > 10 </p></td>
              <td width="354"  ><p   > 每个0.5分 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > Filter：2个以上 </p></td>
              <td width="54"  ><p   > 4 </p></td>
              <td width="354"  ><p   > 每个2分 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > Listener：3个以上 </p></td>
              <td width="54"  ><p   > 6 </p></td>
              <td width="354"  ><p   > 每个2分 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > 数据库表：5个以上 </p></td>
              <td width="54"  ><p   > 5 </p></td>
              <td width="354"  ><p   > 每个1分 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > DTO值类：5个以上 </p></td>
              <td width="54"  ><p   > 5 </p></td>
              <td width="354"  ><p   > 每个1分 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > DAO接口和类：4个以上 </p></td>
              <td width="54"  ><p   > 10 </p></td>
              <td width="354"  ><p   > 每个2.5分 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > BO接口和类：4个以上 </p></td>
              <td width="54"  ><p   > 10 </p></td>
              <td width="354"  ><p   > 每个2.5分 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > JNDI和数据库连接池 </p></td>
              <td width="54"  ><p   > 2 </p></td>
              <td width="354"  ><p   > 不使用连接池0分。 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > I18N支持 </p></td>
              <td width="54"  ><p   > 6 </p></td>
              <td width="354"  ><p > 只需要实现2个页面的I18N支持，每个3分 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > 文件上传到数据库 </p></td>
              <td width="54"  ><p   > 5 </p></td>
              <td width="354"  ><p   > 无文件上传到DB得0分 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > 文件下载或图片显示 </p></td>
              <td width="54"  ><p   > 5 </p></td>
              <td width="354"  ><p   > 无文件从数据库取出0分 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > 发送Mail </p></td>
              <td width="54"  ><p   > 5 </p></td>
              <td width="354"  ><p   > 无mail发送0分 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > 页面美观 </p></td>
              <td width="54"  ><p   > 5 </p></td>
              <td width="354"  ><p   > 使用include实现布局。无布局扣3分。 根据美观程度确定分数 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > 项目应用创新 </p></td>
              <td width="54"  ><p   > 3 </p></td>
              <td width="354"  ><p   > 开发如学生管理，图书管理等常规项目无创新分数。 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > 项目技术创新 </p></td>
              <td width="54"  ><p   > 4 </p></td>
              <td width="354"  ><p   > 使用新技术，如AJAX，jQuery， DOJO，DWR等 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > 项目难度 </p></td>
              <td width="54"  ><p   > 5 </p></td>
              <td width="354"  ><p   > 根据实现的难度进行认定。 </p></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
            <tr>
              <td width="163"  ><p   > 合计 </p></td>
              <td width="54"  ><p   > 100分 </p></td>
              <td width="354"  ></td>
              <td width="274"  ><label class="checkbox">
                <input type="checkbox" >
              完成 </label></td>
            </tr>
          </tbody>
        </table>
      </ul>
      </section>
    </div>
  </div>
</div>
<jsp:include page="../index/bottom.jsp"></jsp:include>
<script type="text/javascript" src="../js/jquery-1.8.2.min.js"> </script>
<script type="text/javascript" src="../js/bootstrap.min.js"> </script>
</body>
</html>
