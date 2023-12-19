package com.wendy.grpc.impl;

import com.wendy.entity.BookVo;
import com.wendy.grpc.BookInfo;
import com.wendy.grpc.BookServiceClient;
import com.wendy.grpc.QueryBookRequest;
import com.wendy.utils.ProtobufBeanUtils;
import com.wendy.utils.RpcUtils;
import org.springframework.stereotype.Service;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/22 15:49
 * @Version 1.0
 */
@Service
public class BookServiceClientImpl implements BookServiceClient {

    @Override
    public BookVo queryBook(long bookId) {
        QueryBookRequest queryBookRequest = QueryBookRequest.newBuilder().setBookId(bookId).build();
        BookInfo bookInfo = RpcUtils.getBookServiceStub()
                .queryBook(queryBookRequest);
        BookVo bookVo = ProtobufBeanUtils.proto2Bean(bookInfo, BookVo.class);
        return bookVo;
    }

}
