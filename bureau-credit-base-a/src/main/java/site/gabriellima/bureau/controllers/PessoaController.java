package site.gabriellima.bureau.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.gabriellima.bureau.models.Divida;
import site.gabriellima.bureau.models.Pessoa;
import site.gabriellima.bureau.services.DividaService;
import site.gabriellima.bureau.services.PessoaService;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;
    private final DividaService dividaService;

    @Autowired
    public PessoaController(PessoaService pessoaService, DividaService dividaService) {
        this.pessoaService = pessoaService;
        this.dividaService = dividaService;
    }

    @GetMapping
    public ResponseEntity<Page<Pessoa>> buscarTudo(Pageable pageable) {
        return ResponseEntity.ok(pessoaService.buscarTudo(pageable));
    }

    @GetMapping("{pessoaId}/dividas")
    public ResponseEntity<Page<Divida>> buscarTodasDividas(@PathVariable Long pessoaId, Pageable pageable) {
        return ResponseEntity.ok(dividaService.buscarTudoPorPessoaId(pessoaId, pageable));
    }

    @GetMapping("{pessoaId}")
    public ResponseEntity<Pessoa> buscarPessoaPorId(@PathVariable Long pessoaId) {
        return ResponseEntity.ok(pessoaService.buscarPessoaPorId(pessoaId));
    }

}
