package com.wuyong.story.controller.backend;

import com.google.common.collect.Maps;
import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.config.AliAccountConfig;
import com.wuyong.story.entity.Article;
import com.wuyong.story.service.ArticleService;
import com.wuyong.story.service.FileService;
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
    @Autowired
    private FileService fileService;
    @Autowired
    private AliAccountConfig aliAccountConfig;


    @PostMapping(value = "save_article")
    private ServerResponse saveArticle(Article article) {
        return articleService.saveArticle(article);
    }

    @RequestMapping(value = "upload")
    private Map upload(MultipartFile file) {
        log.info("file:{}",file);
        String imageUrl = fileService.imageUpload(file, aliAccountConfig.getFolder());
        Map resultMap = Maps.newHashMap();
        if (imageUrl != null) {
            resultMap.put("link", imageUrl);
            return resultMap;
        } else {
            return null;
        }

    }

}
