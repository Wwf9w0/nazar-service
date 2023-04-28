package com.nazar.service.response;

import com.nazar.service.model.enums.MajorArcanaTarotType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MajorArkanaTypeResponse {

    private MajorArcanaTarotType type;
    private String description;
    
}
