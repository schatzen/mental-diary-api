package com.mentaldiary.mentalapi.v1.category.service;

import com.mentaldiary.mentalapi.entity.Category;
import com.mentaldiary.mentalapi.entity.Post;
import com.mentaldiary.mentalapi.entity.User;
import com.mentaldiary.mentalapi.respository.CategoryRepo;
import com.mentaldiary.mentalapi.respository.PostRepo;
import com.mentaldiary.mentalapi.respository.UserRepo;
import com.mentaldiary.mentalapi.utils.ModelMapperUtil;
import com.mentaldiary.mentalapi.v1.category.vo.PostParam;
import com.mentaldiary.mentalapi.v1.category.vo.PostVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {

    private final CategoryRepo categoryRepo;
    private final PostRepo postRepo;
    private final UserRepo userRepo;

    // 게시글 작성
    public Post writePost(String email, String categoryName, PostParam vo) throws Exception {

        User user = userRepo.findByEmail(email).orElseThrow(Exception::new);
        Category category = categoryRepo.findByName(categoryName).orElseThrow(Exception::new);

        Post post = Post.builder()
                .category(category)
                .content(vo.getContent())
                .status("P")
                .priority(0)
                .user(user).build();

        post = postRepo.save(post);

        return post;

    }

    // 게시글 조회
    public PostVo getPost(String categoryName, Long postIdx) throws Exception {
        Post post = postRepo.findById(postIdx).orElseThrow(Exception::new);

        PostVo postVo = ModelMapperUtil.getModelMapper().map(post, PostVo.class);
        return postVo;
    }

    // 카테고리별 전체 게시글 조회
    public List<PostVo> getPostList(String categoryName) throws Exception {
        List<PostVo> postVoList = new ArrayList<PostVo>();
        List<Post> postList = new ArrayList<Post>();

        Category category = categoryRepo.findByName(categoryName).orElseThrow(Exception::new);
        postList = postRepo.findByCategory(category).orElseThrow(Exception::new);

        postVoList = postList
                .stream()
                .map(post -> ModelMapperUtil.getModelMapper().map(post, PostVo.class))
                .collect(Collectors.toList());

        return postVoList;
    }


    public PostVo editPost(Long postIdx, PostParam postParam) throws Exception {
        Post post = postRepo.findById(postIdx).orElseThrow(Exception::new);
        post.setContent(postParam.getContent());
        postRepo.save(post);

        PostVo postVo = ModelMapperUtil.getModelMapper().map(post, PostVo.class);

        return postVo;
    }

    public void deletePost(Long postIdx) throws Exception{
        Post post = postRepo.findById(postIdx).orElseThrow(Exception::new);
        postRepo.delete(post);
    }
}
