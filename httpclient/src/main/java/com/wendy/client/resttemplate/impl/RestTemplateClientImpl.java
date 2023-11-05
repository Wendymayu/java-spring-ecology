package com.wendy.client.resttemplate.impl;

import com.wendy.client.resttemplate.RestTemplateClient;
import com.wendy.constants.RequestPaths;
import com.wendy.entity.BookPo;
import com.wendy.entity.vo.PageVo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.Resource;
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/16 23:42
 * @Version 1.0
 */
@Service
public class RestTemplateClientImpl implements RestTemplateClient {
    @Value("${rest-server.host}")
    private String restServerHost;

    @Resource
    private RestTemplate restTemplate;

    @Override
    @SuppressWarnings("unchecked")
    public List<BookPo> queryAllBooks(int offset, int limit) {
        String url = restServerHost + RequestPaths.QUERY_ALL_BOOKS;
        UriComponents uriComponents = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("offset", offset)
                .queryParam("limit", limit)
                .build();
        PageVo pageVo = restTemplate.getForObject(uriComponents.toUri(), PageVo.class);
        List<BookPo> bookPos = Collections.EMPTY_LIST;
        if (CollectionUtils.isNotEmpty(pageVo.getDatas())) {
            bookPos = (List<BookPo>) pageVo.getDatas();
        }
        return bookPos;
    }

    @Override
    public BookPo queryBook(long bookId) {
        String url = restServerHost + RequestPaths.QUERY_BOOK;
        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("id", bookId);
        return restTemplate.getForObject(url, BookPo.class, uriVariables);
    }

    @Override
    public BookPo addBook(BookPo bookPo) {
        String url = restServerHost + RequestPaths.ADD_BOOK;
        return restTemplate.postForObject(url, bookPo, BookPo.class);
    }

    @Override
    public BookPo updateBook(BookPo bookPo) {
        String url = restServerHost + RequestPaths.UPDATE_BOOK;
        Map<String, Long> uriVariables = new HashMap<>();
        uriVariables.put("id", bookPo.getId());
        restTemplate.put(url, bookPo, uriVariables);
        return bookPo;
    }

    @Override
    public void deleteBook(long bookId) {
        String url = restServerHost + RequestPaths.DELETE_BOOK;
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("id", bookId);
        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .build(uriVariables);
        restTemplate.delete(uri.toString());
    }

    @Override
    public String headerRequest() {
        String url = restServerHost + RequestPaths.REQUEST_HEADER;
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "hfkagak");
        HttpEntity<Void> httpEntity = new HttpEntity<>(httpHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(url, HttpMethod.GET,
                httpEntity, String.class);
        return responseEntity.getBody();
    }

    @Override
    public String commonRequest(long id, BookPo bookPo) {
        String url = restServerHost + RequestPaths.COMMON_REQUEST;

        // 设置path与query参数
        Map<String, Object> uriVariables = new HashMap<>();
        uriVariables.put("id", id);
        URI uri = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("key", "key")
                .build(uriVariables);

        // 设置Header与请求体
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", "hfkagak");
        HttpEntity<BookPo> httpEntity = new HttpEntity<>(bookPo, httpHeaders);

        // 发送请求
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.POST,
                httpEntity, String.class);
        return responseEntity.getBody();
    }
}
