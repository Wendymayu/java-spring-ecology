package com.wendy.constants;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/17 10:25
 * @Version 1.0
 */
public interface RequestPaths {
    String QUERY_ALL_BOOKS = "/rest-demo/v1/books";

    String ADD_BOOK = "/rest-demo/v1/books";

    String QUERY_BOOK = "/rest-demo/v1/books/{id}";

    String UPDATE_BOOK = "/rest-demo/v1/books/{id}";

    String DELETE_BOOK = "/rest-demo/v1/books/{id}";

    String REQUEST_HEADER  = "/rest-demo/v1/request/header";

    String COMMON_REQUEST  = "/rest-demo/v1/request/common/{id}";
}