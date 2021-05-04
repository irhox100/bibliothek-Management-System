package de.bibliothek.phase4.persistence;

import lombok.Getter;

@Getter
public class Medium {

    private String name;

    public Medium(String name){
        this.name = name;
    }
}
