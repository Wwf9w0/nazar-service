package com.nazar.service.model.request;

import javax.validation.constraints.NotBlank;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisterRequest {
    
    @NotBlank(message = "UserName cannot be empty!")
    private String userName;

    @NotBlank(message = "Email cannot be empty!")
    private String email;
}
