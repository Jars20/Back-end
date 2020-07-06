<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/7/2
  Time: 2:00 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <%
    String name = request.getParameter("userName");
    System.out.println("欢迎你");
    System.out.println(name);
  %>
  <%="欢迎你"%>
  Welcome!!
  <%=name%>

  <%=request.getAttribute("Condition")%>>

  </body>
</html>
