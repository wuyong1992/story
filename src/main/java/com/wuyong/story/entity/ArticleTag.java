package com.wuyong.story.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * created by JianGuo
 * on 2017/12/9
 * description: 文章与标签关联表
 */

@Entity
@Data
public class ArticleTag implements Serializable {

    private static final long serialVersionUID = 6053172092167744367L;

    @Id
    private Integer articleId;

    @Id
    private Integer tagId;
}
