<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/7/1
  Time: 7:01 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>登录系统v1.0</title>
  </head>
  <body>
      <form action="registe.do" >
        用户名：<input type="text" name="loginName" value="" />
        <br/>
        密码：<input type="password" name="password" value=""/>
        <br/>
        <input type="submit" value="登录"/>
      </form>>
      <a href="add.html">
          <button>点我注册</button>
      </a>
  </body>
</html>
