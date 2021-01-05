package com.mentaldiary.mentalapi.v1.category.controller;

import com.mentaldiary.mentalapi.entity.Post;
import com.mentaldiary.mentalapi.v1.category.service.PostService;
import com.mentaldiary.mentalapi.v1.category.vo.PostVo;
import com.mentaldiary.mentalapi.v1.response.service.ResponseService;
import com.mentaldiary.mentalapi.v1.response.vo.SingleResult;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = {"2. Post"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/post")
public class PostController {

    private final ResponseService responseService;
    private final PostService postService;

    // 게시글 작성
    public SingleResult<Post> writePost(String email, String categoryName, PostVo vo) throws Exception {
        Post post = postService.writePost(email, categoryName, vo);
        return responseService.getSingleResult(post);
    }

    public SingleResult<Post> getPost(Long postId) throws Exception {
        Post post = postService.getPost(postId);
        return responseService.getSingleResult(post);

    }
}
