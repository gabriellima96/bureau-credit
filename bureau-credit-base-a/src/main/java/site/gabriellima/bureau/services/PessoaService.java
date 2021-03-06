package site.gabriellima.bureau.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import site.gabriellima.bureau.exceptions.ResourceNotFoundException;
import site.gabriellima.bureau.models.Pessoa;
import site.gabriellima.bureau.repositories.PessoaRepository;

@Service
@Slf4j
public class PessoaService {

    private final static String PESSOA_NOT_FOUND = "Pessoa com id '%s' não encontrada";

    private final PessoaRepository pessoaRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public Page<Pessoa> buscarTudo(Pageable pageable) {
        log.info("Buscando todas as pessoas");
        return pessoaRepository.findAll(pageable);
    }

    public Pessoa buscarPessoaPorId(Long id) {
        log.info("Buscando pessoa por id '{}'", id);
        return pessoaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(PESSOA_NOT_FOUND, id)));
    }

}
