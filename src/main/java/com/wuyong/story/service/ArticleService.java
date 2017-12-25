package com.wuyong.story.service;

import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.entity.Article;
import org.springframework.web.multipart.MultipartFile;

/**
 * created by JianGuo
 * on 2017/12/10
 * description:
 */
public interface ArticleService {

    ServerResponse saveArticle(Article article);

    String richTextImageUpload(MultipartFile file);

}
