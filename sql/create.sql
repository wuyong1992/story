-- init v1.0.0

-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
  `user_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` VARCHAR(50) UNIQUE NOT NULL COMMENT '用户名',
  `phone` VARCHAR(25) UNIQUE NOT NULL COMMENT '用户手机号，同时也是登录账号',
  `password` VARCHAR(50) NOT NULL COMMENT '登录密码，MD5加密',
  `avatar` VARCHAR(255) DEFAULT NULL  COMMENT '用户头像',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户表';


-- 标签表
DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag` (
  `tag_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '标签id',
  `tag_name` VARCHAR(50) UNIQUE NOT NULL COMMENT '标签名称',
  `tag_status` TINYINT(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '标签状态，0：正常；1：禁用；10：逻辑删除',
  `tag_sort` INT(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '标签排序，默认值0，值越大越靠前',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间',
  `delete_time` TIMESTAMP COMMENT '逻辑删除时间',
  PRIMARY KEY (`tag_id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '标签表';


-- 分类表
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`(
  `category_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `category_name` VARCHAR(50) UNIQUE NOT NULL COMMENT '分类名称',
  `parent_id` INT(11) UNSIGNED COMMENT '父级分类id，如果为null则表示该分类是顶级分类',
  `category_status` TINYINT(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '标签状态，0：正常；1：禁用；10：逻辑删除',
  `category_sort` INT(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '标签排序，默认值0，值越大越靠前',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间',
  `delete_time` TIMESTAMP COMMENT '逻辑删除时间',
  PRIMARY KEY (`category_id`)
)ENGINE =InnoDB AUTO_INCREMENT = 1000 DEFAULT CHARSET = utf9 COMMENT '文章分类表';


-- 文章信息表
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article`(
  `article_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文章id',
  `article_title` VARCHAR(255) NOT NULL COMMENT '文章标题',
  `user_id` INT(11) UNSIGNED NOT NULL COMMENT '发布者id',
  `article_source` TINYINT(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '文章来源，0：原创；1：转载，默认0',
  `article_audience` TINYINT(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '文章受众，0：所有人可见；1：仅自己可见，默认0',
  `article_top` TINYINT(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否置顶，0：默认排序；1：置顶，默认0',
  `article_recommend` TINYINT(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否推荐，0：不推荐；1：推荐，默认0',
  `article_click` INT(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '文章点击量，默认刚创建的时候为0',
  `article_content_id` INT(11) UNSIGNED COMMENT '文章内容id',
  `article_status` TINYINT(2) UNSIGNED NOT NULL DEFAULT 0 COMMENT '文章状态，0：正常；1：禁用；10：逻辑删除',
  `article_sort` INT(11) UNSIGNED NOT NULL DEFAULT 0 COMMENT '文章排序字段',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间',
  `delete_time` TIMESTAMP COMMENT '逻辑删除时间',
  PRIMARY KEY (`article_id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '文章信息表';


-- 文章内容表
DROP TABLE IF EXISTS `article_content`;
CREATE TABLE `article_content` (
  `article_content_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '文章内容id',
  `article_content_detail` LONGTEXT COMMENT '存放文章富文本内容',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间',
  `delete_time` TIMESTAMP COMMENT '逻辑删除时间',
  PRIMARY KEY (`article_content_id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '文章内容表';


-- 文章与标签关联表
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag`(
  `article_id` INT(11) UNSIGNED NOT NULL COMMENT '文章id',
  `tag_id` INT(11) UNSIGNED NOT NULL COMMENT '标签表',
  PRIMARY KEY (`article_id`, `tag_id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '文章与标签关联表';




-- v1.0.1
-- 文章表增加缩略图和缩略主图字段
ALTER TABLE article ADD `article_thumbnail` JSON COMMENT '文章缩略图json格式';
ALTER TABLE article ADD `article_main_thumbnail` VARCHAR(255) COMMENT '主缩略图';





























