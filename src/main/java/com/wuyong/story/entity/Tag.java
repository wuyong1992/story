package com.wuyong.story.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * created by JianGuo
 * on 2017/12/7
 * description: 标签
 */
@Entity
@Data
public class Tag {

    @Id
    @GeneratedValue
    private Integer tagId;

    /* 标签名称 */
    private String tagName;
    /* 标签状态 */
    private Integer tagStatus;
    /* 标签排序 */
    private Integer tagSort;

    private Date createTime;
    private Date updateTime;
    private Date deleteTime;

}
