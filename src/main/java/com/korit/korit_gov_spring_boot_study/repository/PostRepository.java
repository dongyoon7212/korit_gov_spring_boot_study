package com.korit.korit_gov_spring_boot_study.repository;

import com.korit.korit_gov_spring_boot_study.entity.Post;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepository {
    private List<Post> postList;

    private PostRepository() {
        postList = new ArrayList<>();
    }

    public Post findPostByTitle(String title) {
        return postList.stream()
                .filter(post -> post.getTitle().equals(title))
                .findFirst()
                .orElse(null);

    }

    public void addPost(Post post) {
        post.setPostId(postList.size() + 1);
        postList.add(post);
    }

    public List<Post> getPostAll() {
        return postList;
    }

    public Post findPostByPostId(Integer postId) {
        return postList.stream()
                .filter(post -> post.getPostId().equals(postId))
                .findFirst()
                .orElse(null);
    }

    public List<Post> findPostByKeyword(String keyword) {
        return postList.stream()
                .filter(post -> post.getTitle().contains(keyword))
                .toList();
    }
}
