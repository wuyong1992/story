-- 用户表
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`(
  `user_id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` VARCHAR(50) UNIQUE NOT NULL COMMENT '用户名',
  `password` VARCHAR(50) NOT NULL COMMENT '登录密码，MD5加密',
  `create_time` TIMESTAMP NOT NULL DEFAULT current_timestamp COMMENT '创建时间',
  `update_time` TIMESTAMP NOT NULL DEFAULT current_timestamp ON UPDATE current_timestamp COMMENT '修改时间',
  PRIMARY KEY (`user_id`)
)ENGINE = InnoDB DEFAULT CHARSET = utf8 COMMENT '用户表';
