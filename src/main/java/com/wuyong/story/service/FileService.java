package com.wuyong.story.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * created by JianGuo
 * on 2017/12/23
 * description: 文件操作相关的服务
 */
public interface FileService {

    String imageUpload(MultipartFile file, String folder);
}
