package com.korit.korit_gov_spring_boot_study.service;

import com.korit.korit_gov_spring_boot_study.dto.request.AddPostReqDto;
import com.korit.korit_gov_spring_boot_study.dto.response.*;
import com.korit.korit_gov_spring_boot_study.entity.Post;
import com.korit.korit_gov_spring_boot_study.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public ApiRespDto addPost(AddPostReqDto addPostReqDto) {
        if (postRepository.findPostByTitle(addPostReqDto.getTitle()) != null) {
            return new ApiRespDto("failed", "이미 존재하는 제목입니다.");
        }
        postRepository.addPost(addPostReqDto.toEntity());
        return new ApiRespDto("success", "게시물이 등록되었습니다.");
    }

    public ApiDataRespDto<?> getPostAll() {
        return new ApiDataRespDto<>("success", "전체조회를 완료했습니다.", postRepository.getPostAll());
    }

    public ApiDataRespDto<?> getPostByPostId(Integer postId) {
        Post foundPost = postRepository.findPostByPostId(postId);
        if (foundPost == null) {
            return new ApiDataRespDto<>("failed", "조회된 결과가 없습니다.", null);
        }
        return new ApiDataRespDto<>("success", "단건조회를 완료했습니다.", foundPost);
    }

    public ApiDataRespDto<?> getPostListByKeyword(String keyword) {
        return new ApiDataRespDto<>("success", "키워드 조회를 완료했습니다.", postRepository.findPostByKeyword(keyword));
    }
}
