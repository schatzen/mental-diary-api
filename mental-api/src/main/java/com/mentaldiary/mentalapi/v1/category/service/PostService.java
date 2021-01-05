package com.mentaldiary.mentalapi.v1.category.service;

import com.mentaldiary.mentalapi.entity.Category;
import com.mentaldiary.mentalapi.entity.Post;
import com.mentaldiary.mentalapi.entity.User;
import com.mentaldiary.mentalapi.respository.CategoryRepo;
import com.mentaldiary.mentalapi.respository.PostRepo;
import com.mentaldiary.mentalapi.respository.UserRepo;
import com.mentaldiary.mentalapi.v1.category.vo.PostVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {

    private final CategoryRepo categoryRepo;
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    // 게시글 작성
    public Post writePost(String email, String categoryName, PostVo vo) throws Exception {

        User user = userRepo.findByEmail(email).orElseThrow(Exception::new);
        Category category = categoryRepo.findByName(categoryName).orElseThrow(Exception::new);

        Post post = Post.builder()
                .category(category)
                .content(vo.getContent())
                .status("P")
                .priority(0)
                .user(user).build();

        return post;

    }

    // 게시글 조회
    public Post getPost(Long postId) throws Exception {
        Post post = postRepo.findById(postId).orElseThrow(Exception::new);
        return post;
    }

    // 게시글 수정
    public void editPost(Long postId, PostVo vo) {


    }

}
