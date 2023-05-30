package com.nazar.service.model.service;

import com.nazar.service.model.entity.PostEntity;
import com.nazar.service.model.entity.UserEntity;
import com.nazar.service.model.repository.PostRepository;
import com.nazar.service.model.request.CreatePostRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostPersistenceService {
    private final UserPersistenceService userPersistenceService;
    private final PostRepository postRepository;
    public void savePost(CreatePostRequest request) {
        UserEntity user = userPersistenceService.getUserByUserId(request.getUserId());
        PostEntity post = PostEntity.builder()
                .description(request.getDescription())
                .createdDate(request.getShareDate())
                .isPrivate(request.getIsPrivate())
                .user(user)
                .build();
        postRepository.save(post);
    }


    public List<PostEntity> getPostListByUserId(Long userId) {
        return userPersistenceService.getUserByUserId(userId).getPost();
    }


}
