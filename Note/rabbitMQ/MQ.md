# what is MQ
MQ全称Message Queue，应用程序对应用程序的通信方法，  
目的：解耦发送方与接收方


# rabbitMQ实例
- 发送消息的方法(直接发送至队列，参数一：队列名称；参数二：信息)
public void send (String msg){  
    this.amqpTemplate.convertAndSend(”队列名称”,msg)；  
}
- 交换器（exchange）
1. direct（发布与订阅完全匹配）


2. fanout
3. topic

# 信道（channnel）
- 为什么引入信道
  - TCP创建和销毁的开销太大，创建需要三次握手，销毁需要四次分手；
  - 不使用信道则需要用TCP来链接rabbit，会造成巨大的资源浪费，而且操作系统操作TCP数量也是有限制的，会造成性能瓶颈；
  - 信道的原理是一条线程一条通道，N条线程N条通道，同用一条TCP链接，一条TCP链接可以容纳无数条信道，即时每秒成千上万的信息也不会成为性能瓶颈；

