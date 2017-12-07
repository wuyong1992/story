package com.wuyong.story.mapper;

import com.wuyong.story.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * created by JianGuo
 * on 2017/12/7
 * description:
 */
@Component
public interface UserMapper {

    User selectUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    int insertUserByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
}
