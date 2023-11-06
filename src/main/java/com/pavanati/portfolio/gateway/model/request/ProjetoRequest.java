package com.pavanati.portfolio.gateway.model.request;

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
public class ProjetoRequest {

    private Long id;

    private String nome;

    private LocalDate dataInicio;

    private LocalDate dataPrevisaoFim;

    private LocalDate dataFim;

    private String descricao;

    private ProjetoStatus status;

    private ProjetoRisco risco;

    private Double orcamento;

    private PessoaRequest gerente;

    private List<PessoaRequest> membros;
}
