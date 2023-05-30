package com.nazar.service.service;

import com.nazar.service.model.entity.NazarEntity;
import com.nazar.service.model.entity.UserEntity;
import com.nazar.service.model.entity.UserNazarEntity;
import com.nazar.service.model.request.SocialActivityRequest;
import com.nazar.service.model.response.SocialActivityResponse;
import com.nazar.service.model.service.UserPersistenceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SocialActivityService {

    private final UserService userService;

    public SocialActivityResponse getActivityForUser(SocialActivityRequest request) {
        UserEntity user = userService.getUserById(request.getUserId());
        List<NazarEntity> nazarEntities = user.getNazars();
        List<UserNazarEntity> userNazarEntities = user.getMyNazars();

        return SocialActivityResponse
                .builder()
                .nazar(nazarEntities)
                .toNazar(userNazarEntities)
                .nazarCount(nazarEntities.size())
                .toNazarCount(userNazarEntities.size())
                .followingCount(user.getFollowingCount())
                .followerCount(user.getFollowerCount())
                .nazarLevel(user.getNazarLevel().getLevel())
                .build();
    }

    public SocialActivityResponse seeFollowingActivity(Long userId, Long otherUserId) {
        boolean isSee = isSeeActivity(userId, otherUserId);
        if (!isSee) {
            return null;
        }
        SocialActivityRequest socialActivityRequest = SocialActivityRequest
                .builder()
                .userId(userId)
                .build();
        return getActivityForUser(socialActivityRequest);
    }

    public void superUser(Long userId) {
        UserEntity user = userService.getUserById(userId);
        if (user.getNazarsCount() <= 10 && user.getMyNazarCount() >= 100) {
            user.setIsSuperUser(true);
        }
    }

    public List<UserEntity> getSuperUsers() {
        List<UserEntity> userEntities = userService.getAllUsers()
                .stream()
                .filter(user -> Objects.equals(user.getIsSuperUser(), Boolean.TRUE))
                .collect(Collectors.toList());
        return userEntities;
    }

    public boolean isSeeActivity(Long userId, Long otherUserId) {
        UserEntity user = userService.getUserById(userId);
        UserEntity otherUser = userService.getUserById(otherUserId);
        boolean containsFollowing = user.getFollowing()
                .stream()
                .anyMatch(u ->
                        Objects.equals(u.getFollowingUserId(), otherUser.getId()));

        boolean containsFollower = user.getFollower()
                .stream()
                .anyMatch(u -> Objects.equals(u.getFollowerUserId(), otherUser.getId()));
        if (containsFollower && containsFollowing) {
            return true;
        }
        return false;
    }
}
