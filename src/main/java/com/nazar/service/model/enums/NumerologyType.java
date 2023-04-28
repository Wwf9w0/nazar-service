package com.nazar.service.model.enums;

import com.google.common.base.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NumerologyType {

    ONE(1, "Liderlik, bağımsızlık, yaratıcılık"),
    TWO(2, "İkili ilişkiler, işbirliği, uyum"),
    THREE(3, "İfade, yaratıcılık, sosyallik"),
    FOUR(4, "Sabır, dayanıklılık, disiplin"),
    FIVE(5, "Macera, özgürlük, hareket"),
    SIX(6, "Aile, evlilik, denge"),
    SEVEN(7, "Spiritüel gelişim, iç görü, araştırma"),
    EIGHT(8, "Başarı, maddi kazanç, güç"),
    NINE(9, "Evrensel sevgi, altruizm, insanlığa hizmet");

    private final int value;
    private final String description;

    public static NumerologyType fromValue(int value) {
        for (NumerologyType type : NumerologyType.values()) {
            if (Objects.equal(type.getValue(), value)) {
                return type;
            }
        }
        throw new RuntimeException("Unknown numerology for value : " + value);
    }

}
