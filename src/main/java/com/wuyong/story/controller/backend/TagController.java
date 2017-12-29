package com.wuyong.story.controller.backend;

import com.google.common.collect.Lists;
import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.entity.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by JianGuo
 * on 2017/12/28
 * description: 标签
 */
@RestController
@RequestMapping(value = "/backend/tag")
public class TagController {


    @RequestMapping(value = "get_tag_list")
    private ServerResponse getTagList() {
        List<Tag> tagList = Lists.newArrayList();
        Tag tag1 = new Tag();
        Tag tag2 = new Tag();
        tag1.setTagName("测试1");
        tag2.setTagName("测试2");
        tagList.add(tag1);
        tagList.add(tag2);
        return ServerResponse.createBySuccess(tagList);
    }

    @RequestMapping(value = "add_tag")
    private ServerResponse addTag(String name) {
        return null;
    }
}
