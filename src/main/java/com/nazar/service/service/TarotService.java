package com.nazar.service.service;

import com.nazar.service.model.entity.UserEntity;
import com.nazar.service.model.entity.UserTarotEntity;
import com.nazar.service.model.enums.MajorArcanaTarotType;
import com.nazar.service.model.enums.MinorArkanaTarotType;
import com.nazar.service.model.repository.UserTarotRepository;
import com.nazar.service.model.response.MajorArkanaTypeResponse;
import com.nazar.service.model.response.MinorArkanaTypeResponse;
import com.nazar.service.model.response.TarotResponse;
import com.nazar.service.model.service.UserPersistenceService;
import com.nazar.service.util.RandomUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Service
@Slf4j
public class TarotService {

        private final UserTarotRepository userTarotRepository;
        private final UserPersistenceService userPersistenceService;
        private final Integer ONE = 1;

        public TarotResponse gameTarot(int number, Long userId) {
                int tarotCount = RandomUtil.randomInt(number);
                int majorGameCount = isGameMajorArkana(tarotCount);
                int minorGameCount = isGameMinorArkana(tarotCount);
                UserEntity user = userPersistenceService.getUserByUserId(userId);
                boolean isTarot = hasAlreadyTarot(user, majorGameCount, minorGameCount);
                if (isTarot) {
                        majorGameCount = majorGameCount + ONE;
                        minorGameCount = minorGameCount + ONE;
                }
                MajorArcanaTarotType majorArcanaTarotType = MajorArcanaTarotType.fromValue(majorGameCount); 
                MinorArkanaTarotType minorArkanaTarotType = MinorArkanaTarotType.fromValue(minorGameCount); 

                MajorArkanaTypeResponse majorArkanaTypeResponse = MajorArkanaTypeResponse.builder()
                                .type(majorArcanaTarotType)
                                .description(majorArcanaTarotType.getDescription())
                                .build();

                MinorArkanaTypeResponse minorArkanaTypeResponse = MinorArkanaTypeResponse.builder()
                                .type(minorArkanaTarotType)
                                .description(minorArkanaTarotType.getDescription())
                                .build();

                UserTarotEntity userTarotEntity = UserTarotEntity.builder()
                                .majorTarotType(majorArcanaTarotType.getValue())
                                .minorTarotType(minorArkanaTarotType.getValue())
                                .user(user)
                                .build();

                userTarotRepository.save(userTarotEntity);

                return TarotResponse.builder()
                                .majorArcanaTarotType(majorArkanaTypeResponse)
                                .minorArkanaTarotType(minorArkanaTypeResponse)
                                .build();
        }

        private boolean hasAlreadyTarot(UserEntity user, int majorGameCount, int minorGameCount) {
                if (Objects.nonNull(user.getUserTarots())) {
                        for (UserTarotEntity userTarotEntity : user.getUserTarots()) {
                                if (Objects.equals(userTarotEntity.getMajorTarotType(), majorGameCount)
                                                || Objects.equals(userTarotEntity.getMinorTarotType(),
                                                                minorGameCount)) {
                                        return true;
                                }

                        }
                }
                return false;
        }

        private int isGameMajorArkana(int number) {
                int majorSize = MajorArcanaTarotType.values().length;
                int diff = 0;
                if (majorSize < number) {
                        return diff = number - majorSize;
                }

                return number;
        }

        private int isGameMinorArkana(int number) {
                int minorSize = MinorArkanaTarotType.values().length;
                if (minorSize < number) {
                        return number - minorSize;
                }
                return number;
        }
}
