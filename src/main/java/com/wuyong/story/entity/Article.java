package com.wuyong.story.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * created by JianGuo
 * on 2017/12/7
 * description: 文章信息表
 */

@Entity
@Data
public class Article {

    @Id
    @GeneratedValue
    private Integer articleId;

    /* 文章标题 */
    private String articleTitle;
    /* 文章发布者id */
    private Integer userId;
    /* 文章来源 */
    private Integer articleSource;
    /* 文章受众 */
    private Integer articleAudience;
    /* 是否置顶 */
    private Integer articleTop;
    /* 是否推荐 */
    private Integer articleRecommend;
    /* 文章点击量 */
    private Integer articleClick;
    /* 文章内容id */
    private Integer articleContentId;
    /* 文章状态 */
    private Integer articleStatus;
    /* 文章排序字段 */
    private Integer articleSort;
    /* 文章缩略图 json格式 */
    private String articleThumbnail;
    /* 文章主缩略图 */
    private String articleMainThumbnail;



    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
