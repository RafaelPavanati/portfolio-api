package com.pavanati.portfolio.gateway.http;

import com.pavanati.portfolio.domain.model.Pessoa;
import com.pavanati.portfolio.gateway.mapper.PessoaMapper;
import com.pavanati.portfolio.gateway.model.request.PessoaRequest;
import com.pavanati.portfolio.gateway.model.response.PessoaResponse;
import com.pavanati.portfolio.service.pessoa.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {


    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private PessoaMapper pessoaMapper;

    @PostMapping
    public ResponseEntity<PessoaResponse> criar(@RequestBody PessoaRequest body) {
        Pessoa pessoa = pessoaService.criar(pessoaMapper.toModel(body));
        return ResponseEntity.ok(pessoaMapper.toResponse(pessoa));
    }

    @GetMapping
    public ResponseEntity<List<PessoaResponse>> listar() {
        List<Pessoa> pessoas = pessoaService.listar();
        return ResponseEntity.ok(pessoas.stream().map(pessoa -> pessoaMapper.toResponse(pessoa)).toList());
    }

    @GetMapping("{id}")
    public ResponseEntity<PessoaResponse> listar(@PathVariable("id") Long id) {
        Pessoa pessoa = pessoaService.buscaPorId(id);
        return ResponseEntity.ok(pessoaMapper.toResponse(pessoa));
    }

    @PutMapping("{id}")
    public ResponseEntity<PessoaResponse> atualizar(@PathVariable("id") Long id, @RequestBody PessoaRequest body) {
        Pessoa pessoa = pessoaService.atualizar(pessoaMapper.toModel(body),id);
        return ResponseEntity.ok(pessoaMapper.toResponse(pessoa));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deletar(@PathVariable("id") Long id) {
        pessoaService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }
}
