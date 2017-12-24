package com.wuyong.story.service.impl;

import com.aliyun.oss.OSSClient;
import com.wuyong.story.common.Const;
import com.wuyong.story.config.AliAccountConfig;
import com.wuyong.story.service.FileService;
import com.wuyong.story.util.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.UUID;

/**
 * created by JianGuo
 * on 2017/12/23
 * description:
 */
@Service("fileService")
@Slf4j
public class FileServiceImpl implements FileService {


    @Autowired
    private OSSClient ossClient;

    @Autowired
    private AliAccountConfig aliAccountConfig;



    /**
     * 图片上传
     *
     * @param file   文件
     * @param folder 所要上传的阿里云OSS文件夹名称
     * @return
     */
    @Override
    public String imageUpload(MultipartFile file, String folder) {
        if (file.isEmpty()) {
            // log.info("[文件上传]fil内容为空");
            return "文件内容为空";
        }

        //获取文件原始名称并改名
        String fileName = file.getOriginalFilename();
        log.info("【文件上传】file name: {}", fileName);
        //String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //+1,可以不要文件类型前面的"."
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1);
        log.info("【文件上传】文件后缀名：{}", suffixName);
        // todo 判断文件是否image
        //如果属于图片，则重命名为当前时间+UUID
        fileName = DateUtil.format(new Date(), Const.DATE_FORMAT1) + UUID.randomUUID().toString() + "." + suffixName;
        //组成key
        String key = folder + "/" + fileName;
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(file.getBytes());
            ossClient.putObject(aliAccountConfig.getBucketName(), key, byteArrayInputStream);
            //设置过期时间10年,构造返回参数
            Date expires = new Date(new Date().getTime() + 3600L * 1000 * 24 * 365 * 10);
            /*GeneratePresignedUrlRequest generatePresignedUrlRequest =
                    new GeneratePresignedUrlRequest(aliAccountConfig.getBucketName(), key);
            generatePresignedUrlRequest.setExpiration(expires);*/
            //获取返回的url
            //URL url = ossClient.generatePresignedUrl(generatePresignedUrlRequest);
            URL url = ossClient.generatePresignedUrl(aliAccountConfig.getBucketName(), key, expires);
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
            return "文件上传失败";
        }
    }
}
