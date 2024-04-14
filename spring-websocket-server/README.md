# websocket协议
用于实现实时通讯功能，如即时消息推送、在线状态更新等。
# springboot整合websocket

# 微信用户聊天基本原理
微信两个用户之间的聊天是通过微信服务器进行中转和消息传递实现的。具体实现方式大致如下：

消息发送：当用户A发送消息给用户B时，消息首先会通过用户A的客户端发送到微信服务器。

消息中转：微信服务器接收到用户A发送的消息后，会将消息存储在服务器上，并标记为用户A发送给用户B的消息。

消息推送：微信服务器会向用户B的客户端推送消息，通知用户B有新消息到达。

消息展示：用户B的客户端接收到消息内容后，将消息展示给用户B，用户B可以查看并回复消息。

这样，通过微信服务器的中转和消息传递，实现了用户之间的即时聊天功能。微信还会对消息进行加密、安全验证等处理，以确保消息的安全性和用户隐私。


## 长连接
微信服务器向客户端推送消息通常采用长连接技术，主要包括以下步骤：

建立长连接：客户端在登录或启动应用时会与微信服务器建立长连接，通常使用WebSocket等技术。

保持连接：客户端和微信服务器之间的长连接会保持活跃状态，以便服务器可以随时向客户端推送消息。

消息推送：当有新消息需要推送给客户端时，微信服务器会将消息发送到客户端建立的长连接上。

客户端接收：客户端接收到服务器推送的消息后，会进行相应的处理，比如展示通知、更新消息列表等。

保持连接活跃：为了保持长连接的活跃状态，客户端和服务器会定期发送心跳包或保持连接的消息，以确保连接不会因超时而断开。

通过建立长连接并保持活跃，微信服务器可以实时向客户端推送消息，实现即时通讯功能。这种长连接机制可以减少消息传递的延迟，提高消息的实时性和用户体验
# 模拟微信A与B用户聊天
本例简单模拟A发消息给B这个过程：

1. A发送消息到服务端
2. 服务端推送消息给B
3. B收到消息后，告诉服务器接收成功
4. 服务器通知A消息发送成功

我不想在本地启动两个java客户端，因此用js实现客户端A，java实现客户端B。发消息时需要两个客户端同时在线。
## 浏览器实现客户端A
建立连接
```javascript
var socket = new WebSocket("ws://localhost:8080/websocket-server/v1/hello?userId=browser");

socket.onopen = function(event) {
    console.log("WebSocket opened");
};

socket.onmessage = function(event) {
    console.log("Message received: " + event.data);
};

socket.onclose = function(event) {
    console.log("WebSocket closed");
};
```
发送消息
```javascript
var obj = {
    "from": "idea",
    "to": "browser",
    "content": "你好，idea"
};
var jsonString = JSON.stringify(obj);
socket.send(jsonString);
```

## java实现客户端B
