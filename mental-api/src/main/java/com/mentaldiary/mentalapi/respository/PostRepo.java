package com.mentaldiary.mentalapi.respository;

import com.mentaldiary.mentalapi.entity.Category;
import com.mentaldiary.mentalapi.entity.Post;
import com.mentaldiary.mentalapi.entity.User;
import com.mentaldiary.mentalapi.v1.category.vo.PostVo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepo extends JpaRepository<Post, Long> {

    // 해당 카테고리의 모든 post를 불러올 때. 인자를 컬럼명이 아닌 객체로 받음
    Optional<List<Post>> findByCategory(Category category);

}
