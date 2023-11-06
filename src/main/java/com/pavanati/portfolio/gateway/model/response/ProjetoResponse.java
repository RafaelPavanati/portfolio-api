package com.pavanati.portfolio.gateway.model.response;

import com.pavanati.portfolio.domain.enums.ProjetoRisco;
import com.pavanati.portfolio.domain.enums.ProjetoStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjetoResponse {

    private Long id;

    private String nome;

    private LocalDate dataInicio;

    private LocalDate dataPrevisaoFim;

    private LocalDate dataFim;

    private String descricao;

    private ProjetoStatus status;

    private ProjetoRisco risco;

    private Double orcamento;

    private PessoaResponse gerente;

    private List<PessoaResponse> membros;
}
