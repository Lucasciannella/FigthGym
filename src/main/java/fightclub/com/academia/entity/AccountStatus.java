package fightclub.com.academia.entity;

import lombok.Getter;

@Getter
public enum AccountStatus {
    ACTIVE("ATIVO"),
    PENDING_PAYMENT("PENDENTE DE PAGAMENTO"),
    DESATIVATED("DESATIVADA");

    private final String description;

    AccountStatus(String description) {
        this.description = description;
    }
}