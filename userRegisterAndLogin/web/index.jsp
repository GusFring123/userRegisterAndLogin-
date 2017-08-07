<%--
  Created by IntelliJ IDEA.
  User: wangergou
  Date: 2017/8/6
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>这是一个网站-首页</title>
</head>
<body>
<div align="center">
    <h3>这是一个网站-首页</h3>
    <hr>
    <c:if test="${sessionScope.user == null}">
        欢迎你！游客！
        <a href="${pageContext.request.contextPath}/register.jsp">注册</a>
        <a href="${pageContext.request.contextPath}/login.jsp">登录</a>
    </c:if>
    <c:if test="${sessionScope.user != null}">
        欢迎回来！${sessionScope.user.nickname}
        <a href="${pageContext.request.contextPath}/servlet/LogoutServlet">注销</a>
    </c:if>
</div>
</body>
</html>
