package com.wuyong.story.service.impl;

import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.service.TagService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * created by JianGuo
 * on 2017/12/29
 * description:
 */
@Service(value = "tagService")
@Transactional
public class TagServiceImpl implements TagService{

    @Override
    public ServerResponse addTag(String name) {
        return null;
    }
}
