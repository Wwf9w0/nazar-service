package com.nazar.service.model.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nazar.service.model.entity.NazarEntity;
import com.nazar.service.model.entity.UserEntity;
import com.nazar.service.model.entity.UserNazarEntity;
import com.nazar.service.model.enums.NazarType;
import com.nazar.service.model.repository.NazarRepository;
import com.nazar.service.model.repository.UserNazarRepository;
import com.nazar.service.model.request.NazarRequest;
import com.nazar.service.model.response.AttachNazarResponse;
import com.nazar.service.model.response.NazarCountResponse;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class NazarPersistenceService {

    private final NazarRepository nazarRepository;
    private final UserNazarRepository userNazarRepository;
    private final UserPersistenceService userPersistenceService;
    private final int TEN = 10;
    private final int ONE = 1;

    @Transactional
    public void addNazar(NazarRequest nazarRequest) {
        UserEntity user = userPersistenceService.getUserByUserId(nazarRequest.getUserId());
        UserEntity nazarUser = userPersistenceService.getUserByUserId(nazarRequest.getNazarUserId());
        if (Objects.nonNull(user) && Objects.nonNull(nazarUser)) {
            NazarEntity nazarEntity = NazarEntity.builder()
                    .type(nazarRequest.getNazarType())
                    .nazarDescription(nazarRequest.getNazarDescription())
                    .userNazarId(nazarUser.getId())
                    .user(user)
                    .build();

            UserNazarEntity userNazarEntity = UserNazarEntity.builder()
                    .nazarDescription(nazarRequest.getNazarDescription())
                    .type(nazarRequest.getNazarType())
                    .nazarUserId(user.getId())
                    .user(nazarUser)
                    .createdDate(new Date())
                    .lastModifiedDate(new Date())
                    .build();
            nazarUser.setMyNazarCount(Objects.isNull(user.getMyNazarCount()) ? ONE : nazarUser.getMyNazarCount() + ONE);
            userNazarRepository.save(userNazarEntity);
            nazarRepository.save(nazarEntity);
        }
    }

    public List<NazarCountResponse> getNazarsOfUser(Long userId) {
        final List<NazarEntity> nazarEntities = userPersistenceService.getUserByUserId(userId).getNazars();
        return nazarEntities
                .stream()
                .collect(Collectors.groupingBy(NazarEntity::getType, Collectors.counting()))
                .entrySet()
                .stream()
                .map(entry -> NazarCountResponse.builder()
                        .type(entry.getKey())
                        .nazarCount(entry.getValue())
                        .build())
                .collect(Collectors.toList());
    }

    // Bana nazar atan userlar
    public AttachNazarResponse getNazarUsersForUser(Long userId) {
        List<UserNazarEntity> nazarEntities = userPersistenceService.getUserByUserId(userId).getMyNazars();

        List<Long> userIds = nazarEntities.stream()
                .map(UserNazarEntity::getNazarUserId)
                .collect(Collectors.toList());

        Set<String> userNameList = new HashSet<>();
        userIds.forEach(id -> {
            UserEntity userEntity = userPersistenceService.getUserByUserId(id);
            userNameList.add(userEntity.getUserName());
        });

        return AttachNazarResponse.builder()
                .userName(userNameList)
                .build();
    }

    // Benim nazar attıklarım
    public AttachNazarResponse getNazarUser(Long userId) {
        List<NazarEntity> nazarEntities = userPersistenceService.getUserByUserId(userId).getNazars();
        List<Long> userIds = nazarEntities.stream()
                .map(NazarEntity::getUserNazarId)
                .collect(Collectors.toList());
        Set<String> userNameList = new HashSet<>();
        userIds.forEach(id -> {
            UserEntity userEntity = userPersistenceService.getUserByUserId(id);
            userNameList.add(userEntity.getUserName());
        });

        return AttachNazarResponse.builder()
                .userName(userNameList)
                .build();
    }

    public void removeNazarByNazarPoint(Long userId, Long nazarId) {
        UserEntity user = userPersistenceService.getUserByUserId(userId);
        Optional<UserNazarEntity> nazarEntity = userNazarRepository.findById(nazarId);
        if (!nazarEntity.isPresent()) {
            throw new RuntimeException("Nazar Not Found!");
        }
        isUsedPoint(user.getGozluNazarPoint(), user.getSozluNazarPoint(), nazarEntity.get().getType());
        setPointAndSave(nazarEntity.get(), user);
        deleteNazarForUser(nazarEntity.get(), nazarId);
        log.info("nazarınız silindi -> id {}", nazarId);
    }

    private void deleteNazarForUser(UserNazarEntity nazarEntity, Long nazarId) {
        if (Objects.equals(nazarEntity.getId(), nazarId)) {
            userNazarRepository.delete(nazarEntity);
        }
    }

    private void setPointAndSave(UserNazarEntity nazarEntity, UserEntity user) {
        if (Objects.equals(nazarEntity.getType(), NazarType.GOZLU_NAZAR)) {
            user.setGozluNazarPoint(true);
        }
        if (Objects.equals(nazarEntity.getType(), NazarType.SOZLU_NAZAR)) {
            user.setSozluNazarPoint(true);
        }
        userPersistenceService.save(user);
    }

    private void isUsedPoint(Boolean gPoint, Boolean sPoint, NazarType type) {
        if (Objects.isNull(gPoint) || Objects.isNull(sPoint)) {
            gPoint = false;
            sPoint = false;
        }

        if (gPoint && Objects.equals(type, NazarType.GOZLU_NAZAR)) {
            throw new RuntimeException("This user is already remove point!");
        }

        if (sPoint && Objects.equals(type, NazarType.SOZLU_NAZAR)) {
            throw new RuntimeException("This user is already remove  point!");
        }
    }
}
