package site.gabriellima.bureau.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import site.gabriellima.bureau.models.Pessoa;

public interface PessoaRepository extends MongoRepository<Pessoa, String> {

    Optional<Pessoa> findByPessoaId(Long id);
}