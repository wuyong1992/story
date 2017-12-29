package com.wuyong.story.config;

/**
 * created by JianGuo
 * on 2017/12/25
 * description: 阿里云配置
 */

public class MyAliOssConfig {


    /* 外网访问域名 */
    public static String endpoint = "oss-cn-shanghai.aliyuncs.com";

    /* 访问秘钥 */
    public static String accessKeyId = "LTAICspanl7W8l0H";

    /* 访问秘钥 */
    public static String accessKeySecret = "YIuRyxeBO9KmK5pl0YikE3LNY2hPoJ";

    /* 存储空间名称 */
    public static String bucketName = "story-1992";

    /* 自定义域名,用来替换endpoint */
    public static String CNAME = "story-oss.huyunyun.com";

    /* 图片上传到指定文件夹下 */
    public static String IMAGE_FOLDER = "image";

    /* 富文本中的图片文件夹 */
    public static String RICH_TEXT_IMAGE_FOLDER = "richtext/image";
}
