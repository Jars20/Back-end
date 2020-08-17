## httpBasic与formLogin的区别
httpBasic是利用HTTP头部进行认证，访问页面时会由浏览器弹框要求密码，这个是走HTTP协议层面的认证  
formLogin是基于页面，你需要自己实现一个登录页面，也就是示例中的/usercheck.jsp（名字你可以自己定），里面要有一个登录表单，表单的action和用户名 密码字段名都是框架定死的
## 403自定义权限不足处理
- xml:
```html
<!-- 自定义权限不足处理 --> 
<security:access-denied-handler error-page="/error"/>
```
## 登录
```java
http.fromLogin
```
- 定制登录页
```java
http.formLogin().loginPage("/.....")//更改登录页地址
```
- 登录认证
```java
http.formLogin().loginPage("/.....").loginProcessingUrl("/......")
//TODO:差别
```
## 注销
```java
http.logout.logoutSuccessUrl("/")//回到根目录
```
## CSRF
CSRF一般指跨站请求伪造。跨站请求伪造（英语：Cross-site request forgery）  
idea默认开启，防止get提交，防止攻击。导致404，注销失败
- xml:         
```html
<security:csrf disabled="true"/>
```
- Config.java:
```java
http.csrf().disable();
```
## html根据权限动态显示菜单
springboot：
导入thymeleaf与springsecurity

## 记住我
springboot：
开启：
```java
http.remreberMe();//cookie默认保存两周
```
自定义接收参数：
```java
http.rememberMe().rememberMeParameter("remrember1");
```

## Question:

- WebSecurityConfig
两个config方法，httpsecurity入参的表示拦截，WebSecurity表示白名单
LoginService逻辑
- Spring自动完成。return一个继承userdetails接口的实体类DTO
MyPasswordEncoder 何时调用
- Component自动调用