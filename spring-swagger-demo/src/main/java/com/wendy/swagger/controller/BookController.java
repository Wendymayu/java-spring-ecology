package com.wendy.swagger.controller;

import com.wendy.swagger.entity.vo.BookVo;
import com.wendy.swagger.entity.vo.PageVo;
import com.wendy.swagger.service.BookService;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/10 17:14
 * @Version 1.0
 */
@Api(tags = "BookController", value = "book-controller")
@RestController
@RequestMapping(value = "/swagger-demo/v1/books")
public class BookController {
    @Resource
    private BookService bookService;

    @ApiOperation(value = "分页查询图书")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "offset", value = "页码"),
            @ApiImplicitParam(name = "limit", value = "条数"),
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "success", response = PageVo.class)})
    @GetMapping
    public PageVo<BookVo> queryAllBooks(@RequestParam("offset") int offset,
                                        @RequestParam("limit") int limit) {
        return bookService.queryAllBooks(offset, limit);
    }

    @ApiOperation(value = "查询图书详细信息")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "No Authority"),
            @ApiResponse(code = 200, message = "success", response = BookVo.class)})
    @GetMapping("/{id}")
    public BookVo queryBook(@ApiParam(name = "bookId", value = "图书id") @PathVariable("id") long bookId) {
        return bookService.queryBook(bookId);
    }

    @ApiOperation(value = "新录入一本图书")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "No Authority"),
            @ApiResponse(code = 200, message = "success", response = BookVo.class)})
    @PostMapping
    public BookVo addBook(@RequestBody BookVo bookVo) {
        return bookService.addBook(bookVo);
    }

    @ApiOperation(value = "更新录入的图书信息")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "No Authority"),
            @ApiResponse(code = 200, message = "success", response = BookVo.class)})
    @PutMapping("/{id}")
    public BookVo updateBook(@ApiParam(name = "bookId", value = "图书id") @PathVariable("id") long bookId,
                             @RequestBody BookVo bookVo) {
        return bookService.updateBook(bookId, bookVo);
    }

    @ApiOperation(value = "删除录入的图书信息")
    @ApiResponses(value = {
            @ApiResponse(code = 401, message = "No Authority"),
            @ApiResponse(code = 200, message = "success", response = String.class)})
    @DeleteMapping("/{id}")
    public String deleteBook(@ApiParam(name = "bookId", value = "图书id") @PathVariable("id") int bookId) {
        return bookService.deleteBook(bookId);
    }
}
