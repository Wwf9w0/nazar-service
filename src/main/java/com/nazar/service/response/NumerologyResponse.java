package com.nazar.service.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NumerologyResponse {
    
    private String name;
    private String numerology;
}
