package com.wuyong.story.Repository;

import com.wuyong.story.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by JianGuo
 * on 2017/12/29
 * description:标签 jpa
 */
@Repository
public interface TagRepository extends JpaRepository<Tag, Integer> {

    @Override
    List<Tag> findAll();
}
