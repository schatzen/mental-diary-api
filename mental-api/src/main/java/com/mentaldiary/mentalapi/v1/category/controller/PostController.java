package com.mentaldiary.mentalapi.v1.category.controller;

import com.mentaldiary.mentalapi.entity.Post;
import com.mentaldiary.mentalapi.v1.category.service.PostService;
import com.mentaldiary.mentalapi.v1.category.vo.PostParam;
import com.mentaldiary.mentalapi.v1.category.vo.PostVo;
import com.mentaldiary.mentalapi.v1.response.service.ResponseService;
import com.mentaldiary.mentalapi.v1.response.vo.CommonResult;
import com.mentaldiary.mentalapi.v1.response.vo.ListResult;
import com.mentaldiary.mentalapi.v1.response.vo.SingleResult;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"2. Post"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/post")
public class PostController {

    private final ResponseService responseService;
    private final PostService postService;

    // 게시글 작성
    @PostMapping(value = "/{categoryName}/add")
    @ApiOperation(value = "게시글 작성", notes = "글을 작성합니다.")
    public SingleResult<Long> writePost(
            @ApiParam(value = "카테고리 (free,therapy,tarot)", required = true) @PathVariable String categoryName,
            @ApiParam(required = true) @RequestBody PostParam vo) throws Exception {
        Post post = postService.writePost(categoryName, vo);
        return responseService.getSingleResult(post.getId());
    }

    // 게시글 조회
    @GetMapping(value = "/{categoryName}/{postIdx}")
    @ApiOperation(value = "게시글 조회", notes = "해당 글을 조회합니다.")
    public SingleResult<PostVo> getPost(
            @ApiParam(value = "카테고리 (free,therapy,tarot)") @PathVariable String categoryName,
            @ApiParam(value = "게시글 고유번호", required = true) @PathVariable Long postIdx) throws Exception {

        PostVo postVo = postService.getPost(categoryName, postIdx);

        return responseService.getSingleResult(postVo);
    }

    // 카테고리변 전체 게시글 조회
    @GetMapping(value = "/{categoryName}/list")
    @ApiOperation(value = "전체 게시글 조회", notes = "해당 카테고리의 모든 글을 조회합니다.")
    public ListResult<PostVo> getPostList(
            @ApiParam(value = "카테고리 (free,therapy,tarot)", required = true) @PathVariable String categoryName) throws Exception {

        List<PostVo> postList = postService.getPostList(categoryName);

        return responseService.getListResult(postList);
    }

    // 게시글 수정
    @PutMapping(value = "/{categoryName}/{postIdx}/edit")
    @ApiOperation(value = "게시글 수정", notes = "해당 글을 수정합니다.")
    public SingleResult<Long> editPost(
            @ApiParam(value = "카테고리 (free,therapy,tarot)") @PathVariable String categoryName,
            @ApiParam(value = "게시글 고유번호", required = true) @PathVariable Long postIdx,
            @ApiParam(required = true) @RequestBody PostParam vo
    ) throws Exception {

        PostVo postVo = postService.editPost(postIdx, vo);

        return responseService.getSingleResult(postVo.getId());
    }

    // 게시글 삭제
    @DeleteMapping(value = "/{categoryName}/{postIdx}/delete")
    @ApiOperation(value = "게시글 삭제", notes = "해당 글을 삭제합니다.")
    public CommonResult deletePost(
            @ApiParam(value = "카테고리 (free,therapy,tarot)") @PathVariable String categoryName,
            @ApiParam(value = "게시글 고유번호", required = true) @PathVariable Long postIdx
    ) throws Exception {

        postService.deletePost(postIdx);

        return responseService.getSuccessResult();
    }


}
