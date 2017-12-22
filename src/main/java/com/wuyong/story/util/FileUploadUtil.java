package com.wuyong.story.util;

import com.aliyun.oss.OSSClient;
import com.wuyong.story.config.AliAccountConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

/**
 * created by JianGuo
 * on 2017/12/10
 * description:
 * 1.文件上传工具类 包括：图片、富文本中的图片、文件、富文本中的文件
 * 2.上传至七牛云或者阿里OSS
 */
public class FileUploadUtil {

    @Autowired
    private OSSClient ossClient;

    @Autowired
    private AliAccountConfig aliAccountConfig;

    private String fileUpload(MultipartFile file, String folder) {

        return null;
    }
}
