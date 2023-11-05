package com.wendy.file.controller;

import com.wendy.file.entity.FileVo;
import com.wendy.file.service.FileService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/28 20:52
 * @Version 1.0
 */
@RestController
@RequestMapping("/spring-file/v1")
public class FileController {
    @Resource
    private FileService fileService;

    @PostMapping("/upload")
    public FileVo upload(@RequestParam("file") MultipartFile multipartFile){
        return fileService.upload(multipartFile);
    }

    @PostMapping("/multi-upload")
    public List<FileVo> multiUpload(HttpServletRequest httpServletRequest){
        MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) httpServletRequest;
        return fileService.multiUpload(multipartHttpServletRequest);
    }

    @GetMapping("/download/{fileId}")
    public ResponseEntity<byte[]> download(@PathVariable("fileId") long fileId){
        return fileService.download(fileId);
    }
}
