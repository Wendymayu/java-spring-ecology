package com.wendy.utils;

import com.wendy.grpc.BookServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/10/22 20:39
 * @Version 1.0
 */
public class RpcUtils {
    public static ManagedChannel getManagedChannel() {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext().build();
        return managedChannel;
    }

    public static BookServiceGrpc.BookServiceBlockingStub getBookServiceStub() {
        return BookServiceGrpc.newBlockingStub(RpcUtils.getManagedChannel());
    }
}
