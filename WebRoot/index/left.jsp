<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<ul class="nav nav-list bs-docs-sidenav">
        <li class="homepage"><a href="${path}/index/index.jsp">销售系统主页<i class="icon-chevron-right"></i> </a></li>
        <li class="pinpai"><a href="${pageContext.request.contextPath }/car/main.do"><i class="icon-chevron-right"></i>品牌车型管理</a></li>
        <li class="xiaoshou"><a href="${pageContext.request.contextPath }/sell/main.do"><i class="icon-chevron-right"></i>汽车销售记录</a></li>
        <li class="weixiu"><a href="${pageContext.request.contextPath }/service/main.do"><i class="icon-chevron-right"></i>维修预约管理</a></li>
        <li class="kehu"><a href="${pageContext.request.contextPath }/client/main.do"><i class="icon-chevron-right"></i>客户资料管理</a></li>
        <li class="yuangong"><a href="${pageContext.request.contextPath }/employee/main.do"><i class="icon-chevron-right"></i>员工信息管理</a></li>
      </ul>