<%--
  Created by IntelliJ IDEA.
  User: wangergou
  Date: 2017/8/7
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ taglib prefix="UserTag" uri="http://hello.com/UserTag" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<div align="center">
    <h4>我的网站-登录</h4>
    <hr>
    <font color="red">${msg}</font>
    <form action="${pageContext.request.contextPath}/servlet/LoginServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" value="<UserTag:URLDecoder content="${cookie.remname.value}" encode="utf-8"/>"/></td>
        </tr>
        <tr>
            <td>密码</td>
            <td><input type=" password" name="password">
                </td>
            </tr>

            <tr>
                <td><input type="submit" value="登录"></td>
                <td><input type="checkbox"  value="OK" name="remname"
                        <c:if test="${cookie.remname != null}">
                            checked = "checked"
                        </c:if>
                />记住用户名
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>