package site.gabriellima.bureau.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import site.gabriellima.bureau.models.Consulta;
import site.gabriellima.bureau.services.ConsultaService;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService consultaService;

    @Autowired
    public ConsultaController(ConsultaService consultaService) {
        this.consultaService = consultaService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Consulta>> buscarTudo() {
        return ResponseEntity.ok(consultaService.buscarTudo());
    }

    @PostMapping
    public ResponseEntity<Consulta> salvar(@Valid @RequestBody Consulta consulta) {
        return ResponseEntity.ok(consultaService.salvar(consulta));
    }

    @GetMapping("{cpf}")
    public ResponseEntity<Iterable<Consulta>> buscarPorCPF(@PathVariable String cpf) {
        return ResponseEntity.ok(consultaService.buscarPorCpf(cpf));
    }
}