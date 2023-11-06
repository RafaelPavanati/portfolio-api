package com.pavanati.portfolio.service.projeto;

import com.pavanati.portfolio.domain.enums.ProjetoStatus;
import com.pavanati.portfolio.domain.model.Pessoa;
import com.pavanati.portfolio.domain.model.Projeto;
import com.pavanati.portfolio.domain.repository.ProjetoRepository;
import com.pavanati.portfolio.domain.specification.BasicSpecification;
import com.pavanati.portfolio.domain.specification.GenericBasicSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProjetoSpecification {

    @Autowired
    private ProjetoRepository projetoRepository;

    public BasicSpecification<Projeto> verificaSeMembrosTemAtribuicaoFuncionario() {
        return new GenericBasicSpecification<>("Projeto não existe na base") {
            public boolean isSatisfiedBy(Projeto projeto) {
                return projeto.getMembros().stream().allMatch(Pessoa::getFuncionario);
            }
        };
    }

    public BasicSpecification<Long> verificaSeProjetoExiste() {
        return new GenericBasicSpecification<>("Projeto não existe na base") {
            public boolean isSatisfiedBy(Long id) {
                return projetoRepository.existsById(id);
            }
        };
    }

    public BasicSpecification<Long> verificaSeProjetoJaFoiIniciado() {
        return new GenericBasicSpecification<>("Projeto já iniciado não pode ser excluido") {
            public boolean isSatisfiedBy(Long id) {
                return projetoRepository.existsById(id) && !projetoRepository.existsByIdAndStatus(id, ProjetoStatus.INICIADO, ProjetoStatus.PLANEJADO, ProjetoStatus.EM_ANDAMENTO, ProjetoStatus.ENCERRADO, ProjetoStatus.CANCELADO);
            }
        };
    }

}
