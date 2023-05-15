package com.nazar.service.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NazarLevel {

    BEGINNER(0),
    LOW_LEVEL(1),
    INTERMEDIATE(2),
    ADVANCED(3);

    private final int value;
}
