package com.nazar.service.model.request;

import javax.validation.constraints.NotBlank;

import com.nazar.service.model.enums.NazarType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NazarRequest {

    @NotBlank(message = "UserId cannot be empty!")
    private Long userId;

    @NotBlank(message = "nazarUserId cannot be empty!")
    private Long nazarUserId;

    @NotBlank(message = "nazarType cannot be empty!")
    private NazarType nazarType;

    @NotBlank(message = "nazarDescription cannot be empty!")
    private String nazarDescription;
    
}
