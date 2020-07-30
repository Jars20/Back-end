# what is MQ
MQ全称Message Queue，应用程序对应用程序的通信方法，  
目的：解耦发送方与接收方


# rabbitMQ实例
- 发送消息的方法(直接发送至队列，参数一：队列名称；参数二：信息)
public void send (String msg){  
    this.amqpTemplate.convertAndSend(”队列名称”,msg)；  
}
- 走交换器的方法（先发送至交换器，再通过路由键发送至接收者，参数一：交换器名；参数二：路由键；参数三：信息）
public void send (String msg){  
    this.amqpTemplate.convertAndSend(this.exchange,” 路由键名”,msg)；  
}
- 交换器（exchange）
1. direct（发布与订阅完全匹配）(一对一)
2. fanout（）（一对多）
3. topic（多对多）

# 信道（channnel）
- 为什么引入信道
  - TCP创建和销毁的开销太大，创建需要三次握手，销毁需要四次分手；
  - 不使用信道则需要用TCP来链接rabbit，会造成巨大的资源浪费，而且操作系统操作TCP数量也是有限制的，会造成性能瓶颈；
  - 信道的原理是一条线程一条通道，N条线程N条通道，同用一条TCP链接，一条TCP链接可以容纳无数条信道，即时每秒成千上万的信息也不会成为性能瓶颈；

## autodelete属性
用在@Queue或@Exchange中，表示当所有消费客户端连接断开后，是否自动删除 队列 或者 交换器

## RabbitMQ 中的消息确认 ACK 机制
1、什么是消息确认ACK。

　　答：如果在处理消息的过程中，消费者的服务器在处理消息的时候出现异常，那么可能这条正在处理的消息就没有完成消息消费，数据就会丢失。为了确保数据不会丢失，RabbitMQ支持消息确定-ACK。

2、ACK的消息确认机制。

　　答：ACK机制是消费者从RabbitMQ收到消息并处理完成后，反馈给RabbitMQ，RabbitMQ收到反馈后才将此消息从队列中删除。  

- 如果一个消费者在处理消息出现了网络不稳定、服务器异常等现象，那么就不会有ACK反馈，RabbitMQ会认为这个消息没有正常消费，会将消息重新放入队列中。  
- 如果在集群的情况下，RabbitMQ会立即将这个消息推送给这个在线的其他消费者。这种机制保证了在消费者服务端故障的时候，不丢失任何消息和任务。  
- 消息永远不会从RabbitMQ中删除，只有当消费者正确发送ACK反馈，RabbitMQ确认收到后，消息才会从RabbitMQ服务器的数据中删除。  
- 消息的ACK确认机制默认是打开的。