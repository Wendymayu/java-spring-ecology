package com.wendy.file.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description TODO
 * @Author wendyma
 * @Date 2023/9/28 20:55
 * @Version 1.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileVo {
    private long fileId;

    private String fileName;

    private String fileType;
}
