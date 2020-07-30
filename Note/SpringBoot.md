# SpringBoot
随着新功能的增加，Spring变的越来越复杂，如果必须启动新的Spring项目，则必须添加构建路径或添加Maven依赖项，配置应用程序服务器，添加Spring配置。
SpringBoot是解决这个问题的方法。使用SpringBoot可以避免所有样板代码和配置。


# SpringBoot的核心功能
- 起步依赖
将某种功能的坐标打包到一起并提供一些默认的功能
- 自动配置

# Mybatis代码自动生成
1. 
- 配置文件：
    - 数据源jdbcConnection
    - Mapper文件路径
    - Mapper接口文件路径
    - 实体类路径
- 运行GenerateordDisplay中的main方法
- 复制实体类，mapper接口，sqlMapper以及所有的Mapper父接口MyMapper到新建工程中。在新建工程中引入一个tk.Mybatis坐标：  mapper-spring-boot-statrter

2. 

