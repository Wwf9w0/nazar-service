package com.nazar.service.model.response;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Builder
public class AttachNazarResponse {

    private Set<String> userName;
}
