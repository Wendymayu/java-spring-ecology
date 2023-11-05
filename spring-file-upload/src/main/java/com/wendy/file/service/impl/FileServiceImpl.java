package com.wendy.file.service.impl;

import com.wendy.common.exception.CommonException;
import com.wendy.common.exception.ErrorCode;
import com.wendy.common.utils.FileUtils;
import com.wendy.file.dao.FileDao;
import com.wendy.file.dao.po.FilePo;
import com.wendy.file.entity.FileVo;
import com.wendy.file.service.FileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/28 21:01
 * @Version 1.0
 */
@Slf4j
@Service
public class FileServiceImpl implements FileService {
    @Value("${local-file-server.spring-file-upload.root-path}")
    private String fileRootPath;

    @Resource
    private FileDao fileDao;

    @Override
    @Transactional
    public FileVo upload(MultipartFile multipartFile) {
        // 校验文件
        checkFile(multipartFile);

        // 保存文件
        String filePath = fileRootPath + UUID.randomUUID().toString() + File.separator
                + multipartFile.getOriginalFilename();
        File file = new File(filePath);
        FileUtils.createFile(file);
        try (InputStream inputStream = multipartFile.getInputStream();
             FileOutputStream outputStream = new FileOutputStream(file)) {
            byte[] buffer = new byte[1024];
            while (inputStream.read(buffer) != -1) {
                outputStream.write(buffer);
            }
            outputStream.flush();
        } catch (IOException e) {
            log.error("upload file to local file server error.");
            throw new RuntimeException("upload file to local file server error.");
        }

        // 记录文件信息到数据库
        FilePo filePo = new FilePo();
        filePo.setFileName(multipartFile.getOriginalFilename());
        filePo.setFilePath(filePath);
        String fileType = FileUtils.getFileType(file);
        filePo.setFileType(fileType);
        fileDao.save(filePo);

        // 响应信息
        return FileVo.builder()
                .fileId(filePo.getId())
                .fileName(file.getName())
                .fileType(fileType)
                .build();
    }

    @Override
    public List<FileVo> multiUpload(MultipartHttpServletRequest multipartHttpServletRequest) {
        File photoPath;
        Iterator<String> iterator = multipartHttpServletRequest.getFileNames();
        while (iterator.hasNext()) {
            MultipartFile file = multipartHttpServletRequest.getFile(iterator.next());
            String fileName = null;
            if (file != null) {
                fileName = file.getOriginalFilename();
            }
            String filePath = fileRootPath + UUID.randomUUID().toString() + File.separator;
            photoPath = new File(filePath + fileName);
            FileUtils.createFile(photoPath);
            try (OutputStream os = new FileOutputStream(photoPath);
                 //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
                 InputStream is = file.getInputStream()) {
                byte[] bts = new byte[1024];
                //读取字节数据写入输出流
                while (is.read(bts) != -1) {
                    os.write(bts);
                }
            } catch (IOException e) {
                log.error("upload file failed");
                throw new CommonException(ErrorCode.INTERNAL_ERROR);
            }
        }
        return new ArrayList<>();
    }

    private void checkFile(MultipartFile multipartFile) {
        if (Objects.isNull(multipartFile)) {
            throw new RuntimeException("multipartFile does not exist.");
        }
        String fileName = multipartFile.getOriginalFilename();
        FileUtils.checkNameLength(fileName);
        FileUtils.checkFileType(fileName);
        FileUtils.checkFileSize(multipartFile.getSize());
    }

    @Override
    public ResponseEntity<byte[]> download(long fileId) {
        Optional<FilePo> optional = fileDao.findById(fileId);
        if (optional.isEmpty()) {
            throw new RuntimeException("Resource does not exist.");
        }
        FilePo filePo = optional.get();

        try (FileInputStream inputStream = new FileInputStream(filePo.getFilePath());) {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes);

            HttpHeaders headers = new HttpHeaders();
            headers.add("Content-Disposition", "attachment;filename=" + filePo.getFileName());
            headers.add("Content-Type", "application/octet-stream");
            HttpStatus statusCode = HttpStatus.OK;
            return new ResponseEntity<>(bytes, headers, statusCode);
        } catch (FileNotFoundException e) {
            log.error("file uploading failed, may be file not exist");
            throw new RuntimeException("File not found.");
        } catch (IOException e) {
            throw new RuntimeException("Download file failed.");
        }
    }
}
