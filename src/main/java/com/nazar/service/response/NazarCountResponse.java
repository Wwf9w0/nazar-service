package com.nazar.service.response;

import com.nazar.service.model.enums.NazarType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NazarCountResponse {

    private NazarType type;
    private Long nazarCount;
}
