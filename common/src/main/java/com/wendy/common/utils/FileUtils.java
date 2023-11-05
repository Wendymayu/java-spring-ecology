package com.wendy.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @Description 文件校验工具类
 * @Author wendyma
 * @Date 2023/9/21 23:44
 * @Version 1.0
 */
public class FileUtils {
    private static final int MAX_NAME_SIZE = 256;

    private static final int MB = 1024 * 1024;

    private static final int MAX_FILE_SIZE = 5 * MB;

    private static final List<String> SUPPORTED_FILE = List.of("doc", "docx");

    public static void checkNameLength(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            throw new RuntimeException("File name cannot be empty.");
        }
        int nameLength = fileName.length();
        if (nameLength > MAX_NAME_SIZE) {
            throw new RuntimeException("File name is too long.");
        }
    }

    public static void checkFileType(String fileName) {
        int index = fileName.indexOf(".");
        if (index == -1 || index == fileName.length() - 1) {
            throw new RuntimeException("File no suffix.");
        }

        String type = fileName.substring(index + 1);
        if (!SUPPORTED_FILE.contains(type)) {
            throw new RuntimeException("System don't support this kind of file.");
        }
    }

    public static String getFileType(File file) {
        String fileName = file.getName();
        int index = fileName.indexOf(".");
        if (index == -1 || index == fileName.length() - 1) {
            throw new RuntimeException("File no suffix.");
        }
        return fileName.substring(index + 1);
    }

    public static void checkFileSize(File file) {
        checkFileSize(file.length());
    }

    public static void checkFileSize(long fileSize) {
        if (fileSize > MAX_FILE_SIZE) {
            throw new RuntimeException("File is too big.");
        }
    }

    public static void createFile(File filePath) {
        File parentFile = filePath.getParentFile();
        // 先创建目录
        if (!parentFile.exists()) {
            parentFile.mkdirs();
        }
        // 再创建文件
        if (!filePath.exists()) {
            try {
                filePath.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
