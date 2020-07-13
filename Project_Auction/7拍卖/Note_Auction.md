建数据库时会遇到很多坑，现在将它们记录下来。

# 1. ENGINE=InnoDB\MyISAM
对比：
1. InnoDB支持事务，MyISAM不支持
2. MyISAM适合查询以及插入为主的应用，InnoDB适合频繁修改以及涉及到安全性较高的应用
3. InnoDB支持外键，MyISAM不支持
4. 从MySQL5.5.5以后，InnoDB是默认引擎
5. InnoDB不支持FULLTEXT类型的索引
6. InnoDB中不保存表的行数，如select count() from table时，InnoDB需要扫描一遍整个表来计算有多少行，但是MyISAM只要简单的读出保存好的行数即可。注意的是，当count()语句包含where条件时MyISAM也需要扫描整个表
7. 对于自增长的字段，InnoDB中必须包含只有该字段的索引，但是在MyISAM表中可以和其他字段一起建立联合索引
8. 清空整个表时，InnoDB是一行一行的删除，效率非常慢。MyISAM则会重建表
9. InnoDB支持行锁（某些情况下还是锁整表，如 update table set a=1 where user like ‘％lee％’。
>（https://zq.zhaopin.com/answer/6161223/）

# 2.float与double的选择
在设计数据表时，突然发现原来FLOAT原来是很不靠谱的，所以在这里建议大家换成DOUBLE类型，
原因是：
在数据库中的所有计算都是使用双精度完成的，使用float(单精度)会有误差，出现意想不到的结果。
在我们查询数据时，查询字段sumper值为5.54，sql语句：select * from app_mobile_device lo where lo.sumper= ‘5.54’；
但是结果却显示没有查到数据，实际是数据库中有sumper值为5.54的，这就是float类型造成的精度丢失的问题。一旦精度丢失了
float(5.54) = 5.54 这个是不等的。这样，本来我们应该能查到的数据就会莫名其妙的消失。

所以我们在设计数据库字段类型是小数类型时我们都用double类型，在数据库中也就是decimal类型。
当我们把字段的类型修改为decimal,我们再使用select * from app_mobile_device lo where lo.sumper= ‘5.54’；
结果我们就查出来了sumper为5.54的数据。所以我们在设计数据库使用小数字段类型千万不要选用float类型。
————————————————
原文链接：https://blog.csdn.net/shiAndyuanfang/java/article/details/84967352



# 3.Java 向数据库中输入 datetime类型数据
ava.sql.Date只表示数据库中日期的部分，如果想向数据库中写入完整的时间，如2016-12-11 17:10:25.000 则需要使用java.sql.Timestamp这个类。 

1. 字符串转化为Date
```java
DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // 这里填写的是想要进行转换的时间格式
String str = "2016-12-11 17:17:10";         // 时间字符串
java.utils.Date date = null;
try{
date = format.parse(str);
}catch(Exception e){
e.printStackTrace();
}
```

2. Date转化为字符串
```java
DateFormat format = new SimpleDateFormat("yyyy-MM-dd kk:mm:ss");    // 这里填写的是想要进行转换的时间格式
Date date = new java.utils.Date();      // 获取当前时间
String str = format.format(date);
// str = "2016-12-11 17:17:10"
```

3. 读取精确到秒的时间：java.sql.Timestamp
```java
    Date date = new Date();  
    Timestamp timeStamp = new Timestamp(date.getTime());  

```
在生成java.utils.Date时，将时间精确到s，然后使用预编译语句执行SQL语句
```java
Date date = new Date();  
Timestamp timeStamp = new Timestamp(date.getTime()); 
 sql= "insert into flowmeter2(total,std_flow,temp,press,time) values(?,?,?,?,?)";   
        try {  
            PreparedStatement ps = connection.prepareStatement(sql);  
            ps.setString(1, total);  
            ps.setString(2, std_flow);  
            ps.setString(3, temp);  
            ps.setString(4, press);  
            ps.setTimestamp(5, timeStamp);  
            ps.executeUpdate();  
            System.out.println("添加成功！");  
            connection.close();  
————————————————
原文链接：https://blog.csdn.net/jcq521045349/java/article/details/53574177
```

4. Integer.parseInt(s)与Integer.valueOf(s)的区别
> Integer.parseInt(s)得到的是int类型
> Integer.parseInt(s)多次解析同一个字符串得到的int基本类型数据是相等的，可以直接通过“==”进行判断是否相等。
> 1.valueOf内部调用了parseInt； 2.parseInt期待输入值是String； 3.valueOf返回一个Integer类型，需要装箱；