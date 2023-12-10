package com.wendy.demo.config;

import org.apache.catalina.connector.Connector;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 该配置类用于配置同时支持http
 * @Author wendyma
 * @Date 2023/12/10 22:41
 * @Version 1.0
 */
//@Configuration
public class TomcatConfig {
    @Bean
    public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
        TomcatServletWebServerFactory tomcat = new TomcatServletWebServerFactory();
        tomcat.addAdditionalTomcatConnectors(httpConnector());
        return tomcat;
    }

    @Bean
    public Connector httpConnector() {
        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
        connector.setScheme("http");

        // 这里不能https和http同时使用同一个端口，否则会报端口占用重复。Connector监听的http的端口号8080
        connector.setPort(8080);
        connector.setSecure(true);
        // 监听到http的端口号后转向到的https的端口号，这可让服务器同时支持http/https
        connector.setRedirectPort(8081);
        return connector;
    }
}
