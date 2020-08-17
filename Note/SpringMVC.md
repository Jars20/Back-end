# 1.SpringMVC三大组件
- HandlerMapping：处理器映射器
- HandlerAdapter：处理器适配器
- View Resolver：视图解析器

# 2.自动加载
使用<mvc:annotation-driven> 自动加载 RequestMappingHandlerMapping（处理映 射器）和 RequestMappingHandlerAdapter （ 处 理 适 配 器 ） ， 可 用 在 SpringMVC.xml 配 置 文 件 中 使 用 <mvc:annotation-driven>替代注解处理器和适 配器的配置。 


# 3.HiddentHttpMethodFilter
Spring3.0 添加了一个过滤器，可以将浏览器请求改为指定的请求方式，发送给我们不同的控制器方法，使得支持 GET、POST、PUT 与 DELETE 请求

# 4.ModelAttribute
SpringMVC4.3 版本以后新加入的。它可以用于修饰方法和参数。
value：用于获取数据的 key。key 可以是 POJO 的属性名称，也可以是 map 结构的 key。

# 拦截器Interceptor
- 仅适用于Controller的拦截

# @PathVariable 
@PathVariable映射 URL 绑定的占位符
- 带占位符的 URL 是 Spring3.0 新增的功能，该功能在SpringMVC 向 REST 目标挺进发展过程中具有里程碑的意义
- 通过 @PathVariable 可以将 URL 中占位符参数绑定到控制器处理方法的入参中：URL 中的 {xxx} 占位符可以通过@PathVariable(“xxx“) 绑定到操作方法的入参中。
- 主要是根据请求方法进行类的区别

# 