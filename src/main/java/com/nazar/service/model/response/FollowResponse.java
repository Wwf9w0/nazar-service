package com.nazar.service.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class FollowResponse {

    private List<String> userNameList;
}
