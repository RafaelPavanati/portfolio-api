package com.pavanati.portfolio.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "pessoa")
public class Pessoa {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "datanascimento")
    private LocalDate dataNascimento;

    @Column(name = "cpf")
    private String cpf;

    @Builder.Default
    @Column(name = "funcionario")
    private Boolean funcionario = false;
}
