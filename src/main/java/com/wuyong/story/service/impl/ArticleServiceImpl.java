package com.wuyong.story.service.impl;

import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.entity.Article;
import com.wuyong.story.service.ArticleService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * created by JianGuo
 * on 2017/12/10
 * description:
 */


@Service("articleService")
@Transactional
public class ArticleServiceImpl implements ArticleService {


    @Override
    public ServerResponse saveArticle(Article article) {
        return null;
    }



}
