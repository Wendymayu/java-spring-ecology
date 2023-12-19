package com.wendy.grpc.service;

import com.wendy.grpc.BookInfo;
import com.wendy.grpc.BookServiceGrpc;
import com.wendy.grpc.QueryBookRequest;
import com.wendy.grpc.dao.BookDao;
import com.wendy.grpc.dao.po.BookPo;
import com.wendy.grpc.utils.ProtobufBeanUtils;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.BeanUtils;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/10 17:21
 * @Version 1.0
 */
@GrpcService
public class BookServiceImpl extends BookServiceGrpc.BookServiceImplBase {
    @Resource
    private BookDao bookDao;

    @Override
    public void queryBook(QueryBookRequest request, StreamObserver<BookInfo> responseObserver) {
        BookPo bookPo = bookDao.findById(request.getBookId()).get();
        BookInfo.Builder builder = BookInfo.newBuilder();
        ProtobufBeanUtils.bean2Proto(bookPo, builder);
        responseObserver.onNext(builder.build());
        responseObserver.onCompleted();
    }

    @Transactional
    public BookPo addBook(BookPo bookPo) {
        BeanUtils.copyProperties(bookPo, bookPo);
        bookDao.save(bookPo);
        return bookPo;
    }

    public BookPo updateBook(BookPo bookPo) {
        bookDao.save(bookPo);
        return bookPo;
    }

    public String deleteBook(long bookId) {
        bookDao.deleteById(bookId);
        return "delete book success";
    }
}
