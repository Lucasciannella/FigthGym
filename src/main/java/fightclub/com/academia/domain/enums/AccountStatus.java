package fightclub.com.academia.domain.enums;

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