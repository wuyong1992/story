package com.wuyong.story.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * created by JianGuo
 * on 2017/12/9
 * description: 文章内容
 */

@Entity
@Data
public class ArticleContent {

    @Id
    @GeneratedValue
    private Integer articleContentId;
    /* 文章内容表 */
    private String articleContentDetail;


    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
