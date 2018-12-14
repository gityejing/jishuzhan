这里用到的案例是quartz和spring4的结合使用，有两种不同的触发器方式
如果是quartz和spring3结合使用，会有写不同，参考如下：


两种不同的触发器，分别在spring3和spring4中的不同：
org.springframework.scheduling.quartz.SimpleTriggerBean（spring3） 
org.springframework.scheduling.quartz.SimpleTriggerFactoryBean（spring4）

org.springframework.scheduling.quartz.CronTriggerBean（spring3） 
org.springframework.scheduling.quartz.CronTriggerFactoryBean（spring4）


