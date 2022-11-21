package fightclub.com.academia.entity;

import lombok.Getter;

import javax.persistence.Basic;

@Getter
public enum AccountType {
    BASIC("BASICO"),
    PREMIUM("PREMIUM"),
    BLACK("BLACK");

    private final String description;

    AccountType(String description) {
        this.description = description;
    }
}