package com.wendy.controller.webclient;

import com.wendy.client.webclient.RestServerWebClient;
import com.wendy.entity.BookPo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description Spring WebFlux的WebClient使用demo
 * @Author wendyma
 * @Date 2023/9/17 14:06
 * @Version 1.0
 */
@RestController
@RequestMapping("/httpclient/v1/webclient")
public class WebClientController {
    @Resource
    private RestServerWebClient restServerWebClient;

    @GetMapping("/books")
    public List<BookPo> queryAllBooks(@RequestParam("offset") int offset,
                                      @RequestParam("limit") int limit) {
        return restServerWebClient.queryAllBooks(offset, limit);
    }

    /**
     * RestTemplate GET请求
     * @param bookId
     * @return
     */
    @GetMapping("/books/{id}")
    public BookPo queryBook(@PathVariable("id") long bookId) {
        return restServerWebClient.queryBook(bookId);
    }

    /**
     * RestTemplate POST请求
     * @param bookPo
     * @return
     */
    @PostMapping("/books")
    public BookPo addBook(@RequestBody BookPo bookPo) {
        return restServerWebClient.addBook(bookPo);
    }

    /**
     * RestTemplate PUT请求
     * @param bookId
     * @param bookPo
     * @return
     */
    @PutMapping("/books/{id}")
    public BookPo updateBook(@PathVariable("id") long bookId, @RequestBody BookPo bookPo) {
        return restServerWebClient.updateBook(bookPo);
    }

    /**
     * RestTemplate DELETE请求
     * @param bookId
     * @return
     */
    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable("id") int bookId) {
        restServerWebClient.deleteBook(bookId);
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
        return restServerWebClient.queryAllBooks(offset, limit);
    }

    /**
     * 带path参数的RestTemplate请求
     * @param bookId
     * @return
     */
    @GetMapping("/path-params/{id}")
    public BookPo pathParams(@PathVariable("id") long bookId) {
        return restServerWebClient.queryBook(bookId);
    }

    /**
     * 带Header的RestTemplate请求
     * @return
     */
    @GetMapping("/headers")
    public String pathParams() {
        return restServerWebClient.headerRequest();
    }

    /**
     * 最一般的RestTemplate请求
     * @return
     */
    @PostMapping("/common/{id}")
    public String commonRequest(@PathVariable("id") long id,
                                @RequestParam("key") String key,
                                @RequestBody BookPo bookPo) {
        return restServerWebClient.commonRequest(id, key, bookPo);
    }
}
