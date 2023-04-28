package com.nazar.service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.nazar.service.model.entity.UserEntity;
import com.nazar.service.model.request.UserRegisterRequest;
import com.nazar.service.model.service.UserPersistenceService;
import com.nazar.service.response.TopNazarsResponse;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserPersistenceService userPersistenceService;

    public void createUser(UserRegisterRequest userRegisterRequest) {
        userPersistenceService.createUser(userRegisterRequest);
    }

    public List<UserEntity> getAllUsers() {
        return userPersistenceService.getAllUsers();
    }

    public UserEntity getUserById(Long userId) {
        return userPersistenceService.getUserByUserId(userId);
    }

    public List<TopNazarsResponse> getTopNazarUsers() {
        return userPersistenceService.getNazarsOfUsersGozluType();
    }

}
