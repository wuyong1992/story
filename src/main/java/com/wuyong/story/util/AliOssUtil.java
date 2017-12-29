package com.wuyong.story.util;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.wuyong.story.common.Const;
import com.wuyong.story.config.MyAliOssConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

/**
 * created by JianGuo
 * on 2017/12/25
 * description: 阿里云 OSS工具类
 */
@Slf4j
public class AliOssUtil {

    /* 图片上传 */
    public static String imageUpload(MultipartFile file, String folder) {
        // 1.构造OSSClient对象
        ClientConfiguration conf = new ClientConfiguration();
        conf.setSupportCname(true);
        OSSClient ossClient = new OSSClient(MyAliOssConfig.endpoint, MyAliOssConfig.accessKeyId, MyAliOssConfig.accessKeySecret, conf);

        // 2.判断文件是否为空
        if (file.isEmpty()) {
            // log.info("[文件上传]fil内容为空");
            return null;
        }

        // 3.上传
        // 获取文件原始名称并改名
        String fileName = file.getOriginalFilename();
        // log.info("【文件上传】file name: {}", fileName);
        //String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //+1,可以不要文件类型前面的"."
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1);
        log.info("【文件上传】文件后缀名：{}", suffixName);
        // todo 判断文件是否image
        // 如果属于图片，则重命名为当前时间+UUID
        fileName = DateUtil.format(new Date(), Const.DATE_FORMAT1) + UUID.randomUUID().toString() + "." + suffixName;
        // 组成key
        String key = folder + "/" + fileName;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(file.getBytes());
            ossClient.putObject(MyAliOssConfig.bucketName, key, byteArrayInputStream);
            //设置过期时间10年,构造返回参数
            Date expires = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10);
            /*GeneratePresignedUrlRequest generatePresignedUrlRequest =
                    new GeneratePresignedUrlRequest(aliAccountConfig.getBucketName(), key);
            generatePresignedUrlRequest.setExpiration(expires);*/
            //获取返回的url
            //URL url = ossClient.generatePresignedUrl(generatePresignedUrlRequest);
            URL url = ossClient.generatePresignedUrl(MyAliOssConfig.bucketName, key, expires);
            // log.info(url.toString());
            //列出所有OSS的存储信息
        /*ObjectListing objectListing = ossClient.listObjects(aliAccountConfig.getBucketName());
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" - " + objectSummary.getKey() + "  " +
                    "(size = " + objectSummary.getSize() + ")");
        }*/
            return url.toString();
        } catch (IOException e) {

            // log.info("【文件上传】文件类型MultipartFile转成字节数组Byte[]出现异常");
            e.printStackTrace();
            return null;
        }
    }


}
