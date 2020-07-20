# Mybatis
持久层框架

## SqlMapConfig.xml配置
```html
<!-- 配置连接数据库的信息：用的是数据源(连接池) --> 
<dataSource type="POOLED">
<!-- 告知 mybatis 映射配置的位置 --> 
<mappers> 
<mapper resource="club/banyuan/dao/UserDao.xml"/> 
</mappers>
```
```java
//1.读取配置文件 （@Before）
InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml"); 
//2.创建 SqlSessionFactory 的构建者对象 
SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder(); 
//3.使用构建者创建工厂对象 
SqlSessionFactory factory = builder.build(in); 
//4.使用 SqlSessionFactory 生产 SqlSession 对象 
SqlSession session = factory.openSession(); 
//5.使用 SqlSession 创建 dao 接口的代理对象 
UserDao userDao = session.getMapper(UserDao.class);
//6.执行
//7.释放资源 （@After）
session.submmit()
session.close(); 
in.close();
```


## 编写持久层接口的映射文件 IUserDao.xml 要求：
创建位置：必须和持久层接口在相同的包中。 
名称：必须以持久层接口名称命名文件名，扩展名是.xml
mapper 标签的 namespace 属性取值必须是持久层接口的全限定类名
```html
<mapper namespace="club.banyuan.dao.UserDao">
```
## OGNL(Object Graphic Navigation Language)
ognl 表达式：它是apache提供的一种表达式语言，全称是：Object Graphic Navigation Language 对象图导航语言:  
#{user.username}它会先去找 user 对象，然后在 user 对象中找到 username 属性， 并调用 getUsername()方法把值取出来。但是我们在 parameterType 属性上指定了实体 类名称，所以可以省略 user. 而直接写 username。

## Javatype与oftype的区别
JavaType和ofType都是用来指定对象类型的，但是JavaType是用来指定pojo中对象属性的类型，而ofType指定的是映射到list集合属性中泛型的类型。

## mappers映射器


## 多表查询
1. property后跟entity属性，column后跟db列名
2. Oredr---User  
需求1：查Order的同事要获取User信息（即时）使用的sql：内连接  
返回结果是Order表数据+User表数据--->Result（？类型） 
为了封装成功：方法一：重新构造一个类   
            方法二：Order中添加一个User属性，在OrderDao中的Mapper文件中写上ResultMap将Order中的User属性与查询结果中 User表中的列对应上。

需求2： 查Order，因为Order中已有了关联的User属性，接下来有可能会通过Order找关联的User（order.getUser（））  
    和需求1不一样的地方是，我们不知道用户什么时候会调用order.getUser()；如果采用内连接查询，在获取Order数据的同时还获取到了User的数据，如果用户长时间不去调用getUser(),意味着大量的User数据占用了系统资源  
改进方法：先查Order，当用户调用getUser()，再去查User  
        --- MyBatis自动去查然后封装到Order中的User属性  

    自动去查 是要在配置文件中去指定调用的sql语句(mapper的namespace + select Id)  
        
        
        
## 延迟加载：需要用到数据时再进行加载，不需要数据时就不加载数据。  
        亦称为懒加载  
        好处：先从单表进行查询，需要时再从关联表进行关联查询，大大提高数据库数据查询性能。  
            因为查询单表要比关联多张表速度要快。  
        坏处：因为只有当需要用到数据时，才会进行数据库查询，  
            这样在大批量数据查询时，因为查询工作也要消耗 时间，所以可能造成用户等待时间变长，造成用户体验下降。  

#  脏读，幻读，不可重复读的区别

1. 脏读（读取未提交数据）
A事务读取B事务尚未提交的数据，此时如果B事务发生错误并执行回滚操作，那么A事务读取到的数据就是脏数据
2. 不可重复读（前后多次读取，数据内容不一致）
事务A在执行读取操作，由整个事务A比较大，前后读取同一条数据需要经历很长的时间 。而在事务A第一次读取数据，比如此时读取了小明的年龄为20岁，事务B执行更改操作，将小明的年龄更改为30岁，此时事务A第二次读取到小明的年龄时，发现其年龄是30岁，和之前的数据不一样了，也就是数据不重复了，系统不可以读取到重复的数据，成为不可重复读。 
3. 幻读（前后多次读取，数据总量不一致）
事务A在执行读取操作，需要两次统计数据的总量，前一次查询数据总量后，此时事务B执行了新增数据的操作并提交后，这个时候事务A读取的数据总量和之前统计的不一样，就像产生了幻觉一样，平白无故的多了几条数据，成为幻读。
>原文链接：https://cloud.tencent.com/developer/article/1450773


