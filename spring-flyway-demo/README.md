# h2注意点
jdbc:h2:~/blog h2会在用户目录下创建blog数据库

h2提供了内置的web客户端
http://localhost:8080/h2/login.do

# flyway注意点
resources下面创建db然后在创建migration文件夹用于存放数据库版本控制语句。

开头必须以V1，V2等开口，第几个文件就V几，接着就是两个下划线 __ ，后面就用sql的简要说明。