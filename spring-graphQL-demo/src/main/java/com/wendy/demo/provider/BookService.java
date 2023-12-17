package com.wendy.demo.provider;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.wendy.demo.entity.Book;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/17 22:14
 * @Version 1.0
 */
@Service
public class BookService implements GraphQLQueryResolver {
    public Book bookById(String id){
        Book book = new Book();
        book.setId("book1");
        book.setName("test");
        return book;
    }
}
