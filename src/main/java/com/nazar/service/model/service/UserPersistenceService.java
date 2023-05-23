package com.nazar.service.model.service;

import com.google.common.base.Objects;
import com.nazar.service.model.entity.UserEntity;
import com.nazar.service.model.enums.NazarType;
import com.nazar.service.model.repository.UserRepository;
import com.nazar.service.model.request.UserRegisterRequest;
import com.nazar.service.model.response.TopNazarsResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserPersistenceService {

    private final UserRepository userRepository;

    public void createUser(UserRegisterRequest registerRequest) {
        Optional<UserEntity> user = userRepository.findByUserName(registerRequest.getUserName());
        if (user.isPresent()) {
            throw new RuntimeException("This username is already in use");
        }

        UserEntity userEntity = UserEntity.builder()
                .email(registerRequest.getEmail())
                .userName(registerRequest.getUserName())
                .build();
        UserEntity save = userRepository.save(userEntity);
        log.info("saved user : {}", save);
    }

    public List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }

    public UserEntity getUserByUserId(Long userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void save(UserEntity userEntity) {
        userRepository.save(userEntity);
    }

    public List<UserEntity> getTopNazarForUser(NazarType type) {
        return userRepository.findDistinctByMyNazars_type(type);
    }

    public List<TopNazarsResponse> getNazarsOfUsersGozluType() {
        List<UserEntity> users = getTopNazarForUser(NazarType.GOZLU_NAZAR);
        List<UserEntity> userList = new ArrayList<>();
        users.forEach(u -> {
            u.getMyNazars().forEach(n -> {
                if (Objects.equal(n.getType(), NazarType.GOZLU_NAZAR)) {
                    userList.add(u);
                }
            });
        });
        return userList
                .stream()
                .distinct()
                .map(response -> TopNazarsResponse.builder()
                        .myNazarCount(response.getMyNazarCount())
                        .nazarCount(response.getNazarsCount())
                        .userName(response.getUserName())
                        .build())
                .sorted(Comparator.comparing(TopNazarsResponse::getMyNazarCount).reversed())
                .collect(Collectors.toList());
    }
}
