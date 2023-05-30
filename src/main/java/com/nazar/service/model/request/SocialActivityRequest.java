package com.nazar.service.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SocialActivityRequest {

    private Long userId;
}
