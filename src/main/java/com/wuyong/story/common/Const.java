package com.wuyong.story.common;

/**
 * created by JianGuo
 * on 2017/12/7
 * description: 常量
 */
public class Const {

    /* MD5盐值 */
    public static final String MD5_SALT = "geelysdafaqj23ou89ZXcj@#$@#$#@KJdjklj;D../dSF.,";


    /* 标签常量接口 */
    private interface Tag {
        /* 正常 */
        public Integer TAG_STATUS_NORMAL = 0;
        /* 禁用 */
        public Integer TAG_STATUS_DISABLED = 1;
        /* 逻辑删除 */
        public Integer TAG_STATUS_DELETE = 10;
    }

    /* 分类常量接口 */
    private interface Category {
        /* 正常 */
        public Integer CATEGORY_STATUS_NORMAL = 0;
        /* 禁用 */
        public Integer CATEGORY_STATUS_DISABLED = 1;
        /* 逻辑删除 */
        public Integer CATEGORY_STATUS_DELETE = 10;
    }

    /* 文章常量接口 */
    private interface Article {
        /* 正常 */
        public Integer ARTICLE_STATUS_NORMAL = 0;
        /* 禁用 */
        public Integer ARTICLE_STATUS_DISABLED = 1;
        /* 逻辑删除 */
        public Integer ARTICLE_STATUS_DELETE = 10;

        /* 原创 */
        public Integer ARTICLE_SOURCE_ORIGINAL = 0;
        /* 转载 */
        public Integer ARTICLE_SOURCE_REPRINT = 1;

        /* 不置顶 */
        public Integer ARTICLE_TOP_DEFAULT = 0;
        /* 置顶 */
        public Integer ARTICLE_TOP_YES = 1;

        /* 不推荐 */
        public Integer ARTICLE_RECOMMEND_DEFAULT = 0;
        /* 推荐 */
        public Integer ARTICLE_RECOMMEND_YES = 1;




    }


}
