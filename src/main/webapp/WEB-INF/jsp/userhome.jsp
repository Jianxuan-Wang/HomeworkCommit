<%--
  Created by IntelliJ IDEA.
  User: hspcadmin
  Date: 2023/9/14
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>userhome</title>
</head>
<body>
    当前用户信息：${user_session.username}
    <a href="${pageContext.request.contextPath}/logout">退出</a><br/>
    <a href="${pageContext.request.contextPath}/tofileupload">交作业啦</a>
</body>
</html>
