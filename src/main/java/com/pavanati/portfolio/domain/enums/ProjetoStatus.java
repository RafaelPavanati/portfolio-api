package com.pavanati.portfolio.domain.enums;

import lombok.Getter;

@Getter
public enum ProjetoStatus {

    EM_ANALISE("Em análise"),
    ANALISE_REALIZADA("Análise realizada"),
    ANALISE_APROVADA("Análise aprovada"),
    INICIADO("Iniciado"),
    PLANEJADO("Planejado"),
    EM_ANDAMENTO("Em andamento"),
    ENCERRADO("Encerrado"),
    CANCELADO("Cancelado");

    private final String descricao;

    ProjetoStatus(String descricao) {
        this.descricao = descricao;
    }

}
