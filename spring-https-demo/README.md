## 生成证书
```jshelllanguage
keytool -genkey -alias tomcat -dname "CN=Andy,OU=kfit,O=kfit,L=HaiDian,ST=BeiJing,C=CN" -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 365

```

## springboot配置证书
```yaml
server:
  port: 8081
  ssl:
    key-store: classpath:ssl/keystore.p12
    key-store-password: 52wendyma
    key-password: 52wendyma
    enabled-protocols: TLSv1.2,TLSv1.3
    ciphers:
```
注意要把生成的证书放在资源路径下

## 浏览器访问
浏览器访问以下地址会提示不安全的网站，这是因为我们使用的证书不是CA机构颁发的。
用户通过浏览器高级选项自己决定是否继续访问网站。
https://localhost:8081/https-demo/v1/hello

如果服务器没有同时开启http访问端口，则此时http无法访问到服务器。
生产环境中，我们会从CA机构申请证书，浏览器能够识别CA机构颁发的证书是合法的，就可建立
安全的https连接了。
