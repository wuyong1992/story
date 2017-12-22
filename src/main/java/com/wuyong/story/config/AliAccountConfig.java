package com.wuyong.story.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by 坚果
 * on 2017/9/18
 * ali 配置项
 */
@Getter@Setter@ToString
@Component
@ConfigurationProperties(prefix = "ali.oss")
public class AliAccountConfig {

    /** 外网访问域名 */
    private String endpoint;

    /** 访问秘钥 */
    private String accessKeyId;

    /** 访问秘钥 */
    private String accessKeySecret;

    /** 存储空间名称 */
    private String bucketName;

    /** 自定义域名,用来替换endpoint */
    private String CNAME;

    /** 图片上传到指定文件夹下 */
    private String folder;





}
