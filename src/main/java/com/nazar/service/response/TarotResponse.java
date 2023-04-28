package com.nazar.service.response;


import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TarotResponse {

    private MinorArkanaTypeResponse minorArkanaTarotType;
    private MajorArkanaTypeResponse majorArcanaTarotType;

}
