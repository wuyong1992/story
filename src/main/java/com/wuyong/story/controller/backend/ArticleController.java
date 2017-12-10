package com.wuyong.story.controller.backend;

import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.entity.Article;
import com.wuyong.story.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by JianGuo
 * on 2017/12/10
 * description: 后台文章控制器
 */

@RestController
@RequestMapping(value = "/backend/article")
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @PostMapping(value = "save_article")
    private ServerResponse saveArticle(Article article) {
        return ArticleService.saveArticle(article);
    }

}
