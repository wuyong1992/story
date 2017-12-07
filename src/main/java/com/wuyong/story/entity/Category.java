package com.wuyong.story.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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

}
