package com.mentaldiary.mentalapi.v1.category.controller;

import com.mentaldiary.mentalapi.entity.Post;
import com.mentaldiary.mentalapi.v1.category.service.PostService;
import com.mentaldiary.mentalapi.v1.category.vo.PostVo;
import com.mentaldiary.mentalapi.v1.response.service.ResponseService;
import com.mentaldiary.mentalapi.v1.response.vo.SingleResult;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Api(tags = {"2. Post"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/post")
public class PostController {

    private final ResponseService responseService;
    private final PostService postService;

    // 게시글 작성
    @PostMapping(value = "/post")
    @ApiOperation(value = "게시글 작성", notes = "글을 작성합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    public SingleResult<Post> writePost(@ApiParam(value = "유저 email", required = true) String email,
                                        @ApiParam(value = "카테고리", required = true) String categoryName,
                                        @ApiParam(required = true) @RequestBody PostVo vo) throws Exception {
        Post post = postService.writePost(email, categoryName, vo);
        return responseService.getSingleResult(post);
    }

    @PutMapping(value = "/edit/{postId}")
    @ApiOperation(value = "게시글 수정", notes = "글을 수정합니다.")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 access_token", required = true, dataType = "String", paramType = "header")
    })
    public SingleResult<Post> getPost(@ApiParam(value = "게시글 고유번호", required = true) @PathVariable Long postId) throws Exception {
        Post post = postService.getPost(postId);
        return responseService.getSingleResult(post);

    }
}
