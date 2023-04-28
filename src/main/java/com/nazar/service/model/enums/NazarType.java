package com.nazar.service.model.enums;

import com.google.common.base.Objects;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NazarType {

    GOZLU_NAZAR("Gözlü Nazar"),
    SOZLU_NAZAR("Sözlü Nazar");

    private final String name;
    public static NazarType getByValue(int value){
        for(NazarType nazarType:NazarType.values()){
            if(Objects.equal(nazarType.getName(), value)){
                return nazarType;
            }
        }
        throw new RuntimeException("Unknown nazar type for value : " + value);
    }
    
}
