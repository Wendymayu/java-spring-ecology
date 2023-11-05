package com.wendy.controller.resttemplate;

import com.wendy.client.resttemplate.RestTemplateClient;
import com.wendy.entity.BookPo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/16 23:32
 * @Version 1.0
 */
@RestController
@RequestMapping("/httpclient/v1/rest-template")
public class RestTemplateController {
    @Resource
    private RestTemplateClient restTemplateClient;

    @GetMapping("/books")
    public List<BookPo> queryAllBooks(@RequestParam("offset") int offset,
                                      @RequestParam("limit") int limit) {
        return restTemplateClient.queryAllBooks(offset, limit);
    }

    /**
     * RestTemplate GET请求
     * @param bookId
     * @return
     */
    @GetMapping("/books/{id}")
    public BookPo queryBook(@PathVariable("id") long bookId) {
        return restTemplateClient.queryBook(bookId);
    }

    /**
     * RestTemplate POST请求
     * @param bookPo
     * @return
     */
    @PostMapping("/books")
    public BookPo addBook(@RequestBody BookPo bookPo) {
        return restTemplateClient.addBook(bookPo);
    }

    /**
     * RestTemplate PUT请求
     * @param bookId
     * @param bookPo
     * @return
     */
    @PutMapping("/books/{id}")
    public BookPo updateBook(@PathVariable("id") long bookId, @RequestBody BookPo bookPo) {
        return restTemplateClient.updateBook(bookPo);
    }

    /**
     * RestTemplate DELETE请求
     * @param bookId
     * @return
     */
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int bookId) {
        restTemplateClient.deleteBook(bookId);
    }

    /**
     * 带query参数的RestTemplate请求
     * @param offset
     * @param limit
     * @return
     */
    @GetMapping("/query-params")
    public List<BookPo> queryParams(@RequestParam("offset") int offset,
                                      @RequestParam("limit") int limit) {
        return restTemplateClient.queryAllBooks(offset, limit);
    }

    /**
     * 带path参数的RestTemplate请求
     * @param bookId
     * @return
     */
    @GetMapping("/path-params/{id}")
    public BookPo pathParams(@PathVariable("id") long bookId) {
        return restTemplateClient.queryBook(bookId);
    }

    /**
     * 带Header的RestTemplate请求
     * @return
     */
    @GetMapping("/headers")
    public String pathParams() {
        return restTemplateClient.headerRequest();
    }

    /**
     * 最一般的RestTemplate请求
     * @return
     */
    @PostMapping("/common/{id}")
    public String commonRequest(@PathVariable("id") long id,
                                @RequestBody BookPo bookPo) {
        return restTemplateClient.commonRequest(id, bookPo);
    }
}
