package com.pavanati.portfolio.service.projeto;

import com.pavanati.portfolio.domain.model.Projeto;
import com.pavanati.portfolio.domain.repository.ProjetoRepository;
import com.pavanati.portfolio.domain.specification.PavanatiValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetoService {

    @Autowired
    private ProjetoRepository projetoRepository;

    @Autowired
    private ProjetoSpecification projetoSpecification;

    @Autowired
    private PavanatiValidator pavanatiValidator;

    public Projeto criar(Projeto body) {
        pavanatiValidator.validate(body, projetoSpecification.verificaSeMembrosTemAtribuicaoFuncionario());
        return projetoRepository.save(body);
    }

    public Projeto atualizar(Projeto body, Long id) {
        pavanatiValidator.validate(body, projetoSpecification.verificaSeMembrosTemAtribuicaoFuncionario());
        buscaPorId(id);
        body.setId(id);
        return projetoRepository.save(body);
    }

    public List<Projeto> listar() {
        return projetoRepository.findAll();
    }

    public Projeto buscaPorId(Long id) {
        return projetoRepository.findById(id).orElseThrow(() -> new RuntimeException("Projeto não encontrado"));
    }

    public void deletarPorId(Long id) {
        pavanatiValidator.validate(id, projetoSpecification.verificaSeProjetoExiste());
        pavanatiValidator.validate(id, projetoSpecification.verificaSeProjetoJaFoiIniciado());
        projetoRepository.deleteById(id);
    }

}
