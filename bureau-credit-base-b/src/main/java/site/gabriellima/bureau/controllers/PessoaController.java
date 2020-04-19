package site.gabriellima.bureau.controllers;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.gabriellima.bureau.dtos.RendaDTO;
import site.gabriellima.bureau.models.Ben;
import site.gabriellima.bureau.models.Pessoa;
import site.gabriellima.bureau.services.PessoaService;


@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public ResponseEntity<Page<Pessoa>> buscarTudo(Pageable pageable) {
        return ResponseEntity.ok(pessoaService.buscarTudo(pageable));
    }

    @GetMapping("{pessoaId}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long pessoaId) {
        return ResponseEntity.ok(pessoaService.buscarPorId(pessoaId));
    }

    @PutMapping("{pessoaId}/renda")
    public ResponseEntity<Void> atualizarRenda(@PathVariable Long pessoaId, @Valid @RequestBody RendaDTO rendaDTO) {
        pessoaService.atualizarRenda(pessoaId, rendaDTO);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("{pessoaId}/bens")
    public ResponseEntity<Void> atualizarRenda(@PathVariable Long pessoaId, @Valid @RequestBody Ben ben) {
        pessoaService.adicionarBen(pessoaId, ben);
        return ResponseEntity.noContent().build();
    }
}