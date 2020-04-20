package site.gabriellima.bureau.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.gabriellima.bureau.models.Movimentacao;
import site.gabriellima.bureau.services.MovimentacaoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/movimentacoes")
public class MovimentacaoController {

    private final MovimentacaoService movimentacaoService;

    @Autowired
    public MovimentacaoController(MovimentacaoService movimentacaoService) {
        this.movimentacaoService = movimentacaoService;
    }

    @GetMapping("{cpf}")
    public ResponseEntity<List<Movimentacao>> buscarPorCpf(@PathVariable String cpf) {
        return ResponseEntity.ok(movimentacaoService.buscarPorCpf(cpf));
    }

    @PostMapping("{cpf}")
    public ResponseEntity<Void> salvar(@PathVariable String cpf, @Valid @RequestBody Movimentacao movimentacao) {
        movimentacao.setCpf(cpf);
        movimentacaoService.salvar(movimentacao);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}