package com.wuyong.story.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * created by JianGuo
 * on 2017/12/7
 * description: 分类
 */
@Entity
@Data
public class Category {

    @Id
    @GeneratedValue
    private Integer categoryId;

    /* 分类名称 */
    private Integer categoryName;
    /* 父级分类id 如果为空则表示该分类是顶级分类 */
    private Integer parentId;
    /* 分类状态 */
    private Integer categoryStatus;
    /* 分类排序字段 */
    private Integer categorySort;

    private Date createTime;
    private Date updateTime;
    private Date deleteTime;

}
