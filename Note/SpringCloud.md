# 微服务
## what
通常而言，微服务架构是一种架构模式，或者说一种架构风格，提倡将单一的应用程序划分成一组小的服务，每组服务运行在其独立的进程内，服务之间相互协调相互配置。即服务代码模块化。

1. 微服务架构的四个核心问题：
- 服务器很多，客户端怎么访问
- 这么多服务，服务间怎么通信
- 这么多服务，如何治理
- 服务器挂了怎么办

2. 解决方案： SpringCloud  生态！      
- Spring cloud NetFlix  
>api网关，zuul组件
>Feign-----HttpClient---------Http通信方式
>服务注册发现：Eureka
>熔断机制：Hystrix

- Apache Dubbo Zookeeper
Api：没有，找第三方组件
Dubbo：专一的RPC通信框架
Zookeeper

- Spring Cloud Alibaba 一站式解决方案


新概念：服务网格 Server Mesh

核心：
- API网关
- HTTP，RPC 通信
- 服务的注册和发现（高可用）
- 熔断机制

## SpringCloud
SpringCloud基于SpringBoot提供了一套微服务解决方案。  
分布式微服务架构的一站式解决方案，是多种微服务架构落地技术的集合体，俗称微服务全家桶  
SpringBoot版本与SpringCloud依赖:
技术选型：http://start.spring.io/actuator/info  
查看json串返回结果
|SpringCloud|SpringBoot|
|---|---|
|H|2.2.X|
|G|2.1.X|


### SpringCloud与SpringBoot的关系
- SpringBoot专注于快速方便地开发单个个体的微服务。
- SpringCloud是关注全局的微服务整合治理协调框架，将SpringBoot开发的一个个单体微服务整合并管理起来，为各个微服务之间提供：配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策精选、分布式会话等集成服务。
- 两者处于依赖关系，SpringCloud依赖于SpringBoot

## RESTful与RBC
