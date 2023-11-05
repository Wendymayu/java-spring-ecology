package com.wendy.client.webclient.impl;

import com.wendy.client.webclient.RestServerWebClient;
import com.wendy.constants.RequestPaths;
import com.wendy.entity.BookPo;
import com.wendy.entity.vo.PageVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/17 14:21
 * @Version 1.0
 */
@Service
public class RestServerWebClientImpl implements RestServerWebClient {
    @Value("${rest-server.host}")
    private String restServerHost;

    @Resource
    private WebClient webClient;

    @Override
    @SuppressWarnings("unchecked")
    public List<BookPo> queryAllBooks(int offset, int limit) {
        Mono<PageVo> pageVoMono = WebClient.create(restServerHost)
                .get()
                .uri(uriBuilder -> uriBuilder.path(RequestPaths.QUERY_ALL_BOOKS)
                        .queryParam("offset", offset)
                        .queryParam("limit", limit)
                        .build())
                .retrieve()
                .bodyToMono(PageVo.class);

        List<BookPo> bookPos = pageVoMono.block().getDatas();
        if (CollectionUtils.isEmpty(bookPos)) {
            return Collections.EMPTY_LIST;
        }
        return bookPos;
    }

    @Override
    public BookPo queryBook(long bookId) {
        Mono<BookPo> bookPoMono = webClient.get()
                .uri(restServerHost + RequestPaths.QUERY_BOOK, bookId)
                .retrieve()
                .bodyToMono(BookPo.class);
        return bookPoMono.block();
    }

    @Override
    public BookPo addBook(BookPo bookPo) {
        Mono<BookPo> bookPoMono = webClient.post()
                .uri(restServerHost + RequestPaths.ADD_BOOK)
                .bodyValue(bookPo)
                .retrieve()
                .bodyToMono(BookPo.class);
        return bookPoMono.block();
    }

    @Override
    public BookPo updateBook(BookPo bookPo) {
        Mono<BookPo> bookPoMono = webClient.put()
                .uri(restServerHost + RequestPaths.UPDATE_BOOK, bookPo.getId())
                .bodyValue(bookPo)
                .retrieve()
                .bodyToMono(BookPo.class);
        return bookPoMono.block();
    }

    @Override
    public void deleteBook(long bookId) {
        webClient.delete()
                .uri(restServerHost + RequestPaths.DELETE_BOOK, bookId)
                .retrieve();
    }

    @Override
    public String headerRequest() {
        Mono<String> mono = webClient.get()
                .uri(restServerHost + RequestPaths.REQUEST_HEADER)
                .header("Authorization", "affafa")
                .retrieve()
                .bodyToMono(String.class);
        return mono.block();
    }

    @Override
    public String commonRequest(long id, String key, BookPo bookPo) {
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("id", id);

        Mono<String> mono = webClient.post()
                .uri(uriBuilder -> uriBuilder.scheme("http")
                        .host("localhost")
                        .port(8081)
                        .path(RequestPaths.COMMON_REQUEST)
                        .queryParam("key", key)
                        .build(uriVariables))
                .header("Authorization", "hfkagak")
                .bodyValue(bookPo)
                .retrieve()
                .bodyToMono(String.class);
        return mono.block();
    }
}
