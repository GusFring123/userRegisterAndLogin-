<%--
  Created by IntelliJ IDEA.
  User: wangergou
  Date: 2017/8/7
  Time: 9:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>这是一个网站-注册</title>
</head>
<script type="text/javascript">
    function changeImg(img) {
        img.src = img.src + "?time=" + new Date().getTime();
    }
</script>
<body>
<div align="center">
    <h3>这是一个网站-注册</h3>
    <font color="red"> ${msg}</font>
    <form action="${pageContext.request.contextPath}/servlet/RegisterServlet" method="post">
        <table border="0.3">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" value="${param.username}"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="password" name="password"></td>

            </tr>
            <tr>
                <td>确认密码</td>
                <td><input type="password" name="password2"></td>
            </tr>
            <tr>
                <td>昵称</td>
                <td><input type="text" name="nickname" value="${param.nickname}"></td>
            </tr>
            <tr>
                <td>邮箱</td>
                <td><input type="text" name="email" value="${param.email}"></td>
            </tr>
            <tr>
                <td>验证码</td>

                <td><input type="text" name="valistr"></td>
            </tr>
            <tr>
                <td><input type="submit" value="注册"></td>
                <td><img src="${pageContext.request.contextPath}/servlet/ValiImg" style="cursor: pointer"
                         onclick="changeImg(this)">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
