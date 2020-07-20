1. ----cookie可以设置有效时期，在有效时期内关闭浏览器session会话会失效，也就是sessionID没了，但是也有说法说cookie不随浏览器关闭而失效，这是为什么呢？？  
因为cookie分为两种，一个是会话cookie，存在于浏览器进程里，当浏览器关闭时，会话cookie不存在了，所以说sessionID存在于会话cookie中时会随着浏览器关闭而失效，sessionID是cookie的一个属性。还有一种是存在硬盘的cookie，不会随浏览器关闭而失效。cookie默认失效时间是浏览器关闭。

cookie设置失效时间：对于会话cookie可以设置失效时间吗？对于存在硬盘的cookie怎么设置失效时间呢？？  
cookie.setMaxAge(0) //表示不会记录cookie  
cookie.setMaxAge(-1) ///表示这是会话级cookie，关闭浏览器时就会失效。  
cookie.setMaxAge(60) //设置了失效时间60秒，该cookie会存在硬盘中  

客户端怎么区分cookie是会话cookie还是硬盘cookie？？看设置的失效时间。设置了过期时间的cookie会存放在硬盘中，关闭浏览器再打开，cookie仍然有效，直到时间过期。存在硬盘中的cookie可以在浏览器不同的进程中共享。  

有人问seesionid可以用于保存用户登录状态，且存在cookie中，那么如果将sessionID存在cookie对象里，并且此时将cookie的失效时间设置为30分钟，那么浏览器关闭时，sessionID是否过期？？  
----不会的，因为此时的cookie存在硬盘，sessionID也会存放在硬盘cookie中，cookie没有失效，sessionID值还是可以找到，因此关闭浏览器再次登录时仍然可以进入原来的网页。

自动登录问题  
有时候出现的打开某个网页自动登录，那么这里面是利用什么技术实现的？和sessionID有关系吗？  
------cookie实现。此时利用硬盘cookie，sessionID没有随着浏览器的关闭而关闭。直到cookie失效或者服务器的session对象失效为止。  
------cookie+token实现。引入token实际上是为了安全。那么怎样生成token呢？一：利用设备号/设备Mac地址生成；二：将用户名和时间一起生成token，或者将sessionID加密生成token，将token保存在cookie中。用户访问网站时，后台读取Cookie，获取uid和Token，去数据库对比，如果都存在，且在有效期内，则通过uid直接获取用户信息并保存session，直接跳转到首页。资料： https://www.cnblogs.com/jacksoft/p/5216862.html

此时对cookie设置禁止，sessionID无法存在cookie中，那么怎么保存登录状态信息？
可以利用URL回写的方式实现

## JSTL 
2. 使用 JSTL 的步骤
● 引入 JSTL 的 jar 文件和标签库描述符文件
● 在 JSP 页面添加 taglib 指令  
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
● 使用 JSTL 标签

3. </c:forEach>
items 指定要遍历的集合对象
var 指定当前成员的引用
begin 指定从集合的第几位开始 end 指定迭代到集合的第几位结束 step 指定循环的步长
varStatus 属性用于存放 var 引用的成员的相关信息，如索引等
————————————————
版权声明：本文为CSDN博主「Qian_mos」的原创文章，遵循CC 4.0   BY-SA版权协议，转载请附上原文出处链接及本声明。  
原文链接：https://blog.csdn.net/Qian_mos/java/article/details/89320241  
