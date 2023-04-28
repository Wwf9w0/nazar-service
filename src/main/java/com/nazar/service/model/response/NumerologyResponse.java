package com.nazar.service.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumerologyResponse {
    
    private String name;
    private String numerology;
}
