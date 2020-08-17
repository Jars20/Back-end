1. Spring
spring：IoC（Inverse Of Control： 反转控制）和   
        AOP（Aspect Oriented Programming：面向切面编程）为内核，  
提供了展现层 Spring MVC 和  
     持久层 Spring JDBC 以及  
     业务层 事务管理等众多的企业级应用技术

2. 内聚与耦合
程序讲究的是 低耦合，高内聚。就是同一个模块内的各个元素之间要高度紧密，但是各个模块之间的相互 依存度却要不那么紧密。

3. 工厂模式解耦 
在实际开发中我们可以把三层的对象都使用配置文件配置起来，当启动服务器应用加载的时候，让一个类中的方法通过读取配置文件，把这些对象创建出来并存起来。在接下来的使用的时候，直接拿过来用就好了。那么，这个读取配置文件，创建和获取三层对象的类就是工厂。
什么是工厂？   
工厂就是负责从容器中获取指定对象的类。这时候我们获取对象的方式发生了改变。

4. 控制反转-Inversion Of Control(IOC)
原来在获取对象时，都是采用 new 的方式。是主动的。  
获取对象时，跟工厂要，有工厂为我们查找或者创建对象。是被动的。   
这种被动接收的方式获取对象的思想就是控制反转，它是 spring 框架的核心之一。  

5. AOP:AOP是Spring框架面向切面的编程思想。  
AOP采用一种称为“横切”的技术，将涉及多业务流程的通用功能抽取并单独封装，形成独立的切面，在合适的时机将这些切面横向切入到业务流程的指定位置。  
这样做的好处是提高了代码的重用性和可维护性。

5. 依赖注入：Dependency Injection  
Spring框架核心IOC的具体实现  
简单的说，就是坐等框架把持久层对象传入业务层，而不用我们自己去获取，有效降低了耦合性

6. 常用注解：  

@Component   
>作用：把资源让 spring 来管理。相当于在 xml 中配置一个 bean。

@Controller @Service @Repository   
>他们三个注解都是针对一个的衍生注解，他们的作用及属性都是一模一样的。 他们只不过 是提供了更加明确的语义化。   
@Controller：一般用于表现层的注解。   @Service：一般用于业务层的注解。   @Repository：一般用于持久层的注解。   
细节：如果注解中有且只有一个属性要赋值时，且名称是 value，value 在赋值是可以不写。

@Autowired  
>作用： 自动按照类型注入。当使用注解注入属性时，set 方法可以省略。它只能注入其他 bean 类型。当有多个 类型匹配时，使用要注入的对象变量名称作为 bean 的 id，在 spring 容器查找，找到了也可以注入成功。找不到 就报错。

@Qualifier
>作用： 在自动按照类型注入的基础之上，再按照 Bean的id注入。  
它在给字段注入时不能独立使用，必须和@Autowire一起使用；但是给方法参数注入时，可以独立使用。属性：value：指定 bean 的 id。

@Resource
>作用：直接按照 Bean 的 id 注入。它也只能注入其他bean 类型.  
属性： name：指定bean的id。

@Value 
>作用： 注入基本数据类型和 String 类型数据的  
属性： value：用于指定值

@Scope 
>作用： 指定 bean 的作用范围。  
 取值：singleton prototype request session globalsession



@Configuration
>  用于指定当前类是一个 spring 配置类，当创建容器时会从该类上加载注解。获取容器时 需要使用 AnnotationApplicationContext(有@Configuration 注解的类.class)

@ComponentScan
> - 作用： 用于指定 spring 在初始化容器时要扫描的包。作用和在 spring 的 xml 配置 文件中的： <context:component-scan base-package="com.itheima"/>是一样的。   
>- 属性： basePackages：用于指定要扫描的包。和该注解中的 value 属性作用一样。

>eg.
>- @Configuration
@ComponentScan("club.banyuan")
@PropertySource("classpath:const.properties")
public class SpringConfiguration {
} 

@Bean 
>- 作用： 该注解只能写在方法上，表明使用此方法创建一个对象，并且放入 spring 容器。  
>- 属性： name：给当前@Bean 注解方法创建的对象指定一个名称(即 bean 的 id）。

7. 通过注解获得容器
>//ApplicationContext ctx =   
new AnnotationConfigApplicationContext(club.banyuan.config.SpringConfiguration.class);

8. 事务控制：  
业务层臃肿----业务层方法和事务控制方法耦合  
-->动态代理：字节码随用随创建，随用随加载。
与静态代理（装饰者模式）的最大差别。  
两种方法：
- Proxy：A a=（A）Proxy.newProxyInstance(   
        a1.getClass().getClassLoader(),   
        a1.getClass().getInterfaces(),   
        new InvocationHandler() {
                
        @Override public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
