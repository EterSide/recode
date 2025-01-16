package com.example.recode.entity;

import lombok.Getter;



@Getter
public enum Tribe {

    Terran("Terran"),
    Zerg("Zerg"),
    Protoss("Protoss");

    private final String displayName;

    Tribe(String displayName) {
        this.displayName = displayName;
    }
}
