package site.gabriellima.bureau.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import site.gabriellima.bureau.models.Movimentacao;
import site.gabriellima.bureau.repositories.MovimentacaoRepository;

@Service
@Slf4j
public class MovimentacaoService {

    private final MovimentacaoRepository movimentacaoRepository;

    @Autowired
    public MovimentacaoService(MovimentacaoRepository movimentacaoRepository) {
        this.movimentacaoRepository = movimentacaoRepository;
    }

    public List<Movimentacao> buscarPorCpf(String cpf) {
        log.info("Buscar todas as movimentações do cpf '{}'", cpf);
        return movimentacaoRepository.findAllByCpf(cpf);
    }

    public Movimentacao salvar(Movimentacao movimentacao) {
        log.info("Salvando a movimentaçã '{}'", movimentacao);
        return movimentacaoRepository.save(movimentacao);
    }
}