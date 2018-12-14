### mybatis plus 使用心得

    1，实体类上最好加上@TableName，@TableId，@TableField注解，并且形成规范。避免不必要的麻烦。
    
    2，javabean 属性名采用驼峰命名，mp 全局配置默认开启了使用下划线，可以配置关闭，这样就保持了数据库字段名和javabean属性名的一致性。
    
    3，