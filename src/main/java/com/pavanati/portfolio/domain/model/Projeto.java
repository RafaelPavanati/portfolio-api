package com.pavanati.portfolio.domain.model;

import com.pavanati.portfolio.domain.enums.ProjetoRisco;
import com.pavanati.portfolio.domain.enums.ProjetoStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "projeto")
public class Projeto {

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;

    @Column(name = "data_previsao_fim")
    private LocalDate dataPrevisaoFim;

    @Column(name = "data_fim")
    private LocalDate dataFim;

    @Column(name = "descricao")
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private ProjetoStatus status;

    @Enumerated(EnumType.STRING)
    @Column(name = "risco")
    private ProjetoRisco risco;

    @Column(name = "orcamento")
    private Double orcamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idgerente")
    private Pessoa gerente;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "membros",
            joinColumns = {
                    @JoinColumn(name = "idprojeto")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "idpessoa")
            })
    private List<Pessoa> membros;
}
