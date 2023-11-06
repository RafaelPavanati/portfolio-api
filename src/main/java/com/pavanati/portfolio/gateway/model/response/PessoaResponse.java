package com.pavanati.portfolio.gateway.model.response;

import jakarta.persistence.Entity;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaResponse {

    private Long id;

    private String nome;

    private LocalDate dataNascimento;

    private String cpf;


    private Boolean funcionario;

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setFuncionario(Boolean funcionario) {
        this.funcionario = funcionario;
    }
}
