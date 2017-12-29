package com.wuyong.story.controller.backend;

import com.google.common.collect.Maps;
import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.entity.Article;
import com.wuyong.story.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * created by JianGuo
 * on 2017/12/10
 * description: 后台文章控制器
 */

@RestController
@RequestMapping(value = "/backend/article")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "save_article")
    private ServerResponse saveArticle(Article article) {
        return articleService.saveArticle(article);
    }

    @RequestMapping(value = "rich_text_image_upload")
    private Map richTextImageUpload(MultipartFile file) {
        log.info("file:{}", file);
        String richTextImageUrl = articleService.richTextImageUpload(file);
        Map resultMap = Maps.newHashMap();
        if (richTextImageUrl != null) {
            resultMap.put("link", richTextImageUrl);
            return resultMap;
        } else {
            return null;
        }
    }

    @RequestMapping("image_upload")
    private String imageUpload(MultipartFile file) {
        String imageResultUrl = articleService.imageUpload(file);
        return imageResultUrl;
    }


    @RequestMapping(value = "article_upload")
    private ServerResponse articleUpload(Article article) {
        return null;
    }
}
