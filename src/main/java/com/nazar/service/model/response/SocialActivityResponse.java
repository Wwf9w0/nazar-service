package com.nazar.service.model.response;

import com.nazar.service.model.entity.NazarEntity;
import com.nazar.service.model.entity.UserNazarEntity;
import com.nazar.service.model.enums.NazarLevel;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class SocialActivityResponse {

    private List<NazarEntity> nazar;
    private List<UserNazarEntity> toNazar;
    private NazarLevel nazarLevel;
    private Integer nazarCount;
    private Integer toNazarCount;
    private Integer followerCount;
    private Integer followingCount;
}
