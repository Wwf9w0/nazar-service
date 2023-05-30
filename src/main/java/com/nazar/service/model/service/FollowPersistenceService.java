package com.nazar.service.model.service;

import com.nazar.service.model.entity.FollowerEntity;
import com.nazar.service.model.entity.FollowingEntity;
import com.nazar.service.model.entity.UserEntity;
import com.nazar.service.model.repository.FollowerRepository;
import com.nazar.service.model.repository.FollowingRepository;
import com.nazar.service.model.request.FollowingUserRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class FollowPersistenceService {

    private final FollowingRepository followingRepository;
    private final FollowerRepository followerRepository;
    private final UserPersistenceService userPersistenceService;
    private static int ONE = 1;

    public void followingUser(FollowingUserRequest request) {
        UserEntity user = userPersistenceService.getUserByUserId(request.getUserId());
        UserEntity followingUser = userPersistenceService.getUserByUserId(request.getFollowingUserId());

        FollowingEntity followingEntity = FollowingEntity.builder()
                .followingUserId(followingUser.getId())
                .user(user)
                .build();
        updateFollowingCount(user);
        updateFollowerCount(followingUser);
        followingRepository.save(followingEntity);
    }


    public void followerUser(Long followerUserId, UserEntity user) {
        FollowerEntity followerEntity = FollowerEntity.builder()
                .followerUserId(followerUserId)
                .user(user)
                .build();
        followerRepository.save(followerEntity);
    }

    public void updateFollowingCount(UserEntity user) {
        if (Objects.isNull(user.getFollowing())) {
            return;
        }
        long count = user.getFollowing().size();
        int lastCount = Math.toIntExact(count + ONE);
        user.setFollowerCount(lastCount);
    }

    public void updateFollowerCount(UserEntity user) {
        if (Objects.isNull(user.getFollower())) {
            return;
        }
        long count = user.getFollower().size();
        int lastCount = Math.toIntExact(count + ONE);
        user.setFollowerCount(lastCount);
    }

}
