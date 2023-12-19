package com.wendy.utils;

import com.google.gson.Gson;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;

import java.io.IOException;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/12/19 22:46
 * @Version 1.0
 */
public class ProtobufBeanUtils {
    /**
     * 将ProtoBean对象转化为POJO对象
     *
     * @param message 含有数据的ProtoBean对象实例
     * @param target  目标POJO对象的类类型
     * @return T
     * @throws IOException
     */
    public static <T> T proto2Bean(Message message, Class<T> target) {
        try {
            String json = JsonFormat.printer().print(message);
            return new Gson().fromJson(json, target);
        } catch (Exception e) {
            throw new RuntimeException("proto2Bean error.");
        }
    }

    /**
     * 将POJO对象转化为ProtoBean对象
     *
     * @param sourceBean  含有数据的POJO对象
     * @param destBuilder 目标Message对象的Builder类
     * @return
     * @throws IOException
     */
    public static <T> void pojo2Proto(T sourceBean, Message.Builder destBuilder) {
        try {
            String json = new Gson().toJson(sourceBean);
            JsonFormat.parser().merge(json, destBuilder);
        } catch (Exception e) {
            throw new RuntimeException("pojo2Proto error.");
        }

    }
}
