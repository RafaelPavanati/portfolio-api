package com.pavanati.portfolio.service.pessoa;

import com.pavanati.portfolio.domain.model.Pessoa;
import com.pavanati.portfolio.domain.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa criar(Pessoa body) {
        return pessoaRepository.save(body);
    }

    public Pessoa atualizar(Pessoa body, Long id) {
        buscaPorId(id);
        body.setId(id);
        return pessoaRepository.save(body);
    }

    public List<Pessoa> listar() {
        return pessoaRepository.findAll();
    }

    public Pessoa buscaPorId(Long id) {
        return pessoaRepository.findById(id).orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));
    }

    public void deletarPorId(Long id) {
        pessoaRepository.deleteById(id);
    }


}
