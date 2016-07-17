<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>

<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/js/jquery.min.js" type="text/javascript" />
<link href="${pageContext.request.contextPath}/resources/css/starter-template.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript" />

</head>
<body>
Welcome to Spring MVC!

<nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li><a href="#about">About</a></li>
            <li><a href="#contact">Contact</a></li>
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
    
    <div class="container">

      <div class="starter-template">
        <h1>Spring is running</h1>
        <p class="lead">Udemy course on Java Spring Development</p>
        <p><a href="${pageContext.request.contextPath}/displayusers">Embeded Database</a></p>
        <p><a href="${pageContext.request.contextPath}/displayusersmysql">MySQL Database</a></p>
        <p><a href="${pageContext.request.contextPath}/newblogpost">New Blog Post</a></p>
        <p><a href="${pageContext.request.contextPath}/blogposts">All blog posts</a></p>
        <p><a href="${pageContext.request.contextPath}/draftblogposts">Draft blog posts</a></p>
        <p><a href="${pageContext.request.contextPath}/admin">Admin</a></p>

		<security:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER')">
		<b>You are logged in as: </b><security:authentication property="principal.username"/>
		with the role of <security:authentication property="principal.authorities"/>
			<a href="<core:url value="/logout"/>">Logout</a>
			
		</security:authorize>

      </div>

    </div>
    
<footer class="footer">
      <div class="container">
        <p class="text-muted">Java Spring new project.</p>
        <a href="<%=request.getContextPath() %>?language=en">EN</a>
        <a href="<%=request.getContextPath() %>?language=ru">RU</a>
        <spring:message code="language"/>
        <font color="green"><b><spring:message code="welcome.text"/></b></font>
      </div>
    </footer>
</body>
</html>