package com.nazar.service.model.response;

import java.util.List;
import java.util.Set;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AttachNazarResponse {

    private Set<String> userName;
}
