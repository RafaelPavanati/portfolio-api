package com.pavanati.portfolio.gateway.http;

import com.pavanati.portfolio.domain.model.Pessoa;
import com.pavanati.portfolio.domain.model.Projeto;
import com.pavanati.portfolio.gateway.mapper.PessoaMapper;
import com.pavanati.portfolio.gateway.mapper.ProjetoMapper;
import com.pavanati.portfolio.gateway.model.request.PessoaRequest;
import com.pavanati.portfolio.gateway.model.request.ProjetoRequest;
import com.pavanati.portfolio.gateway.model.response.PessoaResponse;
import com.pavanati.portfolio.gateway.model.response.ProjetoResponse;
import com.pavanati.portfolio.service.pessoa.PessoaService;
import com.pavanati.portfolio.service.projeto.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projetos")
public class ProjetoController {

    @Autowired
    private ProjetoService projetoService;

    @Autowired
    private ProjetoMapper projetoMapper;

    @PostMapping
    public ResponseEntity<ProjetoResponse> criar(@RequestBody ProjetoRequest body) {
        Projeto projeto = projetoService.criar(projetoMapper.toModel(body));
        return ResponseEntity.ok(projetoMapper.toResponse(projeto));
    }

    @GetMapping
    public ResponseEntity<List<ProjetoResponse>> listar() {
        List<Projeto> projetos = projetoService.listar();
        return ResponseEntity.ok(projetos.stream().map(projeto -> projetoMapper.toResponse(projeto)).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<ProjetoResponse> listar(@PathVariable("id") Long id) {
        Projeto projeto = projetoService.buscaPorId(id);
        return ResponseEntity.ok(projetoMapper.toResponse(projeto));
    }

    @PutMapping("{id}")
    public ResponseEntity<ProjetoResponse> atualizar(@PathVariable("id") Long id, @RequestBody ProjetoRequest body) {
        Projeto projeto = projetoService.atualizar(projetoMapper.toModel(body),id);
        return ResponseEntity.ok(projetoMapper.toResponse(projeto));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        projetoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
