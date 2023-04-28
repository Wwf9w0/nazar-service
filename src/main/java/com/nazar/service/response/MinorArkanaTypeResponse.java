package com.nazar.service.response;

import com.nazar.service.model.enums.MinorArkanaTarotType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MinorArkanaTypeResponse {
    
    private MinorArkanaTarotType type;
    private String description;
}
