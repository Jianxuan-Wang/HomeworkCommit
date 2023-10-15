<%--
  Created by IntelliJ IDEA.
  User: hspcadmin
  Date: 2023/9/15
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>summit产品部作业</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/fileupload" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="uploadfile"/><br/>
        文件描述：<input type="text" name="description"/><br/>
        <input type="submit" value="提交"/>
    </form>
</body>
</html>
