package com.wuyong.story.controller.backend;

import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.entity.Article;
import com.wuyong.story.entity.User;
import com.wuyong.story.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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

    @RequestMapping(value = "upload")
    private String upload(MultipartFile file) {
        log.info("file:{}",file);

        return "http://img.bbs.csdn.net/upload/201409/11/1410417123_921560.png";
    }

}
