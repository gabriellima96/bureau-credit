package site.gabriellima.bureau.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import site.gabriellima.bureau.models.Divida;
import site.gabriellima.bureau.repositories.DividaRepository;

@Service
@Slf4j
public class DividaService {

    private final DividaRepository dividaRepository;
    private final PessoaService pessoaService;

    @Autowired
    public DividaService(DividaRepository dividaRepository, PessoaService pessoaService) {
        this.dividaRepository = dividaRepository;
        this.pessoaService = pessoaService;
    }

    public Page<Divida> buscarTudoPorPessoaId(Long pessoaId, Pageable pageable) {
        log.info("Buscando todas as dividas da pessoa com id '{}'", pessoaId);
        pessoaService.buscarPessoaPorId(pessoaId);
        return dividaRepository.findAllByPessoa_id(pessoaId, pageable);
    }
}
