package com.nazar.service.model.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TarotResponse {

    private MinorArkanaTypeResponse minorArkanaTarotType;
    private MajorArkanaTypeResponse majorArcanaTarotType;

}
