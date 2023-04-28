package com.nazar.service.response;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TopNazarsResponse {
    
    private String userName;
    private Integer nazarCount;
    private Integer myNazarCount;
}
