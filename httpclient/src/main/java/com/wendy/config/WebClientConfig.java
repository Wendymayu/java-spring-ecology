package com.wendy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/17 14:29
 * @Version 1.0
 */
@Configuration
public class WebClientConfig {
    @Bean
    public WebClient webClient(){
        return WebClient.create();
    }

/*    @Bean
    ReactorResourceFactory resourceFactory() {
        ReactorResourceFactory factory = new ReactorResourceFactory();
        factory.setUseGlobalResources(false);
        factory.setConnectionProvider(ConnectionProvider.fixed("httpClient", 50, 10));
        factory.setLoopResources(LoopResources.create("httpClient", 50, true));
        return factory;
    }*/

/*    @Bean
    WebClient webClient() {
        Function<HttpClient, HttpClient> mapper = client ->
                client.tcpConfiguration(c ->
                        c.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 10)
                                .option(TCP_NODELAY, true)
                                .doOnConnected(conn -> {
                                    conn.addHandlerLast(new ReadTimeoutHandler(10));
                                    conn.addHandlerLast(new WriteTimeoutHandler(10));
                                }));

        ClientHttpConnector connector =
                new ReactorClientHttpConnector(resourceFactory(), mapper);

        return WebClient.builder().clientConnector(connector).build();
    }*/


}
