package com.nazar.service.model.response;

import com.nazar.service.model.enums.NazarType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NazarResponse {

    private NazarType type;
    private Long count;
}
