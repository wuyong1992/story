package com.wuyong.story.config;

import com.aliyun.oss.ClientConfiguration;
import com.aliyun.oss.OSSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * Created by 坚果
 * on 2017/9/18
 * ali oss 对象存储 （弃用）
 */
@Component
public class AliOssConfig {

    @Autowired
    private AliAccountConfig aliAccountConfig;

    @Bean
    public OSSClient ossClient() {
        String endpoint = aliAccountConfig.getCNAME();
        String accessKeyId = aliAccountConfig.getAccessKeyId();
        String accessKeySecret = aliAccountConfig.getAccessKeySecret();
        ClientConfiguration conf = new ClientConfiguration();
        conf.setSupportCname(true);
        return new OSSClient(endpoint,accessKeyId,accessKeySecret,conf);
    }
}
