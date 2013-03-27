<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:set value="${pageContext.request.contextPath}" var="path" scope="page"/>
<fmt:bundle basename="message">
<div class="navbar navbar-inverse navbar-fixed-top">
  <div class="navbar-inner">
    <div class="container"> <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse"> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </a> <a class="brand" href="#"><fmt:message key="title"/></a>
      <div class="nav-collapse collapse">
        <ul class="nav">
          <li class="active"> <a href="../index/index.jsp"><i class="icon-home icon-white"></i><fmt:message key="homepage"/></a> </li>
          <li><a href="#"><i class="icon-tasks icon-white"></i><fmt:message key="notice"/></a></li>
        </ul>
        <ul class="nav pull-right">
          <li class="divider-vertical"></li>
          <li class="dropdown"> <a href="#" class="dropdown-toggle" data-toggle="dropdown"><fmt:message key="welcome"/>, ${user}<b class="caret"></b></a>
            <ul class="dropdown-menu">
              <li><a href="${path}/index/logout.do"><i class="icon-off"></i><fmt:message key="logout"/></a></li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </div>
</div>
</fmt:bundle>
