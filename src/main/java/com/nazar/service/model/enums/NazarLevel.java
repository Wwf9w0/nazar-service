package com.nazar.service.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NazarLevel {

    BEGINNER(0, "Başlangıç Seviye Nazar"),
    LOW_LEVEL(1, "Düşük Seviye Nazar"),
    INTERMEDIATE(2, "Orta Seviye Nazar"),
    ADVANCED(3, "İleri Seviye Nazar");

    private final int value;
    private final String name;
}
