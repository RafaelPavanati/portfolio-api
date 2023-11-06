package com.pavanati.portfolio.gateway.model.request;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaRequest {

    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String cpf;

    private Boolean funcionario;
}
