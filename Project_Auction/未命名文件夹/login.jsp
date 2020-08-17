<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/7/28
  Time: 10:34 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="${pageContext.request.contextPath}/js/jquery-1.8.2.min.js"></script>
    <script>
        $(function(){
            $("#loginBtn").click(function () {
                $.post("${pageContext.request.contextPath}/securityLogin",
                $("#loginForm").serialize(),function (data) {
                    alert(data.success)
                    if(data.success){
                        location.href="${pageContext.request.contextPath}/product/index";
                    }else{
                        alert(data.errorMsg);
                    }
                },"json");
            });
        });
    </script>
</head>
<body>
<c:if test="${not empty requestScope.error}">
    ${requestScope.error}
</c:if>
<form id="loginForm" action="${pageContext.request.contextPath}/securityLogin" method="post">
    用户名:<input type="text" name="username"/><br/>
    用户名:<input type="password" name="password"/><br/>
    验证码:<input type="text" name="imageCode"/>
    <img src="${pageContext.request.contextPath}/imageCode"/><br/>
    记住我:<input type="checkbox" name="remember-me" value="true"><br/>
    <input type="button" id="loginBtn" value="登录"/>
</form>

</body>
</html>
