package com.wendy.file.service;

import com.wendy.file.entity.FileVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/28 20:58
 * @Version 1.0
 */
public interface FileService {
    /**
     * 一次上传单个文件
     *
     * @param multipartFile 文件
     * @return
     */
    FileVo upload(MultipartFile multipartFile);


    /**
     * 一次上传多个文件
     *
     * @param multipartHttpServletRequest 多媒体文件请求
     * @return
     */
    List<FileVo> multiUpload(MultipartHttpServletRequest multipartHttpServletRequest);

    /**
     * 下载文件
     *
     * @param fileId
     * @return
     */
    ResponseEntity<byte[]> download(long fileId);
}
