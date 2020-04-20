package site.gabriellima.bureau.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import site.gabriellima.bureau.models.Movimentacao;

public interface MovimentacaoRepository extends CrudRepository<Movimentacao, Long> {

    List<Movimentacao> findAllByCpf(String cpf);
}