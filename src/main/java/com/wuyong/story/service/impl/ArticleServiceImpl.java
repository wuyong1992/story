package com.wuyong.story.service.impl;

import com.wuyong.story.common.ServerResponse;
import com.wuyong.story.config.MyAliOssConfig;
import com.wuyong.story.entity.Article;
import com.wuyong.story.service.ArticleService;
import com.wuyong.story.util.AliOssUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Override
    public String richTextImageUpload(MultipartFile file) {
        String folder = MyAliOssConfig.richTextImageFolder;
        return AliOssUtil.richTextImageUpload(file, folder);
    }


}
