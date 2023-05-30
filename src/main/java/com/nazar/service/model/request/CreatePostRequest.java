package com.nazar.service.model.request;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
@Builder
public class CreatePostRequest {

    private Long userId;
    private String description;
    private Boolean isPrivate;
    private Boolean pinned;
    private Boolean commentable;
    @Builder.Default
    private Date shareDate = new Date();
}
