<%--
  Created by IntelliJ IDEA.
  User: hspcadmin
  Date: 2023/9/14
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>register</title>
</head>
<body>
    ${msg}
    <form action="${pageContext.request.contextPath}/register" method="post">
        用户名：<input type="text" name="username" id="username"/><br/>
        密&nbsp;&nbsp;&nbsp;&nbsp;码：<input type="password" name="password" id="password"/><br/>
        <input type="submit" value="注册"/>
    </form>
</body>
</html>
