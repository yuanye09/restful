<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/4/17
  Time: 23:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
  <%@ page language="java" pageEncoding="UTF-8"%>
  <form action="<%=request.getContextPath()%>/media/upload/0bd70bafe879404eae61af0044a60d20" method="POST" enctype="multipart/form-data">
    yourfile: <input type="file" name="myfiles"/><br/>
    yourfile: <input type="file" name="myfiles"/><br/>
    yourfile: <input type="file" name="myfiles"/><br/>
    <input type="submit" value="添加新用户"/>
  </form>
</body>
</html>
