## 注解的配置

删除注解，添加 web.xml 里面写上 TestFilter 的配置，和 Servlet 的配置很相似
```html
 <filter> 
    <filter-name>TestFilter1</filter-name> 
    <filter-class>TestFilter1</filter-class> 
</filter> 
<filter-mapping> 
    <filter-name>TestFilter1</filter-name>
    <url-pattern>/*</url-pattern> 
</filter-mapping> 
```
/*的意思是所有到达服务器的请求都要先经过 TestFilter1 的处理
## eg.
接下来我们示例一个登录权限的Filter
创建一个 LoginValidateFilter，删除注解，添加代码 
```java
HttpServletRequest httpReq = (HttpServletRequest)request; 
HttpSession session = httpReq.getSession(); 
if(session.getAttribute("user")!=null){
     chain.doFilter(request, response); 
}else{ 
    request.getRequestDispatcher("login.jsp").forward(request, response); 
}
```
配置：注意url-pattern的配置
```html
<filter> 
    <filter-name>LoginValidateFilter</filter-name> 
    <filter-class>com.shoppingstreet.filter.LoginValidateFilter</filter-class> 
</filter> 
<filter-mapping> 
    <filter-name>LoginValidateFilter</filter-name> 
    <url-pattern>/user/*</url-pattern> 
</filter-mapping>
```
## 绝对路径与相对路径、
1. 一种方式，用我们之前学过的再前面加上../它就能回到根目录下去了
2. 还有一种写法，就是 让 jsp 页面上的所有相对路径的起始路径都是从项目的根目录开始，这样就不用每次改目录 的时候还需要改所有的相对路径了：  
打开 member.jsp 页面添加这几行代码   
```jsp
<%
    String path = request.getContextPath(); 
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
%>
```
此时 basePath 的值就是 localhost:8080/shoppingstreet,  
然后再<head>标签下加上 base 标签
```jsp
    <base href="<%=basePath%>">
```
测试过程中发现了问题 login 页面的路径又不对了，这是因为过滤器那边也出现了问题，那么我们使用重定向好了 并且配上绝对路径,这样就不会有问题了 
```java
    String path = httpReq.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/"; 
    HttpServletResponse httpResp = (HttpServletResponse) response; 
    httpResp.sendRedirect(basePath+"login.jsp");
```