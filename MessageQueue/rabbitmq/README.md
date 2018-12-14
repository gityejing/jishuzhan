# rabbitmq
rabbitmq入门学习代码



1，生产者将消息发送出去之后，消息到底有没有到达消息中间件服务器呢？不做处理的话，根本就不知道。

- 通过协议的方式 AMQP，实现了事务机制
- 通过comfirm模式

## AMQP 方式

txSelect
txCommit
txRollback

缺点：消耗性能，降低了吞吐量。


# comfirm 模式

最大的好处在于异步。

怎么开启：
channel.confirmSelect();
编程模式：
1，普通发一条 waitForConfirms();
2，批量发一批  waitForConfirms();
3,异步，提供一个回调方法







