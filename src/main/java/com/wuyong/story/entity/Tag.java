package com.wuyong.story.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
