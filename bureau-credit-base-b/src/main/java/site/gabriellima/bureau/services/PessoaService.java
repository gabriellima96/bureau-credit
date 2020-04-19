package site.gabriellima.bureau.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import site.gabriellima.bureau.dtos.RendaDTO;
import site.gabriellima.bureau.exceptions.ResourceNotFoundException;
import site.gabriellima.bureau.models.Ben;
import site.gabriellima.bureau.models.Pessoa;
import site.gabriellima.bureau.repositories.BenRepository;
import site.gabriellima.bureau.repositories.PessoaRepository;

@Service
@Slf4j
public class PessoaService {

    private final static String PESSOA_NOT_FOUND = "Pessoa com id '%s' não encontrada";

    private final PessoaRepository pessoaRepository;

    private final BenRepository benRepository;

    @Autowired
    public PessoaService(PessoaRepository pessoaRepository, BenRepository benRepository) {
        this.pessoaRepository = pessoaRepository;
        this.benRepository = benRepository;
    }

    public Page<Pessoa> buscarTudo(Pageable pageable) {
        log.info("Buscando todas as pessoas");
        return pessoaRepository.findAll(pageable);
    }

    public Pessoa buscarPorId(Long id) {
        log.info("Buscando pessoa com id: '{}'", id);
        return pessoaRepository.findByPessoaId(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(PESSOA_NOT_FOUND, id)));
    }

    public void atualizarRenda(Long id, RendaDTO rendaDTO) {
        Pessoa pessoa = buscarPorId(id);
        pessoa.setRenda(rendaDTO.getRenda());
        pessoaRepository.save(pessoa);
    }

    public void adicionarBen(Long id, Ben ben) {
        Pessoa pessoa = buscarPorId(id);
        ben.setPessoaId(pessoa.getId());
        pessoa.adicionarBen(benRepository.save(ben));
        pessoaRepository.save(pessoa);
    }

}