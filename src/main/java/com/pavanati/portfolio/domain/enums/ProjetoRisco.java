package com.pavanati.portfolio.domain.enums;

import lombok.Getter;

@Getter
public enum ProjetoRisco {

    BAIXO("Baixo"),
    MEDIO("Médio"),
    ALTO("Alto");

    private final String descricao;

    ProjetoRisco(String descricao) {
        this.descricao = descricao;
    }

}
